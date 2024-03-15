/*
 * Reto #30
 * MARCO DE PALABRAS
 * Fecha publicación enunciado: 26/07/22
 * Fecha publicación resolución: 01/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un texto y muestre cada palabra en una línea, formando
 * un marco rectangular de asteriscos.
 * - ¿Qué te parece el reto? Se vería así:
 *   **********
 *   * ¿Qué   *
 *   * te     *
 *   * parece *
 *   * el     *
 *   * reto?  *
 *   **********
 */

package folder;

public class Reto30 {

    private static int PADDING = 2;
    private static int LATERAL_OFFSET = 2 + PADDING; //2 debido a: 2 asteriscos laterales
    private static int VERTICAL_OFFSET = 2; //2 debido a: 2 bordes verticales

    public static void main(String[] args) {
        printFrame("¿Que te parece el reto?");
        System.out.println();
        printFrame("Standing here, I realize you are just like me trying to make history.");
        System.out.println();
        printFrame("Retos semanales con MoureDev ;)");
        System.out.println();
        
        printFrame2("¿Que te parece el reto?");
        System.out.println();
        printFrame2("Standing here, I realize you are just like me trying to make history.");
        System.out.println();
        printFrame2("Retos semanales con MoureDev ;)");
    } //Resultados disponibles hasta el fondo del archivo

    //Imprimirá el marco metiendo la mayor cantidad de palabras posibles dentro de un renglon
    private static void printFrame(String text) {
        String[] words = text.split(" ");
        int maxRows = words.length + VERTICAL_OFFSET;
        int largerWord = getLargerWord(words) + LATERAL_OFFSET;
        for (int i = 0; i < maxRows; i++) {
            if (i == 0) {
                //Imprimir el vertical de arriba
                printVerticalBorders(largerWord);
                continue;
            }
            int it = i - 1; //Restarle 1 para no obtener un IndexOutOfBoundsException
            try {
                String currentWord = words[it];
                while (it < words.length) {
                    String truncateAttempt = "";
                    try {
                        truncateAttempt = currentWord + " " + words[++it];
                    } catch (ArrayIndexOutOfBoundsException e) {break;}//En caso de pasarnos, salir del while
                    if (truncateAttempt.length() + PADDING > largerWord) break;
                    currentWord = truncateAttempt;
                }
                i = it; //Reasignar i por si hay mas de una palabra por renglon
                currentWord = getFormattedLine(currentWord, largerWord);
                System.out.println(currentWord);
            } catch (ArrayIndexOutOfBoundsException e) {
                continue; //Si se llega aqui es porque todas las palabras estan dentro del marco
            }
        }
        printVerticalBorders(largerWord); //Imprimir el vertical de abajo
    }
    
    //Imprime una sola palabra por linea
    private static void printFrame2(String text){
        String[] words = text.split(" ");
        int maxRows = words.length + VERTICAL_OFFSET;
        int largerWord = getLargerWord(words) + LATERAL_OFFSET;
        for (int i = 0; i < maxRows; i++) {
            if (i == 0) {
                //Imprimir el vertical de arriba
                printVerticalBorders(largerWord);
                continue;
            }
            try {
                System.out.println(getFormattedLine(words[i-1], largerWord));
            } catch(ArrayIndexOutOfBoundsException e) {break;}
        }
        printVerticalBorders(largerWord); //Imprimir el vertical de abajo
    }

    private static int getLargerWord(String[] words) {
        if (words == null || words.length == 0) return 0;
        int maxCount = words[0].length();
        for (int i = 1; i < words.length; i++) {
            int length = words[i].length();
            maxCount = length > maxCount ? length : maxCount;
        }
        return maxCount;
    }

    private static void printVerticalBorders(int length) {
        for (int i = 0; i < length + 3; i++) { // Bug: si no le sumo 3, a los late
            System.out.print("*");
        }
        System.out.println();
    }

    private static String getFormattedLine(String word, int maxSpace) {
        int offset = maxSpace - word.length();
        String totalWord = word;
        String paddingSpace = "*";
        for (int i = 0; i < PADDING; i++) paddingSpace += " ";
        for (int i = 1; i < offset; i++) {
            totalWord += " "; //Agregamos espacios para que todas las lineas sean uniformes
        }
        return paddingSpace + totalWord + reverseStr(paddingSpace);
    }
    
    private static String reverseStr(String text){
        String reversed = "";
        for(int i = text.length() - 1; i >= 0; i--){
            reversed += text.charAt(i);
        }
        return reversed;
    }

}

/*

*************
* ¿Que te   *
* parece    *
* el reto?  *
*************

***************
* Standing    *
* here, I     *
* realize     *
* you are     *
* just like   *
* me trying   *
* to make     *
* history.    *
***************

****************
* Retos        *
* semanales    *
* con          *
* MoureDev ;)  *
****************

*************
* ¿Que      *
* te        *
* parece    *
* el        *
* reto?     *
*************

***************
* Standing    *
* here,       *
* I           *
* realize     *
* you         *
* are         *
* just        *
* like        *
* me          *
* trying      *
* to          *
* make        *
* history.    *
***************

****************
* Retos        *
* semanales    *
* con          *
* MoureDev     *
* ;)           *
****************

*/
