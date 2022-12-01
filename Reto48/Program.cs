/*
 * ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
 * 24 días, 24 regalos sorpresa relacionados con desarrollo de software,
 * ciencia y tecnología desde el 1 de diciembre.
 *
 * Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne
 * lo siguiente:
 * - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el regalo
 *   de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
 * - Si la fecha es anterior: Cuánto queda para que comience el calendario.
 * - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
 *
 * Notas:
 * - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00
 *   y finaliza a las 23:59:59.
 * - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos
 *   y segundos.
 * - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo
 *   del calendario de aDEViento hasta el día de su corrección
 *   (sorteo exclusivo para quien entregue su solución).
 */
using System.Text.RegularExpressions;

class Program
{
    static void Main(string[] args)
    {

        aDEViento22("4/17/2022 00:00:00 ");
        aDEViento22("12/11/2022 22:00:00 ");
        aDEViento22("1/6/2023 00:15:00 ");

    }

    private static void aDEViento22(string dateString)
    {
        var regalos = new[] { "PC", "Portatil", "Monitor", "Raton", "Teclado","Alfombrilla","Antivirus","Libro de programacion","Curso de programacion","Tarjeta grafica",
            "juego","Volante para juegos de conduccion","Tablet","Codigo para entorno de trabajo","subcripcion a canal de twich","Clase particular","clave para window","Mes de Netflix"
        ,"Mes de PSNPlus","Tiempo en WOW","Movil","Ebook","Mando PS5","Nintendo Switch"};

        var dateInsertada = DateTime.Parse(dateString, System.Globalization.CultureInfo.InvariantCulture);
        var dateInicial= DateTime.Parse("12 / 1 / 2022 00:00:00 ", System.Globalization.CultureInfo.InvariantCulture);
        var dateFinal = DateTime.Parse("12 / 24 / 2022 23:59:59 ", System.Globalization.CultureInfo.InvariantCulture);

        if (dateInsertada >= dateInicial && dateInsertada<=dateFinal)
        {
            Console.WriteLine("El regalo de hoy es: "+regalos[dateInsertada.Day]);
            dateFinal = DateTime.Parse("12 /"+dateInsertada.Day+"/ 2022 23:59:59 ", System.Globalization.CultureInfo.InvariantCulture);
            TimeSpan Diff_dates = dateFinal.Subtract(dateInsertada);
            Console.WriteLine("Tiempo que queda para solicitar el regalo: " + Diff_dates.Days + "Horas:" + Diff_dates.Hours + "Minutos:" + Diff_dates.Minutes + "Segundos: " + Diff_dates.Seconds);

        }
        else
        {
            if (dateInsertada >= dateFinal)
            {
                TimeSpan Diff_dates = dateInsertada.Subtract(dateFinal);
                Console.WriteLine("Diferencia de dias que han pasado: " + Diff_dates.Days+"Horas:"+Diff_dates.Hours+ "Minutos:" + Diff_dates.Minutes +"Segundos: " +Diff_dates.Seconds);
            }
            else
            {
                TimeSpan Diff_dates = dateInicial.Subtract(dateInsertada);
                Console.WriteLine("Diferencia de dias que quedan: " + Diff_dates.Days + "Horas:" + Diff_dates.Hours + "Minutos:" + Diff_dates.Minutes + "Segundos: " + Diff_dates.Seconds);
            }
            
        }
    }
}