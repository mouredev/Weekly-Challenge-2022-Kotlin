/*
* Challenge #6
* REVERSING STRINGS
* Difficulty: EASY
*
* Statement: Create a program that reverses the order of a text string without using language-specific functions that do so automatically.
* - If we pass "Hello world" we would return "dlrow olleH"
*
* Reto #6
* INVIRTIENDO CADENAS
* Dificultad: FÁCIL
*
* Enunciado: Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
* - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
*/
string ReverseString(string text)
{
    List<char> textSplitted = text.ToCharArray().ToList();
    string reversedString = "";
    for (int idx = textSplitted.Count - 1; idx >= 0; idx--)
    {
        reversedString += textSplitted[idx];
    }
    return reversedString;
}
Console.WriteLine(ReverseString("Hello world"));