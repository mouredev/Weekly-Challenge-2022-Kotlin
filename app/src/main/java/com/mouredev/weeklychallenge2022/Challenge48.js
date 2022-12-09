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

function adventCalendar(date){
    // inicio y fin del calendario de adviento
    let startDate = new Date(2022, 11, 01);
    let endDate = new Date(2022, 11, 24, 23, 59, 59);

    if(date >= startDate && date <= endDate) return "🎁";

    const dateFormat = (time) => {
        let seconds = Math.floor(time / 1000),
            minutes = Math.floor(seconds / 60),
            hours = Math.floor(minutes / 60),
            days = Math.floor(hours / 24),
            years = Math.floor(days / 365);
        const pad = (n) => {return (n > 9)? n : '0' + n};
        seconds %= 60;
        minutes %= 60;
        hours %= 24;
        days = ((hours / 24) < 365)? Math.floor(hours / 24) : Math.floor(hours / 24) % 365;
        return `${years} años, ${days} días y ` + [pad(hours), pad(minutes), pad(seconds)].join(":");
    }

    let difTime;
    if(date < startDate){
        difTime = Math.abs(date.getTime() - startDate.getTime());
        return `Aún faltan: ` + dateFormat(difTime);
    }
    else if(date > endDate){
        difTime = Math.abs(date.getTime() - endDate.getTime());
        return `Han pasado: ` + dateFormat(difTime);
    }
}

// los meses en JavaScript empiezan en 0, por eso el 11 es diciembre
console.log(adventCalendar(new Date(2022, 11, 01))); // 🎁
console.log(adventCalendar(new Date(2022, 11, 24, 23, 59, 59))); // 🎁
console.log(adventCalendar(new Date())) // Aún faltan: 0 años, 0 meses, 1 dias y 11:50:07
console.log(adventCalendar(new Date(2023, 11, 25))) // Han pasado: 0 años, 1 meses, 1 días y 00:00:00