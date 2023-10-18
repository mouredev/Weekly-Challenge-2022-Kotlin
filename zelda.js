/*
 * Enunciado: ¡Han anunciado un nuevo "The Legend of Zelda"! 
 * Se llamará "Tears of the Kingdom" y se lanzará el 12 de mayo de 2023.
 * Pero, ¿recuerdas cuánto tiempo ha pasado entre los distintos
 * "The Legend of Zelda" de la historia?
 * Crea un programa que calcule cuántos años y días hay entre 2 juegos de Zelda
 * que tú selecciones.
 * - Debes buscar cada uno de los títulos y su día de lanzamiento 
 *   (si no encuentras el día exacto puedes usar el mes, o incluso inventártelo)
 */


const juegos = [
    {
        nombre: 'The Legend of Zelda',
        fecha: new Date('1986-2-21')
    },
    {
        nombre: 'The Legend of Zelda: A Link to the Past',
        fecha: new Date('1991-11-21')
    },
    {
        nombre: 'The Legend of Zelda: Ocarina of Time',
        fecha: new Date('1998-9-27')
    },
    {
        nombre: "The Legend of Zelda: Majora's Mask",
        fecha: new Date('2000-1-27')
    },
    {
        nombre: 'The Legend of Zelda: The Wind Waker',
        fecha: new Date('2002-9-14')
    },
    {
        nombre: 'The Legend of Zelda: Twilight Princess',
        fecha: new Date('2006-11-24')
    },
    {
        nombre: 'The Legend of Zelda: Skyward Sword',
        fecha: new Date('2011-11-20')
    },
    {
        nombre: 'The Legend of Zelda: Breath of the Wild',
        fecha: new Date('2017-2-3')
    },
    {
        nombre: 'The Legend of Zelda: Tears of the Kingdom',
        fecha: new Date('2023-4-12')
    }
];

function diferencia(fecha1, fecha2) {
    const anio = fecha1.fecha.getFullYear() - fecha2.fecha.getFullYear()
    const dias = Math.round(Math.ceil(fecha1.fecha - fecha2.fecha) / (1000 * 60 * 60 * 24))
    return { anio, dias }
}
const { anio, dias } = diferencia(juegos[8], juegos[0])

console.log(`El año es ${anio} y los dias son ${dias}`)