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
bool IsPrime(int number)
{
    int divisors = 0;
    if (number < 2) return false;
    for (int n = 1; n <= number; n++)
    {
        if (number % n == 0) divisors++;
    }
    if (divisors == 2) return true;
    else return false;
}
for (int num = 1; num <= 100; num++)
{
    if (IsPrime(num))
    {
        Console.WriteLine(num);
    }
}