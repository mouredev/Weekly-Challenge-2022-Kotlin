using System;

namespace Reto_43
{
    class Program
    {
        /*
 * Reto #43
 * TRUCO O TRATO
 * Fecha publicación enunciado: 24/10/22
 * Fecha publicación resolución: 02/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Este es un reto especial por Halloween.
 * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco o Trato" y
 * un listado (array) de personas con las siguientes propiedades:
 * - Nombre de la niña o niño
 * - Edad
 * - Altura en centímetros
 *
 * Si las personas han pedido truco, el programa retornará sustos (aleatorios)
 * siguiendo estos criterios:
 * - Un susto por cada 2 letras del nombre por persona
 * - Dos sustos por cada edad que sea un número par
 * - Tres sustos por cada 100 cm de altura entre todas las personas
 * - Sustos: 🎃 👻 💀 🕷 🕸 🦇
 *
 * Si las personas han pedido trato, el programa retornará dulces (aleatorios)
 * siguiendo estos criterios:
 * - Un dulce por cada letra de nombre
 * - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
 * - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
 * - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

        //https://www.jdoodle.com/compile-c-sharp-online/ Es el unico compilador online que he localizado que me pone los emoticonos bien
        //Si se ven interrogantes en vez de simbolos, usenlo
        static string[] dulces = { "🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩" };
        static string[] sustos = { "🎃", "👻", "💀", "🕷", "🕸", "🦇" };
        struct Persona
        {
            public string Nombre;
            public int Edad;
            public float Altura;
        }

        static void Main(string[] args)
        {
            Persona[] GrupoPersonas = CollectData();
            if (TrucoOTrato())
                Truco(GrupoPersonas);
            else
                Trato(GrupoPersonas);
        }
        static Persona[] CollectData()
        {
            Persona[] GrupoPersonas = { };
            bool NumeroValido = false;
            while (!NumeroValido)
            {
                Console.WriteLine("Introduce la cantidad de personas");
                if (Int32.TryParse(Console.ReadLine(), out int cantidadPersonas))
                {
                    GrupoPersonas = new Persona[cantidadPersonas];
                    NumeroValido = true;
                }
                else
                    Console.WriteLine("Entrada incorrecta, prueba otra vez");
            };
            for (int i = 0; i < GrupoPersonas.Length; i++)
            {
                Console.WriteLine("Introduce nombre de la persona " + (i + 1));
                GrupoPersonas[i].Nombre = Console.ReadLine();
                NumeroValido = false;
                while (!NumeroValido)
                {
                    Console.WriteLine("Introduce edad de " + GrupoPersonas[i].Nombre);
                    if (Int32.TryParse(Console.ReadLine(), out int edadPersona))
                    {
                        GrupoPersonas[i].Edad = edadPersona;
                        NumeroValido = true;
                    }
                    else
                        Console.WriteLine("Entrada incorrecta, prueba otra vez");
                }
                NumeroValido = false;
                while (!NumeroValido)
                {
                    Console.WriteLine("Introduce altura de " + GrupoPersonas[i].Nombre);
                    if (float.TryParse(Console.ReadLine(), out float alturaPersona))
                    {
                        GrupoPersonas[i].Altura = alturaPersona;
                        NumeroValido = true;
                    }
                    else
                        Console.WriteLine("Entrada incorrecta, prueba otra vez");
                }
            }
            return GrupoPersonas;
        }
        static bool TrucoOTrato()
        {
            Console.WriteLine("Truco o trato?");
            Console.WriteLine("[1] Truco");
            Console.WriteLine("[2] Trato");
            while (true)
            {
                switch (Console.Read())
                {
                    case '1':
                        return true;
                    case '2':
                        return false;
                    default:
                        break;
                }
            }
        }
        static void Truco(Persona[] personas)
        {
            int CantidadSustos = 0;
            foreach(Persona persona in personas)
            {
                CantidadSustos += persona.Nombre.Length / 2;
                if (persona.Edad % 2 == 0)
                    CantidadSustos++;
                CantidadSustos += ((int)persona.Altura/100) * 3; 
            }
            string sustosString = "";
            Random rng = new Random();
            for  (int i = 0; i < CantidadSustos; i++)
                sustosString += sustos[rng.Next(0, sustos.Length)];
            Console.WriteLine($"Has dado {CantidadSustos} sustos \n {sustosString}");


        }
        static void Trato(Persona[] personas)
        {
            int CantidadDulces = 0;
            foreach (Persona persona in personas)
            {
                CantidadDulces += persona.Nombre.Length;
                CantidadDulces += persona.Edad > 10 ? 10 / 3 : persona.Edad / 3;
                CantidadDulces += persona.Altura > 150 ? (150 / 50)*2 : ((int)persona.Altura / 50)*2;
            }
            string dulcesString = "";
            Random rng = new Random();
            for (int i = 0; i < CantidadDulces; i++)
                dulcesString += dulces[rng.Next(0, dulces.Length)];
            Console.WriteLine($"Has recibido {CantidadDulces} dulces \n {dulcesString}");


        }
    }
}
