using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MiSolucionRetoSemanal21 {
    class Program {
        static void Main(string[] args) {
            // Mi solución reto semanal
            Console.WriteLine("Inicio");
            Console.WriteLine("Lectura del archivo...");
            try {
                // Lectura del archivo
                string[] contenidoArchivo = System.IO.File.ReadAllLines("Challenge21.txt");
                // Validar contenido del archivo
                if (!ValidarArchivo(contenidoArchivo, out string mensaje)) {
                    Console.WriteLine(mensaje);
                } else {
                    // Realizar las operaciones con el resultado del archivo
                    decimal resultado = 0;
                    for (int i = 0; i <= contenidoArchivo.Length - 1; i++) {
                        bool conversion = false;
                        if (i % 2 == 0) { // Linea corresponde a un número
                            conversion = decimal.TryParse(contenidoArchivo[i], out decimal numero);
                            if (i == 0) resultado = numero;
                            if (i > 1) {
                                resultado = Operacion(resultado, numero, contenidoArchivo[i - 1]);
                            }
                        }
                    }
                    Console.WriteLine("Archivo correcto.");
                    Console.WriteLine("Resultado: " + resultado);
                }
                Console.WriteLine("Fin!");
            } catch(Exception ex) {
                Console.WriteLine(ex.ToString());
            }
            Console.ReadKey();
        }

        /// <summary>
        /// Valida el contenido de string[], corresponde a todas las líneas de un archivo txt.
        /// </summary>
        /// <param name="contenidoArchivo"></param>
        /// <param name="mensaje">Resultado de la validación</param>
        /// <returns></returns>
        private static bool ValidarArchivo(string[] contenidoArchivo, out string mensaje) {
            string operadores = "+-*/";
            for (int i = 0; i <= contenidoArchivo.Length - 1; i++) {
                if (i % 2 == 0) {//Linea debe contener un numero
                    if (!decimal.TryParse(contenidoArchivo[i], out decimal primerNumero)) {
                        mensaje = "El contenido del archivo es incorrecto (debe ser un número). Línea " + (i + 1);
                        return false;
                    }
                } else { //Linea debe contener un operador
                    if (!operadores.Contains(contenidoArchivo[i])) {
                        mensaje = "El contenido del archivo es incorrecto (debe ser un operador). Línea " + (i + 1);
                        return false;
                    }
                }
            }
            mensaje = "Archivo correcto";
            return true;
        }

        /// <summary>
        /// Realiza la operacion indicada por operador sobre los dos números
        /// </summary>
        /// <param name="numero1"></param>
        /// <param name="numero2"></param>
        /// <param name="operador"></param>
        /// <returns></returns>
        private static decimal Operacion(decimal numero1, decimal numero2, string operador) {
            switch (operador) {
                case "+": return numero1 + numero2;
                case "-": return numero1 - numero2;
                case "*": return numero1 * numero2;
                case "/": return numero1 / numero2;
            }
            return 0;
        }
    }
}
