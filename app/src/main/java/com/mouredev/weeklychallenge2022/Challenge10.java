import java.util.HashMap;
import java.util.Map;

/*
 * Reto #10
 * EXPRESIONES EQUILIBRADAS
 * Fecha publicación enunciado: 07/03/22
 * Fecha publicación resolución: 14/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que comprueba si los paréntesis, llaves y corchetes de una expresión están equilibrados.
 * - Equilibrado significa que estos delimitadores se abren y cieran en orden y de forma correcta.
 * - Paréntesis, llaves y corchetes son igual de prioritarios. No hay uno más importante que otro.
 * - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
 * - Expresión no balanceada: { a * ( c + d ) ] - 5 }
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

public class Challenge10 {
    public static void main(String[] args) {
        String text = "{ a * ( c + d ) ] - 5 }";
        System.out.println( testExpression(text));
    }

    /**
     * @param expression expression in string format.
     * @return return TRUE if the expression is balanced, and FALSE if isn't balanced.
     */
    static boolean testExpression(String expression){

        String characters[] = expression.split("");
        Map<String, Integer> mapChars = new HashMap<String, Integer>();

        mapChars.put("{", 0);
        mapChars.put("}", 0);
        mapChars.put("[", 0);
        mapChars.put("]", 0);
        mapChars.put("(", 0);
        mapChars.put(")", 0);

        for (String character : characters) {
            if (mapChars.containsKey(character)) {
                mapChars.put(character, mapChars.get(character)+1);
            }
        }
        
        if (mapChars.get("{") != mapChars.get("}")) {
            return false;
        } else if(mapChars.get("[") != mapChars.get("]")){
            return false;
        }else if (mapChars.get("(") != mapChars.get(")")) {
            return false;
        }
        return true;
    }
}
