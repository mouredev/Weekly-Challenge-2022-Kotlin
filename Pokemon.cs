using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Reto_35
{
    class Pokemon
    {
        public enum Tipo
        {
            Agua,
            Fuego,
            Planta,
            Electrico
        }

        private String nombre;
        private int ataque, defensa;
        private double efectividad = 0;
        private bool tipoAtaque;
        private Tipo tipo;

        #region get y set
        public String Nombre
        {
            get { return nombre; }
        }
        public int Ataque
        {
            get { return ataque; }
        }
        public int Defensa
        {
            get { return defensa; }
        }
        public bool TipoAtaque
        {
            get { return tipoAtaque; }
        }
        public double Efectividad
        {
            get { return efectividad; }
            set { efectividad = value; }
        }
        public Tipo TipoPokemon
        {
            get { return tipo; }
        }
        #endregion

        public Pokemon()
        {
            this.nombre = "unknown";
        }

        public Pokemon(String nombre, int ataque, int defensa, Pokemon.Tipo tipo, bool tipoAtaque)
        {
            this.nombre = nombre;
            this.ataque = ataque;
            this.defensa = defensa;
            this.tipo = tipo;
            this.tipoAtaque = tipoAtaque;
        }
    }
}
