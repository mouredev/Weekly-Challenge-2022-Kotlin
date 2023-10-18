using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatallaPokemn.Clases
{
    internal class Pokedex
    {
       public static List<Pokemon> ListaPokemon = new List<Pokemon>();
        public static int Long = 4;
       public Pokedex()
        {
            Pokemon Pk=new Pokemon();
            Pk.Nombre = "Bulbasaur";
            Pk.Tipo =(int)TipoPokemon.Tipo.Planta;
            Pk.Ataque = 49;
            Pk.Defensa = 49;
            Pk.vida = 45;
            ListaPokemon.Add(Pk);

            Pk = new Pokemon();
            Pk.Nombre = "Charmander";
            Pk.Tipo = (int)TipoPokemon.Tipo.Agua;
            Pk.Ataque = 52;
            Pk.Defensa = 43;
            Pk.vida = 39;
            ListaPokemon.Add(Pk);

            Pk = new Pokemon();
            Pk.Nombre = "Squirtle";
            Pk.Tipo = (int)TipoPokemon.Tipo.Agua;
            Pk.Ataque = 48;
            Pk.Defensa = 65;
            Pk.vida = 44;
            ListaPokemon.Add(Pk);

            Pk = new Pokemon();
            Pk.Nombre = "Pikachu";
            Pk.Tipo = (int)TipoPokemon.Tipo.Agua;
            Pk.Ataque = 55;
            Pk.Defensa = 40;
            Pk.vida = 3;
            ListaPokemon.Add(Pk);
        }
        
    }

}
