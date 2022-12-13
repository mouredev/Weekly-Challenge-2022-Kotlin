package com.mouredev.weeklychallenge2022

/*
 * Reto #50
 * LA ENCRIPTACIÓN DE KARACA
 * Fecha publicación enunciado: 12/11/22
 * Fecha publicación resolución: 19/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto utilizando el
 * algoritmo de encriptación de Karaca (debes buscar información sobre él).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

public class Solucion_50 {

public static void encriptadorKaraca(String texto) {
        //Primero se reversa el texto original:
        StringBuilder sb = new StringBuilder(texto).reverse();
        texto = sb.toString().toLowerCase().replaceAll(" ", "");

        //Segundo: se reemplazan las vocales presentes en el texto:
        Map<Character, Character> mapaVocales = new HashMap<>();
        mapaVocales.put('a', '0');
        mapaVocales.put('e', '1');
        mapaVocales.put('i', '2');
        mapaVocales.put('o', '2');
        mapaVocales.put('u', '3');
        for(int i=0; i < texto.length(); i++) {
            if(mapaVocales.containsKey(texto.charAt(i))) {
                texto = texto.replace(texto.charAt(i), mapaVocales.get(texto.charAt(i)));
            }
        }

        //Tercero: se agrega "aca" al final del texto resultante luego de los pasos anteriores:
        texto = texto.concat("aca");

        System.out.println(texto);

    }


    public static void main(String[] args) {
        //karacasEncriptador("apple");
        encriptadorKaraca("apple"); // esperado "1lpp0aca"
        encriptadorKaraca("karaca"); // esperado "0c0r0kaca"
        encriptadorKaraca("mouredev"); // esperado "v1d1r32maca"

    }

}
