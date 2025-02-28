/*
 * Crea una función que sea capaz de detectar si existe un viernes 13
 * en el mes y el año indicados.
 * - La función recibirá el mes y el año y retornará verdadero o falso.
 */

const viernes13 = (mes, año) => {
    // Crear una fecha con el día 13 del mes y año dados
    const fecha = new Date(año, mes - 1, 13); // mes - 1 porque en JavaScript los meses van de 0 a 11
    return fecha.getDay() === 5; // 5 representa el viernes
};

// Ejemplo de uso:
console.log(viernes13(10, 2024)); // false (octubre 2024 no tiene un viernes 13)
console.log(viernes13(9, 2024));  // true (septiembre 2024 tiene un viernes 13)
