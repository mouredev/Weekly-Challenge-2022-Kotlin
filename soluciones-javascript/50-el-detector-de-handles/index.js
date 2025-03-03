/*
 * Crea una función que sea capaz de detectar y retornar todos los
 * handles de un texto usando solamente Expresiones Regulares.
 * Debes crear una expresión regular para cada caso:
 * - Handle usuario: Los que comienzan por "@"
 * - Handle hashtag: Los que comienzan por "#"
 * - Handle web: Los que comienzan por "www.", "http://", "https://"
 *   y finalizan con un dominio (.com, .es...)
 */

const elDetectorDeHandles = ( texto ) => {

    const handleUser = texto.match((/@\w+/g)) || [] ;
    const handleHashtag = texto.match((/#\w+/g)) || [];
    const handleWeb = texto.match(/https?:\/\/[\w\-\.]+\.\w{2,}|www\.[\w\-\.]+\.\w{2,}/) || [];

    return {
        handleUser,
        handleHashtag,
        handleWeb,
    }

}

const texto = "Hola @usuario, visita https://openai.com o www.ejemplo.com. #programacion #regex";
console.log(elDetectorDeHandles(texto));