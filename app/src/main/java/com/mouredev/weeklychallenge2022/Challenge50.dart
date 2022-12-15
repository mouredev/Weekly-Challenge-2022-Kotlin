//package com.mouredev.weeklychallenge2022

/*
 * Reto #50
 * LA ENCRIPTACIÓN DE KARACA
 * Fecha publicación enunciado: 12/11/22
 * Fecha publicación resolución: 19/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto utilizando el
 * algoritmo de encriptación de Karaca (debes buscar información sobre él).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

import 'dart:io';

void main() {
  print("Enter a string: ");
  String? text = stdin.readLineSync();
  print(karaca(text!));
}

String karaca(String text) {
  const encrypt = {"a": 0, "e": 1, "i": 2, "o": 2, "u": 3};
  List? reverse = text.split('').toList();
  final List keys = encrypt.keys.toList();
  for (int i = 0; i < reverse.length; i++) {
    if (keys.contains(reverse[i])) {
      reverse[i] = encrypt[reverse[i]].toString();
    }
  }
  final String output = reverse.join();
  return output + 'aca';
}
