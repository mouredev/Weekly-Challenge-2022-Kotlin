package com.mouredev.weeklychallenge2022
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
        ArrayList<String> operacion = fileToArray("src/main/resources/test.txt");
        if (checkFormat(operacion)) {
            System.out.println(calculate(operacion));
        } else {
            System.out.println("No se cumple el formato del fichero");
        }
    }

    private static ArrayList<String> fileToArray(String fileName) {
        ArrayList<String> lines = new ArrayList<>();

        File file = new File(fileName);
        try (FileInputStream fis = new FileInputStream(file);
             BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (EOFException e) {
            System.out.printf("End of file reached: %s%n", e.getMessage());
        } catch (IOException ef) {
            System.out.println("Error reading file");
        } finally {
            return lines;
        }

    }

    private static boolean checkFormat(ArrayList<String> lines) {

        if (lines.size() % 2 == 0) {
            return false;
        }
        for (int i = 0; i < lines.size(); i++) {
            if (i % 2 == 0) {
                if (!isNumeric(lines.get(i))) {
                    return false;
                }
            } else {
                if (!isSign(lines.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("\\d+(\\.\\d+)?");
    }

    private static boolean isSign(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("[+-/*]");
    }

    private static float calculate(ArrayList<String> operacion) {
        float result = 0;
        for (int i = 0; i < operacion.size(); i++) {
            if (i % 2 == 0) {
                if (i == 0) result = Float.parseFloat(operacion.get(i));
            } else {
                switch (operacion.get(i)) {
                    case "+":
                        result += Float.parseFloat(operacion.get(++i));
                        break;
                    case "-":
                        result -= Float.parseFloat(operacion.get(++i));
                        break;
                    case "*":
                        result *= Float.parseFloat(operacion.get(++i));
                        break;
                    case "/":
                        result /= Float.parseFloat(operacion.get(++i));
                        break;
                }
            }
        }
        return result;
    }
}