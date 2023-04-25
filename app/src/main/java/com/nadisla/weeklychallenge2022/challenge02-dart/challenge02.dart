/*
* Reto #2
* LA SUCESIÓN DE FIBONACCI
* Dificultad: DIFÍCIL
*
* Enunciado: Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.
* La serie Fibonacci se compone por una sucesión de números en la que el siguiente siempre es la suma de los dos anteriores.
* 0, 1, 1, 2, 3, 5, 8, 13...

* Challenge #2
* THE FIBONACCI SEQUENCE
* Difficulty: HARD
*
* Statement: Write a program that prints the first 50 numbers of the Fibonacci sequence starting at 0.
* The Fibonacci series consists of a sequence of numbers in which the next is always the sum of the previous two.
* 0, 1, 1, 2, 3, 5, 8, 13...
*/
void main() {
  int n1 = 0, n2 = 1, fib = 0;
  for (int i = 1; i <= 50; i++) {
    print(n1);
    fib = n1 + n2;
    n1 = n2;
    n2 = fib;
  }
}
