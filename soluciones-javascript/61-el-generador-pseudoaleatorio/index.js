/*
 * Crea un generador de números pseudoaleatorios entre 0 y 100.
 * - No puedes usar ninguna función "random" (o semejante) del
 *   lenguaje de programación seleccionado.
 *
 * Es más complicado de lo que parece...
 */

const generadorPseudoaleatorio = (seed) => {

    let current = seed;
    const m = 101;  // Módulo (define el rango 0-100)
    const a = 31;   // Multiplicador
    const c = 7;    // Incremento

    return function next() {
        current = (a * current + c) % m;
        return current;
    };

}

const random = generadorPseudoaleatorio(Date.now() % 101);

console.log(random());
console.log(random());
console.log(random());