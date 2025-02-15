/*
 * Crea un función que reciba un texto y retorne la vocal que
 * más veces se repita.
 * - Ten cuidado con algunos casos especiales.
 * - Si no hay vocales podrá devolver vacío.
 */

/**
 *
 * @param {String} string
 */
const vocalMasComun = (string) => {

    const vocales = string.toLowerCase().match(/[aeiou]/g);
    if (!vocales) return '';  // Retorna vacío si no hay vocales

    return (
        "La letra que más se repite es: " +
        string.split("")
            .filter(
                (word) =>
                    word === "a" || word === "e" || word === "i" || word === "o" || word === "u"
            )
            .reduce((acc, letter) => {
                acc[letter] = (acc[letter] || 0) + 1;                
                return acc;
            })
    );
};

console.log(vocalMasComun("Hola yo soy el que no se repite no no no")); // o
console.log(vocalMasComun("ees es la letraee mas reeepeteee")); // e
console.log(vocalMasComun("xyz")); // ""