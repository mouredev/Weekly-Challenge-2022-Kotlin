/*
 * Reto #49
 * EL DETECTOR DE HANDLES
 * Fecha publicación enunciado: 05/11/22
 * Fecha publicación resolución: 12/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de detectar y retornar todos los handles de un texto usando solamente Expresiones Regulares.
 * Debes crear una expresión regular para cada caso:
 * - Handle usuario: Los que comienzan por "@"
 * - Handle hashtag: Los que comienzan por "#"
 * - Handle web: Los que comienzan por "www.", "http://", "https://" y finalizan con un dominio (.com, .es...)
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

/**
 * Constantes con las expresiones regulares necesarias para detectar los handles
 * @type {RegExp}
 * Regex.regexUser: Detecta los handles de usuario (@)
 *  Busca un @ seguido de una o más letras o números
 * Regex.regexHashtag: Detecta los handles de hashtag (#)
 *  Busca un # seguido de una o más letras o números
 * Regex.regexWeb: Detecta los handles de web (www., http://, https://)
 * Esta expresión está formada por cuatro patrones distintos que se unen con un OR (|)
 *  -El primero busca direcciones URL que comiencen con "https" o "http" seguidas de nombre de subdominio opcional y el dominio que puede contener letras, números y guiones y acabe con un . con 2 o mas caracteres
 *  -El segundo busca direcciones URL que comiencen con "https" o "http" seguidas de nombre de dominio que puede contener letras, números y guiones y acabe con un . con 2 o mas caracteres
 *  -El tercero busca direcciones URL que comiencen con "www."  seguidas de un nombre de dominio que puede contener letras, números y guiones, y termina con un punto seguido de una extensión de dominio de al menos dos caracteres.
 *
 */
 const Handlers = {
    user: /@([a-zA-Z0-9_-]+)/g,
    hashTag: /#([a-zA-Z0-9_-]+)/g,
    web : /(https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.\S{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]+\.\S{2,}|www\.[a-zA-Z0-9]+\.\S{2,})/g
}

/**
 * Función que comprueba si un texto cumple con una expresión regular
 * @param text Texto a comprobar
 * @param regex Expresión regular a comprobar
 * @returns Array con los resultados coincidentes de la expresión regular
 */
function checkRegex(text: string,regex:RegExp): string[]  {
    let handles: string[] = []
    let matchUser = text.match(regex);

    matchUser?.forEach(match => {
        handles.push(match);
    })

    return handles;

}

/**
 * Función que detecta los handles de un texto y los devuelve en un array
 * @param text Texto a comprobar los handles
 * @returns Array con los handles detectados (usuario, hashtag, web)
 */
export function handleDetector(text:string):string[]{
    let handles:string[] = [];
    handles.push(...checkRegex(text,Handlers.user));
    handles.push(...checkRegex(text,Handlers.hashTag));
    handles.push(...checkRegex(text,Handlers.web));
    return handles;
}


/**
 * Función que detecta los handles (usuario, hashtag, web) de un texto y los imprime por pantalla
 * @param text Texto a comprobar los handles
 */
function printHandlers(text:string): void {
    handleDetector(text).forEach(handle => {
        console.log(handle);
    })

}

printHandlers("Acabo de encontrar el mejor café de la ciudad gracias a la recomendación de @cafes. ¡Definitivamente lo voy a probar y compartir en mis redes con el hashtag #elmejorCafe! www.elmejorcafe.es")
printHandlers("Retos de programacion : (https://mouredev.com/discord) #reto-semanal #reto49 #MoureDev @malopezrom @mouredev https://mouredev.com .moure.es https://retosdeprogramacion.com/semanales2022 #retosdeprogramacion")
printHandlers("Hola a todos! Hoy es un día hermoso y estoy muy emocionada. #feliz #sol #playa.Estoy disfrutando de un día de descanso en la playa con mis amigos @paula @juan @maria.No puedo esperar para compartir fotos en mis redes sociales con todos ustedes. #friends #beachday #relax");
