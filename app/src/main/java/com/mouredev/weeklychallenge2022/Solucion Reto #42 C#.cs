
/*
 * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit
 * y viceversa.
 *
 * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" 
 *   y su unidad ("C" o "F").
 *   Para convertir de ºC a ºF use la fórmula: ºF = ºC x 1.8 + 32.
 * - En caso contrario retornará un error.
 * - ¿Quieres emplear lo aprendido en este reto?
 *   Revisa el reto mensual y crea una App: 
 *   https://retosdeprogramacion.com/mensuales2022
 */

internal class Program
{
    private static void Main(string[] args)
    {
        string? temp = Console.ReadLine();
        

        Console.WriteLine($"La temperatura de entrada es: {temp}. La conversión es: {Convertir(temp)}");
    }

    private static string Convertir(string? temperatura)
    {
        if(String.IsNullOrEmpty(temperatura)== false)
        {
            if (temperatura.Contains('°') && (temperatura.Contains('C') || temperatura.Contains('F')) && temperatura.Equals("") == false)
            {
                temperatura = temperatura.Remove(temperatura.Length - 2);

                double temperaturaConvertida = Convert.ToDouble(temperatura);
                double result = 0;

                if (temperatura.Contains('C'))
                {
                    result = (temperaturaConvertida * 1.8) + 32;
                    return result.ToString() + "°F";
                }
                else
                {
                    result = (temperaturaConvertida - 32) / 1.8;
                    return result.ToString() + "°C";
                }
            }
            else
            {
                return "Error en la conversión, la temperatura de entrada no es correcta.";
            }
        }
        else
        {
            return "Error en la conversión, la temperatura de entrada no es correcta.";
        }
       
    }
}