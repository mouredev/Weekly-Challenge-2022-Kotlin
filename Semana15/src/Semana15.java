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
 */

import java.util.GregorianCalendar;

public class Semana15 {

    public static void main(String[] args) {
        String date1 = "30/06/1990";
        String date2 = "27/04/1988";
        System.out.println("Total: " + daysBetweenDates(date1, date2));

        String date3 = "15/04/2022";
        String date4 = "dd/$$/2022";
        System.out.println("Total: " + daysBetweenDates(date3, date4));
    }

    public static int daysBetweenDates(String date1, String date2) {
        long result = 0;
        try {

            final int MILLISECONDS_DAY = 86400000;
            final int DAY = 0;
            final int MONTH = 1;
            final int YEAR = 2;

            String[] date1Format = date1.trim().split("/");
            String[] date2Format = date2.trim().split("/");
            GregorianCalendar fecha1 = new GregorianCalendar(Integer.parseInt(date1Format[YEAR]), Integer.parseInt(date1Format[MONTH]), Integer.parseInt(date1Format[DAY]));
            GregorianCalendar fecha2 = new GregorianCalendar(Integer.parseInt(date2Format[YEAR]), Integer.parseInt(date2Format[MONTH]), Integer.parseInt(date2Format[DAY]));

            long t1 = fecha1.getTimeInMillis();
            long t2 = fecha2.getTimeInMillis();
            result = Math.abs(t2 - t1) / MILLISECONDS_DAY;


        } catch (Exception e) {
            System.out.println("Wrong date!");
        }

        return (int) result;
    }

}