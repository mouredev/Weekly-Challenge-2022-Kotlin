/*
 * Reto #41
 * LA LEY DE OHM
 * Fecha publicación enunciado: 10/10/22
 * Fecha publicación resolución: 17/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que calcule el valor del parámetro perdido correspondiente a la ley de Ohm.
 * - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y retornará el valor del tercero (redondeado a 2 decimales).
 * - Si los parámetros son incorrectos o insuficientes, la función retornará la cadena de texto "Invalid values".
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

// WIP: code copied from MoureDev Discord. Improved but more improvement is possible.

public class Program {

  public static void main(String[] args) {
    System.out.println(calcularLeyOHM("1", null, 4.567));
    System.out.println(calcularLeyOHM(1, null, 4.567));
    System.out.println(calcularLeyOHM("1", "2", "3"));
    System.out.println(calcularLeyOHM(1, 2, 3));
    System.out.println(calcularLeyOHM(null, null, null));
  }

  static String calcularLeyOHM(Object voltage, Object resistence, Object current) {
    String result = "";
    double V, R, I;
    try {
      if (!isDoubleParse(voltage) && isDoubleParse(resistence) && isDoubleParse(current)) {
        R = parseToDouble(resistence);
        I = parseToDouble(current);
        result = "El Voltaje es: " + truncate(voltage(R, I));
      } else if (isDoubleParse(voltage) && !isDoubleParse(resistence) && isDoubleParse(current)) {
        V = parseToDouble(voltage);
        I = parseToDouble(current);
        result = "La Resistencia es: " + truncate(resistance(V, I));
      } else if (isDoubleParse(voltage) && isDoubleParse(resistence) && !isDoubleParse(current)) {
        V = parseToDouble(voltage);
        R = parseToDouble(resistence);
        result = "La Corriente es: " + truncate(current(V, R));
      } else {
        result = "Invalid Values";
      }
    } catch (Exception e) {
      result = "Invalid Values";
      System.out.println(e);
    }
    return result;
  }

  static boolean isDoubleParse(Object number) {
    try {
      Double.parseDouble(number.toString());
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  static double parseToDouble(Object value) {
    return Double.parseDouble(value.toString());
  }

  static double truncate(double value) {
    return (double) Math.round(value * 100) / 100;
  }

  static double voltage(double resistance, double current) {
    return resistance * current;
  }

  static double resistance(double voltage, double current) {
    return voltage / current;
  }

  static double current(double voltage, double resistance) {
    return voltage / resistance;
  }

}
