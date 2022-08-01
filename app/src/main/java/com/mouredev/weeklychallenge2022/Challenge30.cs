using System;
using System.Linq;

namespace Reto30
{
    internal class Challenge30
    {
        static void Main(string[] args)
        {
            //Mi primer intento
            marcoAsteriscos("Primera solucion con ciclos");
            //Segundo intento luego de ver la explicacion de moure
            drawFrame("Segunda solucion con Enumerable");
        }

        //Primera 
        public static void marcoAsteriscos(string cadena)
        {
            int longitudMax = 0;
            int espaciado = 4;
            string[] palabras = cadena.Split(' ');            
            
            foreach (string palabra in palabras)
            {
                longitudMax = palabra.Length>longitudMax ? palabra.Length : longitudMax;               
            }           
            for (int i = 0; i < longitudMax + espaciado; i++)
            {
                Console.Write("*");
            }
            Console.WriteLine("");
            foreach (string palabra in palabras)
            {
                Console.Write("* ");
                Console.Write(palabra);
                if (palabra.Length <longitudMax)
                {
                    for (int i = palabra.Length; i<longitudMax; i++ )
                    {
                        Console.Write(" ");
                    }
                }                
                Console.WriteLine(" *");
            }
            for (int i = 0; i < longitudMax + espaciado; i++)
            {
                Console.Write("*");
            }
            Console.WriteLine("");
        }
        //Segunda al estilo moure
        public static void drawFrame(String texto)
        {
            var words = texto.Split();
            var marLength = 0;
            foreach (String w in words)
            {
                if (w.Length > marLength)
                {
                    marLength = w.Length;
                }
            }
            Console.WriteLine(string.Concat(Enumerable.Repeat("*", marLength + 4)));
            foreach (String w in words)
            {
                Console.WriteLine("* "+w+string.Concat(Enumerable.Repeat(" ",marLength-w.Length))+" *");
            }
            Console.WriteLine(string.Concat(Enumerable.Repeat("*", marLength + 4)));
        }
    }
}