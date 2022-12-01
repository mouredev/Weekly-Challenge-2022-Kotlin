package com.mouredev.weeklychallenge2022

import java.text.Normalizer

/*
 * Reto #47
 * VOCAL MÁS COMÚN
 * Fecha publicación enunciado: 21/11/22
 * Fecha publicación resolución: 28/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 * - Ten cuidado con algunos casos especiales.
 * - Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;


namespace Vocales
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("ESTE PROGRAMA CUENTA LAS VOCALES Y CUANTAS VECES SE REPITEN:");
            Console.WriteLine("************************************************************");
            Console.WriteLine();
            Console.WriteLine("INTRODUZZCA UN TEXTO CUALQUIERA:");

           String texto = Console.ReadLine();
            //Pasamos todos y cada uno de los caracteres a minusculas para que no haya problemas al controlar las vocales
            texto = texto.ToLower();
            Cuenta_vocales(texto);
        }

        static void Cuenta_vocales(String txt) {
            int a = 0, e = 0, i = 0, o = 0, u = 0;

            //Recorremos el texto en busca de las vocales y vamos sumando cuando encuentre cada vocal
            for (int j = 0; j < txt.Length; j++){
                if (txt[j] == 'a')
                {
                    a += 1;
                }else if (txt[j] == 'e')
                {
                    e += 1;
                }else if (txt[j] == 'i')
                {
                    i += 1;
                }else if(txt[j] == 'o')
                {
                    o +=1;
                }else if (txt[j] == 'u')
                {
                    u += 1;
                } 
            }

            //Creamos dos listas, una con las vocales y otra con los valores de cada vocal encontrada
           List<String> letras = new List<string>{ "a", "e", "i", "o", "u" };
            List<int> valores = new List<int> { a, e, i, o, u };

            int mayor = 0;
            int m = 1;
            String letra = "";

            //ordenamos las listas de mayor a menor
            for (int l=0; l < valores.Count - 1; l++)
            {
                if(valores[l] > valores[m])
                {
                    mayor = valores[l];
                    letra = letras[l]; 
                }
                else
                {
                    mayor = valores[m];
                    letra = letras[m];
                    valores[m] = valores[l];
                    letras[m] = letras[l];
                    valores[l] = mayor;
                    letras[l] = letra;
                }
                m += 1;
            }

            //Una vez ordenadas las dos listas, mostramos el valor de cada una en la posicion 0, ya que va a ser la letra que más veces se repite
                Console.WriteLine("La letra que más se repite es: " + letras[0] + " con un total de: " + valores[0] + " veces.");

            Console.ReadLine();
        }
    }
}
=======
fun main() {
    println(mostRepeatedVowel("aaaaaeeeeiiioou"))
    println(mostRepeatedVowel("AáaaaEeeeIiiOoU"))
    println(mostRepeatedVowel("eeeeiiioouaaaaa"))
    println(mostRepeatedVowel(".-Aá?aaaBbEeeweIiiOoU:"))
    println(mostRepeatedVowel(".-Aá?aaa BbEeew eIiiOoU:"))
    println(mostRepeatedVowel(".-Aá?aaa BbEeew eEIiiOoU:"))
    println(mostRepeatedVowel(".-Aá?aaa BbEeew eEIiiOoUuuuuu:"))
    println(mostRepeatedVowel("aeiou"))
    println(mostRepeatedVowel("brp qyz"))
}

private fun mostRepeatedVowel(text: String) : List<String> {

    val vowelCount = mutableMapOf<Char, Int>()

    Normalizer.normalize(text.lowercase(), Normalizer.Form.NFD).forEach { character ->
        if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
            vowelCount[character] = vowelCount[character]?.plus(1) ?: 1
        }
    }

    val mostRepeated = mutableListOf<String>()
    var maxRepeated = 0

    vowelCount.forEach { (vowel: Char, count: Int) ->
        if (count >= maxRepeated) {
            if (count > maxRepeated) {
                mostRepeated.clear()
            }
            mostRepeated.add(vowel.toString())

            maxRepeated = count
        }
    }

    return mostRepeated
}

