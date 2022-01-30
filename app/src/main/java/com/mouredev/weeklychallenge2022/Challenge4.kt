       IDENTIFICATION DIVISION.
       PROGRAM-ID. AUTAREA.

      ***-----------------------------------------------------------***
      * Reto 4: ÁREA DE UN POLÍGONO                                   *
      *                                                               *
      * Fecha publicación enunciado: 24/01/22                         *
      * Fecha publicación resolución: 31/01/22                        *
      * Dificultad: FÁCIL                                             *
      *                                                               *
      * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea    *
      * una) que sea capaz de calcular y retornar el área de un       *
      * polígono.                                                     *
      * - La función recibirá por parámetro sólo UN polígono a la vez.*
      * - Los polígonos soportados serán Triángulo, Cuadrado y        *
      *   Rectángulo.                                                 *
      * - Imprime el cálculo del área de un polígono de cada tipo.    *
      *                                                               *
      * Información adicional:                                        *
      * - Usa el canal de Discord (https://mouredev.com/discord)      *
      *   "reto-semanal" para preguntas, dudas o prestar ayuda la     *
      *   comunidad.                                                  *
      * - Puedes hacer un Fork del repo y una Pull Request al repo    *
      *   original para que veamos tu solución aportada.              *
      * - Revisaré el ejercicio en directo desde Twitch el lunes      *
      *   siguiente al de su publicación.                             *
      * - Subiré una posible solución al ejercicio el lunes siguiente *
      *   al de su publicación.                                       *
      ***-----------------------------------------------------------***
       ENVIRONMENT DIVISION.

       CONFIGURATION SECTION.
       SOURCE-COMPUTER. AS-400.
       OBJECT-COMPUTER. AS-400.
       SPECIAL-NAMES.
           DECIMAL-POINT IS COMMA.

       INPUT-OUTPUT SECTION.
       FILE-CONTROL.

       DATA DIVISION.

       WORKING-STORAGE SECTION.
      ***-------------------***
       01  VARIABLES.
           05  TIPO                PIC  X(10)       VALUE SPACES.
           05  TIPO-TRIANGULO      PIC  X(10)       VALUE SPACES.
           05  BASE                PIC  9(03)V9(03) VALUE 0.
           05  ALTURA              PIC  9(03)V9(03) VALUE 0.
           05  RAIZ                PIC  9(04)V9(03) VALUE 0.
           05  CUADRADO1           PIC  9(04)V9(03) VALUE 0.
           05  CUADRADO2           PIC  9(04)V9(03) VALUE 0.
           05  PERIMETRO           PIC  9(04)V9(03) VALUE 0.
           05  SEMI                PIC  9(04)V9(03) VALUE 0.
           05  SPR1                PIC  9(04)V9(03) VALUE 0.
           05  SPR2                PIC  9(04)V9(03) VALUE 0.
           05  SPR3                PIC  9(04)V9(03) VALUE 0.

       01  SWITCHES.
           05  SW-FIN-COMVAF       PIC  1.
               88 NO-FIN-COMVAF         VALUE B"0".
               88 SI-FIN-COMVAF         VALUE B"1".

           05  SW-ERROR            PIC  1.
               88 NO-ERROR              VALUE B"0".
               88 SI-ERROR              VALUE B"1".

       LINKAGE SECTION.
       01  RG-UTLAREA.
           03  ENTRADA.
               05 E-LADO1          PIC 9(03).
               05 E-LADO2          PIC 9(03).
               05 E-LADO3          PIC 9(03).

           03  SALIDA.
               05 S-AREA           PIC 9(03)V9(03).

       PROCEDURE DIVISION USING RG-UTLAREA.

       PROGRAMA.
            PERFORM INICIO.

            PERFORM PROCESO
              UNTIL SI-FIN-PROCESO.

            PERFORM FIN.

      *
      *
      ***-----------------------------------------------------------***
      *    En este párrafo:                                           *
      *     - Se inicializan las variables utilizadas en              *
      *       el proceso.                                             *
      *     - Se validan los datos de entrada.                        *
      ***-----------------------------------------------------------***
       INICIO.
      * -- Inicializamos las variables utilizadas por el proceso
           INITIALIZE VARIABLES
            REPLACING ALPHANUMERIC DATA  BY SPACES
                      NUMERIC      DATA  BY ZEROS.

           SET NO-ERROR                  TO TRUE.
           SET NO-FIN-PROCESO            TO TRUE.

      * -- Inicializamos la salida del proceso.
           INITIALIZE SALIDA OF RG-UTLAREA.

      * -- Validaciones de los parametros de entrada
           PERFORM VALIDAR-ENTRADA.

      *
      ***-----------------------------------------------------------***
       VALIDAR-ENTRADA.
      * -- Comprobamos que al menos el primer lado esté informado
      * -- con un valor numérico > 0 (no se asignaria valor negativo
      * -- ya que la variable es un entero sin signo).
           IF E-LADO1 OF RG-UTLAREA IS NOT NUMERIC
           OR E-LADO1 OF RG-UTLAREA <= 0
              SET SI-FIN-PROCESO
                  SI-ERROR               TO TRUE

              DISPLAY "DEBE INFORMAR AL MENOS UN LADO DEL POLIGONO "
                      "CON UN VALOR NUMERICO"
           END-IF.

      * -- Si ha entrado algun valor raro en el resto de
      * -- parametros de la entrada, lo pondremos a 0.
           IF E-LADO2 OF RG-UTLAREA IS NOT NUMERIC
              MOVE 0                     TO E-LADO2
           END-IF.

           IF E-LADO3 OF RG-UTLAREA IS NOT NUMERIC
              MOVE 0                     TO E-LADO3
           END-IF.

      *
      *
      ***-----------------------------------------------------------***
      *    En este párrafo:                                           *
      *     - Cálculo del area de un poligono dados sus lados         *
      ***-----------------------------------------------------------***
       PROCESO.
           IF LADO2 > 0
              IF LADO3 = 0
                 MOVE "RECTANGULO"       TO TIPO
                 COMPUTE S-AREA = E-LADO1 * E-LADO2
              ELSE
                 MOVE "TRIANGULO"        TO TIPO
                 PERFORM TRATAR-TRIANGULO
              END-IF
           ELSE
              MOVE "CUADRADO"            TO TIPO
              COMPUTE S-AREA = E-LADO1 * E-LADO1
           END-IF.

      *
      ***-----------------------------------------------------------***
       TRATAR-TRIANGULO.
      * -- Si los  tres  lados son iguales  : triangulo equilatero
      * -- Si dos de los lados son iguales  : triangulo isosceles
      * -- Si los  tres  lados son distintos: triangulo escaleno
           IF E-LADO1 = E-LADO2
              IF E-LADO1 = E-LADO3
                 MOVE "EQUILATERO"       TO TIPO-TRIANGULO
                 PERFORM TRATAR-EQUILATERO
              ELSE
                 MOVE E-LADO3            TO BASE
                 MOVE E-LADO1            TO LADO
                 MOVE "ISOSCELES"        TO TIPO-TRIANGULO
                 PERFORM TRATAR-ISOSCELES
              END-IF
           ELSE
              IF E-LADO1 = E-LADO3
                 MOVE E-LADO2            TO BASE
                 MOVE E-LADO1            TO LADO
                 MOVE "ISOSCELES"        TO TIPO-TRIANGULO
                 PERFORM TRATAR-ISOSCELES
              ELSE
                 IF E-LADO2 = E-LADO3
                    MOVE E-LADO1         TO BASE
                    MOVE E-LADO2         TO LADO
                    MOVE "ISOSCELES"     TO TIPO-TRIANGULO
                    PERFORM TRATAR-ISOSCELES
                 ELSE
                    MOVE "ESCALENO"      TO TIPO-TRIANGULO
                    PERFORM TRATAR-ESCALENO
              END-IF
           END-IF.

      *
      ***-----------------------------------------------------------***
       TRATAR-EQUILATERO.
      * -- Se calcula la raiz cuadrada de tres y el lado al cuadrado.
           COMPUTE RAIZ ROUNDED = 3 ** (1 / 2).
           COMPUTE CUADRADO1 ROUNDED = E-LADO1 ** 2.

      * -- Se multiplica la raiz anterior por el lado al cuadrado y
      * -- se divide entre entre dos para obtener el area
      * -- en un triangulo equilatero
           COMPUTE S-AREA ROUNDED = (RAIZ * CUADRADO1) / 2.

      *
      ***-----------------------------------------------------------***
       TRATAR-ISOSCELES.
           COMPUTE CUADRADO1 = LADO ** 2.
           COMPUTE CUADRADO2 = BASE ** 2.
           COMPUTE RAIZ = (CUADRADO1 - (CUADRADO2 / 4)) ** (1 / 2).

           COMPUTE S-AREA ROUNDED = (BASE * RAIZ) / 2.

      *
      ***-----------------------------------------------------------***
       TRATAR-ESCALENO.
           COMPUTE PERIMETRO = E-LADO1 + E-LADO2 + E-LADO3.
           COMPUTE SEMI = PERIMETRO / 2.
           COMPUTE SPR1 = SEMI - E-LADO1.
           COMPUTE SPR2 = SEMI - E-LADO2.
           COMPUTE SPR3 = SEMI - E-LADO3.

           COMPUTE S-AREA ROUNDED = (SEMI * SPR1 * SPR2 * SPR3) ** 0.5.

      *
      *
      ***-----------------------------------------------------------***
      *    Escritura de informe final.                                *
      *    Fin del programa.                                          *
      ***-----------------------------------------------------------***
       FIN.
           IF NO-ERROR
              DISPLAY "TIPO POLIGONO: ", TIPO
              EVALUATE TIPO
               WHEN "CUADRADO"
                 DISPLAY "LADO ....... : " E-LADO1

               WHEN "RECTANGULO"
                 DISPLAY "BASE ....... : " E-LADO1
                 DISPLAY "ALTURA ..... : " E-LADO2

               WHEN "TRIANGULO"
                 DISPLAY TIPO-TRIANGULO
                 DISPLAY "LADO 1 ..... : " E-LADO1
                 DISPLAY "LADO 2 ..... : " E-LADO2
                 DISPLAY "LADO 3 ..... : " E-LADO3
              END-EVALUATE

              DISPLAY "AREA ........: ", S-AREA
           ELSE
              DISPLAY "SE PRODUJO UN ERROR. REVISE LOS DATOS"
           END-IF.

           GOBACK.