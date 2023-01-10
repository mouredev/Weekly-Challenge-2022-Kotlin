/*
 * Reto #6
 * INVIRTIENDO CADENAS
 * Fecha publicación enunciado: 07/02/22
 * Fecha publicación resolución: 14/02/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
 * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

// WAY 1 TO DO IT
function reverse(str){
    let empty = []; // we create a new empty array and split the given one
    str.split("").forEach(element => empty.unshift(element)); // adds all elements to the beginning of the array
    // now we have an array with the elements in reverse order -> we need to convert this to a string
    return empty.join(""); // converts an array to a string by joining the elements with its argument
}

// WAY 2 TO DO IT -> simpler than the oder
function reverse2(str){
    let i = str.length - 1;
    let empty = "";
    while(i >= 0){
        empty += str[i];
        i -= 1;
    }
    return empty;
}

// using the first way
console.log(reverse("Hello world")); // dlrow olleH

// usign the second way
console.log(reverse2("Say something!")); // !gnihtemos yaS