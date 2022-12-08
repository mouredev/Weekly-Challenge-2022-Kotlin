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
using System.Globalization;

internal class Programa
{
    static void Main(string[] args)
    {

        //DateTime date = new DateTime(2023, 10, 22, 10, 18, 18);
        DateTime date = DateTime.Now;
        Datos datos = new Datos();
        datos.CrearPremios();
        datos.BuscarPremio(date);
        datos.ImprimirPremio();
    }
}

public class Datos
{
    DateTime fecha_inicio;
    DateTime fecha_termino;
    List<Premios> premios;
    string currentPremio;

    public Datos()
    {
        fecha_inicio = new DateTime(2022, 12, 1, 00, 00, 00);
        fecha_termino = new DateTime(2022, 12, 24, 23, 59, 59);
        premios = new List<Premios>();
        currentPremio = string.Empty;
    }

    public void BuscarPremio(DateTime date)
    {
        if (date >= fecha_inicio && date <= fecha_termino)
        {
            currentPremio = premios.Where(x => x.Fecha.ToString("dd/MM/yyyy", CultureInfo.InvariantCulture) == date.ToString("dd/MM/yyyy", CultureInfo.InvariantCulture)).Select(x => x.Premio).FirstOrDefault();
            currentPremio = $"Tu regalo es: {currentPremio}";
            if (currentPremio == null || currentPremio == "")
            {
                currentPremio = "Sin premio";
            }
        }
        else if (date < fecha_inicio)
        {
            TimeSpan diffTimeSpan = fecha_inicio.Subtract(date);        
            currentPremio = $"Faltan {diffTimeSpan.Days} dias, {diffTimeSpan.Hours} Horas, {diffTimeSpan.Minutes} minutos, {diffTimeSpan.Seconds} segundos para que empiece la rifa de premios";
        }
        else if (date > fecha_termino)
        {
            TimeSpan diffTimeSpan = date.Subtract(fecha_termino);
            currentPremio = $"Ya pasaron {diffTimeSpan.Days} dias {diffTimeSpan.Hours} Horas, {diffTimeSpan.Minutes} minutos, {diffTimeSpan.Seconds} desde que termino la rifa de premios";
        }
    }
    public void ImprimirPremio()
    {
        Console.WriteLine(currentPremio);
    }

    public void CrearPremios()
    {

        premios.Add(new Premios { Premio = "Control de Xbox", Fecha = new DateTime(2022, 12, 1, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Teclado", Fecha = new DateTime(2022, 12, 2, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Control de PS5", Fecha = new DateTime(2022, 12, 3, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Mouse gamer", Fecha = new DateTime(2022, 12, 4, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Celular Nokia", Fecha = new DateTime(2022, 12, 5, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Monitor 32' ", Fecha = new DateTime(2022, 12, 6, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Silla gamer", Fecha = new DateTime(2022, 12, 7, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Tarjeta de video", Fecha = new DateTime(2022, 12, 8, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Curso de Phyton", Fecha = new DateTime(2022, 12, 9, 00, 00, 00) });
        premios.Add(new Premios { Premio = "El programador pragmatico", Fecha = new DateTime(2022, 12, 10, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Audifonos", Fecha = new DateTime(2022, 12, 11, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Arduino", Fecha = new DateTime(2022, 12, 12, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Raspberry", Fecha = new DateTime(2022, 12, 13, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Disco de los acosta", Fecha = new DateTime(2022, 12, 14, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Curso de GO", Fecha = new DateTime(2022, 12, 15, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Curso de Kotlin", Fecha = new DateTime(2022, 12, 16, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Curso de JavaScript", Fecha = new DateTime(2022, 12, 17, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Curso de Vue", Fecha = new DateTime(2022, 12, 18, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Hosting por 1 año", Fecha = new DateTime(2022, 12, 19, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Videojuegos multiplataforma “while True: learn()", Fecha = new DateTime(2022, 12, 20, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Cursos \"Aprende Javascript ES9, HTML, CSS3 y NodeJS desde cero” de Nicolás Schürmann", Fecha = new DateTime(2022, 12, 21, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Cursos \"Patrones de Diseño en JavaScript y TypeScript” de Héctor de León", Fecha = new DateTime(2022, 12, 22, 00, 00, 00) });
        premios.Add(new Premios { Premio = "Pack de libros \"Aprende Python en un fin de semana” de Alfredo Moreno Muñoz y Sheila Córcoles Córcoles", Fecha = new DateTime(2022, 12, 23, 00, 00, 00) });
        premios.Add(new Premios { Premio = "(x5) Cursos \"Desarrollo de Apps iOS con Swift” de Juan Villalvazo y Brais Moure", Fecha = new DateTime(2022, 12, 24, 00, 00, 00) });

    }

  
}

public class Premios
{
    public string Premio { get; set; }
    public DateTime Fecha { get; set; }
}