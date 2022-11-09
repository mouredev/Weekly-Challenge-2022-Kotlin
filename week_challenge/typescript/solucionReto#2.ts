// solucion Reto#2
// Dificultad: DIFÍCIL

// LA SUCESIÓN DE FIBONACCI

// Enunciado: Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.
// La serie Fibonacci se compone por una sucesión de números en la que el siguiente siempre es la suma de los dos anteriores.
// 0, 1, 1, 2, 3, 5, 8, 13...

const fib = () => {

    let index:number = 0;
    let next:number = 1;

    while (next < 50) {
        console.log(index);
        let fib = index + next;
        index = next;
        next = fib;
    }
};
fib();

//big(0) time complexity = 0(1)
//big(0) space complexity = 0(1)