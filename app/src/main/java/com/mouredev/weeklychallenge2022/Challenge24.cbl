       IDENTIFICATION DIVISION.
       PROGRAM-ID. CHALLENGE24.
       ENVIRONMENT DIVISION.
       DATA DIVISION.
       WORKING-STORAGE SECTION.
           01 VARIABLES.
               05 WS-IDX PIC 9(3).

       PROCEDURE DIVISION.
      * METODO 1
           MOVE 1 TO WS-IDX
           PERFORM UNTIL WS-IDX > 100
               DISPLAY WS-IDX
               ADD 1 TO WS-IDX
           END-PERFORM

      * METODO 2
           PERFORM VARYING WS-IDX FROM 1 BY 1 UNTIL WS-IDX > 100
               DISPLAY WS-IDX
           END-PERFORM

           STOP RUN.
