package com.mouredev.weeklychallenge2022;

import java.util.HashMap;

import static android.text.TextUtils.split;

/*
 * Reto #7
 * CONTANDO PALABRAS
 * Fecha publicación enunciado: 14/02/22
 * Fecha publicación resolución: 21/02/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
public class Challenge7 {
    public static void main(String[] args){
        String texto = "Hola mundo te cuento que el mundo de hoy es un mundo sin gente que dice hola";
        texto = texto.toLowerCase();
        String[] vText = texto.split(" ");
        String[] vTextCopy = texto.split(" ");
        HashMap<String, Integer> hash = new HashMap<>();
        //La idea es ir iterando por cada palabra de vText y comparlarla con todas las palabras de vTextCopy
        for(int i=0; i<vText.length; i++){
            int cont=1, coincidencia=0;
            for(int j=0; j<vTextCopy.length; j++){
                //Si las palabras son iguales
                if(vTextCopy[j].equals(vText[i])){
                    //Aumentamos la coincidencia, siempre una palabra del vector tendra almenos una coincidencia
                    coincidencia++;
                    if(coincidencia>1)
                        hash.put(vTextCopy[j],cont++);
                }
            }
        }
        for(String key : hash.keySet()){
            //Como anteriormente ignoramos las palabras que coincidian una vez con el vecCopia, aquí le sumamos ese 1 ignorado
            System.out.println("La palabra "+ key + " se repitio "+(hash.get(key)+1)+" vez");
        }
    }
}
