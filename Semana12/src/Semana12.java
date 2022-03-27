/* Reto #12
 * ¿ES UN PALÍNDROMO?
 * Fecha publicación enunciado: 21/03/22
 * Fecha publicación resolución: 28/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba un texto y retorne verdadero o falso (Boolean) según sean o no palíndromos.
 * Un Palíndromo es una palabra o expresión que es igual si se lee de izquierda a derecha que de derecha a izquierda.
 * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 * Ejemplo: Ana lleva al oso la avellana.
 */
public class Semana12 {

    public static void main(String[] args) {

        String prueba1 = "Ana lleva al oso la avellana.";
        String prueba2 = "Sé verlas al revés";
        String prueba3 = "No soy un palindromo";
        String prueba4 = "Isaac no ronca así";

        System.out.println(esPalindromo(prueba1));
        System.out.println(esPalindromo(prueba2));
        System.out.println(esPalindromo(prueba3));
        System.out.println(esPalindromo(prueba4));

    }

    public static boolean esPalindromo(String text) {

        text = text.toLowerCase()
                .replace("á", "a").replace("é", "e")
                .replace("í", "i").replace("ó", "o")
                .replace("ú", "u").replace(" ", "")
                .replace(".", "").replace(",", "");

        String newText = "";

        for (int i = text.length() - 1; i > -1; i--) {
            newText += text.charAt(i);
        }

        return newText.equals(text);
    }

}
