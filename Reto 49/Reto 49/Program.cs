/*
 * Reto #49
 * EL DETECTOR DE HANDLES
 * Fecha publicación enunciado: 05/11/22
 * Fecha publicación resolución: 12/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de detectar y retornar todos los handles de un texto usando solamente Expresiones Regulares.
 * Debes crear una expresión regular para cada caso:
 * - Handle usuario: Los que comienzan por "@"
 * - Handle hashtag: Los que comienzan por "#"
 * - Handle web: Los que comienzan por "www.", "http://", "https://" y finalizan con un dominio (.com, .es...)
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

using System.Text.RegularExpressions;


namespace Reto49;
internal class Program
{

    static void Main(string[] args)
    {
        Console.WriteLine("Introduzca un texto para que podamos analizar los handlers que tiene: ");
        var result = "";

        Regex regexUsuario = new Regex("@\\w+", RegexOptions.IgnoreCase);
        Regex regexHastag = new Regex("#\\w+", RegexOptions.IgnoreCase);
        Regex regexWww = new Regex("(?:(?:https?|http):\\/\\/)?[\\w/\\-?=%.]+\\.[\\w/\\-&?=%.]+", RegexOptions.IgnoreCase);
        var texto = Console.ReadLine();
        result += ExtraerHandlers(texto, regexUsuario, "usuario");
        result += "\n";

        result += ExtraerHandlers(texto, regexHastag, "Hastag");
        result += "\n";

        result += ExtraerHandlers(texto, regexWww, "WEB");
        result += "\n";
        Console.WriteLine(result);

    }
    static string ExtraerHandlers(string Texto, Regex pattern, string tipo)
    {

        MatchCollection matches = pattern.Matches(Texto);
        var MyList = matches.Select(s => s.Value).ToList();
        return "Los handles de " + tipo + " encontrados son: " + string.Join(",", MyList);



    }


}



