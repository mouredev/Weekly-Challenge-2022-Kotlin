using System;


namespace BatallaPokemn
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Clases.Pokedex Pokedex = new Clases.Pokedex();

            Console.WriteLine("Un Pokémon salvaje a parecido");
            Console.WriteLine("Presiona una tecla para entrar en batalla");
            Console.ReadKey();

            var rand = new Random();

            Clases.Pokemon Salvaje = Clases.Pokedex.ListaPokemon[rand.Next(Clases.Pokedex.Long-1)];
            Console.WriteLine($"Un {Salvaje.Nombre} salvaje a parecido");
            Console.WriteLine("Que Pokemon usaras?");
            for(int p = 0; p < Clases.Pokedex.Long; p++)
            {
                Console.WriteLine($"{p} -  {Clases.Pokedex.ListaPokemon[p].Nombre}");

            }
           
            Clases.Pokemon Entrenador = Clases.Pokedex.ListaPokemon[Convert.ToInt32(Console.ReadLine())];
            while (Entrenador.vida>0 && Salvaje.vida>0)
            {
                Clases.ResultadoAtaque AtacaEntrenador = new Clases.ResultadoAtaque();
                Clases.ResultadoAtaque AtacaSalvaje = new Clases.ResultadoAtaque();

                Console.WriteLine("Presiona una tecla para atacar");
                Console.ReadKey();
                Console.WriteLine($"{Entrenador.Nombre} ataca a {Salvaje.Nombre}");

                AtacaEntrenador = Entrenador.Ataca(Salvaje);
                Console.WriteLine($"el ataque ha sido {AtacaEntrenador.Mensaje} ");
                Salvaje.vida -= AtacaEntrenador.Dano;
                if(Salvaje.vida>0)
                {
                    Console.WriteLine($"Vida restante del pokemon {Salvaje.vida} ");
                }
                else
                {
                    Console.WriteLine($"EL pokemon ha sido debilitado");
                    break;
                }

                //ataca pokemn salvaje
                Console.WriteLine("Presiona una tecla para defender");
                Console.ReadKey();
                AtacaSalvaje = Salvaje.Ataca(Entrenador);
                Console.WriteLine($"el ataque ha sido {AtacaSalvaje.Mensaje} ");
                Entrenador.vida -= AtacaSalvaje.Dano;                
                if (Entrenador.vida > 0)
                {
                    Console.WriteLine($"Vida restante de tu pokemon {Entrenador.vida} ");
                }
                else
                {
                    Console.WriteLine($"Tu pokemon ha sido debilitado");
                    break;
                }

            }


        }
    }
}
