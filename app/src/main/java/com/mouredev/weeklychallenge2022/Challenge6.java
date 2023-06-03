/*
Reto #6
INVIRTIENDO CADENAS
Fecha publicación enunciado: 07/02/22
Fecha publicación resolución: 14/02/22
Dificultad: FÁCIL

Enunciado: Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
- Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
 */
package weeklychallenge2022;

import java.util.Scanner;

public class Challenge6 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Ingresar cadena de texto: ");
        String cadena = leer.next();
        
        invertirCadena(cadena);

    }
    
    public static void invertirCadena(String cadena){
        int longitud = cadena.length();
        String cadenaInvertida = "";
        for (int i = (longitud - 1); i >= 0; i--) {
            cadenaInvertida += cadena.charAt(i);
        }
        System.out.println(cadenaInvertida);
    }

}
