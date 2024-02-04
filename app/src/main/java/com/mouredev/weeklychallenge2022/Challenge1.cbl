     /*
      * Reto #1
      * ¿ES UN ANAGRAMA?
      * Fecha publicación enunciado: 03/01/22
      * Fecha publicación resolución: 10/01/22
      * Dificultad: MEDIA
      *
      * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
      * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
      * NO hace falta comprobar que ambas palabras existan.
      * Dos palabras exactamente iguales no son anagrama.
      *
 */
       IDENTIFICATION DIVISION.
       PROGRAM-ID. ANAGRAMA.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
           77 CADENA1 PIC X(20).
           77 CADENA2 PIC X(20).
           77 CARACTER PIC X.
           77 CADENA4 PIC X(20).
           77 REPE PIC 9.
           77 CONTADOR PIC 9(2) VALUE 1.
           77 LONG1 PIC 9(2).
           77 LONG2 PIC 9(2).
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           DISPLAY "INTRODUCE LA PRIMERA PALABRA: ".
           ACCEPT CADENA1.
           DISPLAY "INTRODUCE LA SEGUNDA PALABRA: ".
           ACCEPT CADENA4.
           IF CADENA1 = CADENA4
               DISPLAY "NO SON ANAGRAMAS"
           ELSE
               COMPUTE LONG1 = FUNCTION LENGTH
                           (FUNCTION TRIM(CADENA1, TRAILING))
               COMPUTE LONG2 = FUNCTION LENGTH
                           (FUNCTION TRIM(CADENA4, TRAILING))
               IF LONG1 NOT EQUAL LONG2
                   DISPLAY "NO SON ANAGRAMAS"
               ELSE
                   MOVE FUNCTION REVERSE(CADENA1) TO CADENA2
                   IF CADENA2 = CADENA4
                       DISPLAY "ANAGRAMAS"
                   ELSE
                       MOVE FUNCTION LENGTH(CADENA1) TO LONG1
                       ADD 1 TO LONG1
                       PERFORM UNTIL CONTADOR = LONG1
                       MOVE CADENA1(CONTADOR:1) TO CARACTER
                       INSPECT CADENA4 TALLYING REPE FOR ALL CARACTER
                       REPLACING FIRST CARACTER BY SPACE
                       ADD 1 TO CONTADOR
                       MOVE 0 TO REPE
                       END-PERFORM
                       IF CADENA4 EQUAL SPACES
                           DISPLAY "ANAGRAMAS"
                       ELSE
                           DISPLAY "NO SON ANAGRAMAS"
                       END-IF
                   END-IF
               END-IF
           END-IF.
           STOP RUN.
       END PROGRAM ANAGRAMA.
