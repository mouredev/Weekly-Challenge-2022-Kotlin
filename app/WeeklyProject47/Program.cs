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

using System.Globalization;
using System.Text;

const string lorem = @"Lórem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Non curabitur gravida arcu ac tortor dignissim convallis. Velit euismod in pellentesque massa placerat duis ultricies. Sodales ut eu sem integer vitae. Ut etiam sit amet nisl purus in mollis nunc. Ipsum dolor sit amet consectetur adipiscing. Auctor elit sed vulputate mi sit amet mauris. Elementum facilisis leo vel fringilla est ullamcorper eget nulla. Senectus et netus et malesuada fames. Eu lobortis elementum nibh tellus molestie. Consectetur lorem donec massa sapien faucibus et molestie ac. Est ultricies integer quis auctor elit sed vulputate. Ut venenatis tellus in metus vulputate. Congue quisque egestas diam in arcu cursus euismod.
Quam nulla porttitor massa id neque aliquam vestibulum. Magna etiam tempor orci eu lobortis. Rhoncus urna neque viverra justo nec ultrices dui. Commodo odio aenean sed adipiscing. Id nibh tortor id aliquet. A diam maecenas sed enim ut sem. Nec sagittis aliquam malesuada bibendum. Est lorem ipsum dolor sit amet consectetur adipiscing elit pellentesque. Auctor elit sed vulputate mi. Enim tortor at auctor urna. Placerat duis ultricies lacus sed turpis. Lobortis feugiat vivamus at augue. Egestas dui id ornare arcu odio ut. A diam sollicitudin tempor id eu nisl nunc mi. Velit scelerisque in dictum non consectetur a erat nam at. Facilisi morbi tempus iaculis urna id volutpat. Arcu odio ut sem nulla pharetra diam.
Placerat vestibulum lectus mauris ultrices eros in cursus turpis. Enim ut tellus elementum sagittis vitae et. Viverra ipsum nunc aliquet bibendum enim facilisis gravida neque. Enim nunc faucibus a pellentesque sit amet porttitor eget dolor. Potenti nullam ac tortor vitae purus faucibus. Diam in arcu cursus euismod. Cursus eget nunc scelerisque viverra. Pretium viverra suspendisse potenti nullam ac tortor vitae purus faucibus. Vestibulum morbi blandit cursus risus. Lacus vestibulum sed arcu non odio euismod lacinia. Maecenas pharetra convallis posuere morbi leo urna. Aliquam ultrices sagittis orci a scelerisque purus. Venenatis cras sed felis eget velit aliquet sagittis id consectetur. Tellus pellentesque eu tincidunt tortor aliquam nulla facilisi cras. Risus sed vulputate odio ut. Vestibulum lectus mauris ultrices eros in cursus turpis massa tincidunt. Vulputate odio ut enim blandit volutpat maecenas. In massa tempor nec feugiat.
Cras adipiscing enim eu turpis egestas pretium aenean. Diam volutpat commodo sed egestas egestas fringilla phasellus faucibus. Etiam dignissim diam quis enim. Sed ullamcorper morbi tincidunt ornare massa eget egestas. Molestie nunc non blandit massa enim nec dui nunc. At risus viverra adipiscing at in tellus integer feugiat. Condimentum id venenatis a condimentum vitae. In hac habitasse platea dictumst vestibulum rhoncus. Iaculis eu non diam phasellus vestibulum. In arcu cursus euismod quis viverra. Sed velit dignissim sodales ut eu sem integer vitae justo. Porttitor massa id neque aliquam vestibulum morbi. Mauris ultrices eros in cursus turpis. Lorem dolor sed viverra ipsum nunc aliquet bibendum enim. Nisl nunc mi ipsum faucibus vitae aliquet nec ullamcorper. Erat pellentesque adipiscing commodo elit at imperdiet dui. Molestie nunc non blandit massa enim nec dui nunc.
Vel facilisis volutpat est velit egestas dui. Fringilla urna porttitor rhoncus dolor purus non enim praesent elementum. Erat imperdiet sed euismod nisi porta lorem mollis. Magna fringilla urna porttitor rhoncus. Malesuada bibendum arcu vitae elementum curabitur vitae. Non nisi est sit amet. Nisl vel pretium lectus quam id leo in. Elementum integer enim neque volutpat ac tincidunt vitae semper. Condimentum lacinia quis vel eros donec ac odio. In cursus turpis massa tincidunt dui ut. Facilisis gravida neque convallis a cras semper auctor neque vitae. Sit amet purus gravida quis blandit turpis. Donec adipiscing tristique risus nec feugiat in fermentum posuere urna. Bibendum arcu vitae elementum curabitur vitae nunc sed. Nec dui nunc mattis enim ut tellus elementum sagittis vitae. Purus ut faucibus pulvinar elementum integer. Leo urna molestie at elementum eu facilisis. Non nisi est sit amet facilisis magna etiam. Rhoncus aenean vel elit scelerisque mauris pellentesque pulvinar pellentesque habitant.";

GetTopVowels(lorem);

void GetTopVowels(string text)
{
    const string vowels = "aeiou";
    var vowelRepetitions = text.RemoveDiacritics().ToLower() // Queremos contar vocales independientemente de su estado: quitamos acentos y convertimos a minúscula
        .Where(l => vowels.Contains(l)) // Nos quedamos sólo con las vocales
        .GroupBy(c => c) // Agrupamos por vocales
        .Select(x => new VowelRepetitions(x.Key, x.Count())) // Contamos cuántas hay de cada
        .OrderByDescending(x => x.Repetitions) // Ordenamos dejando primero las que más tienen
        .ToList();

    var topVowel = vowelRepetitions.First();

    // Nos quedamos con todas las vocales de las que haya tantas como la que más (por si hubiese un empate)
    var topVowels = vowelRepetitions
        .Where(c => c.Repetitions == topVowel.Repetitions).Select(x => x.Vowel)
        .ToList();

    var repetitionsResult = $", con {topVowel.Repetitions} apariciones";
    repetitionsResult = topVowels.Count > 1
        ? $"Las vocales que más veces se repiten son '{string.Join(", ", topVowels)}'{repetitionsResult}"
        : $"La vocal que más veces se repite es '{topVowel.Vowel}'{repetitionsResult}";

    Console.WriteLine(repetitionsResult);

    Environment.Exit(0);
}

internal static class StringExtensions
{
    //https://yeahexp.com/remove-accents-from-a-string-in-c/
    public static string RemoveDiacritics(this string text)
    {
        return new string(text.Normalize(NormalizationForm.FormD)
            .Where(c => CharUnicodeInfo.GetUnicodeCategory(c) != UnicodeCategory.NonSpacingMark)
            .ToArray()).Normalize(NormalizationForm.FormC);
    }
}

internal record VowelRepetitions(char Vowel, int Repetitions)
{
    public char Vowel { get; set; } = Vowel;
    public int Repetitions { get; set; } = Repetitions;
}