
/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */
package com.mouredev.weeklychallenge2022
import java.util.*;

public class SecondHigher
{
    public static void secondHigher(List<Integer> numbers){
        int last = 0;
        ArrayList<Integer> secondHigh = new ArrayList<Integer>();
        
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i)> last)
            {
                last = numbers.get(i);
                secondHigh.add(numbers.get(i));
            }
            
        }
        Integer sec = (secondHigh.size() - 2);
        
        System.out.println("2 " + secondHigh.get(sec));

    }
    public static void main(String[] args) {
		List<Integer> list = Arrays.asList(34,23,43,55,66,56,767,1000,1001,2000,200000);
        secondHigher(list);
	}
}
