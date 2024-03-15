// See https://aka.ms/new-console-template for more information
using System.Runtime.ConstrainedExecution;

var elements = new List<string>() { "madera", "fuego", "tierra", "metal", "agua" };
var animals = new List<string>() {"rata", "buey", "tigre", "conejo",
    "dragon", "serpiente", "caballo", "oveja", "mono", "gallo", "perro", "cerdo"};
var start = 1984;
var currentYear = 4521;
var diffYear = currentYear - start;
var elementIndex = (int)Math.Floor((diffYear % 10) / 2.0);

var animaltIndex = diffYear % 12;

Console.WriteLine($"Element: {elements[elementIndex]}, and animal: {animals[animaltIndex]}");