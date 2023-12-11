package com.mouredev.weeklychallenge2022

/*
 * Reto #0
 * Enunciado: Escribe un programa que muestre por consola (con un print) los números de 1 a 100 (ambos incluidos y con un salto de línea entre cada impresión), sustituyendo los siguientes:
 * - Múltiplos de 3 por la palabra "fizz".
 * - Múltiplos de 5 por la palabra "buzz".
 * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
 
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 */

// C#

            int i = 1;

            Console.WriteLine("FIZZ BUZZ, ");

            for (; i < 100; i++) //when you put the i here sums 1 at very end of the cycle
            {
                if (i % 3 == 0) 
                {
                    if (i % 5 == 0 )
                    {
                        Console.Write("FIZZBUZZ, "); //both
                    }
                    else
                    {
                        Console.Write("FIZZ, "); //only divisible in 3
                    }
                }
                else if (i % 5 == 0) //divisible in 5
                {
                    Console.Write("BUZZ, ");
                }
                
                else //neither 3 or 5
                {
                    Console.Write(i + ", ");
                }
            }
            Console.ReadKey();
