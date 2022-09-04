using System;

namespace Reto_35
{
    class Program
    {
        static void Main(string[] args)
        {
            Pokemon atacante = ConstruirPokemon(true);
            Pokemon defensor = ConstruirPokemon(false);

            CalcularEfectividad(atacante, defensor);

            Console.WriteLine("{0} vs {1}", atacante.Nombre, defensor.Nombre);
            Console.WriteLine("Daño --> {0}", CalcularDano(atacante, defensor));
            Console.WriteLine("Efectividad --> {0}", atacante.Efectividad);
        }

        /// <summary>
        /// Función que pide todos los datos de un Pokemon y crea y devuelve un Objeto Pokemon
        /// </summary>
        /// <param name="tipoAtaque"></param>
        /// <returns></returns>
        public static Pokemon ConstruirPokemon(bool tipoAtaque)
        {
            String nombre;
            int ataque = 0, defensa = 0, numeroTipo;
            Pokemon.Tipo tipo = 0;
            bool error = true;
            String titulo;

            if (tipoAtaque) titulo = "INFORMACIÓN DE POKEMON ATACANTE";
            else titulo = "INFORMACIÓN DE POKEMON DEFENSOR";

            Console.WriteLine(titulo);
            Console.Write("Nombre --> ");
            nombre = Console.ReadLine();
            Console.Clear();

            while (error)
            {
                try
                {
                    Console.WriteLine(titulo);
                    Console.Write("Ataque --> ");
                    ataque = Convert.ToInt32(Console.ReadLine());
                    if (ataque <= 0) throw new Exception("EL VALOR DEBE SER MAYOR QUE CERO");
                    Console.Clear();
                    error = false;
                }
                catch (Exception e)
                {
                    Console.Clear();
                    Console.WriteLine(e);
                    Console.ReadKey();
                    Console.Clear();
                }
            }
            error = true;

            while (error)
            {
                try
                {
                    Console.WriteLine(titulo);
                    Console.Write("Defensa --> ");
                    defensa = Convert.ToInt32(Console.ReadLine());
                    if (ataque <= 0) throw new Exception("EL VALOR DEBE SER MAYOR QUE CERO");
                    Console.Clear();
                    error = false;
                }
                catch (Exception e)
                {
                    Console.Clear();
                    Console.WriteLine(e);
                    Console.ReadKey();
                    Console.Clear();
                }
            }
            error = true;

            while (error)
            {
                try
                {
                    Console.WriteLine(titulo);
                    Console.WriteLine("1. Agua\n2. Fuego\n3. Planta\n4.Electrico");
                    Console.Write("Tipo --> ");
                    numeroTipo = Convert.ToInt32(Console.ReadLine());
                    if (numeroTipo > 4 || numeroTipo < 1) throw new Exception("VALOR INCORRECTO");
                    tipo = (Pokemon.Tipo)numeroTipo - 1;
                    Console.Clear();
                    error = false;
                }
                catch (Exception e)
                {
                    Console.Clear();
                    Console.WriteLine(e);
                    Console.ReadKey();
                    Console.Clear();
                }
            }
            error = true;

            Pokemon pokemon = new Pokemon(nombre, ataque, defensa, tipo, tipoAtaque);
            return pokemon;
        }

        /// <summary>
        /// Ataque vs Defensa:
        ///     Agua vs Agua --> x0.5
        ///     Agua vs Fuego --> x2
        ///     Agua vs Planta --> x0.5
        ///     Agua vs Electrico --> x1
        /// 
        ///     Fuego vs Agua --> x0.5
        ///     Fuego vs Fuego --> x0.5
        ///     Fuego vs Planta --> x2
        ///     Fuego vs Electrico --> x1
        ///     
        ///     Planta vs Agua --> x2
        ///     Planta vs Fuego --> x0.5
        ///     Planta vs Planta --> x0.5
        ///     Planta vs Electrico --> x1
        ///     
        ///     Electrico vs Agua --> x2
        ///     Electrico vs Fuego --> x1
        ///     Electrico vs Planta --> x0.5
        ///     Electrico vs Electrico --> x0.5
        /// </summary>
        /// <param name="ataque"></param>
        public static void CalcularEfectividad(Pokemon ataque, Pokemon defensa)
        {
            if (ataque.TipoPokemon == ataque.TipoPokemon) ataque.Efectividad = 0.5;
            else if(ataque.TipoPokemon == Pokemon.Tipo.Agua)
            {
                if (defensa.TipoPokemon == Pokemon.Tipo.Fuego) ataque.Efectividad = 2;
                else if (defensa.TipoPokemon == Pokemon.Tipo.Planta) ataque.Efectividad = 0.5;
                else ataque.Efectividad = 1;
            }
            else if (ataque.TipoPokemon == Pokemon.Tipo.Fuego)
            {
                if (defensa.TipoPokemon == Pokemon.Tipo.Agua) ataque.Efectividad = 0.5;
                else if (defensa.TipoPokemon == Pokemon.Tipo.Planta) ataque.Efectividad = 2;
                else ataque.Efectividad = 1;
            }
            else if (ataque.TipoPokemon == Pokemon.Tipo.Planta)
            {
                if (defensa.TipoPokemon == Pokemon.Tipo.Agua) ataque.Efectividad = 2;
                else if (defensa.TipoPokemon == Pokemon.Tipo.Fuego) ataque.Efectividad = 0.5;
                else ataque.Efectividad = 1;
            }
            else
            {
                if (defensa.TipoPokemon == Pokemon.Tipo.Agua) ataque.Efectividad = 2;
                else if (defensa.TipoPokemon == Pokemon.Tipo.Fuego) ataque.Efectividad = 1;
                else ataque.Efectividad = 0.5;
            }
        }

        /// <summary>
        /// Calcula el daño siguiendo la siguiente fórmula:
        /// daño = 50 * (ataque / defensa) * efectividad
        /// </summary>
        /// <param name="ataque"></param>
        /// <param name="defensa"></param>
        /// <returns></returns>
        public static double CalcularDano(Pokemon ataque, Pokemon defensa)
        {
            return 50 * (ataque.Ataque / defensa.Defensa) * ataque.Efectividad;
        }
    }
}
