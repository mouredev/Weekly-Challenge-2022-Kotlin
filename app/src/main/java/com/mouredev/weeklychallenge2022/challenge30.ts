/*
 * Reto #30
 * MARCO DE PALABRAS
 * Fecha publicación enunciado: 26/07/22
 * Fecha publicación resolución: 01/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un texto y muestre cada palabra en una línea, formando
 * un marco rectangular de asteriscos.
 * - ¿Qué te parece el reto? Se vería así:
 *   **********
 *   * ¿Qué   *
 *   * te     *
 *   * parece *
 *   * el     *
 *   * reto?  *
 *   **********
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */


/**
 * Funcion que recibe un texto y muestra cada palabra en una línea, formando un marco rectangular de asteriscos.*
 * @param text texto a mostrar en el marco
 */
function frame(text:string){

    let textArray = text.split(" ");
    let maxLength = 0;
    textArray.forEach(word => {
        if(word.length > maxLength){
            maxLength = word.length;
        }
    }
    );
    console.log("*".repeat(maxLength+4));

    textArray.forEach(word => {
        let spaces = "";
        for(let i = 0; i < maxLength - word.length; i++){
            spaces += " ";
        }
        console.log("* " + word + spaces + " *");
    }
    );
    console.log("*".repeat(maxLength+4));

}



frame("En un lugar de la mancha de cuyo nombre no quiero acordarme");
frame("¿Qué te parece el reto?");

