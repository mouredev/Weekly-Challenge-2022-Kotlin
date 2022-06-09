import 'dart:math'; //Para utilizar pow, max y min
/*
 * Reto #23
 * MÁXIMO COMÚN DIVISOR Y MÍNIMO COMÚN MÚLTIPLO
 * Fecha publicación enunciado: 07/06/22
 * Fecha publicación resolución: 13/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra que calcule el mínimo común múltiplo (mcm) de dos números enteros.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

void main() {
  //Descomponer en factores primos
  List<int> primeFactors(int number) {
    List<int> primes = [];
    while (number > 1) {
      for (int i = 2; i <= number; i++) {
        if (number % i == 0) {
          // print("$number\t| $i");
          number ~/= i;
          primes.add(i);
          break;
        }
      }
    }
    return primes;
  }

  //Contar las veces que se repite un entero en una lista ( entero : nroRepeticiones)
  Map<int, int> primeOcurrences(List<int> primes) {
    Map<int, int> ocurrences = Map<int, int>();
    primes.forEach((number) {
      if (ocurrences.containsKey(number)) {
        ocurrences[number] = ocurrences[number]! + 1;
      } else {
        ocurrences[number] = 1;
      }
    });
    return ocurrences;
  }

  //Minimo Comun Multiplo
  int mcm(int numberA, int numberB) {
    Map<int, int> primesA = primeOcurrences(primeFactors(numberA));
    Map<int, int> primesB = primeOcurrences(primeFactors(numberB));
    int result = 1;

    primesA.keys.forEach((int key) {
      if (primesB.containsKey(key)) {
        result *= pow(key, max(primesA[key]!, primesB[key]!)).toInt();
      } else {
        result *= pow(key, primesA[key]!).toInt();
      }
    });
    for (int key in primesB.keys) {
      if (primesA.containsKey(key)) {
        continue;
      } else {
        result *= pow(key, primesB[key]!).toInt();
      }
    }
    return result;
  }

  //Maximo Comun Divisor
  int MCD(int numberA, int numberB) {
    Map<int, int> primesA = primeOcurrences(primeFactors(numberA));
    Map<int, int> primesB = primeOcurrences(primeFactors(numberB));
    int result = 1;

    primesA.keys.forEach((int key) {
      if (primesB.containsKey(key)) {
        result *= pow(key, min(primesA[key]!, primesB[key]!)).toInt();
      }
    });
    return result;
  }

  //MAIN
  int first = 84;
  int second = 72;
  print('$first  ->\t factores primos: ${primeFactors(first)}');
  print('$second  ->\t factores primos: ${primeFactors(second)}');
  print('Múltiplo Común Menor de $first y $second: ${mcm(first, second)}');
  print('Divisor Común Mayor de $first y $second: ${MCD(first, second)}');
}
