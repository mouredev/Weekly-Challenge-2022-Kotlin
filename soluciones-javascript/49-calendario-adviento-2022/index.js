/*
 * ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
 * 24 días, 24 regalos sorpresa relacionados con desarrollo de software,
 * ciencia y tecnología desde el 1 de diciembre.
 *
 * Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne
 * lo siguiente:
 * - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el regalo
 *   de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
 * - Si la fecha es anterior: Cuánto queda para que comience el calendario.
 * - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
 *
 * Notas:
 * - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00
 *   y finaliza a las 23:59:59.
 * - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos
 *   y segundos.
 */

const regalos = [
    "📚 Guía rápida de Git y GitHub",
    "💻 Snippet de código para autenticación JWT en Node.js",
    "⌨️ Atajo de teclado para VS Code que te cambiará la vida",
    "🎨 Mini curso de Flexbox y CSS Grid en 30 minutos",
    "🔍 Cheat sheet de expresiones regulares (regex)",
    "🖼️ Plantilla HTML + Tailwind para un portfolio web",
    "🧼 Consejo sobre Clean Code: Nombra mejor tus variables",
    "🐍 Script en Python para automatizar tareas repetitivas",
    "🗃️ Truco para optimizar consultas en bases de datos SQL",
    "🖱️ Atajo en la terminal para agilizar tu flujo de trabajo",
    "🌐 Snippet de código para consumir APIs REST con Fetch",
    "🛠️ Herramienta para generar datos ficticios para pruebas",
    "🧩 Extensión de VS Code imprescindible para desarrolladores",
    "⚛️ Cómo mejorar el rendimiento de tu app React",
    "🎧 Lista de podcasts de tecnología y programación",
    "🐳 Introducción a Docker con un ejemplo práctico",
    "🔐 Explicación sencilla de OAuth y por qué deberías usarlo",
    "📖 Top 5 libros recomendados sobre desarrollo web",
    "🚀 Snippet para crear un servidor Express en 2 minutos",
    "📝 Curso gratuito de JavaScript avanzado",
    "🎨 Atajos de Figma para diseñadores y devs",
    "🛡️ Plugin de Chrome para mejorar tu productividad",
    "🤝 Guía para contribuir a proyectos Open Source",
    "📄 Template para tu README en GitHub"
];

/**
 *
 * @param {Date} date
 */
const calendarioAdviento2022 = ( date ) => {

    const fechaInicio = new Date(2022, 11, 1, 0, 0, 0).getTime();
    const fechaFin = new Date(2022, 11, 24, 23, 59, 59).getTime();
    const dateInputInMiliseconds = date.getTime();


    if( dateInputInMiliseconds >= fechaInicio && dateInputInMiliseconds <= fechaFin ){
        const dia = date.getDate();
        const diaFinal = new Date(2022, 11, dia, 23, 59, 59).getTime();
        const diferencia = diaFinal - dateInputInMiliseconds;
        const horasRestantes = Math.floor( diferencia / (1000 * 60 * 60 ));
        const minutosRestantes = Math.floor( diferencia / (1000 * 60 )) / ( 1000 * 60 );

        return `Regalo del día ${dia}: ${regalos[dia - 1]}. Quedan ${horasRestantes} horas y ${minutosRestantes} minutos para que termine el sorteo de hoy.`;

    }

    if (dateInputInMiliseconds < fechaInicio) {
        const diferenciaInicio = fechaInicio - dateInputInMiliseconds;  // Diferencia en milisegundos entre ahora y el inicio del calendario
        const diasRestantes = Math.ceil(diferenciaInicio / (1000 * 60 * 60 * 24));  // Convertir la diferencia a días

        return `El calendario aún no ha comenzado. Faltan ${diasRestantes} días para el 1 de diciembre.`;
    }

    if (dateInputInMiliseconds > fechaFin) {
        const diferenciaFinal = dateInputInMiliseconds - fechaFin;  // Diferencia en milisegundos entre ahora y el fin del calendario
        const diasPasados = Math.floor(diferenciaFinal / (1000 * 60 * 60 * 24));  // Convertir la diferencia a días

        return `El calendario ya ha finalizado. Han pasado ${diasPasados} días desde el 24 de diciembre.`;
    }

}

console.log(calendarioAdviento2022(new Date(2022, 11, 14, 12, 6, 12))); // Prueba con una fecha en diciembre
console.log(calendarioAdviento2022(new Date(2022, 10, 30))); // Prueba con una fecha antes del 1 de diciembre
console.log(calendarioAdviento2022(new Date(2022, 11, 25))); // Prueba con una fecha después del 24 de diciembre