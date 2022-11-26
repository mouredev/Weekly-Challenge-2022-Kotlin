       IDENTIFICATION DIVISION.
       PROGRAM-ID. RETO47.
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       INPUT-OUTPUT SECTION.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
         01 WS-VARIABLES.
           05 WS-TEXT        PIC X(1000) VALUE SPACES.
           05 WS-LENGTH      PIC 9(4)    VALUE ZEROS.
           05 WS-I           PIC 9(4)    VALUE ZEROS.
           05 WS-COUNT-PREV  PIC 9(4)    VALUE ZEROS.

         01 SW-SWITCHES      PIC X(1)    VALUE 'N'.
           88 SW-VOWELS                  VALUE 'Y'.

         01 TABLES.
           05 WS-VOWELS-AUX  PIC X(20)   VALUE 'a000e000i000o000u000'.
             05 FILLER REDEFINES WS-VOWELS-AUX.
               10 WS-VOWELS OCCURS 5 INDEXED BY WS-J.
                 15 WS-VOWEL PIC X(1).
                 15 WS-COUNT PIC 9(3).

       PROCEDURE DIVISION.
         MAIN-PROCEDURE.
           INITIALIZE WS-VARIABLES
           ACCEPT WS-TEXT
           MOVE FUNCTION LOWER-CASE(WS-TEXT) TO WS-TEXT
           INSPECT WS-TEXT CONVERTING "ביםףתüאטלעש" TO "aeiouuaeiou"

           INSPECT FUNCTION REVERSE(WS-TEXT)
           TALLYING WS-LENGTH FOR LEADING SPACES

           COMPUTE WS-LENGTH = LENGTH OF WS-TEXT - WS-LENGTH

           PERFORM VARYING WS-I FROM 1 BY 1 UNTIL WS-I > WS-LENGTH
             SET WS-J TO 1
             SEARCH WS-VOWELS
               WHEN WS-VOWEL(WS-J) = WS-TEXT(WS-I:1)
                 ADD 1 TO WS-COUNT(WS-J)
                 SET SW-VOWELS TO TRUE
           END-PERFORM

           IF SW-VOWELS THEN
             SORT WS-VOWELS ON DESCENDING KEY WS-COUNT
                            ON ASCENDING KEY WS-VOWEL
             PERFORM VARYING WS-I FROM 1 BY 1
                       UNTIL WS-I > 5 OR WS-COUNT(WS-I) < WS-COUNT-PREV
                 DISPLAY WS-VOWEL(WS-I)
                 MOVE WS-COUNT(WS-I) TO WS-COUNT-PREV
             END-PERFORM
           END-IF

           STOP RUN.
