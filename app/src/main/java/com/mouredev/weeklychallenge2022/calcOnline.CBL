      ******************************************************************
      * Author: Roswell468
      * Date: 29/05/2022
      * Purpose: Resolución Reto 21.
      *          Fastidiar a MoureDev con este código COBOL del demonio
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. CHALLENGE21.

      ******************************************************************
      * DEFINICION DE FICHEROS Y FORMA DE ACCESO.
      ******************************************************************
       ENVIRONMENT DIVISION.
           INPUT-OUTPUT SECTION.
               FILE-CONTROL.
               SELECT CALCULADORA ASSIGN TO 'Challenge21.txt'
               FILE STATUS WS-FS-FILE
               ORGANIZATION IS LINE SEQUENTIAL.

      ******************************************************************
      * DEFINICION DE ESTRUCTURA DE DATOS DE FICHERO.
      ******************************************************************
       DATA DIVISION.
           FILE SECTION.
           FD CALCULADORA.
           01 CALC-FILE                PIC X(35).

      ******************************************************************
      * DEFINICION DE VARIABLES Y CONSTANSTES.
      ******************************************************************
       WORKING-STORAGE SECTION.
           01 VARIABLES.
               05 WS-RECORD            PIC X(35).
               05 WS-RESULT            PIC S9(25)V9(10).
               05 WS-RESULT-FORMAT     PIC -(25)9.9(10).
               05 WS-LAST-NUMBER       PIC S9(25)V9(10).
               05 WS-LAST-OPERATOR     PIC X(1).
               05 WS-COUNT             PIC 9(5).
               05 WS-RMDR              PIC 9(5).
               05 WS-TEMP              PIC 9(5).
               05 WS-IDX               PIC 9(2).
               05 WS-FS-FILE           PIC 9(2).
               05 WS-AUX-COUNTERS.
                   10 WS-COUNT-SIZE    PIC 9(2).
                   10 WS-COUNT-SIGN    PIC 9(2).
                   10 WS-COUNT-POINT   PIC 9(2).

           01 SWITCHES.
               05 SW-EOF               PIC X(1)    VALUE 'N'.
                   88 EOF                          VALUE 'Y'.
                   88 NOT-EOF                      VALUE 'N'.

               05 SW-TYPE              PIC 9       VALUE 0.
                   88 IS-NUMBER                    VALUE 0.
                   88 IS-OPERATOR                  VALUE 1.

           01 TABLES.
               05 TBL-OPERATORS.
                   10 FILLER           PIC X(35)   VALUE '+'.
                   10 FILLER           PIC X(35)   VALUE '-'.
                   10 FILLER           PIC X(35)   VALUE '*'.
                   10 FILLER           PIC X(35)   VALUE '/'.
               05 TBL-OPERATION REDEFINES TBL-OPERATORS.
                   10 WS-OPERATION     PIC X(35) OCCURS 4 INDEXED BY I.

      ******************************************************************
      * PROGRAMA PRINCIPAL.
      ******************************************************************
       PROCEDURE DIVISION.

           PERFORM INIT-VARIABLES
           PERFORM OPEN-FILE
           PERFORM READ-FILE
           PERFORM PROCESS-FILE UNTIL EOF
           PERFORM SHOW-RESULT
           PERFORM CLOSE-FILE
           PERFORM END-PROGRAM.

      ******************************************************************
      * INICIALIZACION DE VARIABLES Y SWITCHES
      ******************************************************************
           INIT-VARIABLES.

               INITIALIZE VARIABLES
               SET NOT-EOF TO TRUE.

      ******************************************************************
      * LECTURA DE FICHERO, VALIDACION DE DATOS Y CALCULO DEL RESULTADO
      ******************************************************************
           PROCESS-FILE.

               IF WS-COUNT = 1 THEN
                  MOVE WS-RECORD TO WS-RESULT
               END-IF

               IF IS-NUMBER THEN
                   MOVE WS-RECORD TO WS-LAST-NUMBER
                   PERFORM CALCULATE-RESULT
               ELSE
                   MOVE WS-RECORD(1:1) TO WS-LAST-OPERATOR
               END-IF

               PERFORM READ-FILE.

      ******************************************************************
      * DETERMINAR SI EL REGISTRO LEIDO ES PAR O IMPAR
      * (NUMERO U OPERADOR).
      ******************************************************************
           CHECK-TYPE.

               ADD 1 TO WS-COUNT
               DIVIDE 2 INTO WS-COUNT GIVING WS-TEMP REMAINDER WS-RMDR

               IF WS-RMDR = 0 THEN
                   SET IS-OPERATOR TO TRUE
               ELSE
                   SET IS-NUMBER TO TRUE
               END-IF.

      ******************************************************************
      * VALIDA LOS DATOS LEIDOS DEL FICHERO.
      ******************************************************************
           VALIDATE-DATA.

               IF IS-OPERATOR THEN
                   SET I TO 1
                   SEARCH WS-OPERATION
                       AT END PERFORM ERROR-VALIDATION
                       WHEN WS-OPERATION(I) = WS-RECORD
                           CONTINUE
                   END-SEARCH
                ELSE
                   INITIALIZE WS-AUX-COUNTERS
                   INSPECT WS-RECORD TALLYING WS-COUNT-SIGN FOR ALL '-'
                   INSPECT WS-RECORD TALLYING WS-COUNT-POINT FOR ALL '.'

                   IF WS-COUNT-SIGN > 1 OR WS-COUNT-POINT > 1 THEN
                       PERFORM ERROR-VALIDATION
                   END-IF

                   IF WS-COUNT-SIGN = 1 AND WS-RECORD(1:1) <> '-' THEN
                       PERFORM ERROR-VALIDATION
                   END-IF

                   IF WS-COUNT-POINT = 1 THEN
                       IF (WS-COUNT-SIGN = 0 AND
                          WS-RECORD(1:1) = '.') THEN
                           PERFORM ERROR-VALIDATION
                       END-IF
                       IF (WS-COUNT-SIGN = 1 AND
                          WS-RECORD(2:1) = '.') THEN
                           PERFORM ERROR-VALIDATION
                       END-IF
                   END-IF

                   INSPECT FUNCTION REVERSE(WS-RECORD)
                   TALLYING WS-COUNT-SIZE FOR LEADING SPACES

                   COMPUTE WS-COUNT-SIZE =
                   LENGTH OF WS-RECORD - WS-COUNT-SIZE

                   IF WS-COUNT-SIZE = 0 THEN
                       PERFORM ERROR-VALIDATION
                   END-IF

                   PERFORM VARYING WS-IDX FROM 1 BY 1
                   UNTIL WS-IDX > WS-COUNT-SIZE
                       IF WS-RECORD(WS-IDX:1) IS NOT NUMERIC AND
                           WS-RECORD(WS-IDX:1) NOT = '-' AND
                           WS-RECORD(WS-IDX:1) NOT = '.' THEN
                               PERFORM ERROR-VALIDATION
                       END-IF
                   END-PERFORM
               END-IF.

      ******************************************************************
      * CALCULO DEL RESULTADO
      ******************************************************************
           CALCULATE-RESULT.

               EVALUATE WS-LAST-OPERATOR
                   WHEN '+'
                       COMPUTE WS-RESULT = WS-RESULT + WS-LAST-NUMBER
                   WHEN '-'
                       COMPUTE WS-RESULT = WS-RESULT - WS-LAST-NUMBER
                   WHEN '*'
                       COMPUTE WS-RESULT = WS-RESULT * WS-LAST-NUMBER
                   WHEN '/'
                       COMPUTE WS-RESULT = WS-RESULT / WS-LAST-NUMBER
               END-EVALUATE.

      ******************************************************************
      * MUESTRA EL RESULTADO SI NO HUBO ERRORES.
      ******************************************************************
           SHOW-RESULT.

               IF IS-NUMBER THEN
                   MOVE WS-RESULT TO WS-RESULT-FORMAT
                   DISPLAY 'EL RESULTADO ES: ' WS-RESULT-FORMAT
               ELSE
                   PERFORM ERROR-VALIDATION
               END-IF.

      ******************************************************************
      * ERROR VALIDACION.
      ******************************************************************
           ERROR-VALIDATION.

               DISPLAY 'DATOS INCORRECTOS EN EL FICHERO'
               PERFORM CLOSE-FILE
               PERFORM END-PROGRAM.

      ******************************************************************
      * APERTURA DEL FICHERO CON CONTROL DE ERRORES.
      * SI FILE STATUS <> 0 SE FINALIZA EL PROGRAMA.
      ******************************************************************
           OPEN-FILE.

               OPEN INPUT CALCULADORA.

               IF WS-FS-FILE NOT = 0 THEN
                   DISPLAY 'FILE STATUS ERROR (OPEN): ' WS-FS-FILE
                   PERFORM END-PROGRAM
               END-IF.

      ******************************************************************
      * LECTURA SECUENCIAL DEL FICHERO CON CONTROL DE ERRORES.
      * SI FILE STATUS = 10, SE ACTIVA SWITCH DE FIN DE ARCHIVO (EOF).
      * SI FILE STATUS <> 0 Y 10 SE FINALIZA EL PROGRAMA.
      ******************************************************************
           READ-FILE.

               READ CALCULADORA INTO WS-RECORD
                   AT END
                       SET EOF TO TRUE
                   NOT AT END
                       PERFORM CHECK-TYPE
                       PERFORM VALIDATE-DATA
               END-READ

               IF WS-FS-FILE NOT = 0 AND 10 THEN
                   DISPLAY 'FILE STATUS ERROR (READ): ' WS-FS-FILE
                   PERFORM END-PROGRAM
               END-IF.

      ******************************************************************
      * CIERRE DEL FICHERO CON CONTROL DE ERRORES.
      * SI FILE STATUS <> 0 SE FINALIZA EL PROGRAMA.
      ******************************************************************
           CLOSE-FILE.

               CLOSE CALCULADORA

               IF WS-FS-FILE NOT = 0 THEN
                   DISPLAY 'FILE STATUS ERROR (CLOSE): ' WS-FS-FILE
                   PERFORM END-PROGRAM
               END-IF.

      ******************************************************************
      * FIN DEL PROGRAMA
      ******************************************************************
           END-PROGRAM.

               STOP RUN.
