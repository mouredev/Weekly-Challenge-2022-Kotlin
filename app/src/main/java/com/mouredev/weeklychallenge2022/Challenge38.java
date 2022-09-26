package com.mouredev.weeklychallenge2022

/*
 * Reto #38
 * BINARIO A DECIMAL
 * Fecha publicación enunciado: 19/09/22
 * Fecha publicación resolución: 27/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
public class Program
{
   public static void main(String[] args) {
      try {
         System.out.println(binarioADecimal("1101010111"));
         System.out.println(binarioADecimal("11"));
         System.out.println(binarioADecimal("0"));
         System.out.println(binarioADecimal("1000005"));
      } catch(binarioExcepcion be) {
         System.out.println(be.getMessage());
      }
   }
   
   public static int binarioADecimal(String binario) throws binarioExcepcion {
      if (!binario.matches("^[0-1]+")) {
         throw new binarioExcepcion("El número " + binario + " no es un número binario.");
      }
      
      int decimal = 0;
      int potencia = 0;
      
      for(int i = binario.length(); i > 0; i--) {
         decimal += Character.getNumericValue(binario.charAt(i - 1)) * Math.pow(2, potencia);
         potencia++;
      }

      return decimal;
   }
   
   public static class binarioExcepcion extends Exception {
      public binarioExcepcion(String mensajeError) {
         super(mensajeError);
      }
   }
}
