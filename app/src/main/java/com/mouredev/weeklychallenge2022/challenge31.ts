/*
 * Reto #31
 * AÑOS BISIESTOS
 * Fecha publicación enunciado: 01/08/22
 * Fecha publicación resolución: 08/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que imprima los 30 próximos años bisiestos siguientes a uno dado.
 * - Utiliza el menor número de líneas para resolver el ejercicio.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

/**
 * Funcion que imprime los N proximos años bisiestos
 * @param year año inicial
 * @param n numero de años a imprimir
 * @returns array con los años bisiestos
 */
function leapYears(year:number,n:number):number[]{
    var currentYear = year;
    var leapYears = [];
    while(leapYears.length<n){
        if(isLeapYear(currentYear)) leapYears.push(currentYear);
        currentYear++;
    }
    return leapYears;
}

/**
 * Funcion que determina si un año es bisiesto
 * Año bisiesto es el divisible entre 4, salvo que sea año secular -último de cada siglo, terminado en «00»-, en cuyo caso también ha de ser divisible entre 400.
 * @param year año a comprobar
 * @returns true si es bisiesto, false si no
 */
function isLeapYear(year:number){
    return (year%4==0 && year%100!=0 || year%400==0)
}


console.log(leapYears(2022,5));