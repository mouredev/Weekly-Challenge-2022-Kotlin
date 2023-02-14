/*
 * Reto #3
 * ¿ES UN NÚMERO PRIMO?
 * Fecha publicación enunciado: 17/01/22
 * Fecha publicación resolución: 24/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

public class Challenge3 {
    public static void main(String[] args) {
        if (itsPrime(37)) {
            System.out.println("El numero 37 es primo.");
        }
        for (int i = 2; i <= 100; i++) {
            if (itsPrime(i)) {
                System.out.println("El numero " + i + " SI es primo.");
            } else {
                System.out.println("El numero " + i + " NO es primo.");
            }
        }
    }

    static boolean itsPrime(int number) {
        double result;
        for (int i = 2; i < number; i++) {
            result = (double) number / i;

            // comprueva si hay decimales en alguna división antes de el mismo o de 1
            // test if there are decimals on any division before itself or 1
            if (((result - (int) result) == 0)) {
                return false;
            }
        }
        return true;
    }
}
