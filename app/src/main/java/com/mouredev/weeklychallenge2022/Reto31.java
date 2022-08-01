/*
 * Reto #31
 * AÑOS BISIESTOS
 * Fecha publicación enunciado: 01/08/22
 * Fecha publicación resolución: 08/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que imprima los 30 próximos años bisiestos siguientes a uno dado.
 * - Utiliza el menor número de líneas para resolver el ejercicio.
 */

package folder;
import java.util.Calendar;
import java.util.Arrays;

public class Reto31 {
    
    public static void main(String[] args){
        calculateLeapYear(2019);
        calculateLeapYear(2016);
        calculateLeapYear(1980);
        calculateLeapYear(2013);
    }
    
    //12 lineas. 14 si contamos la declaracion del metodo y su } final
    private static void calculateLeapYear(int year){
        Calendar c = Calendar.getInstance();
        c.set(year, c.FEBRUARY, 1); //Siempre ajustar el mes a febrero
        if(c.getActualMaximum(c.DAY_OF_MONTH) <= 28) {
            System.out.println(year + " no es bisiesto");
            return;
        } else {
            int[] nextYears = new int[30];
            for (int i = 0; i < 30; i++) {
                nextYears[i] = year + (i == 0 ? 4 : nextYears[i - 1] - year + 4);
            }
            System.out.println("Los proximos 30 años bisiestos despues de " + year + " son: " + Arrays.toString(nextYears));
        }
    }
    
}
