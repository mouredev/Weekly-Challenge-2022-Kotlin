using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatallaPokemn.Clases
{
   
     

    internal class TipoPokemon
    {

        public enum Tipo
        {
            Fuego = 1,
            Agua = 2,
            Planta = 3,
            Electrico = 4
        }

        public static ResultadoAtaque Efectividad(Pokemon Atacante,Pokemon Defensor)
        {
            ResultadoAtaque Result = new ResultadoAtaque();

            //Agua, Fuego, Planta y Eléctrico
            float Efectividad = 0;
            string Mensaje = "";
            switch(Atacante.Tipo)
            {
                case (int)Tipo.Fuego:
                    switch (Defensor.Tipo)
                    {
                        case (int)Tipo.Fuego:
                            Efectividad = 1;
                            Mensaje = "neutral";
                            break;
                        case (int)Tipo.Agua:
                            Efectividad = .5F;
                            Mensaje = "no es muy efectivo";
                            break;
                        case (int)Tipo.Planta:
                            Efectividad = 2;
                            Mensaje = "súper efectivo";
                            break;
                        case (int)Tipo.Electrico:
                            Efectividad = 1;
                            Mensaje = "neutral";
                            break;
                    }
                    break;
                case (int)Tipo.Agua:
                    switch (Defensor.Tipo)
                    {
                        case (int)Tipo.Fuego:
                            Efectividad = 2;
                            Mensaje = "súper efectivo";
                            break;
                        case (int)Tipo.Agua:
                            Efectividad = 1;
                            Mensaje = "neutral";
                            break;
                        case (int)Tipo.Planta:
                            Efectividad = .5F;
                            Mensaje = "no es muy efectivo";
                            break;
                        case (int)Tipo.Electrico:
                            Efectividad = 1;
                            Mensaje = "neutral";
                            break;
                    }
                    break;
                case (int)Tipo.Planta:
                    switch (Defensor.Tipo)
                    {
                        case (int)Tipo.Fuego:
                            Efectividad = 1;
                            Mensaje = "neutral";
                            break;
                        case (int)Tipo.Agua:
                            Efectividad = 2;
                            Mensaje = "súper efectivo";
                            break;
                        case (int)Tipo.Planta:
                            Efectividad = 1;
                            Mensaje = "neutral";
                            break;
                        case (int)Tipo.Electrico:
                            Efectividad = 1;
                            Mensaje = "neutral";
                            break;
                    }
                    break;
                case (int)Tipo.Electrico:
                    switch (Defensor.Tipo)
                    {
                        case (int)Tipo.Fuego:
                            Efectividad = 1;
                            Mensaje = "neutral";
                            break;
                        case (int)Tipo.Agua:
                            Efectividad = 2;
                            Mensaje = "súper efectivo";
                            break;
                        case (int)Tipo.Planta:
                            Efectividad = .5F;
                            Mensaje = "no es muy efectivo";
                            break;
                        case (int)Tipo.Electrico:
                            Efectividad = 1;
                            Mensaje = "neutral";
                            break;
                    }
                    break;
            }
            Result.Efectividad = Efectividad;
            Result.Mensaje = Mensaje;

            return Result;
        }
    }
}
