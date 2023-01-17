/*
 * Reto #42
 * CONVERSOR DE TEMPERATURA
 * Fecha publicación enunciado: 17/10/22
 * Fecha publicación resolución: 24/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit y viceversa.
 * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" y su unidad ("C" o "F").
 * - En caso contrario retornará un error.
 * - ¿Quieres emplear lo aprendido en este reto?
 *   Revisa el reto mensual y crea una App: https://retosdeprogramacion.com/mensuales2022
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

public class Challenge42 {
    public static void main(String[] args) {
        System.out.println("Degree converter");
        System.out.println("ºC -> ºF and ºF -> ºC");
        String celsius1 = "0.0ºC";
        String celsius2 = "100.0ºC";
        String fahrenheit1 = "32.0ºF";
        String fahrenheit2 = "212.0ºF";
        String result1 = converter(celsius1);
        String result2 = converter(celsius2);
        String result3 = converter(fahrenheit1);
        String result4 = converter(fahrenheit2);
        String result5 = converter("0ºD");
        String result6 = converter("0C");

        String test = celsius1 + " = " + result1;

        if (result1.equals(fahrenheit1)){
            test = test + " CORRECT!";
        }
        else{
            test = test + " INCORRECT!";
        }

        System.out.println(test);

        test = celsius2 + " = " + result2;

        if (result2.equals(fahrenheit2)){
            test = test + " CORRECT!";
        }
        else{
            test = test + " INCORRECT!";
        }

        System.out.println(test);

        test = fahrenheit1 + " = " + result3;

        if (result3.equals(celsius1)){
            test = test + " CORRECT!";
        }
        else{
            test = test + " INCORRECT!";
        }

        System.out.println(test);

        test = fahrenheit2 + " = " + result4;

        if (result4.equals(celsius2)){
            test = test + " CORRECT!";
        }
        else{
            test = test + " INCORRECT!";
        }

        System.out.println(test);

        test = result5;

        if (result5.equals("Invalid value")){
            test = test + " CORRECT!";
        }
        else{
            test = test + " INCORRECT!";
        }

        System.out.println(test);

        test = result6;

        if (result6.equals("Invalid value")){
            test = test + " CORRECT!";
        }
        else{
            test = test + " INCORRECT!";
        }

        System.out.println(test);
    }

    public static String converter(String degrees){
        if (degrees.indexOf('º') == -1){
            return "Invalid value";
        }
        else if(degrees.indexOf('C') == -1 && degrees.indexOf('F') == -1){
            return "Invalid value";
        }
        else if(degrees.indexOf('C') != -1){
            degrees = degrees.replace("ºC", "");
            return String.valueOf((9.0/5.0)*Float.parseFloat(degrees)+32) + "ºF";
        }
        else{
            degrees = degrees.replace("ºF", "");
            return String.valueOf((Float.parseFloat(degrees)-32)/(9.0/5.0)) + "ºC";
        }
    }
}
