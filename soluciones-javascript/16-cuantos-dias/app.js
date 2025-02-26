/*
 * Crea una función que calcule y retorne cuántos días hay entre dos cadenas
 * de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se
 *   lanzará una excepción.
 */

/**
 *
 * @param {String} fecha1 : 'dd/mm/yyyy'
 * @param {String} fecha2 : 'dd/mm/yyyy'
 */
const cuantosDias = (fecha1, fecha2) => {
    const regexFecha = /^\d{2}\/\d{2}\/\d{4}$/;
    if (!regexFecha.test(fecha1) || !regexFecha.test(fecha2))
        throw new Error("El formato de fechas es erróneo");

    const fechaFormatted1 = new Date(fecha1).getTime();
    const fechaFormatted2 = new Date(fecha2).getTime();

    const diferenciaDeDias =
        fechaFormatted1 > fechaFormatted2
            ? fechaFormatted1 - fechaFormatted2
            : fechaFormatted2 - fechaFormatted1;
    const diferenciaDeDiasFormateado = diferenciaDeDias / (1000 * 60 * 60 * 24);

    return diferenciaDeDiasFormateado;
};

console.log(cuantosDias("04/16/2006", "12/05/2006")); // Esperado: 233
console.log(cuantosDias("12/05/2006", "04/16/2006")); // Esperado: 233
console.log(cuantosDias("01/01/2023", "12/31/2023")); // Esperado: 364
console.log(cuantosDias("01/01/2024", "01/01/2024")); // Esperado: 0
console.log(cuantosDias("12/05/2006", "04162006"));
