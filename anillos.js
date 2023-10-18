/*
 * Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales
 * a Sauron contra otras bondadosas que no quieren que el mal reine
 * sobre sus tierras.
 * Cada raza tiene asociado un "valor" entre 1 y 5:
 * - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3),
 *   Númenóreanos (4), Elfos (5)
 * - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2),
 *   Huargos (3), Trolls (5)
 * Crea un programa que calcule el resultado de la batalla entre
 * los 2 tipos de ejércitos:
 * - El resultado puede ser que gane el bien, el mal, o exista un empate.
 *   Dependiendo de la suma del valor del ejército y el número de integrantes.
 * - Cada ejército puede estar compuesto por un número de integrantes variable
 *   de cada raza.
 * - Tienes total libertad para modelar los datos del ejercicio.
 * Ej: 1 Peloso pierde contra 1 Orco
 *     2 Pelosos empatan contra 1 Orco
 *     3 Pelosos ganan a 1 Orco
 */

let getRandom = (min, max) => { return Math.floor(Math.random() * (max - min + 1) + min) };

const razaBuena = [
    [" Pelosos", 1],
    [" Sureños", 2],
    [" Enanos", 3],
    [" Numenoreanos", 4],
    [" Elfos", 5]]
;
const razaMala = [
    [" Sureños", 2],
    [" Orcos", 2],
    [" Goblins", 2],
    [" Huargos", 3],
    [" Trolls", 5]
];

let getEjercitoBueno = () => {              // Obtenemos aleatoriamente los ejércitos.
    let numOponentes = getRandom(1, 10);    // Primero el número de guerreros Buenos
    let ejercito = [];                      // Aqui vamos a guardar el ejercito
    let fuerza = 0;

    for ( let i = 0; i < numOponentes; i++ ) {
        let temp = getRandom(0, 4);
        ejercito.push(razaBuena[temp][0]);      // Elegimos los atacantes buenos
        fuerza = fuerza + razaBuena[temp][1];   //Suma de la fuerza de ataque de los buenos
    }

    console.log(`El ejercito bueno está compuesto por:${ejercito}, y suma una fuerza de ${fuerza}`);
    return fuerza;
};

let getEjercitoMalo = () => {
    let numOponentes = getRandom(1, 10);
    let ejercito = [];                  // Aqui vamos a ir guardando el ejercito malo
    let fuerza = 0;

    for ( let i = 0; i < numOponentes; i++ ) {
        let temp = getRandom(0, 4);
        ejercito.push(razaMala[temp][0])
        fuerza = fuerza + razaMala[temp][1];
    }

    console.log(`El ejercito malo está compuesto por:${ejercito}, y suma una fuerza de ${fuerza}`);
    return fuerza;
};

let resultado = (buenos, malos) => {
    (buenos > malos)? console.log("Ganan los buenos") : (buenos < malos)?  console.log("Ganan los malos"):  
        console.log("Empate")
};

resultado(getEjercitoBueno(), getEjercitoMalo());