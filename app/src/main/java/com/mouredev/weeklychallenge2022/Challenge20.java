/*
 * Reto #20
 * PARANDO EL TIEMPO
 * Fecha publicación enunciado: 16/05/22
 * Fecha publicación resolución: 23/05/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que sume 2 números y retorne su resultado pasados unos segundos.
 * - Recibirá por parámetros los 2 números a sumar y los segundos que debe tardar en finalizar su ejecución.
 * - Si el lenguaje lo soporta, deberá retornar el resultado de forma asíncrona, es decir, sin detener la ejecución del programa principal. Se podría ejecutar varias veces al mismo tiempo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

import java.util.Scanner;

public final class Challenge20 extends Thread {

    int valor1, valor2;

    public Challenge20(int valor1, int valor2) {

        this.valor1 = valor1;
        this.valor2 = valor2;

    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("El valor es: " + (valor1 + valor2));
    }


    public static void main(String[] args) {

        try (Scanner myObj = new Scanner(System.in)) {
            boolean finalizar = false;

            while (!finalizar) {
                System.out.println("Dos números enteros separados por espacio, 'end' finaliza el programa:");
                String numberInput = myObj.nextLine();
                if (numberInput.equals("end")) {
                    finalizar = true;
                } else {
                    String numeros[] = numberInput.split(" ");
                    Challenge20 T1 = new Challenge20(Integer.parseInt(numeros[0]), Integer.parseInt(numeros[1]));
                    T1.start();
                }

            }
        }

    }
}