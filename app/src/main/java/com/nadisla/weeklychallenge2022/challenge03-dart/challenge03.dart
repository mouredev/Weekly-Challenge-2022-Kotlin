/*
* Challenge #3
* IS IT A PRIME NUMBER?
* Difficulty: MEDIUM
*
* Statement: Write a program that is responsible for checking whether or not a number is prime.
* Once this is done, print the prime numbers between 1 and 100.

* Reto #3
* ¿ES UN NÚMERO PRIMO?
* Dificultad: MEDIA
*
* Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
* Hecho esto, imprime los números primos entre 1 y 100.
*/
void main() {
  for (var i = 1; i <= 100; i++) {
    if (isPrime(i)) {
      print(i);
    }
  }
}

bool isPrime(int number) {
  int divisors = 0;
  if (number < 2) {
    return false;
  }
  for (int i = 1; i <= number; i++) {
    if (number % i == 0) {
      divisors++;
    }
  }
  return divisors == 2;
}
