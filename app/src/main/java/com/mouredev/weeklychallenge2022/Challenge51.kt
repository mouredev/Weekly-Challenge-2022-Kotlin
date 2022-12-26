package com.mouredev.weeklychallenge2022

/*
 AQUI PROPONGO UNA SERIE DE RETOS QUE SE PODRIAN HACER EL PROXIMO AÑO

Propuesta #1: Contar hacia arriba y hacia abajo

Enunciado: Crea una función que reciba un número entero positivo n y devuelva una lista de enteros
desde 0 hasta n y desde n hasta 0.

Ejemplo:

countUpAndDown(5) -> [0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0]

    --------------

Propuesta #2: Imprimir numeros con pasos

Enunciado: Crea una función que reciba un número entero positivo n y devuelva una lista de enteros
descendente desde n hasta 0

Ejemplo:

countDown(5) -> [5, 4, 3, 2, 1, 0]

    --------------

Propuesta #3: Validar una arbol binario de busqueda

Enunciado: Dado un nodo, validar el árbol de búsqueda binario, asegurándose de que el hijo izquierdo
de cada nodo es menor que el valor del nodo padre, y que el hijo derecho de cada nodo es mayor que
el padre.

    --------------

Propuesta #4: Letra rodeada

Enunciado: Dada una cadena que contiene letras y caracteres +, implemente una función que determine
si cada letra de la cadena está rodeada por un carácter +. Puede haber más de un carácter + entre
letras (+a++b+) y las letras pueden estar rodeadas por el mismo carácter + (+a+b+).

Ejemplo:

surroundedLetter("+a+") // true

surroundedLetter("+ab+") // false

surroundedLetter("+a+b+") // true

surroundedLetter("+a++b++") // true

    --------------

Propuesta #5: Monedas

Enunciado: Dada una cantidad de dinero y una matriz de monedas escribe un método que calcule el
número de formas de hacer la cantidad de dinero con monedas de las monedas disponibles.

Ejemplo:

coins(4, [1, 2, 3]) // 4

    --------------

Propuesta #6: Transciptor de ARN

Enunciado: Dada una cadena de ADN, devuelva su complemento de ARN (por transcripción de ARN).

Tanto la cadena de ADN como la de ARN son una secuencia de nucleótidos.

Los cuatro nucleótidos del ADN son adenina (A), citosina (C), guanina (G) y timina (T).

Los cuatro nucleótidos del ARN son adenina (A), citosina (C), guanina (G) y uracilo (U).

Dada una cadena de ADN, su cadena de ARN transcrita se forma sustituyendo cada nucleótido por su
complemento:

    G -> C
    C -> G
    T -> A
    A -> U

    --------------

Propuesta #7: Color de la resistencia

Enunciado: Si quieres construir algo utilizando una Raspberry Pi, probablemente utilizarás
resistencias. Para este ejercicio, necesitas saber dos cosas sobre ellas:

    Cada resistencia tiene un valor de resistencia.
    Las resistencias son pequeñas, tan pequeñas que si imprimieras el valor de la resistencia en
    ellas, sería difícil de leer.

Para evitar este problema, los fabricantes imprimen bandas de colores en las resistencias para
indicar su valor. Cada banda tiene una posición y un valor numérico.

Las 2 primeras bandas de una resistencia tienen un esquema de codificación sencillo: cada color
corresponde a un único número.

En este ejercicio vas a crear un programa útil para que no tengas que recordar los valores de las
bandas.

Estos colores se codifican de la siguiente manera

    Negro: 0
    Marrón: 1
    Rojo: 2
    Naranja 3
    Amarillo 4
    Verde 5
    Azul: 6
    Violeta: 7
    Gris: 8
    Blanco: 9

El objetivo de este ejercicio es crear una forma

    buscar el valor numérico asociado a una banda de color determinada
    enumerar los diferentes colores de las bandas

La mnemotecnia asigna los colores a los números que, cuando se almacenan en una matriz, se asignan
a su índice en la matriz: Más Vale Que Sea Correcto O Sus Grandes Valores Se Equivocarán.

Puede encontrar más información sobre la codificación de colores de las resistencias en el artículo
de Wikipedia Código electrónico de colores.

    --------------

Y para acabar, tres retos que se podrian catalogar como dificiles


Propuesta #8: Simulacion de cuenta bancaria

Enunciado: Simule una cuenta bancaria con apertura/cierre, reintegros y depósitos de dinero.
¡Cuidado con las transacciones simultáneas!

Se puede acceder a una cuenta bancaria de múltiples maneras. Los clientes pueden realizar ingresos
y reintegros por Internet, teléfono móvil, etc. Los comercios pueden cobrar contra la cuenta.

Crea una cuenta a la que se pueda acceder desde múltiples hilos/procesos.

Debe ser posible cerrar una cuenta; las operaciones contra una cuenta cerrada deben fallar.

    --------------

Propuesta #9: Edad espacial

Enunciado: Dada una edad en segundos, calcula cuántos años tendría alguien en:

    Mercurio: período orbital 0,2408467 años terrestres
    Venus: período orbital 0,61519726 años terrestres
    Tierra: período orbital 1,0 años terrestres, 365,25 días terrestres o 31557600 segundos
    Marte: período orbital 1,8808158 años terrestres
    Júpiter: período orbital 11,862615 años terrestres
    Saturno: período orbital 29,447498 años terrestres
    Urano: período orbital 84,016846 años terrestres
    Neptuno: período orbital 164,79132 años terrestres

Por tanto, si te dijeran que alguien tiene 1.000.000.000 de segundos, deberías poder decir que
tiene 31,69 años terrestres.

    --------------

Propuesta #10: Calculadora de complejos

Enunciado: Suponga que el lenguaje de programación que está utilizando no tiene una implementación
de números complejos. Implementar las sigueintes operaciones: suma, resta, multiplicación y división
de dos números complejos. Ademas calcular el conjugado, valor absoluto, modulo y exponente de un
número complejo dado.



 */
