      ******************************************************************
      * PROGRAMA COBOL QUE ANALIZA LAS PARTIDAS Y DEVUELVE RESULTADO
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. CHECKGAME.
       AUTHOR. ROSWELL468.
       DATA DIVISION.
       
      ******************************************************************
      * DEFINICION DE VARIABLES, CONSTANSTES Y TABLAS.
      ******************************************************************       
       WORKING-STORAGE SECTION.
       01 VARIABLES.
           05 WS-CURRENT-GAME  PIC X(2).
           05 WS-I             PIC 9(3).
           05 WS-SCORE-P1      PIC 9(3).
           05 WS-SCORE-P2      PIC 9(3).

       01 TABLES.
           05 WS-GAMES-AUX.
               10 WS-TBL-GAMES OCCURS 500 TIMES.
                   15 FILLER       PIC X(2).
                   15 WS-GAME-P1   PIC X(1).
                   15 FILLER       PIC X(3).
                   15 WS-GAME-P2   PIC X(1).
                   15 FILLER       PIC X(4).
                   
           05 WS-GAME-RESULTS      PIC X(27)
                                   VALUE 'RR0PP0SS0RS1PR1SP1RP2PS2SR2'.
           05 FILLER REDEFINES WS-GAME-RESULTS.
               10 WS-GAMES      OCCURS 9 INDEXED BY WS-J.
                   15 WS-GAME   PIC X(2).
                   15 WS-RESULT PIC 9(1).
       
       LINKAGE SECTION.
       01 PARAMETERS.
           05 PA-GAMES         PIC X(500)  VALUE SPACES.
           05 PA-RESULT        PIC X(30)   VALUE SPACES.
           
      ******************************************************************
      * PROGRAMA PRINCIPAL.
      ******************************************************************           
       PROCEDURE DIVISION USING PARAMETERS.
           
           INITIALIZE VARIABLES PA-RESULT
           MOVE PA-GAMES TO WS-GAMES-AUX
          
           PERFORM VARYING WS-I FROM 1 BY 1 
           UNTIL WS-TBL-GAMES(WS-I) = SPACES
               MOVE WS-GAME-P1(WS-I) TO WS-CURRENT-GAME(1:1)
               MOVE WS-GAME-P2(WS-I) TO WS-CURRENT-GAME(2:1)
               PERFORM PROCESS-GAME
           END-PERFORM
           
           PERFORM RETURN-RESULT
           PERFORM END-PROGRAM.

      ******************************************************************
      * VALIDACION DE DATOS Y CALCULO DEL RESULTADO
      ******************************************************************
       PROCESS-GAME.

           SET WS-J TO 1
           SEARCH WS-GAMES
               AT END PERFORM ERROR-VALIDATION
               WHEN WS-GAME(WS-J) = WS-CURRENT-GAME
                   EVALUATE WS-RESULT(WS-J)
                       WHEN 1
                           ADD 1 TO WS-SCORE-P1
                       WHEN 2
                           ADD 1 TO WS-SCORE-P2
                   END-EVALUATE
           END-SEARCH.
               
      ******************************************************************
      * DEVUELVE EL RESULTADO DE LA PARTIDA.
      ******************************************************************
       RETURN-RESULT.

           EVALUATE TRUE
               WHEN WS-SCORE-P1 = WS-SCORE-P2
                   MOVE 'TIE' TO PA-RESULT
               WHEN WS-SCORE-P1 > WS-SCORE-P2
                   MOVE 'PLAYER 1'  TO PA-RESULT 
               WHEN OTHER
                   MOVE 'PLAYER 2'  TO PA-RESULT
           END-EVALUATE.       

      ******************************************************************
      * ERROR EN DATOS DE ENTRADA.
      ******************************************************************
       ERROR-VALIDATION.

           MOVE 'DATOS DE JUGADA INCORRECTOS' TO PA-RESULT
           PERFORM END-PROGRAM.
               
      ******************************************************************
      * FIN DEL PROGRAMA.
      ******************************************************************
       END-PROGRAM. 
           EXIT PROGRAM.
