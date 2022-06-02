/*
 * Reto #22
 * CONJUNTOS
 * Fecha publicación enunciado: 01/06/22
 * Fecha publicación resolución: 07/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos array, un booleano y retorne un array.
 * - Si el booleano es verdadero buscará y retornará los elementos comunes de los dos array.
 * - Si el booleano es falso buscará y retornará los elementos no comunes de los dos array.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
	internal class Program
	{
		static void Main(string[] args)
		{
			Console.WriteLine(" ------- Test Array de Caracteres  ------- ");
			char[] charArray1 = { 'a', 'b', 'c', 'd', 'f', 'g', 'l' };
			char[] charArray2 = { 'c', 'f', 'g', 'h', 'i', 'j', 'k' };

			var arrayIntersecChar   = GetArrayIntersectOrDiferrences(charArray1, charArray2);
			var arrayDiferencesChar = GetArrayIntersectOrDiferrences(charArray1, charArray2, false);
			Console.WriteLine("Elementos Comunes:  [{0}]", string.Join(",", arrayIntersecChar));
			Console.WriteLine("Elementos Diferentes [{0}]", string.Join(",", arrayDiferencesChar));

			Console.WriteLine();
			Console.WriteLine(" ------- Test Array de Enteros  ------- ");

			int[] arrayInt1 = { 1, 2, 5, 8, 9, 10 };
			int[] arrayInt2 = { 3, 4, 5, 6, 7, 8, 10 };

			var arrayInterseccInt = GetArrayIntersectOrDiferrences(arrayInt1, arrayInt2);			
			var arrayDiferencesInt = GetArrayIntersectOrDiferrences(arrayInt1, arrayInt2, false);
			Console.WriteLine("Elementos Comunes:  [{0}]", string.Join(",", arrayInterseccInt));
			Console.WriteLine("Elementos Diferentes [{0}]", string.Join(",", arrayDiferencesInt));

			Console.WriteLine();
			Console.WriteLine(" -------  Test Array de Cadenas ------- ");

			string[] arrayNames1 = { "jose", "pablo", "carmelo", "paula", "antonio", "maria" };
			string[] arrayNames2 = { "juan", "natalia", "carmelo", "paula", "genaro", "nicolas", "nadia" };
			var arrayInterseccNames = GetArrayIntersectOrDiferrences(arrayNames1, arrayNames2);			
			var arrayDiferencesNames = GetArrayIntersectOrDiferrences(arrayNames1, arrayNames2, false);

			Console.WriteLine("Elementos Comunes:  [{0}]", string.Join(",", arrayInterseccNames));
			Console.WriteLine("Elementos Diferentes [{0}]", string.Join(",", arrayDiferencesNames));

			Console.WriteLine();
			Console.WriteLine(" ------- Test Array con Decimales ------- ");
			Random rand = new Random();

			Double[] arrayDecimales1 = { rand.NextDouble(), rand.NextDouble(), rand.NextDouble(), 1.5f, 2.5555f };
			Double[] arrayDecimales2 = { rand.NextDouble(), rand.NextDouble(), rand.NextDouble(),1.5f, 2.5555f };
			var arrayIntersecDoubles = GetArrayIntersectOrDiferrences(arrayDecimales1, arrayDecimales2);
			var arrayDiferencesDoubles = GetArrayIntersectOrDiferrences(arrayDecimales1, arrayDecimales2, false);

			Console.WriteLine("Elementos Comunes:  [{0}]",  string.Join(";", arrayIntersecDoubles));
			Console.WriteLine("Elementos Diferentes [{0}]", string.Join(";", arrayDiferencesDoubles));

			Console.ReadLine();
		}



		/// <summary>
		/// Get the Arrays Intersect or Diferences.
		/// </summary>
		/// <typeparam name="T"></typeparam>
		/// <param name="array1"></param>
		/// <param name="array2"></param>
		/// <param name="intersect">
		/// True (Default) Intersect, False (Diferences)
		/// </param>
		/// <returns></returns>
		public static T[] GetArrayIntersectOrDiferrences<T>(T[] array1, T[] array2, bool intersect = true)
		{
			return intersect ? _GetArraysIntersect(array1, array2) : _GetArraysDifferences(array1, array2);
		}

		private static T[] _GetArraysDifferences<T>(T[] array1, T[] array2)
		{
			List<T> arrayResult = new List<T>();

			if (array1.Length > 0)
			{
				foreach (T item in array1)
				{
					if (!array2.Contains(item))
						arrayResult.Add(item);
				}
			}

			if (array2.Length > 0)
			{
				foreach (T item in array2)
				{
					if (!array1.Contains(item))
						arrayResult.Add(item);
				}
			}

			return arrayResult.ToArray();

		}

		private static T[] _GetArraysIntersect<T>(T[] array1, T[] array2)
		{
			List<T> arrayResult = new List<T>();

			if (array1.Length < 0 || array2.Length < 0)
				return arrayResult.ToArray();

			foreach (T item in array1)
			{
				if (array2.Contains(item))
					arrayResult.Add(item);
			}

			return arrayResult.ToArray();
		}
	}
}