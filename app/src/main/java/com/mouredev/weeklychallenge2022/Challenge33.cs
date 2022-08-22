using System;
using System.Globalization;

public class Program
{
	/** He marraneado el array de los elementos, 
	* duplicandolos y poniendole un order a mano, 
	* para evitar tener que hacer calculos que solo entorpecerian mucho la comprensión del código dando el mismo resultado.
	* No es la solución que me gustaría pero quizás si la mas 'sencilla'.
	* Se puede hacer uso de la librearia para comprobar resultados etc --> https://docs.microsoft.com/es-es/dotnet/api/system.globalization.chineselunisolarcalendar?view=net-6.0
	*/
	private static string[] celestialTrunks = new string[] { "Agua", "Madera", "Madera", "Fuego", "Fuego", "Tierra", "Tierra", "Metal", "Metal", "Agua" };
	private static string[] earthlyBranches = new string[] { "Cerdo", "Rata", "Buey", "Tigre", "Conejo", "Dragón", "Serpiente", "Caballo", "Oveja", "Mono", "Gallo", "Perro" };

	public static void Main()
	{
		Console.WriteLine("Introduce un año para conocer su símbolo sexagesimal.");

		var readedYear = Console.ReadLine();
		var sexagenaryCycleSymbol = GetSexagenaryCycleSymbolBy(readedYear);

		Console.WriteLine(sexagenaryCycleSymbol);


		/**
		Bloque para sacar una lista de simbolos sin tener que insertar a mano los años, para pruebas

		var currentYear = 1804;
		for (var i = 0; i < 2500; i++) 
		{
			Console.WriteLine(GetSexagenaryCycleSymbolBy(currentYear.ToString()));

			currentYear++;
		}\
		*/
	}

	private static string GetSexagenaryCycleSymbolBy(string year)
	{
		var resultMessage = "El Año introducido no es un año válido";
		int introducedYear;
		var isNumber = int.TryParse(year, out introducedYear);
		if (isNumber == true && introducedYear > 0)
		{
			var sexagenaryYear = ((introducedYear - 4) % 60) + 1;
			var celestialTrunk = celestialTrunks[(sexagenaryYear % 10)];
			var earthlyBranch = earthlyBranches[(sexagenaryYear % 12)];

			resultMessage = string.Format("El signo sexagesimal para el año {0} es: {1} - {2}", introducedYear, celestialTrunk, earthlyBranch);
		}

		return resultMessage;
	}
}