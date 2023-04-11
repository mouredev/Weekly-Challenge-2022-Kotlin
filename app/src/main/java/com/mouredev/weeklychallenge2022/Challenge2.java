/*
Reto #2
LA SUCESIÓN DE FIBONACCI
Fecha publicación enunciado: 10/01/22
Fecha publicación resolución: 17/01/22
Dificultad: DIFÍCIL

Enunciado: Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.
La serie Fibonacci se compone por una sucesión de números en la que el siguiente siempre es la suma de los dos anteriores.
0, 1, 1, 2, 3, 5, 8, 13...
 */
package weeklychallenge2022;

public class Challenge2 {

    public static void main(String[] args) {

        long[] vector = new long[50];

        for (int i = 0; i < vector.length; i++) {

            switch (i) {
                case 0:
                    vector[i] = 0;
                    break;
                case 1:
                    vector[i] = 1;
                    break;
                default:
                    vector[i] = vector[i - 2] + vector[i - 1];
            }
            
            System.out.println("[" + vector[i] + "]");
        }
        
    }
}
