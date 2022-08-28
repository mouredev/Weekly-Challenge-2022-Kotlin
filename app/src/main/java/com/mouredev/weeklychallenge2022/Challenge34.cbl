       IDENTIFICATION DIVISION.
       PROGRAM-ID. CHALLENGE-34.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       01  WS-VARIBLES.
           05  WS-IDX PIC 9(2) VALUE ZEROS.
           05  WS-AUX PIC S9(5) VALUE ZEROS.
           05  WS-COUNT-NBR PIC 9(2) VALUE ZEROS.
           05  FILLER OCCURS 1 TO 10 TIMES DEPENDING ON WS-COUNT-NBR.
               10  WS-NUMBER PIC S9(5).

       PROCEDURE DIVISION.
         PERFORM ENTER-NUMBERS
         PERFORM MISSING-NUMBERS
         PERFORM END-PROGRAM.

       ENTER-NUMBERS.
         DISPLAY 'Cantidad de Enteros a ingresar (MAXIMO 10):'
         ACCEPT WS-COUNT-NBR
         IF WS-COUNT-NBR > 10 THEN
           DISPLAY 'Solo se pueden ingresar como máximo 10 enteros'
           PERFORM END-PROGRAM
         END-IF
         PERFORM VARYING WS-IDX FROM 1 BY 1
                   UNTIL WS-IDX > WS-COUNT-NBR
           ACCEPT WS-NUMBER(WS-IDX)
           IF WS-IDX > 1 THEN
             PERFORM VALIDATE-NUMBERS
           END-IF
         END-PERFORM.

       VALIDATE-NUMBERS.
         IF WS-NUMBER(WS-IDX - 1) >= WS-NUMBER(WS-IDX) THEN
           DISPLAY 'Error: El Array no está ordenado ascendente / El '
      -            'número ingresado está repetido.'
           PERFORM END-PROGRAM
         END-IF.

       MISSING-NUMBERS.
         PERFORM VARYING WS-IDX FROM 1 BY 1
                   UNTIL WS-IDX >= WS-COUNT-NBR
           COMPUTE WS-AUX = WS-NUMBER(WS-IDX) + 1
           PERFORM VARYING WS-AUX FROM WS-AUX BY 1
                     UNTIL WS-AUX = WS-NUMBER(WS-IDX + 1)
             DISPLAY WS-AUX
           END-PERFORM
         END-PERFORM.

       END-PROGRAM.
         STOP RUN.
