/*
 * Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto
 * utilizando el algoritmo de encriptación de Karaca. 
 * (Debes buscar información sobre él)
 */

using System;

namespace EncriptacionKaraca
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Karaca karaca = new Karaca();
            Console.WriteLine("Escribe el valor de entrada >> ");
            string entrada = Console.ReadLine();
            Console.WriteLine(karaca.Encript(entrada));
        }
    }

    public class Karaca
    {

        public string Encript(string entrada)
        {
            char[] chars = entrada.ToCharArray();
            Array.Reverse(chars);
            string salida = new string(chars).ToLower();
            salida = salida.Replace("a", "0");
            salida = salida.Replace("e", "1");
            salida = salida.Replace("i", "2");
            salida = salida.Replace("o", "2");
            salida = salida.Replace("u", "3");
            salida = salida + "aca";
            return "Tu variable encriptada es: " + salida;
        }

        
    }

}
