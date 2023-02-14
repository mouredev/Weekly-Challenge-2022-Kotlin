/*
 * Reto #18
 * TRES EN RAYA
 * Fecha publicación enunciado: 02/05/22
 * Fecha publicación resolución: 09/05/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea una función que analice una matriz 3x3 compuesta por "X" y "O" y retorne lo siguiente:
 * - "X" si han ganado las "X"
 * - "O" si han ganado los "O"
 * - "Empate" si ha habido un empate
 * - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta. O si han ganado los 2.
 * Nota: La matriz puede no estar totalmente cubierta. Se podría representar con un vacío "", por ejemplo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

public class Challenge18 {
    public static void main(String[] args) {
        System.out.println("test");

        String matrizTresEnRaya[][] = {
            {"O","O","X"},
            {"O","X","X"},
            {"X","X","O"}
        };

        System.out.println(comprobarTresEnRaya(matrizTresEnRaya));
    }

    private static String comprobarTresEnRaya(String[][] matrizTresEnRaya) {
        int resultat;
        if(valicionTresEnRaya(matrizTresEnRaya)){
            resultat = comprovarTresEnRaya(matrizTresEnRaya);
        }else{
            return "nulo";
        }

        if (resultat == 2) {
            return "Empate";
        }else if(resultat == 1){
            return "X";
        }else if(resultat == 0){
            return "O";
        }else{
            return "Nulo";
        }

    }

    /**
     * 
     * @param matrizTresEnRaya
     * @return true si la matriz es valida false si la proporcion es incorrecta o hay algun vacio.
     */
    private static boolean valicionTresEnRaya(String[][] matrizTresEnRaya) {

        int countX = 0;
        int countO = 0;

        for (String[] linea : matrizTresEnRaya) {
            for (String valor : linea) {
                if (valor.equals("X")) {
                    countX ++;
                }else if (valor.equals("O")) {
                    countO ++;
                }
            }
        }
        if ((countX == 4 && countO == 5)||(countX == 5 && countO == 4)) {
            return true;
        }else{
            return false;
        }

        
    }
/**
 * 
 * @param matrizTresEnRaya
 * @return 0 si ha ganado O, 1 si ha ganado X, 2 si hay empate, 3 si ganan los 2, 4 si alguien gana 2 veces.
 */
    private static int comprovarTresEnRaya(String[][] matrizTresEnRaya) {
        int winO = 0;
        int winX = 0;

        int count;

        //comprovamos los valores de cada linea horizontal
        for (String[] linea : matrizTresEnRaya) {
            count = 0;
            for (String valor : linea) {
                if(valor.equals("O")){
                    count ++;
                }else if (valor.equals("X")) {
                    count --;
                }
            }
            // puntuamos al ganador si lo hay
            if (count == 3) {
                winO ++;
            }else if (count == -3) {
                winX ++;
            }
        }

        //comprovamos los valores de las lineas verticales
        for (int x = 0; x < 3; x++) {
            count = 0;
            for (int y = 0; y < 3; y++) {
                if(matrizTresEnRaya[y][x].equals("O")){
                    count ++;
                }else if (matrizTresEnRaya[y][x].equals("X")) {
                    count --;
                }
            }

            // puntuamos al ganador si lo hay
            if (count == 3) {
                winO ++;
            }else if (count == -3) {
                winX ++;
            }
        }

        //comprovamos las diagonales
        count = 0;
        for (int i = 0; i < 3; i++) {
            if(matrizTresEnRaya[i][i].equals("O")){
                count ++;
            }else if (matrizTresEnRaya[i][i].equals("X")) {
                count --;
            }
        }
        // puntuamos al ganador si lo hay
        if (count == 3) {
            winO ++;
        }else if (count == -3) {
            winX ++;
        }

        
        int contadorInvertido = 0;
        count = 0;
        for (int i = 2; i >= 0; i--) {

            if(matrizTresEnRaya[contadorInvertido][i].equals("O")){
                count ++;
            }else if (matrizTresEnRaya[contadorInvertido][i].equals("X")) {
                count --;
            }
            contadorInvertido ++;
        }
        // puntuamos al ganador si lo hay
        if (count == 3) {
            winO ++;
        }else if (count == -3) {
            winX ++;
        }

        if ((winX > 1) || (winO >1)) {
            return 4;
        }
        if ((winX == 1) && (winO == 1)) {
            return 4;
        }
        if (winX == 1) {
            return 1;
        }else if(winO == 1){
            return 0;
        }else if(winO == 0 && winX == 0){
            return 3;
        }
        return 0;
    }
}
