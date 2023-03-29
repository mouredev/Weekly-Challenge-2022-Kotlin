/*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
 using System;
 using System.Diagnostics;

 namespace Titan
 {
    class W
    {
        static bool anagram(string cad1, string cad2)
        {
            char[] temp = cad1.ToCharArray(); 
            char[] temp2 = cad2.ToCharArray();           
            Array.Sort(temp);
            Array.Sort(temp2);
            cad1 = new string(temp);
            cad2 = new string(temp2);
            bool iguales = (cad1 == cad2);            
            return iguales;
        }
        static void Main()
        {
            Console.WriteLine(anagram("amor","roma"));
        }
    }
 }
