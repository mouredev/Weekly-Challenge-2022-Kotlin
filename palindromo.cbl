       IDENTIFICATION DIVISION.
       PROGRAM-ID. PALINDROMO.
       ENVIRONMENT     DIVISION.
       DATA            DIVISION.
       WORKING-STORAGE SECTION.
       01  ELTEXTO     PIC X(8000). * variable que contiene el texto
       01  MITEXTO     PIC X(8000). * variable con el texto sin signos raros
       01  LARGO       PIC 9(4). * largo del texto
       01  MITAD       PIC 9(4). * mitad de longitud del texto 
       01  LI          PIC 9(4). * contador
       01  XX          PIC 9(4). * contador
       01  C1          PIC 9.    * booleano
       PROCEDURE       DIVISION.
      * Aceptamos el texto y primero cambiamos los carácteres con tilde.
           ACCEPT ELTEXTO 
           INSPECT ELTEXTO CONVERTING "ÁÉÍÓÚáéíóú" TO "AEIOUAEIOU"
      * Averiguamos la longitud del texto introducido y quitamos todo lo que no sean letras o números 
      * el restulado se guarda en la variable MITEXTO.     
           MOVE FUNCTION UPPER-CASE(ELTEXTO) TO ELTEXTO
           COMPUTE LARGO = FUNCTION STORED-CHAR-LENGTH(ELTEXTO)
           INITIALIZE XX MITEXTO
           PERFORM VARYING LI FROM 1 BY 1 UNTIL LI > LARGO
              IF (ELTEXTO(LI:1) >= '0' AND ELTEXTO(LI:1) <= '9') 
              OR (ELTEXTO(LI:1) >= 'A' AND ELTEXTO(LI:1) <= 'Z') 
                 ADD 1 TO XX MOVE ELTEXTO(LI:1) TO MITEXTO(XX:1)
              END-IF
           END-PERFORM
      * Volvemos a ver la longitud de Mitexto y dividimos entre 2.
           COMPUTE LARGO = FUNCTION STORED-CHAR-LENGTH(MITEXTO)
           COMPUTE MITAD = LARGO / 2
      * Recorremos la variable con el string comparando el primero con el último y sucesivos     
           MOVE 0 TO C1
           PERFORM VARYING LI FROM 1 BY 1 UNTIL LI > MITAD OR C1 = 1
              IF MITEXTO(LI:1) NOT = MITEXTO(LARGO:1) MOVE 1 TO C1 END-IF
              COMPUTE LARGO = LARGO - 1
           END-PERFORM
           IF C1 = 0 DISPLAY 'PERFECTO' ELSE DISPLAY 'ERROR' END-IF
        STOP RUN.
