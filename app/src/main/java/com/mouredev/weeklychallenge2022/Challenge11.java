import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Reto #11
 * ELIMINANDO CARACTERES
 * Fecha publicación enunciado: 14/03/22
 * Fecha publicación resolución: 21/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos cadenas como parámetro (str1, str2) e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO estén presentes en str1.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

public class Challenge11 {
    public static void main(String[] args) {

        charsNoIncluded("Hola como va.", "Hola que tal.");

    }

    /**
     * Take the 2 inputs and compate them, shows the chars not present in the other
     * input.
     * 
     * @param phrase1 String for first input
     * @param phrase2 String for second input
     */
    static void charsNoIncluded(String phrase1, String phrase2) {
        List <String> firstList = new ArrayList<String>();
        List <String> secnodList = new ArrayList<String>();
        String phraseFirst[] = phrase1.split("");
        String phraseSecond[] = phrase2.split("");

        String resultOne = "", resultTwo = "";

        

        for (String character1 : phraseFirst) {
            if (!firstList.contains(character1)) {
                firstList.add(character1);
            }
        }
        for (String character2 : phraseSecond) {
            if (!secnodList.contains(character2)) {
                secnodList.add(character2);
            }
        }

        for (String character : firstList) {
            if (!secnodList.contains(character)) {
                resultOne += character;
            }

        }
        for (String character : secnodList) {
            if (!firstList.contains(character)) {
                resultTwo += character;
            }
        }

        System.out.println("Result 1:" + resultOne);
        System.out.println("Result 2:" + resultTwo);


    }
}
