/*
 * Crea tu propio enunciado para que forme parte de los retos de 2023.
 * - Ten en cuenta que su dificultad debe ser asumible por la comunidad y seguir
 * un estilosemejante a los que hemos realizado durante el año.
 * - Si quieres también puedes proponer tu propia solución al reto
 *   (en el lenguaje que quieras).
 */

/*
 * Enunciado: Escribe un programa que reciba una cadena de texto y devuelva las palabras únicas que contiene,
 * ignorando mayúsculas, minúsculas y signos de puntuación. Además, muestra cuántas veces aparece cada palabra repetida.
 * Condiciones:
 * - El programa debe ignorar signos de puntuación como , . ; : ! ?.
 * - No debe diferenciar entre mayúsculas y minúsculas (Hola y hola cuentan como la misma palabra).
 * - Devuelve un listado de palabras ordenado alfabéticamente junto con su frecuencia.
 */

function contarPalabras(texto) {
    // Quitar signos de puntuación y convertir a minúsculas
    const limpio = texto.replace(/[.,;:!?\(\)]/g, "").toLowerCase();
    const palabras = limpio.split(/\s+/);

    const contador = {};
    palabras.forEach((palabra) => {
        contador[palabra] = (contador[palabra] || 0) + 1;
    });

    const ordenado = Object.keys(contador).sort();
    ordenado.forEach((palabra) => {
        console.log(`${palabra}: ${contador[palabra]}`);
    });
}

contarPalabras("Hola mundo! Hola a todos en este hermoso mundo.");
