/*
 * Escribe un programa que muestre por consola (con un print) los
 * números de 1 a 100 (ambos incluidos y con un salto de línea entre
 * cada impresión), sustituyendo los siguientes:
 * - Múltiplos de 3 por la palabra "fizz".
 * - Múltiplos de 5 por la palabra "buzz".
 * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
 */

// 1) mostrar numeros de 1 - 100
 for (let i = 1; i < 100; i++){ //mientras el tope es de 100, sigue iterando hasta el tope
   console.log(i);
   if ( i % 3 === 0 && i % 5 === 0) {
     // 2) mostrar fizzbuzz por cada multiplo de 3 y 5 (es decir, si el numero es divisible por 3 y 5)
     console.log('fizzbuzz');
    } else if (i % 3 === 0 ){
     // 3) mostrar fizz por cada multiplo de 3 (es decir, si el numero es divisible por 3)
       console.log('fizz');
  } else if (i % 5 === 0){
     // 4) mostrar buzz por cada multiplo de 5 (es decir, si el numero es divisible por 5)
     console.log('buzz');
   }
 }
