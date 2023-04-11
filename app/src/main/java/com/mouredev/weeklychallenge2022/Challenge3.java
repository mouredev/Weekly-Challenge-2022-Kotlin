/*
Reto #3
¿ES UN NÚMERO PRIMO?
Fecha publicación enunciado: 17/01/22
Fecha publicación resolución: 24/01/22
Dificultad: MEDIA

Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
Hecho esto, imprime los números primos entre 1 y 100.
 */
package weeklychallenge2022;

public class Challenge3 {

    public static void main(String[] args) {

        System.out.println("Los números primos entre 1 y 100 son:");

        for (int i = 1; i <= 100; i++) {
            if (esPrimo(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean esPrimo(int num) {
        
        if(num <= 1){
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
