/*
 * Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
 * - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
 * - EXTRA: ¿Eres capaz de dibujar más figuras?
 */

/**
 *
 * @param {*} size
 * @param {*} type
 */
const dibujarFigurasGeometricas = (size, type) => {
    if (size < 2) throw new Error("El tamaño debe ser 2 o mayor a 2");

    switch (type) {
        case "cuadrado":
            dibujarCuadrado(size);
            break;
        case "triangulo":
            dibujarTriangulo(size);
            break;
        case "rombo":
            dibujarRombo(size);
            break;
        default:
            console.log("Tamaño ingresado no existe, ingrese cuadrado - triangulo - rombo");
            break;
    }
};

const dibujarCuadrado = (size) => {
    
    const linea = "* ".repeat(size);

    for (let i = 0; i < size; i++) {
    
        console.log(linea);
        
    }

}

const dibujarTriangulo = (size) => {

    for (let i = 0; i <= size; i++) {
        
        console.log( " ".repeat(size - i) + "* ".repeat(i));
        
    }

}

const dibujarRombo = (size) => {

    if ( size % 2 === 0){
        console.log("El tamaño del rombo debe ser impar");
        return; 
    }

    let half = Math.floor( size / 2 );

    for (let i = 0; i <= half; i++) {
        console.log(" ".repeat(half - i) + "* ".repeat(i + 1));
    }

    for (let i = half - 1; i >= 0; i--) {
        console.log(" ".repeat(half - i) + "* ".repeat(i + 1));
    }

}

dibujarFigurasGeometricas(11, 'rombo');
dibujarFigurasGeometricas(6, 'triangulo');
dibujarFigurasGeometricas(6, 'cuadrado');