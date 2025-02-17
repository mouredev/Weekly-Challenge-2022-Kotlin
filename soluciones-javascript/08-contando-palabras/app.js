/*
 * Crea un programa que cuente cuantas veces se repite cada palabra
 * y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que
 *   lo resuelvan automáticamente.
 */

const countWords = (text) => {
    const cleanedText = text.toLowerCase().replace(/[^\w\s]/g, '');

    const wordsArray = cleanedText.split(/\s+/).filter( word => word !== '');

    const wordCount = {};
    console.log({cleanedText}, {wordsArray});

    wordsArray.forEach(word => {
        wordCount[word] = (wordCount[word] || 0) + 1;
    });

    console.log( { wordsArray, wordCount } );
};

countWords(" Hola, asd  una páasdlabra d asd asd repetida,, hotra a a dsad sad palabraasd  repetida paasdq3wrlabra o hola ");
