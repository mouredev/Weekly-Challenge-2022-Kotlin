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

const numeroAleatorio = Math.floor((Math.random() * 10) + 1)
const numeroAleatorio2 = Math.floor((Math.random() * 10) + 1)

const razasBuenas = [
    {
        nombre: 'pelosos',
        valor: 1,
        ejercito: numeroAleatorio
    },
    {
        nombre: 'sureños buenos',
        valor: 2,
        ejercito: numeroAleatorio
    },
    {
        nombre: 'enanos',
        valor: 3,
        ejercito: numeroAleatorio
    },
    {
        nombre: 'numenóreanos',
        valor: 4,
        ejercito: numeroAleatorio
    },
    {
        nombre: 'elfos',
        valor: 5,
        ejercito: numeroAleatorio
    }
]

const razasMalas = [
    {
        nombre: 'sureños malos',
        valor: 2,
        ejercito: numeroAleatorio2
    },
    {
        nombre: 'orcos',
        valor: 2,
        ejercito: numeroAleatorio2
    },
    {
        nombre: 'goblins',
        valor: 2,
        ejercito: numeroAleatorio2
    },
    {
        nombre: 'Huargos',
        valor: 3,
        ejercito: numeroAleatorio2
    },
    {
        nombre: 'trolls',
        valor: 5,
        ejercito: numeroAleatorio2
    }
]

const ejercitoBueno = () => razasBuenas[Math.floor(Math.random() * razasBuenas.length)]

const ejercitoMalo = () => razasMalas[Math.floor(Math.random() * razasMalas.length)]

function batalla(buenos, malos) {
    if ((buenos.ejercito * buenos.valor) > (malos.ejercito * malos.valor))
        console.log(`${buenos.ejercito} ${buenos.nombre} ganan contra ${malos.ejercito} ${malos.nombre}`)
    if ((buenos.ejercito * buenos.valor) < (malos.ejercito * malos.valor))
        console.log(`${buenos.ejercito} ${buenos.nombre} pierden contra ${malos.ejercito} ${malos.nombre}`)
    if ((buenos.ejercito * buenos.valor) == (malos.ejercito * malos.valor))
        console.log(`${buenos.ejercito} ${buenos.nombre} empatan contra ${malos.ejercito} ${malos.nombre}`)
}

batalla(ejercitoBueno(), ejercitoMalo())