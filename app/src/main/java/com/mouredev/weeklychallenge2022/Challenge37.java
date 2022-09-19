import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

   public class Program
   {
      private static final Map<String, String> titulosZelda = new HashMap<>() {{
         put("The Legend of Zelda", "21/02/1986");
         put("The Adventure of Link", "14/01/1987");
         put("A Link to the Past", "21/11/1991");
         put("Link's Awakening", "06/06/1993");
         put("Ocarina of Time", "21/11/1998");
         put("Majora's Mask", "27/04/2000");
         put("Oracle of Seasons", "27/02/2001");
         put("Oracle of Ages", "27/02/2001");
         put("The Wind Waker", "13/12/2002");
         put("A Link to the Past", "14/03/2003");
         put("The Minish Cap", "04/11/2004");
         put("Twilight Princess", "02/12/2006");
         put("Spirit Tracks", "23/12/2009");
         put("Skyward Sword", "23/11/2011");
         put("A Link Between Worlds", "26/12/2013");
         put("Tri Force Heroes", "22/10/2015");
         put("Breath of the Wild", "03/03/2017");
         put("Tears of the Kingdom", "12/05/2023");
      }};

      public static void main(String[] args) {
         System.out.println(diferenciaTiempoJuegos("Tri Force Heroes", "Tears of the Kingdom"));
         System.out.println(diferenciaTiempoJuegos("Spirit Tracks", "The Legend of Zelda"));
         System.out.println(diferenciaTiempoJuegos("Spirit Tracks", "peras"));
         System.out.println(diferenciaTiempoJuegos("manzanas", "Spirit Tracks"));
         System.out.println(diferenciaTiempoJuegos("Oracle of Seasons", "Oracle of Ages"));
      }

      public static String diferenciaTiempoJuegos(String primerTitulo, String segundoTitulo) {
         if(!titulosZelda.containsKey(primerTitulo)) {
            return "No existe el título " + primerTitulo;
         }
         if(!titulosZelda.containsKey(segundoTitulo)) {
            return "No existe el título " + segundoTitulo;
         }
         int anios;
         int meses;
         int dias;
         try {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate primeraFecha = LocalDate.parse(titulosZelda.get(primerTitulo), df);
            LocalDate segundaFecha = LocalDate.parse(titulosZelda.get(segundoTitulo), df);
            Period diferencia = Period.between(primeraFecha, segundaFecha);
            
            anios = Math.abs(diferencia.getYears());
            meses = Math.abs(diferencia.getMonths());
            dias = Math.abs(diferencia.getDays());
         } catch(DateTimeException dte) {
         
         return("La fecha de algún titulo es incorrecta.\n" + dte.getMessage());
      }
      return "La diferencia entre \"" + primerTitulo + "\" y \"" + segundoTitulo + "\" es de " 
         + anios + " años, " + meses + " meses y " + dias + " dias.";
   }
}
