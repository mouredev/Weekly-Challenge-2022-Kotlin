/*
 * Reto #14
 * ¿ES UN NÚMERO DE ARMSTRONG?
 * Fecha publicación enunciado: 04/04/22
 * Fecha publicación resolución: 11/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función que calcule si un número dado es un número de Amstrong (o también llamado narcisista).
 * Si no conoces qué es un número de Armstrong, debes buscar información al respecto.
 */

public class Semana14 {

    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
        System.out.println(isArmstrong(255));
        System.out.println(isArmstrong(-304));
        System.out.println(isArmstrong(407));
    }

    public static boolean isArmstrong(int num) {
        boolean isArmstrong = false;
        if (num < 0) {
            isArmstrong = false;
        } else {
            String aux = Integer.toString(num);
            double numAux = 0;
            int result = 0;

            for (int i = 0; i < aux.length(); i++) {
                numAux = Double.parseDouble(String.valueOf(aux.charAt(i)));
                result += Math.pow(numAux, aux.length());
            }

            if (num == result) {
                isArmstrong = true;
            }
        }
        return isArmstrong;
    }
}

