package com.mouredev.weeklychallenge2022

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

static void Main(string[] args)
{
    Console.WriteLine($"Result: {IsAnagram("ael", "tale")}");
}

private static bool IsAnagram(string wordOne, string wordTwo)
{
    wordOne = wordOne.ToLower();
    wordTwo = wordTwo.ToLower();

    if (IsSameWordOrDifferentLength(wordOne, wordTwo))
    {
        return false;
    }

    bool isAnagram = true;
    List<char> wordOneLetters = new();
    wordOneLetters.AddRange(wordOne);

    foreach (char wordTwoletter in wordTwo)
    {
        if (LetterExistRemove(wordOneLetters, wordTwoletter))
        {
            isAnagram = false;
            break;
        }
    }

    return isAnagram;
}

#region Methods Complementaries
private static bool LetterExistRemove(List<char> wordOneLetters, char wordTwoletter)
{
    return !wordOneLetters.Remove(wordTwoletter);
}

private static bool IsSameWordOrDifferentLength(string wordOne, string wordTwo)
{
    return IsSameWord(wordOne, wordTwo) ||
                    !IsSameLength(wordOne, wordTwo);
}

private static bool IsSameLength(string wordOne, string wordTwo)
{
    return wordOne.Length == wordTwo.Length;
}

private static bool IsSameWord(string wordOne, string wordTwo)
{
    return wordOne == wordTwo;
}
#endregion
