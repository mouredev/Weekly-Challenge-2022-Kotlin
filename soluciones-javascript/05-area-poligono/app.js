/*
 * Crea una única función (importante que sólo sea una) que sea capaz
 * de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 */

const areaPoligono = ({ tipo = "", datosPoligono = {} }) => {

    const esPositivo = (n) => typeof n === 'number' && n > 0; 

    switch (tipo) {
        case "Triangulo":
            if ( esPositivo(datosPoligono.base) && esPositivo(datosPoligono.altura) ) {
                return (datosPoligono.base * datosPoligono.altura) / 2;
            }else{
                throw new Error("Los datos del triangulo deben ser positivos");
            }
        case "Cuadrado":
            if ( esPositivo(datosPoligono.lado) ) {
                return datosPoligono.lado * datosPoligono.lado;
            }else{
                throw new Error("Los datos del Cuadrado deben ser positivos");
            }    
        case "Rectangulo": 
            if ( esPositivo(datosPoligono.base) && esPositivo(datosPoligono.altura) ) {
                return datosPoligono.base * datosPoligono.altura; 
            }else{
                throw new Error("Los datos del Rectangulo deben ser positivos");
            }
        default:
            throw new Error("Especifica un dato correcto");
    }

}

// Ejemplos de uso
console.log(areaPoligono({ tipo: "Triangulo", datosPoligono: { base: 2, altura: 4 } }));
console.log(areaPoligono({ tipo: "Cuadrado", datosPoligono: { lado: 5 } }));
console.log(areaPoligono({ tipo: "Rectangulo", datosPoligono: { base: 3, altura: 6 } }));