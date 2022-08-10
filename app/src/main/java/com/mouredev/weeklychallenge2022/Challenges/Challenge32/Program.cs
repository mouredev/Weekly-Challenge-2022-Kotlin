// See https://aka.ms/new-console-template for more information
Console.WriteLine("Hello, World!");

var list = new List<int> {2,30,45,24,55,20,11};

var secondNumber = list.OrderBy(c => c).Skip(1).FirstOrDefault();

Console.WriteLine($"Second number is {secondNumber}");