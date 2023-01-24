import java.util.HashMap;
import java.util.Map;

/*
 * Reto #9
 * CÓDIGO MORSE
 * Fecha publicación enunciado: 02/03/22
 * Fecha publicación resolución: 07/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que sea capaz de transformar texto natural a código morse y viceversa.
 * - Debe detectar automáticamente de qué tipo se trata y realizar la conversión.
 * - En morse se soporta raya "—", punto ".", un espacio " " entre letras o símbolos y dos espacios entre palabras "  ".
 * - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Código_morse.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

public class Challenge9 {
    public static void main(String[] args) {
        System.out.println(convertToMorse("Esto es una prueva, haber si funciona correctamente."));
    }

    static String convertToMorse(String text) {

        String result = "";

        Map<String, String> alphabet = new HashMap<String, String>();
        String characters = "A|B|C|CH|D|E|F|G|H|I|J|K|L|M|N|Ñ|O|P|Q|R|S|T|U|V|W|X|Y|Z|0|1|2|3|4|5|6|7|8|9|.|,|?|\"|/";
        String morseChars = "·-|-···|-·-·|----|-··|·|··-·|--·|····|··|·---|-·-|·-··|--|-·|--·--|---|·--·|--·-|·-·|···|-|··-|···-|·--|-··-|-·--|--··|-----|·----|··---|···--|····-|·····|-····|--···|---··|----·|·-·-·-|--··--|··--··|·-··-·|-··-·";
        System.out.println(characters);

        String charArray[] = characters.split("[|]");
        String morseArray[] = morseChars.split("[|]");

        for (int i = 0; i < morseArray.length; i++) {
            alphabet.put(charArray[i], morseArray[i]);
        }
        for (String letter : text.split("")) {
            if (letter.equalsIgnoreCase(" ")) {
                result += "  ";
            } else {
                result += alphabet.get(letter.toUpperCase()) + " ";
            }
            
        }

        return result;
    }
}
