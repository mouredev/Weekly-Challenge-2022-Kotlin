
/*
 * Reto #47
 * VOCAL MÁS COMÚN
 * Fecha publicación enunciado: 21/11/22
 * Fecha publicación resolución: 28/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 * Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

using System.Text.RegularExpressions;

namespace Reto47
{
    using System.Collections;
    using System.Text.RegularExpressions;
    class Program
    {
        static void Main(string[] args)
        {
            var vocales = new[] { "a", "e", "i", "o", "u" };
            var contadorVocales = new[] { 0,0,0,0,0 };
            var texto = "";
            Console.WriteLine("Introduca el texto");
            texto = Console.ReadLine().ToLower();
            for (int i = 0; i < vocales.Length; i++)
            {
                var contador = Regex.Matches(texto, vocales[i]).Count();
                contadorVocales[i] = contador;
            }
            for (int i = 0; i < contadorVocales.Length; i++)
            {
                if (contadorVocales[i]>= contadorVocales.Max()&& contadorVocales[i]>0)
                {
                    Console.WriteLine("Vocal: "+vocales[i] + " ,Numero de veces repetida: " + contadorVocales[i]);
                }

            }


        }
    }
}
