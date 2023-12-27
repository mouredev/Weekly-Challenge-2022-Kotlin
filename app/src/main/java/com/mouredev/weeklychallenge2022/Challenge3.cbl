     /*
      * Escribe un programa que se encargue de comprobar si un numero es
      * o no primo. Hecho esto, imprime los numeros primos entre 1 y 100
      */
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PRIMO.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
           77 NUM PIC 999 VALUE 2.
           77 CONTADOR PIC 99.
           77 I PIC 999.
           77 RESULTADO PIC 999 VALUE 0.
           77 RESTO PIC 999.
       PROCEDURE DIVISION.
           PERFORM UNTIL NUM > 100
           MOVE 0 TO CONTADOR
           MOVE 1 TO I
               PERFORM NUM TIMES
                   DIVIDE NUM BY I GIVING RESULTADO
                   REMAINDER RESTO
                       IF RESTO = 0
                           ADD 1 TO CONTADOR
                       END-IF
                   ADD 1 TO I
               END-PERFORM
           IF CONTADOR = 2
               DISPLAY NUM
           END-IF
           ADD 1 TO NUM
           END-PERFORM.
           STOP RUN.
       END PROGRAM PRIMO.
