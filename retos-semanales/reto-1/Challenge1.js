//package com.mouredev.weeklychallenge2022

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
 * Autor: Gonzalo Piorno
 * Lenguaje: Javascript
 */


function anagrama (a,b) {

    let str1 = a;
    let str2 = b;
    
    if (str1==str2) {
        return false;
    }
    else if (str1.length==str2.length) {

        for (let i = 0;i<str2.length;i++) {
            let valor = str2.search(str1[i]);
            let valor2 = str1.search(str2[i]);

            if (valor != -1 && valor2!=-1) {
                str1 = str1.slice(i+1);
            }
            else {
                return false;
            }
        }
        return true;        
    }
    else {
        return false
    }
   
}
