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
 */
 
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Reto21{
    
    public static void main(String[] args){
        sum(); //Este programa usa la jerarquia de simbolos (PEMDAS)
        //Imprime -14 en Challenge21.txt original: 5+2-1*8-15+4/2
        //Challenge21.txt modificacion 1: 4 * 3 + 5 - 6 / 4 = 15.5
        //Challenge21.txt modificacion 2: 65 * 3 / 5 + 12 = 51
        //Challenge21.txt modificacion 2: 65 * 3 / 5 + = Error de sintaxis
        multAndDivEval("5*5*4+12/2/2"); //Este caso es para aplicar mas de una multiplicacion o division
    } //Cualquier duda sobre el funcionamiento, pueden copiar el codigo y hacerle un debug :)
    
    private static void sum() { //Lee el archico txt del reto
        String path = "/storage/emulated/0/AppProjects/Only Java/Retos/Reto21.txt";
        //Se hizo en un IDE disponible en Android
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(path));
            String line, mathExpression = "";
            while((line = reader.readLine()) != null){
                mathExpression += line;
            }
            reader.close();
            System.out.println(mathExpression);
            multAndDivEval(mathExpression); //Siempre checa primero por multiplicacion y division
            } catch(IOException e){
                e.printStackTrace();
            }
    }
    
    //Esta operacion simplificará la expresion original para solo dejar suma y resta
    //Ej: Le llega 5 + 4 * 2 -> 5 + 8
    private static void multAndDivEval(String expression){
        double result = 0, n1, n2;
        String simplerExpression = expression.replaceAll(" ", "");
        boolean containsMult = expression.indexOf("*") > -1; //Contiene multiplicaciones?
        boolean containsDiv = expression.contains("/"); //Contiene divisiones?
        if(containsMult){
            int multCount = simplerExpression.split("\\*").length - 1; //Cuantas multiplicaciones se haran
            for(int i = 1; i <= multCount; i++){
                String[] mult = simplerExpression.split("\\*"); //5*3+2 -> [5, 3+2], analizar en getFirstNum y getSecondNum
                try {
                    String stringN1 = getFirstNum(mult[0]), stringN2 = getSecondNum(mult[1]);
                    n1 = Double.parseDouble(stringN1); //Valor a la izquierda del operador
                    n2 = Double.parseDouble(stringN2); //Valor a la derecha del operador
                    result = n1 * n2;
                    String replace = stringN1 + "*" + stringN2; //Escribir en string la operacion original
                    int index = simplerExpression.indexOf(replace); //Buscar la operacion en la expresion original
                    simplerExpression = simplerExpression.substring(0, index) + result + simplerExpression.substring(index + replace.length(), simplerExpression.length());
                    //La linea de arriba reemplaza en la expresion: 5*3+2 -> resultadoConDecimal+2
                } catch(ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e){
                    System.out.println("Error de sintaxis");
                    System.exit(2);
                    break;
                } catch(ArithmeticException e){
                    System.out.println("Error Matemático: " + e.getMessage());
                    System.exit(1);
                    break;
                }
            }
        }
        if(containsDiv){
            int divCount = simplerExpression.split("/").length - 1; //Cuantas divisiones se haran
            for(int i = 1; i <= divCount; i++){
                String[] div = simplerExpression.split("/"); //8/4+2 -> [8, 4+2], analizar en getFirstNum y getSecondNum
                try {
                    String stringN1 = getFirstNum(div[0]), stringN2 = getSecondNum(div[1]);
                    n1 = Double.parseDouble(stringN1); //Valor a la izquierda
                    n2 = Double.parseDouble(stringN2); //Valor a la derecha
                    result = n1 / n2;
                    String replace = stringN1 + "/" + stringN2;
                    int index = simplerExpression.indexOf(replace);
                    simplerExpression = simplerExpression.substring(0, index) + result + simplerExpression.substring(index + replace.length(), simplerExpression.length());
                    //La linea de arriba reemplaza en la expresion: 8/4+2 -> resultadoConDecimal+2
                } catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
                    System.out.println("Error de sintaxis");
                    System.exit(2);
                    break;
                } catch(ArithmeticException e){
                    System.out.println("Error Matemático: " + e.getMessage());
                    System.exit(1);
                    break;
                }
            }
        }
        sumEval(simplerExpression);
    }
    
    //A esta operaciom siempre le llegan solo sumas y restas
    private static void sumEval(String expression){
        String num = ""; //Obtener los numeros en string
        char operator = 0;
        boolean numberAvailable = false;
        //numberAvailable sirve para checar si el primer numero de la expresion es negativo
        ArrayList<Double> numsList = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++){
            char current = expression.charAt(i);
            if(isOperator(current) && numberAvailable){
                addToList(numsList, num, operator);
                num = "";
                operator = current;
            } else {
                num += current;
                numberAvailable = true;
            }
        }
        addToList(numsList, num, operator); //Agregar el ultimo numero del loop
        double result = 0;
        for(int i = 0; i < numsList.size(); i++){ //Sumar todos los numeros
        //(En la lista puede haber numeros negativos, y esos se restan)
            result += numsList.get(i);
        }
        String decimal = String.valueOf(result).split("\\.")[1];
        if(decimal.equals("0")){ //Si el numero tiene solo decimal 0, imprimir el numero entero
            System.out.println(Integer.valueOf((int)result));
        } else {
            System.out.println(result);
        }
    }
    
    //Obtiene el numero que esta por detras del operador (*, /)
    //Va obteniendo el numero en reversa hasta encontrarse con cualquier operador
    private static String getFirstNum(String expression){
        String number = "";
        for(int i = expression.length() - 1; i >= 0; i--){
            char current = expression.charAt(i);
            if(current == '-'){ //Checar si el numero es negativo
                number = "-" + number;
                break;
            } else if(isOperator(current)){ //Si el simbolo en curso es un operador, retornar el numero formado
                break;
            } else {
                number = current + number;
                continue;
            }
        }
        return number;
    }
    
    //Obtiene el numero despues del operador (*, /)
    private static String getSecondNum(String expression){
        String number = "";
        for(int i = 0; i < expression.length(); i++){
            char current = expression.charAt(i);
            if(current == '-' && i == 0){ //Checar si el numero a multiplicar es negativo
                number = "-";
                continue;
            } else if(current == '-') { //Si el negativo no es el primer simbolo, sabemos que el - le pertenece a otro numero
                break;
            } else if(isOperator(current)){ //Si el simbolo en curso es un operador, retornar el numero formado
                break;
            } else {
                number += current;
                continue;
            }
        }
        return number;
    }
    
    //Checa si el valor dado es un operador matematico
    private static boolean isOperator(char value){
        switch(value){
            case '+': case '-': case '/': case '*': case '(': case ')': return true;
            default: return false;
        }
    }
    
    //Agrega el numero en formato string a double
    private static void addToList(ArrayList<Double> numsList, String number, char operator){
        try {
            if (operator == 0 || operator == '+') {
                numsList.add(Double.parseDouble(number)); //Agrega el numero tal cual
            } else if (operator == '-') {
                //operator = -, number = 3, en lista se vera como -3
                numsList.add(Double.parseDouble(operator + number));
            }
        } catch (NumberFormatException e) {
            System.out.println("Error de sintaxis");
            System.exit(3);
        }
    }
}
