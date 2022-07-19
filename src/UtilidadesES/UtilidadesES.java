package UtilidadesES;

import java.util.Scanner;

/**
 * Biblioteca con utilidades de entrada y salida
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */
public class UtilidadesES {
    final static String ERROR_ENTERO = "\nERRROR. El valor tiene que ser un entero.\n";
    final static String ERROR_FUERA_RANGO = "\nERROR. El valor esta fuera de rango.\n";
  
    /**
     * Devuelve un entero entre dos valores
     * @param texto
     * @param valorMinimo
     * @param valorMaximo
     * @return 
     */
    public int pedirEntero(String texto, int valorMinimo, int valorMaximo) {
        Scanner scanner = new Scanner(System.in);
        int entero = 0;
        boolean datoCorrecto;
        
        do {
            System.out.print(texto);
            datoCorrecto = scanner.hasNextInt();
            if(datoCorrecto) {
                entero = scanner.nextInt();
                if(entero < valorMinimo || entero > valorMaximo) {
                    datoCorrecto = false;
                    System.out.println(ERROR_FUERA_RANGO);
                }
            } else {
                System.out.println(ERROR_ENTERO);
                scanner.next();
            }
        } while(!datoCorrecto);
        return entero;
    }
    /**
     * Devuelve una cadena de texto
     * @param texto
     * @return 
     */
    public String pedirCadena(String texto) {
        Scanner scanner = new Scanner(System.in);
        String cadena;
        
        System.out.print(texto);
        cadena = scanner.nextLine();     
        
        return cadena;
    }
    
    /**
     * Muestra un menú pasador por parametro
     * @param titulo
     * @param menu 
     */
    public void mostrarMenu(String titulo, String[] menu) {
        System.out.println(titulo);
        for(int i = 0; i < titulo.length() + 2; i++) {
            System.out.print("=");            
        }
        System.out.println();
        for(int i = 0; i < menu.length; i++) {
            System.out.println("[" + i + "] " + menu[i]);
        }
        System.out.println();
    }
}
