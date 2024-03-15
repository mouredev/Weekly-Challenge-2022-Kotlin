using System;

class Reto31 {
    static void Main(String[] args){
        // Se pide al usuario introducir un numero, el cual se convierte a entero para poder llamar
        // al metodo que validara e imprimira los años Bisiestos.
        Console.WriteLine("Escribe un año para calcular los proximos 30 años bisiestos: ");
        int inputYear = Convert.ToInt32(Console.ReadLine());
        Bisiestos(inputYear);
    }

    /*public static void Bisiestos (int year){
        // Variable de control para mostrar los proximos 30 años bisiestos
        int n = 0;
        do{
            // Primer paso, si el año es exactamente divisible por 4 pasa al siguiente paso
            // de lo contrario no es Bisiesto
            if(year % 4 == 0){
                // Segundo paso, si el año es exactamente divisible por 100 pasa al siguiente paso
                // de lo contrario es Bisiesto
                if(year % 100 == 0){
                    // Tercer paso, si el año es exactamente divisible por 400 es Bisiesto.
                    if(year % 400 == 0){
                        Console.WriteLine((n+1) + ".- "+ year + " es un año Bisiesto");
                        n ++;
                    }                    
                }else{
                    Console.WriteLine((n+1) + ".- "+ year + " es un año Bisiesto");
                    n ++;
                }
            }
            year ++;
        // Si el año es Bisiesto se suma la variable de control, se aumenta en 1 el año para seguir validando
        // hasta conseguir los 30 años bisiestos.
        }while (n < 30);
    }*/

    public static void Bisiestos (int year){
        // Actualización reduciendo lineas
        int n = 0;
        while (n < 30){
            if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)){
                Console.WriteLine((n+1) + ".- "  + year + " es un año bisiesto");
                n ++;
            }
            year ++;
        }
    }
}