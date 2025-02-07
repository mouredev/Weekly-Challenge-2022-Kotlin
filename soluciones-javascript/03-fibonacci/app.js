/*
 * * LA SUCESIÓN DE FIBONACCI *
 * Escribe un programa que imprima los 50 primeros números de la sucesión
 * de Fibonacci empezando en 0.
 * - La serie Fibonacci se compone por una sucesión de números en
 *   la que el siguiente siempre es la suma de los dos anteriores.
 *   0, 1, 1, 2, 3, 5, 8, 13...
 */


const sucesionFibonacci = ( cantidadNumeros ) => {

    if ( cantidadNumeros < 0 ) return console.log(0);
    
    let anterior = 0;
    let actual = 1;

    for (let i = 0; i < cantidadNumeros; i++) {
        
        console.log(`${ i + 1 }_:  ${anterior}`);
        
        let temp = anterior; 
        anterior = actual + anterior; 
        actual = temp; 

    }


}



sucesionFibonacci( 50 );
