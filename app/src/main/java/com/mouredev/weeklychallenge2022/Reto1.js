
/*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function isAnAnagram(word1, word2){

    if(word1 == word2){
        return false;
    }else{
        let first = word1.split("");
        let second = word2.split("");
        let count = 0;

        first.sort();
        second.sort();

        for(let i = 0; i < first.length; i++){
            for(let j = 0; j < second.length;j++){
                if(first[i] == second[j]){
                    count++;
                }
            }
        }

        if(count == first.length){
            return true;
        }else{
            return false;
        }
    }
}

isAnAnagram("amores", "roma");