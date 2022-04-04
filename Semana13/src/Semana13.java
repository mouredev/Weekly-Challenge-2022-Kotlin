/*
 *Reto #13
 *FACTORIAL RECURSIVO
 *Fecha publicación enunciado:28/03/22
 *Fecha publicación resolución:04/04/22
 *Dificultad:FÁCIL
 *
 *Enunciado:Escribe una función que calcule y retorne el factorial de un número dado de forma recursiva.
 */
public class Semana13 {
    public static void main(String[] args) {
        System.out.print(calcularFactorial(4));
    }

    public static int calcularFactorial(int num) {
        int factorial;
        if (num == 1) {
            return 1;
        } else {
            factorial = calcularFactorial(num - 1) * num;
            return factorial;
        }
    }
}


