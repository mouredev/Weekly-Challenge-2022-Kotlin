package challenge2;

/**
 * Solución Reto #2 "LA SUCESIÓN DE FIBONACCI" Lenguaje: Java
 *
 * @author JoseSerpaCode
 */
public class Challenge2 {

    public static void main(String[] args) {
        long num1 = 0;
        long num2 = 1;

        System.out.println(num1);
        System.out.println(num2);

        for (int i = 0; i < 50; i++) {
            System.out.println(num1 + num2);
            num2 += num1;
            num1 = num2 - num1;
        }
    }
}
