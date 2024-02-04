     /*
      * Escribe un programa que imprima los 50 primeros numeros de la
      * sucesion de Fibonacci empezando en 0.
      * - La serie Fibonacci se compone por una sucesiun de numeros en
      *   la que el siguiente siempre es la suma de los dos anteriores.
      *   0, 1, 1, 2, 3, 5, 8, 13...
      */
       IDENTIFICATION DIVISION.
       PROGRAM-ID. FIBONACCI.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
           77 CONTADOR PIC 99.
           77 SUMA PIC 9(10) VALUE 0.
           77 NUM1 PIC 9(10) VALUE 0.
           77 NUM2 PIC 9(10) VALUE 1.

       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
            PERFORM SUCESION VARYING CONTADOR FROM 0 BY 1 UNTIL
            CONTADOR > 49.
            STOP RUN.
       SUCESION.
           DISPLAY NUM1.
           ADD NUM1 TO NUM2 GIVING SUMA.
           MOVE NUM2 TO NUM1.
           MOVE SUMA TO NUM2.
       END PROGRAM FIBONACCI.
