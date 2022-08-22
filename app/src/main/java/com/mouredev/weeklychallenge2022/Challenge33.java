/*
 * Reto #33
 * CICLO SEXAGENARIO CHINO
 * Fecha publicación enunciado: 15/08/22
 * Fecha publicación resolución: 22/08/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un función, que dado un año, indique el elemento y animal correspondiente
 * en el ciclo sexagenario del zodíaco chino.
 * - Información: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
 * - El ciclo sexagenario se corresponde con la combinación de los elementos madera,
 *   fuego, tierra, metal, agua y los animales rata, buey, tigre, conejo, dragón, serpiente,
 *   caballo, oveja, mono, gallo, perro, cerdo (en este orden).
 * - Cada elemento se repite dos años seguidos.
 * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
 *
 * Información adicional:
 * - Retos obtenidos de https://github.com/mouredev/Weekly-Challenge-2022-Kotlin
 *
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        for (int i = 1923; i <= 2040; i++) {
            System.out.println("--------" + i + "--------");
            calcularElementoChino(i);
            calcularAnimalChino(i);
        }
    }
    
    private static void calcularElementoChino(int numero) {
        String[] elementos = {"madera", "fuego", "tierra", "metal", "agua"};
        int numeroEquivalente = calcularNumeroEquivalente(numero, 1924, 1933); // En que elemento esta el año -> numeros del 1 al 10 en grupos de 2 -> ej: 1 o 2 = "madera"
       
        if (numeroEquivalente % 2 != 0) {
            int i = numeroEquivalente + 1;
            System.out.println(elementos[(i/2)-1]);
        } else {
            System.out.println(elementos[(numeroEquivalente/2)-1]);
        }
        
    }
    
    private static void calcularAnimalChino(int numero) {
        String[] animales = {"rata", "buey", "tigre", "conejo", "dragón", "serpiente", "caballo", "cabra", "mono", "gallo", "perro", "cerdo"};
        int numeroEquivalente = calcularNumeroEquivalente(numero, 1924, 1935); // En que animal está el año -> numeros del 1 al 12 en grupos de 2 -> ej: 12 = "cerdo"
       
        System.out.println(animales[numeroEquivalente-1]);
    }
    
    private static int calcularNumeroEquivalente(int numero, int minimo, int maximo) {
        int intervalo = maximo - minimo + 1;

        while (numero < (minimo + intervalo)) {
            numero += intervalo;
        }

        while (numero >= (minimo + intervalo)) {
            numero -= intervalo;
        }
        
        numero = numero - minimo + 1;
        
        return numero;
    }
}
