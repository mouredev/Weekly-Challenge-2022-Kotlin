     /*
      * Escribe una función que reciba un texto y retorne verdadero o
      * falso (Boolean) según sean o no palíndromos.
      * Un Palíndromo es una palabra o expresión que es igual si se lee
      * de izquierda a derecha que de derecha a izquierda.
      * NO se tienen en cuenta los espacios.
      * Ejemplo: Ana lleva al oso la avellana
      */
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PALINDROMO.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
           77 FRASE PIC X(200).
           77 RESTO PIC 9.
           77 MITAD PIC 9(2).
           77 I PIC 9(2) VALUE 1.
           77 J PIC 9(2).
           77 LONG PIC 9(3).
           77 CARACI PIC X.
           77 CARACJ PIC X.
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           DISPLAY "INTRODUCE LA FRASE O PALABRA: ".
           ACCEPT FRASE.
           MOVE FUNCTION LOWER-CASE(FRASE) TO FRASE.
           COMPUTE LONG = FUNCTION LENGTH
                              (FUNCTION TRIM(FRASE, TRAILING)).
           DIVIDE LONG BY 2 GIVING MITAD REMAINDER RESTO.
           MOVE LONG TO J.
           PERFORM UNTIL I > MITAD
               PERFORM UNTIL J < MITAD
                   MOVE FRASE(I:LONG) TO CARACI
                   IF CARACI = SPACE
                       ADD 1 TO I
                       MOVE FRASE(I:LONG) TO CARACI
                   END-IF
                   MOVE FRASE(J:1) TO CARACJ
                   IF CARACJ = SPACE
                       SUBTRACT 1 FROM J
                       MOVE FRASE(J:1) TO CARACJ
                   END-IF
                   IF CARACI = CARACJ
                       ADD 1 TO I
                       SUBTRACT 1 FROM J
                   ELSE
                       DISPLAY "NO ES PALINDROMO"
                       STOP RUN
                   END-IF
               END-PERFORM
           END-PERFORM.
           DISPLAY "PALINDROMO"
           STOP RUN.
       END PROGRAM PALINDROMO.
