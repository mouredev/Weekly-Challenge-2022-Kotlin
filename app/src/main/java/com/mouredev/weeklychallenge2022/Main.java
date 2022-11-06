package org.example;

public class Main {

    /*
     * Enunciado: Crea una función que retorne el número total de bumeranes de
     * un array de números enteros e imprima cada uno de ellos.
     * - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números
     *   seguidos, en el que el primero y el último son iguales, y el segundo
     *   es diferente. Por ejemplo [2, 1, 2].
     * - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2]
     *   y [4, 2, 4]).
     */

    public static int Boomerang(int[] array){
        int sum = 0;
        for (int i = 2; i < array.length; i++){
            if(array[i] == array[i-2] && array[i-1] != array[i]){
                sum++;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arreglo = {2, 1, 2, 3, 3, 4, 2, 4};
        System.out.println(Boomerang(arreglo));
    }
}