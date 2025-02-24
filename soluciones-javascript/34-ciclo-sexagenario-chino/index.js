/*
 * Crea un función, que dado un año, indique el elemento 
 * y animal correspondiente en el ciclo sexagenario del zodíaco chino.
 * - Info: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
 * - El ciclo sexagenario se corresponde con la combinación de los elementos
 *   madera, fuego, tierra, metal, agua y los animales rata, buey, tigre,
 *   conejo, dragón, serpiente, caballo, oveja, mono, gallo, perro, cerdo
 *   (en este orden).
 * - Cada elemento se repite dos años seguidos.
 * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
 */

const cicloSexagenarioChino = (year) => {

    const elements =  [ "madera", "fuego", "tierra", "metal", "agua" ];
    const animals =   [ "rata", "buey", "tigre", "conejo", "dragón", "serpiente", "caballo", "oveja", "mono", "gallo", "perro", "cerdo"];

    if ( year < 604) {
        return "El ciclo sexagenario comenzó en el año 604";
    }

    const sexagenaryYear = Math.floor((year - 4) % 60);
    const elementsYear = elements[Math.floor((sexagenaryYear % 10) / 2)];
    const animalsYear = animals[Math.floor(sexagenaryYear % 12)];


    return `El año ${year}: ${elementsYear} ${animalsYear}`;

}

console.log(cicloSexagenarioChino(1924));
console.log(cicloSexagenarioChino(1946));
console.log(cicloSexagenarioChino(1984));
console.log(cicloSexagenarioChino(604));
console.log(cicloSexagenarioChino(603));
console.log(cicloSexagenarioChino(1987));
console.log(cicloSexagenarioChino(2022));