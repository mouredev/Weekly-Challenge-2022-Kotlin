import java.util.*;
 
public class Program {
   public enum Efectividad {
      EFECTIVO(2),
      NEUTRAL(1),
      POCO_EFECTIVO(0.5);
      
      private final double efecto;
      
      private Efectividad(double efecto) {
         this.efecto = efecto;
      }
      
      public double getEfecto() {
         return efecto;
      }
   }
   public enum TipoPokemon {
       AGUA, FUEGO, PLANTA, ELECTRICO;
   }

   public static void main(String[] args) {
      Pokemon atacante = new Pokemon(TipoPokemon.ELECTRICO);
      Pokemon defensor = new Pokemon(TipoPokemon.AGUA);
      
      System.out.println("Atacante: " + atacante.getTipo());
      System.out.println("Defensor: " + defensor.getTipo());
      try {
         System.out.printf("El daño es de %.2f", danioAtaquePokemon(atacante, defensor, 20, 70));
      }catch(rangoExcepcion re) {
         System.out.println(re.getMessage());
      }
   }
   
   public static double danioAtaquePokemon(Pokemon atacante, Pokemon defensor, double ataque, double defensa) throws rangoExcepcion {
      if(ataque < 0 || ataque > 100 || defensa < 0 || defensa > 100) {
         throw new rangoExcepcion("El valor de ataque y defensa tienen que estar entre 0 y 100.");
      }
      return 50 * (ataque / defensa) * atacante.getEfectividad(defensor);
   }
   
   public static class rangoExcepcion extends Exception {
      public rangoExcepcion(String mensajeError) {
         super(mensajeError);
      }
   }

   private static class Pokemon {
      private TipoPokemon tipo;
      private Map<TipoPokemon, Efectividad> efectividad = new HashMap<TipoPokemon, Efectividad>();
      
      public Pokemon(TipoPokemon tipo) {
         this.tipo = tipo;
         this.efectividad = getDatosEfectividad(tipo);
      }
      
      public double getEfectividad(Pokemon pokemon) {
         return efectividad.get(pokemon.getTipo()).getEfecto();
      }
      public TipoPokemon getTipo() {
          return tipo;
      }
      private Map<TipoPokemon, Efectividad> getDatosEfectividad(TipoPokemon tipo) {
         Map<TipoPokemon, Efectividad> efectividad = new HashMap<TipoPokemon, Efectividad>();
                   
         switch(tipo) {
            case AGUA: {
               efectividad.put(TipoPokemon.AGUA, Efectividad.POCO_EFECTIVO);
               efectividad.put(TipoPokemon.FUEGO, Efectividad.EFECTIVO);
               efectividad.put(TipoPokemon.PLANTA, Efectividad.POCO_EFECTIVO);
               efectividad.put(TipoPokemon.ELECTRICO, Efectividad.NEUTRAL);
               break;
            }
            case FUEGO: {
               efectividad.put(TipoPokemon.AGUA, Efectividad.POCO_EFECTIVO);
               efectividad.put(TipoPokemon.FUEGO, Efectividad.POCO_EFECTIVO);
               efectividad.put(TipoPokemon.PLANTA, Efectividad.EFECTIVO);
               efectividad.put(TipoPokemon.ELECTRICO, Efectividad.NEUTRAL);
               break;
            }
            case PLANTA: {
               efectividad.put(TipoPokemon.AGUA, Efectividad.EFECTIVO);
               efectividad.put(TipoPokemon.FUEGO, Efectividad.POCO_EFECTIVO);
               efectividad.put(TipoPokemon.PLANTA, Efectividad.POCO_EFECTIVO);
               efectividad.put(TipoPokemon.ELECTRICO, Efectividad.NEUTRAL);
               break;
            }
            case ELECTRICO: {
               efectividad.put(TipoPokemon.AGUA, Efectividad.EFECTIVO);
               efectividad.put(TipoPokemon.FUEGO, Efectividad.NEUTRAL);
               efectividad.put(TipoPokemon.PLANTA, Efectividad.NEUTRAL);
               efectividad.put(TipoPokemon.ELECTRICO, Efectividad.POCO_EFECTIVO);
               break;
            }
         }
         
         return efectividad;
      }
   }
}
