using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SolucionReto33
{
    class Program
    {
        static void Main(string[] args)
        {
            string anioString = string.Empty;
            int anio = 0;
            int AnioFinUltimoCiclo = 1983;
            bool esNumero = int.TryParse(anioString, out anio);
            string respuesta = "N";
            while (!esNumero || respuesta == "S")
            {
                Console.WriteLine("Ingrese un año");
                anioString = Console.ReadLine();
                esNumero = int.TryParse(anioString, out anio);

                if (esNumero)
                {
                    //OBTENEMOS EL DIA DEL CALENDARIO ENTRE 1 Y 60
                    double AnioActual = anio - AnioFinUltimoCiclo;
                    double aniooo = AnioActual / 60;
                    if ((AnioActual / 60) > 1)
                    {
                        while (AnioActual > 60 )
                        {
                            AnioActual = AnioActual - 60;
                        }
                    }else if((AnioActual / 60) < 0)
                    {
                        while (AnioActual  < 1)
                        {
                            AnioActual = AnioActual + 60;
                        }
                       
                    }

                    //OBTENEMOS EL AÑO DEL CICLO SEGUN EL ANIMAL ENTRE 1 Y 12

                    double diaAnimal = AnioActual;
                    string animal = string.Empty;

                    while(diaAnimal > 12)
                    {
                        diaAnimal = diaAnimal - 12;
                    }

                    switch (diaAnimal)
                    {
                        case 1:
                            animal = "Rata";
                            break;
                        case 2:
                            animal = "Buey";
                            break;
                        case 3:
                            animal = "Tigre";
                            break;
                        case 4:
                            animal = "Conejo";
                            break;
                        case 5:
                            animal = "Dragon";
                            break;
                        case 6:
                            animal = "Serpiente";
                            break;
                        case 7:
                            animal = "Caballo";
                            break;
                        case 8:
                            animal = "Oveja";
                            break;
                        case 9:
                            animal = "Mono";
                            break;
                        case 10:
                            animal = "Gallo";
                            break;
                        case 11:
                            animal = "Perro";
                            break;
                        case 12:
                            animal = "Cerdo";
                            break;
                    }


                    //OBTENEMOS EL ULTIMO DIGITO DEL AÑO PARA OBTENER EL ELEMENTO

                    double ultimoNumero = AnioActual % 10;
                    string elemento = string.Empty;
                    if(ultimoNumero == 1 || ultimoNumero == 2)
                    {
                        elemento = "Madera";
                    }

                    if (ultimoNumero == 3 || ultimoNumero == 4)
                    {
                        elemento = "Fuego";
                    }

                    if (ultimoNumero == 5 || ultimoNumero == 6)
                    {
                        elemento = "Tierra";
                    }

                    if (ultimoNumero == 7 || ultimoNumero == 8)
                    {
                        elemento = "Metal";
                    }

                    if (ultimoNumero == 9 || ultimoNumero == 0)
                    {
                        elemento = "Agua";
                    }

                    Console.WriteLine("El año es chino es: " + animal + " de " + elemento);


                    string r = string.Empty;
                    while(r != "N" && r != "S")
                    {
                        Console.WriteLine("¿Desea consultar otro año? (S/N)");
                        r = Console.ReadLine().ToUpper();
                    }
                }
            }
        }
    }
}
