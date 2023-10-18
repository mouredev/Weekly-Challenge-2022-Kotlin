using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        getBoomerang(new List<int> { 2, 1, 2, 3, 3, 4, 2, 4 });
        getBoomerang(new List<int> { 2, 1, 2, 3, 2, 4, 2, 4 });

    }

    getBoomerang(List<int> numbers)
    {
        if (numbers.Count < 1) throw new Exception("The list of number is empty. Please add at least 3 numbers");

        for (int i = 0; i < numbers.Count; i++)
        {
            if (i >= 2)
            {
                if (numbers[i] == numbers[i - 2] && numbers[i - 1] != numbers[i])
                    Console.WriteLine($"{numberr[i]}, {numberr[i - 1]}, {numberr[i]}");
            }
        }

        Console.WriteLine("--------------------");
    }
}