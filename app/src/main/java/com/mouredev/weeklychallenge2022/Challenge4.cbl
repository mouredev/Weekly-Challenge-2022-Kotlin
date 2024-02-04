     /*
      * Crea una unica funcion (importante que solo sea una) que sea
      * capaz de calcular y retornar el Ã¡rea de un poli­gono.
      * - La funcion recibira por parametro solo UN poli­gono a la vez.
      * - Los poli­gonos soportados seran Triangulo, Cuadrado y
      *Rectangulo.
      * - Imprime el calculo del area de un poli­gono de cada tipo.
      */
       IDENTIFICATION DIVISION.
       PROGRAM-ID. AREA_POL.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
           77 CALC PIC 99V99 VALUE 0.
           77 BASE PIC 99V99 VALUE 0.
           77 ALTURA PIC 99V99 VALUE 0.
           01 POLIGONO PIC X(10) VALUE SPACES.
               88 TRI VALUE "triangulo".
               88 CUA VALUE "cuadrado".
               88 REC VALUE "rectangulo".
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
            DISPLAY "Dime el poligono(triangulo, rectangulo, cuadrado):"
            ACCEPT POLIGONO.

            EVALUATE TRUE
                WHEN TRI
                    DISPLAY "Dime la base: "
                    ACCEPT BASE
                    DISPLAY "Dime la altura: "
                    ACCEPT ALTURA
                    MULTIPLY BASE BY ALTURA GIVING CALC
                    DIVIDE CALC BY 2 GIVING CALC
                    DISPLAY "El area del rectangulo introducido es "CALC

                WHEN REC
                    DISPLAY "Dime la base: "
                    ACCEPT BASE
                    DISPLAY "Dime la altura: "
                    ACCEPT ALTURA
                    MULTIPLY BASE BY ALTURA GIVING CALC
                    DISPLAY "El area del rectangulo introducido es "CALC

                WHEN CUA
                   DISPLAY "Dime el lado: "
                   ACCEPT BASE
                   MULTIPLY BASE BY BASE GIVING CALC
                   DISPLAY "El area del cuadrado introducido es " CALC

               WHEN OTHER
               DISPLAY "Poligono no contemplado. Fin del programa".



            STOP RUN.
       END PROGRAM AREA_POL.
