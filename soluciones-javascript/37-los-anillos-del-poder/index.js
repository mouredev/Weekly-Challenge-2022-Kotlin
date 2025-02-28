/*
 * ¡La Tierra Media está en guerra! En ella lucharán razas leales
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

const razasBondadosas = {
    pelosos: 1, 
    sureniosBuenos: 2,
    enanos: 3,
    numenoreanos: 4, 
    elfos: 5
}

const razasMalvadas = {
    sureniosMalosMalos: 2, 
    orcos: 2, 
    goblins: 2,
    huargos: 3, 
    trolls: 5
}

const calculoRazaVencedora = ( ejercitoBondadoso, ejercitoMalvado ) => {
    let puntosBondadosos = 0;
    let puntosMalvados = 0;

    ejercitoBondadoso.forEach(raza => {
        const [ nombre, cantidad ] = Object.entries(raza)[0];

        if( razasBondadosas[nombre]) {
            puntosBondadosos += razasBondadosas[nombre] * cantidad;
        }
    });

    ejercitoMalvado.forEach(raza => {
        const [ nombre, cantidad] = Object.entries(raza)[0];

        if( razasMalvadas[nombre]) {
            puntosMalvados += razasMalvadas[nombre] * cantidad;
        };
    });


    return puntosBondadosos > puntosMalvados 
            ? 'El bien triunfa sobre el mal'
            : puntosMalvados > puntosBondadosos 
            ? 'El mal triunfa sobre el bien'
            : 'La batalla fue un empate';

}

const ejercitoBondadoso = [
    {pelosos: 2,},
    {sureniosBuenos: 3,},
    {enanos: 4, },
    {numenoreanos: 2, },
    {elfos: 5,},
];
const ejercitoMalvado  = [
    {sureniosMalosMalos: 2,} ,
    {orcos: 2, },
    {goblins: 2,},
    {huargos: 3, },
    {trolls: 5},
];


console.log(calculoRazaVencedora(ejercitoBondadoso, ejercitoMalvado));