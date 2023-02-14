/*
 * Reto #22
 * CONJUNTOS
 * Fecha publicación enunciado: 01/06/22
 * Fecha publicación resolución: 07/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos array, un booleano y retorne un array.
 * - Si el booleano es verdadero buscará y retornará los elementos comunes de los dos array.
 * - Si el booleano es falso buscará y retornará los elementos no comunes de los dos array.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

public class Challenge22 {
    public static void main(String[] args) throws Exception {

        String array1[] = {"a","b","c","d"};

        String array2[] = {"i","b","h","d", "d"};

        Boolean option = true;

        String result[] = compareArray(array1,array2,option);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    private static String[] compareArray(String[] array1, String[] array2, Boolean option) {

        List<String> llista1 = Arrays.asList(array1);
        List<String> llista2 = Arrays.asList(array2);

        List<String> resultList = new ArrayList<String>();

        for (String string : llista1) {
            if (llista2.contains(string)) {
                resultList.add(string);
            }
        }

        String[] result = new String[resultList.size()];
        resultList.toArray(result);
        return result;
    }
}