/*
 * Reto #38
 * BINARIO A DECIMAL
 * Fecha publicación enunciado: 19/09/22
 * Fecha publicación resolución: 27/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 */

import 'dart:math';

void main(List<String> args) {
  BinarioDecimal("10101100");
}

void BinarioDecimal(String binario) {
  num decimal = 0;
  int elevar = 0;
  
  for (int contador = binario.length - 1; contador >= 0; contador--) {
    
    if (int.parse(binario[contador]) == 1) {
      decimal = decimal + pow(2, elevar);
      
    } else if (int.parse(binario[contador]) != 0) {
      print("Ingrese un numero Binario");
      return;
    }

    elevar++;
  }
  print("El numero BINARIO es $binario y convertido a Decimal es $decimal");
}
