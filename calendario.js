/*
 * Enunciado: Crea un función, que dado un año, indique el elemento 
 * y animal correspondiente en el ciclo sexagenario del zodíaco chino.
 * - Info: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
 * - El ciclo sexagenario se corresponde con la combinación de los elementos
 *   madera, fuego, tierra, metal, agua y los animales rata, buey, tigre,
 *   conejo, dragón, serpiente, caballo, oveja, mono, gallo, perro, cerdo
 *   (en este orden).
 * - Cada elemento se repite dos años seguidos.
 * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
 */

const elementos = ['madera', 'madera', 'fuego', 'fuego', 'tierra', 'tierra', 'metal', 'metal', 'agua', 'agua'];
const animales = ['rata', 'buey', 'tigre', 'conejo', 'dragón', 'serpiente', 'caballo', 'oveja', 'mono', 'gallo', 'perro', 'cerdo']


const posicionCiclo = (anio) => {

    const preCiclo = Math.floor(anio % 60) - 3
    switch (preCiclo) {
        case -3:
            return 57;
        case -2:
            return 58;
        case -1:
            return 59;
        case 0:
            return 60;
                
        default:
            return  Math.floor(anio % 60) - 3;
    }
}

const cicloSexagenario = (anio) => {

    const ciclo = posicionCiclo(anio)
    const indexElementos = Math.floor(ciclo % 10) -1;
    const indexAnimales = Math.floor(ciclo % 12) -1;

    console.log(signoChino(elementos[indexElementos], animales[indexAnimales]))
    console.log(ciclo)
}

const signoChino = (elemento, animal) => {

    return (
        `Su signo es ${animal} ${elemento}`
    )
}

cicloSexagenario(1)