using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatallaPokemn.Clases
{
    internal class Pokemon
    {
        public string Nombre;
        public float Tipo;
        public float Ataque;
        public int Defensa;
        public float vida;

        public ResultadoAtaque Ataca(Pokemon Defensor)
        {
            ResultadoAtaque Resultado = new ResultadoAtaque();
            //50 * (ataque / defensa) * efectividad
            Resultado = TipoPokemon.Efectividad(this, Defensor);
            float Efectividad = Resultado.Efectividad;
            float Dano = 50 * (Ataque / Defensa) * Efectividad;
            Resultado.Dano= Dano;
            return Resultado;
        }

     
    }
}
