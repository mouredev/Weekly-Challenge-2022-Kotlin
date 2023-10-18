using System;
using System.Text;

namespace PokeBattleSimulator
{
    /// <summary>
    /// Combatiente Pokémon.
    /// </summary>
    public struct Pokemon
    {
        public int ID;
        public ElementalType MainType;
        public int Attack;
        public int Defense;
        public string Name;
    }

    /// <summary>
    /// Tipo elemental principal del Pokémon.
    /// </summary>
    public enum ElementalType
    {
        Agua,
        Fuego,
        Planta,
        Electrico
    }

    public class Program
    {
        static float[,] _typesTable = new float[,]
        {
            { 0.5f, 2, 0.5f, 1 }, // Tipo atacante: Agua.
            { 0.5f, 0.5f, 2, 1 }, // Tipo atacante: Fuego.
            { 2, 0.5f, 0.5f, 1 }, // Tipo atacante: Planta.
            { 2, 1, 0.5f, 0.5f }  // Tipo atacante: Electrico.
        };

        static Pokemon _pokemon1;
        static Pokemon _pokemon2;

        static void Main(string[] args)
        {
            Console.WriteLine("\t\t\t * * Reto #35: Batalla Pokémon * * \n");

            if (args.Length == 0)
            {
                Console.WriteLine("Defina al primer Pokemon (atacante): ");
                _pokemon1 = PokemonCreator(1);

                Console.WriteLine("\nDefina al segundo Pokemon (defensor): ");
                _pokemon2 = PokemonCreator(2);
            }
            // Pasando DEMO como parametro se puede observar una batalla con Pokémons ya definidos.
            else if (args.Length > 0)
            {
                if (args[0] == "DEMO")
                {
                    _pokemon1 = CreatePokemon(1, ElementalType.Agua, 45, 58, "Marinadora");
                    _pokemon2 = CreatePokemon(2, ElementalType.Fuego, 60, 48, "Fuegardo");
                }
            }

            Console.WriteLine(" * * Primer combate * * \n");
            Console.WriteLine(StartBattle(_pokemon1, _pokemon2));

            Console.WriteLine(" * * Segundo combate * * \n");
            Console.WriteLine(StartBattle(_pokemon2, _pokemon1));
        }

        /// <summary>
        /// Inicia una batalla entre el Pokémon atacante y el Pokémon defensor.
        /// </summary>
        /// <param name="pokeAttacker">Pokémon atacante (causa el daño).</param>
        /// <param name="pokeDefenser">Pokémon defensor (recibe el daño).</param>
        /// <returns>Transcurso de la batalla.</returns>
        static string StartBattle(Pokemon pokeAttacker, Pokemon pokeDefenser)
        {
            StringBuilder combatLog = new StringBuilder();
            combatLog.AppendFormat("\t* {0} contra {1} *\n\n", pokeAttacker.Name, pokeDefenser.Name);
            
            Console.WriteLine("¡Pulsa una tecla para iniciar!");
            Console.ReadKey(true);            


            combatLog.AppendFormat(
                "¡{0} realiza un ataque directo a {1}!\n",
                pokeAttacker.Name,
                pokeDefenser.Name
            );
            combatLog.AppendLine("¡Menudo golpe!");
            combatLog.AppendFormat(
                "¡{0} le causo {2} puntos de daño a {1}!\n\n",
                pokeAttacker.Name,
                pokeDefenser.Name,
                CalculateDamage(pokeAttacker, pokeDefenser)
            );
            combatLog.AppendLine("¡Fin del turno!");

            return combatLog.ToString();
        }

        /// <summary>
        /// Ayuda al usuario a crear sus propios Pokémons.
        /// </summary>
        /// <param name="id">ID del Pokémon</param>
        /// <returns>Pokémon creado con las especificaciones del usuario.</returns>
        static Pokemon PokemonCreator(int id)
        {
            ElementalType pokeType = ElementalType.Agua;
            int pokeAttack = 0;
            int pokeDefense = 0;
            string pokeName = string.Empty;

            do
            {
                Console.WriteLine(
                    "\n * Defina su tipo elemental de los siguientes:\n"
                        + "\t1 - Agua.\n"
                        + "\t2 - Fuego.\n"
                        + "\t3 - Planta.\n"
                        + "\t4 - Electrico.\n"
                );
            } while (DefinePokeType(ref pokeType));

            do
            {
                Console.WriteLine("\n * Defina su poder de ataque (entre 1 y 100)");
            } while (DefineCombatStat(ref pokeAttack));

            do
            {
                Console.WriteLine("\n * Defina su poder de defensa (entre 1 y 100)");
            } while (DefineCombatStat(ref pokeDefense));

            Console.WriteLine(
                "\n * ¿Quieres ponerle un nombre a tu Pokémon?\n(Solo pulsa ENTER para usar el nombre por defecto.)"
            );
            DefinePokeName(ref pokeName, id);

            Console.Write("\n");

            return CreatePokemon(id, pokeType, pokeAttack, pokeDefense, pokeName);
        }

        /// <summary>
        /// Defines uno de los stat del Pokémon.
        /// </summary>
        /// <param name="stat">Stat a definir (ataque o defensa).</param>
        /// <returns>El stat se definio correctamente?</returns>
        static bool DefineCombatStat(ref int stat)
        {
            bool statHasBeenCorrectlyDefined = false;            

            try
            {
                Console.Write("> ");
                stat = Int32.Parse(Console.ReadLine());

                if (CheckValueWithinRange(stat, 1, 100))
                {
                    statHasBeenCorrectlyDefined = true;
                    Console.WriteLine("\nValor introducido: {0}", stat);
                }
                else
                {
                    statHasBeenCorrectlyDefined = false;
                    Console.WriteLine("\nValor introducido fuera del rango.");
                }
            }
            catch (Exception)
            {
                statHasBeenCorrectlyDefined = false;
                Console.WriteLine("\nEntrada no valida");
            }
           
            return !(statHasBeenCorrectlyDefined);
        }

        /// <summary>
        /// Define el tipo elemental del Pokémon.
        /// </summary>
        /// <param name="pokeType">Tipo elemental a definir.</param>
        /// <returns>El tipo se seteo correctamente?</returns>
        static bool DefinePokeType(ref ElementalType pokeType)
        {
            bool typeHasWellDefined = false;

            try
            {
                Console.Write("> ");
                int typeEntered = Int32.Parse(Console.ReadLine());
                
                if (CheckValueWithinRange(typeEntered, 1, 4))
                {
                    typeHasWellDefined = true;

                    pokeType = (ElementalType)(typeEntered - 1);
                    Console.WriteLine("\nTipo seleccionado: {0}", Enum.GetName(pokeType));
                }
                else
                {
                    typeHasWellDefined = false;

                    Console.WriteLine(
                        "\nEl valor introducido no encaja con ninguno de los presentados. Escribalo de nuevo, por favor."
                    );
                }
            }
            catch (Exception)
            {
                typeHasWellDefined = false;

                Console.WriteLine("\nEntrada no valida.");
            }

            return !(typeHasWellDefined);
        }

        /// <summary>
        /// Define el nombre del Pokémon.
        /// </summary>
        /// <param name="name">Nombre a definir.</param>
        /// <param name="id">ID del Pokémon.</param>
        static void DefinePokeName(ref string name, int id)
        {
            Console.Write("> ");
            name = Console.ReadLine();
            
            if (name == "")
            {
                string genericName = String.Format("Poke Monster {0}", id);

                Console.WriteLine("Usando nombre por defecto: {0}", genericName);
                name = genericName;
            }
        }

        /// <summary>
        /// Crea a un Pokémon con las especificaciones dadas.
        /// </summary>
        /// <param name="id">ID del Pokémon (1 o 2).</param>
        /// <param name="type">Su tipo elemental principal.</param>
        /// <param name="attack">Su poder de ataque.</param>
        /// <param name="defense">Su poder de defensa.</param>
        /// <param name="name">Su nombre.</param>
        /// <returns>Pokémon con sus propias características.</returns>
        static Pokemon CreatePokemon(
            int id,
            ElementalType type,
            int attack,
            int defense,
            string name
        )
        {
            Pokemon pokemon = new Pokemon();
            pokemon.ID = id;
            pokemon.MainType = type;
            pokemon.Attack = attack;
            pokemon.Defense = defense;
            pokemon.Name = name;

            return pokemon;
        }

        /// <summary>
        /// Obtiene la efectividad de un tipo contra otro.
        /// </summary>
        /// <param name="attackerType">Tipo del Pokémon atacante.</param>
        /// <param name="defenderType">Tipo del Pokémon defensor.</param>
        /// <returns>Su efectividad, desde x0.5 hasta x2</returns>
        static float GetTypeEffectiveness(ElementalType attackerType, ElementalType defenderType)
        {
            // Niveles de efectividad:
            // * * * * * * * * * * * * * * *
            // Súper efectivo: x2
            // Neutral: x1
            // No es muy efectivo: x0.5
            // * * * * * * * * * * * * * * *

            return _typesTable[(int)attackerType, (int)defenderType];
        }

        /// <summary>
        /// Calcula el daño causado por el ataque de un pokemon hacia el otro.
        /// </summary>
        /// <param name="attacker">Pokémon atacante.</param>
        /// <param name="defenser">Pokémon defensor.</param>
        /// <returns>Daño causado hacia el Pokémon defensor.</returns>
        static float CalculateDamage(Pokemon attacker, Pokemon defenser)
        {
            // Formula usada:
            //      * * daño = 50 * (ataque / defensa) * efectividad * *
            int umbral = 50;
            float damage =
                umbral
                * (attacker.Attack / defenser.Defense)
                * GetTypeEffectiveness(attacker.MainType, defenser.MainType);

            // Los ataques siempre causan daño, como en el juego original.
            if (damage <= 0)
            {
                damage = 1;
            }

            return damage;
        }

        /// <summary>
        /// Comprueba si un valor esta dentro de un rango de valores.
        /// </summary>
        /// <param name="value">Valor a comprobar.</param>
        /// <param name="minLimit">Limite minimo del valor.</param>
        /// <param name="maxLimit">Limite máximo del valor.</param>
        /// <returns>Esta dentro del rango?</returns>
        static bool CheckValueWithinRange(int value, int minLimit, int maxLimit)
        {            
            return (value >= minLimit && value <= maxLimit);
        }
    }
}
