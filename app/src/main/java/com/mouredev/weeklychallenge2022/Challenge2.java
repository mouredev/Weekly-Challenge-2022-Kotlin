package com.company;

public static void Challenge2 (String[] args) {

/*
 * Enunciado: Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.
 * La serie Fibonacci se compone por una sucesión de números en la que el siguiente siempre es la suma de los dos anteriores.
 * 0, 1, 1, 2, 3, 5, 8, 13...
 */

public static void main(String[] args) {
	/*
	Declarar variables
	imprimir primeros numeros
	For (imprimir 50 veces)
	    suma de los numeros
	    imprime el número resultado
	    cambia las variables.
	 */
        long penultimate =0;
        long lastest =1;
        long resultado;
        System.out.println("El primer número es:" + penultimate);
        System.out.println("El segundo número es:" + lastest);

        for (int i=2; i<50; i++){
        resultado = penultimate+lastest;
        System.out.println((i+1) + ": "+ resultado);
        penultimate=lastest;
        lastest=resultado;
        }

}
}
