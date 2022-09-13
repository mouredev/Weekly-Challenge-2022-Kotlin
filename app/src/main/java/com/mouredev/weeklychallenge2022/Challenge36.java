import java.util.*;
 
public class Program {
   public enum Raza {
      PELOSO(1),
      SURENO(2),
      ENANO(3),
      NUMENOREANO(4),
      ELFO(5),
      ORCO(2),
      GOBLIN(2),
      HUARGO(3),
      TROLL(5);
      
      private final int valor;
      
      private Raza(int valor) {
         this.valor = valor;
      }
      
      public int getValor() {
         return valor;
      }
   }

   public static void main(String[] args) {
      try {
         Ejercito razaBondadosa = new Ejercito("Raza bondadosa");
         razaBondadosa.addRaza(Raza.PELOSO, 2);
         razaBondadosa.addRaza(Raza.SURENO, 15);
   
         Ejercito razaMalvada = new Ejercito("Raza malvada");
         razaMalvada.addRaza(Raza.ORCO, 1);
         razaMalvada.addRaza(Raza.SURENO, 5);
         razaMalvada.addRaza(Raza.HUARGO, 1);
   
         razaBondadosa.batalla(razaMalvada);
     }catch(RangoExcepcion re) {
      System.out.println(re.getMessage());
     }
   }
   public static class RangoExcepcion extends Exception {
      public RangoExcepcion(String mensaje) {
         super(mensaje);
      }
   }
   
   public static class Ejercito {
      private int sumaValor;
      private String nombre;
      
      public Ejercito(String nombre) {
         sumaValor = 0;
         this.nombre = nombre;
      }
            
      public int getSumaValor() {
         return sumaValor;
      }
      
      public String getNombre() {
         return nombre;
      }
      
      public void addRaza(Raza raza, int numeroIntegrantes) throws RangoExcepcion {
         int valorRaza = raza.getValor();
         
         if(valorRaza < 1 || valorRaza > 5) {
            throw new RangoExcepcion("La raza " + raza + " tiene el valor " + 
                        valorRaza + ", que no está comprendido entre 1 y 5");
         }
         sumaValor += valorRaza * numeroIntegrantes;
      }
      
      public void batalla(Ejercito ejercitoContrario) {
         int valorBatalla = sumaValor - ejercitoContrario.getSumaValor();
         
         if(valorBatalla > 0) {
            System.out.println("Ganan la batalla " + nombre);
            return;
         }
         if(valorBatalla < 0) {
            System.out.println("Ganan la batalla " + ejercitoContrario.getNombre());
            return;
         }
         System.out.println("Ha habido un empate en la batalla.");
      }
   }
}
