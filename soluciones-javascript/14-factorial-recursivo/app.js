/*
 * Escribe una función que calcule y retorne el factorial de un número dado
 * de forma recursiva.
 */

const factorial = (n) => {
    
    if ( n <= 0 ) return 1; 

    return  n * factorial( n - 1 );

}

console.log(factorial(3));
console.log(factorial(10));