/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 */
 
 List<int> numberList = new List<int>(){
    5, 8, 10, 4, 2, 45, 35, 11, 100, 25
};

// variables para ir almacenando los numeros evaluados
int largest = 0;
int secondLargest = 0;

// Bucle para evaluar los numeros del listado
foreach (var number in numberList){
    if(number > largest){
        secondLargest = largest;
        largest = number;
    }else if(number > secondLargest){
        secondLargest = number;
    }
}

Console.WriteLine("El segundo numero mayor es: {0}", secondLargest);