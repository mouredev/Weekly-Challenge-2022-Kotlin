     /*
      * Escribe una funcion que calcule y retorne el factorial de un
      * numero dado de forma recursiva.
      */
       IDENTIFICATION DIVISION.
       PROGRAM-ID. FACTORIAL RECURSIVE.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
           77 NUM PIC 9(3) VALUE 5.
           77 FACT PIC 9(6) VALUES ZEROES.
       LOCAL-STORAGE SECTION.
           77 NUM-ORI PIC 9(3).
       PROCEDURE DIVISION.
            MOVE NUM TO NUM-ORI.
            IF NUM = 0
                MOVE 1 TO FACT
            ELSE
                SUBTRACT 1 FROM NUM
                CALL "FACTORIAL"
                MULTIPLY NUM-ORI BY FACT
            END-IF.
            DISPLAY NUM-ORI "!=" FACT.
            GOBACK.
       END PROGRAM FACTORIAL.
