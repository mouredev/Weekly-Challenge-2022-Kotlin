import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;

/*
 * Reto #15
 * ¿CUÁNTOS DÍAS?
 * Fecha publicación enunciado: 11/04/22
 * Fecha publicación resolución: 18/04/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea una función que calcule y retorne cuántos días hay entre dos cadenas de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se lanzará una excepción.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

public class Challenge15 {
    public static void main(String[] args) {
        calculoDias("15/12/2021", "17/11/2021");
    }

    private static int calculoDias(String date1, String date2) {
        LocalDate firstDate, secondDate;
        Period rangeDate;

        firstDate = formatDate(date1);
        if (firstDate != null) {
            secondDate = formatDate(date2);
            if (secondDate != null) {
                rangeDate = Period.between(firstDate, secondDate);
                System.out.println(Math.abs(rangeDate.getDays()));
            }
        } 
        return 0;
    }

    private static LocalDate formatDate(String dateInput){
        try {
            LocalDate date = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return date;
        } catch (DateTimeException e) {
            // TODO: handle exception
            System.out.println("The format is incorrect dd/MM/yyyy");
            return null;
        }
    }

}
