/*
 * Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 */

void main() {
  for (int i = 1; i <= 100; i++) {
    if (isPrime(i)) {
      print(i);
    }
  }
}

bool isPrime(int number) {
  if (number <= 1) {
    return false;
  }

  for (int x = 2; x < number; x++) {
    if (number % x == 0) return false;
  }
  return true;
}
