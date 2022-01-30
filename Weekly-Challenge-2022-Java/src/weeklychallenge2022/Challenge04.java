/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weeklychallenge2022;

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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
/**
 *
 * @author Brais
 */
public class Challenge04 {

    final static int TRIANGULO = 0;
    final static int CUADRADO = 1;
    final static int RECTANGULO = 2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(area(TRIANGULO, 5, 3));
        System.out.println(area(CUADRADO, 4, 0));
        System.out.println(area(RECTANGULO, 4, 2));
    }

    public static float area(int poligono, float base, float altura) {
        switch (poligono) {
            case TRIANGULO:
                return base * altura / 2;
            case CUADRADO:
                return base * base;
            case RECTANGULO:
                return base * altura;
            default:
                return -1;
        }
    }

}
