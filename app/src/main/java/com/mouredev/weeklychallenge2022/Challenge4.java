package com.mouredev.weeklychallenge2022;
/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
public class Challenge4 {
    public static void areaPoligono(int a, int b, int t){
        switch (t){
            case 1:
                System.out.println("Triguangulo: " + (a*b)/2);
                break;
            case 2:
                System.out.println("Rectangulo: " + a*b);
                break;
            case 3:
                System.out.println("Cuadrado: "+ Math.pow(a,2));
                break;
            default :
                System.out.println("Estas equivocado mijitico");
                break;
        }
    }
    public static void main(String[] args){
        for(int i=1; i<=3; i++){
            areaPoligono(2, 4, i);
        }
    }
}
