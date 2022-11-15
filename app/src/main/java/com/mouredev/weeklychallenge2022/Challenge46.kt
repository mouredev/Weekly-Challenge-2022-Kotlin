package com.mouredev.weeklychallenge2022

using Microsoft.SqlServer.Server;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace Robot
{       
    internal class Program
    {

        ///  Enunciado: Calcula dónde estará un robot(sus coordenadas finales) que se
        // encuentra en una cudrícula representada por los ejes "x" e "y".
        // - El robot comienza en la coordenada(0, 0).
        // - Para idicarle que se mueva, le enviamos un array formado por enteros
        // (positivos o negativos) que indican la secuencia de pasos a dar.
        // - Por ejemplo: [10, 5, -2] indica que primero se mueve 10 pasos, se detiene,
        // luego 5, se detiene, y finalmente 2. 
        //   El resultado en este caso sería (x: -5, y: 12)
        // - Si el número de pasos es negativo, se desplazaría en sentido contrario al
        //   que está mirando.
        // - Los primeros pasos los hace en el eje "y". Interpretamos que está mirando
        //   hacia la parte positiva del eje "y".
        // - El robot tiene un fallo en su programación: cada vez que finaliza una
        // secuencia de pasos gira 90 grados en el sentido contrario a las agujas
        //   del reloj.


        static void Main(string[] args)
        {
            List<int> pasos = new List<int>();
            int movimientos;


            Console.WriteLine("Bienvenido humano al control por pasos del Robot IO:");
            Console.WriteLine("¿Cuántos movimientos deseas que haga tu robot?:");
                         
            String mov = Console.ReadLine();

            while (!mov.All(char.IsDigit)){
                Console.WriteLine("¡Introduzca un valor correcto!");
                mov = Console.ReadLine();
            }

            movimientos = Int32.Parse(mov);
            
            for(int i = 0; i < movimientos; i++)
            {
                Console.WriteLine("Introduce el movimiento número: " + (i + 1));
                pasos.Add(Int32.Parse(Console.ReadLine()));
            }

            String resultado = Movimientos_Robot(pasos);
            Console.WriteLine(resultado);

            Console.WriteLine("Pulse cualquier tecla para salir.");
            Console.ReadKey();
        }

        static String Movimientos_Robot(List<int> movimientos)
        {
            int x = 0, y = 0;
            int pasoy = 0;
            int pasox = 1;

            for (int i = 0; i < movimientos.Count; i++)
            {
                if(i % 2 == 0)
                {
                    if(pasoy % 2 != 0)
                    {
                        y -= movimientos[i];
                    }
                    else
                    {
                        y += movimientos[i];
                    }    
                    pasoy++;
                }
                else
                {
                    if(pasox % 2 != 0)
                    {
                        //valor es negativo
                        if (movimientos[i] %2 < 0)
                        {
                            x += movimientos[i];
                        }
                        else
                        {
                            x -= movimientos[i];
                        }
                    }
                    else
                    {
                        if (movimientos[i] % 2 < 0)
                        {
                            x -= movimientos[i] * -1;
                        }
                        else
                        {
                            x += movimientos[i];
                        }
                    }
                    pasox++;
                }
            }

            String mensaje = "El valor de x es: " + x + ". El valor de y es: " + y;

            return mensaje;
        }
    }
}




