      ******************************************************************
      * LLAMADO A PROGRAMA COBOL (CHECKGAME) PARA ANALIZAR PARTIDAS
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. CHALLENGE25.
       AUTHOR. ROSWELL468.
       DATA DIVISION.

      ******************************************************************
      * DEFINICION DE VARIABLES Y CONSTANSTES.
      ******************************************************************
       WORKING-STORAGE SECTION.
       01 PARAMETERS.
           05 PA-GAMES         PIC X(500)  VALUE SPACES.
           05 PA-RESULT        PIC X(30)   VALUE SPACES.
           
      ******************************************************************
      * PROGRAMA PRINCIPAL.
      ******************************************************************
       PROCEDURE DIVISION.

           INITIALIZE PARAMETERS

           MOVE '("P","R"), ("S","S"), ("R","S")' TO PA-GAMES
           CALL 'CHECKGAME' USING PARAMETERS
           DISPLAY PA-RESULT
           
           MOVE '("R","S"), ("S","R"), ("P","S")' TO PA-GAMES
           CALL 'CHECKGAME' USING PARAMETERS
           DISPLAY PA-RESULT

           MOVE '("R","S"), ("S","P"), ("P","S"), ("P","S"), ' &            
      -         '("P","R"), ("R","R"), ("P","S")' TO PA-GAMES
           CALL 'CHECKGAME' USING PARAMETERS
           DISPLAY PA-RESULT
           
           MOVE '("R","S"), ("X","P")' TO PA-GAMES
           CALL 'CHECKGAME' USING PARAMETERS
           DISPLAY PA-RESULT
                      
           STOP RUN.
