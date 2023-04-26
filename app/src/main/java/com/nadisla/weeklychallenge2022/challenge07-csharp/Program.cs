/*
* Challenge #7
* COUNTING WORDS
* Difficulty: MEDIUM
*
* Statement: Create a program that counts how many times each word is repeated and displays the final count for all of them.
* - Punctuation marks are not part of the word.
* - A word is the same even if it appears in upper and lower case.
* - It is not possible to use functions of the language that resolve it automatically.
*
* Reto #7
* CONTANDO PALABRAS
* Dificultad: MEDIA
*
* Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
* - Los signos de puntuación no forman parte de la palabra.
* - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
* - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
*/
using System.Text.RegularExpressions;

void CountWordsRepetitions(string text)
{
    string[] textSplitted = text.Split(" ");
    Dictionary<string, int> wordDetail = new Dictionary<string, int>();
    Regex regex = new Regex(@"\p{P}");

    foreach (string word in textSplitted)
    {
        string wordCleaned = regex.Replace(word, "").ToLower();
        if (wordDetail.ContainsKey(wordCleaned) == false) wordDetail.Add(wordCleaned, 1);
        else wordDetail[wordCleaned] += 1;
    }
    Console.WriteLine("************ Word: Repetitions ************");
    foreach (var word in wordDetail) Console.WriteLine($"{word.Key}: {word.Value}");
    int finalCount = wordDetail.Values.Sum();
    Console.Write($"Final words count: {finalCount}");
}
CountWordsRepetitions("Hello World. Hello, hello world");