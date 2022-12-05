/*
 * Reto #48
 * EL CALENDARIO DE ADEVIENTO 2022
 * Fecha publicación enunciado: 28/11/22
 * Fecha publicación resolución: 05/12/22
 * Dificultad: FÁCIL
 *
 * ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
 * 24 días, 24 regalos sorpresa relacionados con desarrollo de software, ciencia y tecnología desde el 1 de diciembre.
 *
 * Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne lo siguiente:
 * - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el regalo de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
 * - Si la fecha es anterior: Cuánto queda para que comience el calendario.
 * - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
 *
 * Notas:
 * - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00 y finaliza a las 23:59:59.
 * - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos y segundos.
 * - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo del calendario de aDEViento hasta el día de su corrección (sorteo exclusivo para quien entregue su solución).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

/**
 * Tipo de datos que contiene los regalos de cada dia , cuando empieza y termina el Calendario de Adeviento
 */
const adevientoCalendar = {
    adevientoStartDay :  new Date("2022-12-01T00:00:00"),
    adevientoEndDay : new Date("2022-12-24T23:59:59"),
    gifts : ["🍰","🤶","🎁","🧁","🍫","🍭","🍬","🍪","🎄","🍡","🍿","🍩","🍦","🍧","🍨","🍮","🍭","🍬","🍿","🍩","🍦","🍧","🍨","🍮"]
}

/**
 * Función que devuelve el regalo del día a partir de una fecha dada si la fecha esta dentro del calendario de aDEViento
 * Si no esta dentro del calendario de aDEViento devuelve un mensaje con los dias que se han pasado desde que finalizo el calendario o los que faltan
 * @param date Fecha que se quiere comprobar
 * @returns Regalo del día o mensaje con los dias que faltan o que se han pasado
 */

function aDEVientocalendar(date:Date):string{

    if(date < adevientoCalendar.adevientoStartDay){
        return `Faltan ${dateDiff(date,adevientoCalendar.adevientoStartDay)} para que comience el calendario de aDEViento ${adevientoCalendar.adevientoStartDay.getFullYear()}`
    }
    else if(date > adevientoCalendar.adevientoEndDay) {
        return `Han pasado ${dateDiff(date,adevientoCalendar.adevientoEndDay)} desde que finalizó el calendario de aDEViento ${adevientoCalendar.adevientoStartDay.getFullYear()}`;
    }
    else {
        return `El regalo del dia ${date.toLocaleDateString()} es ${getGift(date)}.${nextGift(date)}`
    }
}

/**
 * Funcion que calcula el siguiente sorteo del calendario de aDEViento.
 * @param date Fecha que se quiere comprobar
 *
 */
function nextGift(date:Date):string{
    let nextDate = new Date(date.getFullYear(),date.getMonth(),date.getDate()+1,0,0,0);

    if(nextDate<=adevientoCalendar.adevientoEndDay) {
        return `El siguiente sorteo será en ${dateDiff(nextDate,date)}`
    }
    else {
        return `Hoy es el ultimo día del calendario de ADEViento ${adevientoCalendar.adevientoStartDay.getFullYear()}`;
    }
}

/**
 * Funcion que devuelve la diferencia en dias ,horas ,minutos y segundos de dos fechas dadas.
 * @param date1 Fecha 1 que se quiere comprobar
 * @param date2 Fecha 2 que se quiere comprobar
 * @returns Diferencia en dias ,horas ,minutos y segundos de dos fechas dadas.
 */
function dateDiff(date1:Date,date2:Date) : string {

    const  diff = Math.abs(date1.getTime() - date2.getTime())/1000
    let days =  Math.floor(diff / ( 24 * 60 * 60))
    let hours = Math.floor((diff - (days * 24 * 60 * 60)) / (60 * 60))
    let minutes = Math.floor((diff - (days * 24 * 60 * 60) - (hours * 60 * 60)) / 60)
    let seconds = Math.floor(diff - (days * 24 * 60 * 60) - (hours * 60 * 60) - (minutes * 60))


    if(days>0){
          return `${days} días, ${hours} horas, ${minutes} minutos y ${seconds} segundos`
    }else if(hours>0){
        return `${hours} horas, ${minutes} minutos y ${seconds} segundos`
    }else if(minutes>0){
        return `${minutes} minutos y ${seconds} segundos`
    }else{
        return `${seconds} segundos`
    }


}

/**
 * Funcion que devuelve los dias de diferencia entre dos fechas
 * @param date1 Fecha 1 que se quiere comprobar
 * @param date2 Fecha 2 que se quiere comprobar
 * @returns Diferencia de dias entre las dos fechas dadas.Si la primera es mayor devuelve un numero positivo, si es menor devuelve un numero negativo
 */
export function daysLeft(date1: Date, date2: Date): number {
    return (Math.floor((date1.getTime()-date2.getTime())/(1000*60*60*24)))
}

/**
 * Funcion que devuelve el regalo del dia a partir de una fecha dada
 * @param date Fecha que se quiere comprobar
 * @return Regalo del dia si esta dentro de la fecha del calendario de aDEViento
 */
export function getGift(date:Date):string{
    let gift = daysLeft(date,adevientoCalendar.adevientoStartDay)
    if(gift>=0 && gift<adevientoCalendar.gifts.length){
        return adevientoCalendar.gifts[gift]
    }
    else{
        return "⌚"
    }
}

console.log(aDEVientocalendar(new Date("2022-11-26T09:30:10")));
console.log(aDEVientocalendar(new Date("2022-12-26T09:30:10")));
console.log(aDEVientocalendar(new Date("2022-12-23T09:30:10")));
console.log(aDEVientocalendar(new Date("2022-12-13T23:30:10")));
console.log(aDEVientocalendar(new Date("2022-12-01T00:00:00")));
console.log(aDEVientocalendar(new Date()));
