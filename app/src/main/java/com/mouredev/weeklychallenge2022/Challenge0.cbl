     /*
      * Escribe un programa que muestre por consola (con un print) los
      * numeros de 1 a 100 (ambos incluidos y con un salto de li­nea
      * entre cada impresion), sustituyendo los siguientes:
      * - Multiplos de 3 por la palabra "fizz".
      * - Multiplos de 5 por la palabra "buzz".
      * - Multiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
     */
       IDENTIFICATION DIVISION.
       PROGRAM-ID. FIZZBUZZ.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
           77 NUMERO PIC ZZ9 VALUE ZERO.
           77 RESULTADO PIC 99 VALUE ZERO.
           77 RESTO3 PIC 9 VALUE ZERO.
           77 RESTO5 PIC 9 VALUE ZERO.
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
            PERFORM BUCLE VARYING NUMERO FROM 1 BY 1 UNTIL NUMERO > 100
            STOP RUN.
       BUCLE.
           DIVIDE NUMERO BY 3 GIVING RESULTADO REMAINDER RESTO3.
           DIVIDE NUMERO BY 5 GIVING RESULTADO REMAINDER RESTO5.
           IF RESTO3 = 0 AND RESTO5 = 0
               DISPLAY "fizzbuzz"
           ELSE
               IF RESTO3 = 0
                   DISPLAY "fizz"
               ELSE
                   IF RESTO5 = 0
                       DISPLAY "buzz"
                   ELSE
                       DISPLAY NUMERO.
           END PROGRAM FIZZBUZZ.
