package com.mouredev.weeklychallenge2022

/*
 * Reto #48
 * EL CALENDARIO DE ADEVIENTO 2022
 * Fecha publicación enunciado: 28/11/22
 * Fecha publicación resolución: 05/12/22
 * Dificultad: FÁCIL
 *
 * ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
 * 24 días, 24 regalos sorpresa relacionados con desarrollo de software, ciencia y tecnología desde el 1 de diciembre.
 *
 * Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne lo siguiente:
 * - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el regalo de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
 * - Si la fecha es anterior: Cuánto queda para que comience el calendario.
 * - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
 *
 * Notas:
 * - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00 y finaliza a las 23:59:59.
 * - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos y segundos.
 * - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo del calendario de aDEViento hasta el día de su corrección (sorteo exclusivo para quien entregue su solución).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

	/*
     * ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
     * 24 días, 24 regalos sorpresa relacionados con desarrollo de software,
     * ciencia y tecnología desde el 1 de diciembre.
     *
     * Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne
     * lo siguiente:
     * - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el regalo
     *   de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
     * - Si la fecha es anterior: Cuánto queda para que comience el calendario.
     * - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
     *
     * Notas:
     * - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00
     *   y finaliza a las 23:59:59.
     * - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos
     *   y segundos.
     * - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo
     *   del calendario de aDEViento hasta el día de su corrección
     *   (sorteo exclusivo para quien entregue su solución).
     */
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.time.temporal.ChronoUnit;
import java.util.*;
public class CalendarioADEViento {    
    
  public static void main(String[] args) {    
  
   LocalDateTime tempDateTime = LocalDateTime.parse("2022-11-30T23:59:59");
   
   String txtCalendario = fechaCalendarioADEViento(tempDateTime);
   System.out.println(txtCalendario);
   
  } 
  
  public static String fechaCalendarioADEViento(LocalDateTime fecha){
      
        LocalDateTime inicioCalendarioAdviento = LocalDateTime.parse("2022-12-01T00:00:00");
        LocalDateTime finCalendarioAdviento = LocalDateTime.parse("2022-12-24T23:59:59");
        long dias = ChronoUnit.DAYS.between(fecha, inicioCalendarioAdviento);
        
        long horas = ChronoUnit.HOURS.between(fecha, inicioCalendarioAdviento);
        long minutos = ChronoUnit.MINUTES.between(fecha, inicioCalendarioAdviento);
        long segundos = ChronoUnit.SECONDS.between(fecha, inicioCalendarioAdviento);
        
        String texto = "";
            if(dias <= 0){
                if(horas <= 0){
                    if(minutos <= 0){
                        if(segundos <= 0){
                            dias = ChronoUnit.DAYS.between(finCalendarioAdviento, fecha);
                            segundos = ChronoUnit.SECONDS.between(finCalendarioAdviento, fecha);
                            minutos = ChronoUnit.MINUTES.between(finCalendarioAdviento, fecha);
                            horas = ChronoUnit.HOURS.between(finCalendarioAdviento, fecha);
                            if(dias >= 0 && segundos < 60 && segundos > 0){
                                texto = "Han pasado " + segundos + " segundos desde la finalización del calendario";
                                }else if(dias >= 0 && minutos < 60 && minutos > 0){
                                     texto = "Han pasado " + minutos + " minutos desde la finalización del calendario";
                                     }else if(dias >= 0 && horas < 24 && horas > 0){
                                        texto = "Han pasado " + horas + " horas desde la finalización del calendario";
                                     }else if(dias > 0)  {
                                          texto = "Han pasado " + dias + " dias desde la finalización del calendario";
                                     }else{
                                        Integer diaSeleccionado = fecha.getDayOfMonth();
                                        texto = "Enhorabuena ha conseguido un premio relacionado con el calendario de aDEViento y le ha tocado: " + obtenerPremioAdviento(diaSeleccionado) + ",a disfrutarlo!!!!!!!!!!"; 
                                     }
                        }else{
                            texto = "Quedan " + segundos + " segundos para el comienzo del calendario";
                        }
                    }else{
                        segundos = segundos - 60;
                        texto = "Quedan " + minutos + " minutos y " + segundos  + " segundos para el comienzo del calendario";
                    }
                }else{
                     
                     texto = "Quedan " + horas + " horas para el comienzo del calendario";
                }
            }else{
                texto = "Quedan " + dias + " días para el comienzo del calendario";
            
            }
        
        return texto;
  }
  
  public static String obtenerPremioAdviento(Integer day){
      Map<Integer, String> map = new HashMap<Integer, String>();
      map.put(1, "Libro Clean Code");
      map.put(2, "Curso JavaScript por los mejores profesionales");
      map.put(3, "5 Subscripciones");
      map.put(4, "Entrada a evento Java");
      map.put(5, "Curso C# por los mejores expertos");
      map.put(6, "Bootcamp desarrollo Web");
      map.put(7, "Licencia Software Microsoft");
      map.put(8, "Vale descuento 150€ Amazon");
      map.put(10, "5 décimos para la lotería de Navidad");
      map.put(11, "2 Entradas para la final del mundial de Qatar");
      map.put(12, "Entrada para Conferencia de Elon Musk");
      map.put(13, "Esacapada de fin de semana para 2 personas por España");
      map.put(14, "Viaje al caribe para 2 personas");
      map.put(15, "Libro Java más curso SpringBoot");
      map.put(16, "Dominio y hosting gratis durante un año para tu alojamiento web");
      map.put(17, "Raspberry pi último modelo");
      map.put(18, "PC nuevo a elegir mediante componentes en PCComponentes");
      map.put(19, "Kit de robótica de Arduino más curso para aprender a utilizarlo");
      map.put(20, "Play Station 5");
      map.put(21, "Patinente eleéctrico Xiaomi");
      map.put(22, "Kit de Alexa para smart home");
      map.put(23, "Experiencia gastronómica por España para 2 personas");
      map.put(24, "Cesta de Navidad");
      
      String premio = map.get(day);
      return premio;
  }         
}
