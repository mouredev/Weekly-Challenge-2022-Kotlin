using System;

namespace FizzBuzzer;

public class Program
{
    private static void Main(string[] args)
    {
        Console.WriteLine("\t\t* * Ejercicio #0 - FIZZ BUZZ * *");

        for (int number = 1; number <= 100; number++)
        {
            bool isMultipleOf3 = number % 3 == 0;
            bool isMultipleOf5 = number % 5 == 0;

            if (isMultipleOf3 && isMultipleOf5)
            {
                Console.Write("fizzbuzz");
            }
            else if (isMultipleOf3)
            {
                Console.Write("fizz");
            }
            else if (isMultipleOf5)
            {
                Console.Write("buzz");
            }
            else
            {
                Console.Write(number);
            }

            Console.Write("\n");
        }
    }
}
