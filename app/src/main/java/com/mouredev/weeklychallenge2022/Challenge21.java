import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Reto #21
 * CALCULADORA .TXT
 * Fecha publicación enunciado: 23/05/22
 * Fecha publicación resolución: 01/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Lee el fichero "Challenge21.txt" incluido en el proyecto, calcula su resultado e imprímelo.
 * - El .txt se corresponde con las entradas de una calculadora.
 * - Cada línea tendrá un número o una operación representada por un símbolo (alternando ambos).
 * - Soporta números enteros y decimales.
 * - Soporta las operaciones suma "+", resta "-", multiplicación "*" y división "/".
 * - El resultado se muestra al finalizar la lectura de la última línea (si el .txt es correcto).
 * - Si el formato del .txt no es correcto, se indicará que no se han podido resolver las operaciones.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

public class Challenge21 {
    public static void main(String[] args) {

        File fileCalculator = new File("Clallenge21/src/Challenge21.txt");

        ArrayList<String> arrayListLines = new ArrayList<String>();
        int lineIndex = 0;
        try {
            Scanner fileRead = new Scanner(fileCalculator);

            while (fileRead.hasNext()) {
                arrayListLines.add(lineIndex, fileRead.nextLine());
                lineIndex++;
            }

            fileRead.close();
        } catch (Exception e) {
            System.err.println("No se puede leer el fichero.");
        }
        if (checkFile(arrayListLines)) {
            System.out.println(makeOperations(arrayListLines));
        }else{
            System.err.println("No se han podido realizar las operaciones.");
        }
    }

    private static boolean checkFile(ArrayList<String> textList) {
        int i = 1;

        while (i < textList.size()) {
            try {
                if (i == 1) {
                    if (!isNumber((String) textList.get(i - 1))) {
                        return false;
                    }
                }
                if (!isOperation((String) textList.get(i))) {
                    return false;
                }
                if (!isNumber((String) textList.get(i + 1))) {
                    return false;
                }
            } catch (IndexOutOfBoundsException e) {
                return false;
            }

            i = i + 2;
        }

        return true;
    }

    public static boolean isNumber(String text) {
        try {
            Float.parseFloat(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static boolean isOperation(String text) {
        switch (text) {
            case "+":
                return true;
            case "-":
                return true;
            case "*":
                return true;
            case "/":
                return true;
            default:
                return false;
        }
    }

    private static String makeOperations(ArrayList<String> listValues) {
        int i = 1;
        Float result = 0f;
        while (i < listValues.size()) {

            if (i == 1) {
                result = Float.parseFloat((String) listValues.get(i - 1));
            }
            switch ((String) listValues.get(i)) {
                case "+":
                    result = result + Float.parseFloat((String) listValues.get(i + 1));
                    break;
                case "-":
                    result = result - Float.parseFloat((String) listValues.get(i + 1));
                    break;
                case "*":
                    result = result * Float.parseFloat((String) listValues.get(i + 1));
                    break;
                case "/":
                    result = result / Float.parseFloat((String) listValues.get(i + 1));
                    break;
                default:
                    break;
            }

            i = i + 2;
        }

        return Float.toString(result);
    }

}