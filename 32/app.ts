// Dado un listado de numeros, encuentra el SEGUNDO más grande.
// Ejemplo:
// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// El segundo numero mas grande es: 9
// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
// El segundo numero mas grande es: 14
// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
// El segundo numero mas grande es: 19

// Declaramos una variable con el array de numeros
const numbers = [24, 16, 0, 123, 565, 34, 445, 445, 445, 12, 3];

// Borramos los items duplicados y creamos un nuevo array sin los duplicados
const uniqueNumbers = [...new Set(numbers)];

// Declaramos una variable que guardarar el segundo numero mas grande.
// Utilizamos la funcion .sort() para ordenar el array de numeros ordenador de mayor a menor.
// Al ser un array seleccionamos la posición [1] que sería el segundo más grande.
const secondMaxNumber = uniqueNumbers.sort((a, b) => b - a)[1];
// Resultado actual sin seleccionar la posicion [1]
// [ 565, 445, 123, 34, 24, 16, 12, 3, 0 ]

// Hacemos un print por pantalla de la solución final
console.log(secondMaxNumber); // Resultado actual => 445
