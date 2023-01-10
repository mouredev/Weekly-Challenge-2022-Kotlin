/*
 * Reto #2
 * LA SUCESIÓN DE FIBONACCI
 * Fecha publicación enunciado: 10/01/22
 * Fecha publicación resolución: 17/01/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.
 * La serie Fibonacci se compone por una sucesión de números en la que el siguiente siempre es la suma de los dos anteriores.
 * 0, 1, 1, 2, 3, 5, 8, 13...
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

// fibonacci function
function fib(i, f1, f2){
    if(i === 0) return 0; // if it's the first fibonacci (i=0), returns 0
    else if(i === 1) return 1; // if it's the second fibonacci (i=1), returns 1
    return f1 + f2; // else, returns the sum of the previous two
}

// we create the previous fibonacci and the one before the previous one
let fib1 = 0;
let fib2 = 0;
// loop to print all the fibonaccis
for(let i=0; i<=50; i++){
    let actualFib = fib(i, fib1, fib2); // uses the function to calculate the actual fibonacci
    console.log(actualFib); // prints the actual fibonacci
    // updates the values
    fib2 = fib1;
    fib1 = actualFib;
}