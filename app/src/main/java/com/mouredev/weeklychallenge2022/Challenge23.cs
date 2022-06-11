/*
 * Reto #23
 * MÁXIMO COMÚN DIVISOR Y MÍNIMO COMÚN MÚLTIPLO
 * Fecha publicación enunciado: 07/06/22
 * Fecha publicación resolución: 13/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra que calcule el mínimo común múltiplo (mcm) de dos números enteros.
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

namespace MCD_MCM
{
	class Program
	{
		static void Main(string[] args)
		{

			Console.WriteLine(" Maximo comun divisor");
			Console.WriteLine(MaximoComunDivisor(42, 56).ToString());  //14
			Console.WriteLine(MaximoComunDivisor(48, 60).ToString());  //12
			Console.WriteLine(MaximoComunDivisor(451, 851).ToString());//1
			Console.WriteLine(MaximoComunDivisor(325, 1125).ToString());//25
			Console.WriteLine(MaximoComunDivisor(7878, 6969).ToString());//303
			Console.WriteLine(MaximoComunDivisor(3621, 745).ToString());//1
			Console.WriteLine(MaximoComunDivisor(89, 99).ToString());//1
			Console.WriteLine(MaximoComunDivisor(251, 632).ToString());//1


			Console.WriteLine(" Minimo comun multiplo");

			Console.WriteLine(MinimoComunMultiplo(72, 50)); //1.800
			Console.WriteLine(MinimoComunMultiplo(32, 2));  //32
			Console.WriteLine(MinimoComunMultiplo(451, 526)); //237.226
			Console.WriteLine(MinimoComunMultiplo(745, 1452)); //1.081.740
			Console.WriteLine(MinimoComunMultiplo(99, 84)); // 2.772
			Console.WriteLine(MinimoComunMultiplo(741474, 147511)); // 109.375.571.214
																	

			Console.ReadLine();
		}
				
		/// <summary>
		///  El Mayor número entero que divide dos o mas numeros sin dejar un resto (resto = 0).
		///  Usando Algoritmo de Euclides.
		///  https://es.wikipedia.org/wiki/M%C3%A1ximo_com%C3%BAn_divisor
		/// </summary>
		/// <param name="a"></param>
		/// <param name="b"></param>
		/// <returns></returns>
		public static double MaximoComunDivisor(double a, double b)
		{
			double auxA = Math.Max(a, b);
			double auxB = Math.Min(a, b);			

			if (auxB == 0)
				return auxA;

			double resto = auxA % auxB;

			while ( resto != 0)
			{
				auxA  = auxB;
				auxB  = resto;
				resto = auxA % auxB;				
			}

			return auxB;
		}

		
		/// <summary>
		/// Es el número positivo mas pequeño que es multiplo de dos o más números. 
		/// Formula mcm(a,b) = a*b / MCD(a,b)
		/// https://es.wikipedia.org/wiki/M%C3%ADnimo_com%C3%BAn_m%C3%BAltiplo
		/// </summary>
		/// <param name="a"></param>
		/// <param name="b"></param>
		/// <returns></returns>
		public static double MinimoComunMultiplo(double a , double b )
		{
			return ((a * b) / MaximoComunDivisor(a, b));
		}

	}
}