using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Retos
{
    class Program
    {
        static void Main(string[] args)
        {
            missingNumbers(new int[] { 0, 1 }); // Doesn't have enough elements / numbers
            missingNumbers(new int[] { 0, 1, 3, 7, 5, 9 }); // Not in order
            missingNumbers(new int[] { 0, 1, 3, 3, 7, 9 }); // Duplicate number
            missingNumbers(new int[] { 0, 1, 3, 7, 9 }); // Correct!
        }

        static void missingNumbers(int[] numbers)
        {
            try
            {
                if (numbers.Length < 3) throw new Exception("The array must contains at least 3 elements to be consider it!!");

                int lastNumber = numbers[0]; // We get the first element from the begining

                for (int i = 1; i < numbers.Length; i++) //Starting from the second element 
                {
                    if (numbers[i] < lastNumber) throw new Exception($"The number: '{numbers[i]}' can't be minor than the previous one: '{lastNumber}'");

                    if (lastNumber == numbers[i]) throw new Exception($"The number: '{numbers[i]}' can't be the same than the previous one: '{lastNumber}'");

                    lastNumber = numbers[i];
                }

                Console.WriteLine("Missing Numbers:");

                for (int i = 1; i < numbers.Length - 1; i++) //Starting from the second element and finishing before the last one
                {
                    Console.WriteLine($"{i}) {numbers[i]}");
                }

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}
