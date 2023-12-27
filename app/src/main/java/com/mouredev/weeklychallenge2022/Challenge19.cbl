     /*
      * Crea una funciun que reciba di­as, horas, minutos y segundos
      * (como enteros) y retorne su resultado en milisegundos.
      */
       IDENTIFICATION DIVISION.
       PROGRAM-ID. CONVERSOR.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
           77 HORAS PIC 99.
           77 HORAS-MIL PIC 9(14).
           77 MINUTOS PIC 99.
           77 MINUTOS-MIL PIC 9(10).
           77 SEGUNDOS PIC 99.
           77 SEGUNDOS-MIL PIC 9(6).
           77 DIAS PIC 999.
           77 DIAS-MIL PIC 9(30).
           77 MILISEGUNDOS PIC Z(30) VALUES ZEROES.
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
            DISPLAY "Introduce los dias: "
            ACCEPT DIAS.
            DISPLAY "Introduce las horas: "
            ACCEPT HORAS.
            DISPLAY "Introduce los minutos: "
            ACCEPT MINUTOS.
            DISPLAY "Introduce los segundos: "
            ACCEPT SEGUNDOS.
            MULTIPLY DIAS BY 86400000 GIVING DIAS-MIL.
            MULTIPLY HORAS BY 3600000 GIVING HORAS-MIL.
            MULTIPLY MINUTOS BY 60000 GIVING MINUTOS-MIL.
            MULTIPLY SEGUNDOS BY 1000 GIVING SEGUNDOS-MIL.
            COMPUTE MILISEGUNDOS = DIAS-MIL + HORAS-MIL + MINUTOS-MIL +
                                   MINUTOS-MIL.
            DISPLAY "Los milisegundos son: " MILISEGUNDOS.
            STOP RUN.
       END PROGRAM CONVERSOR.
