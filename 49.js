/*
 * Enunciado: Crea una función que sea capaz de detectar y retornar todos los
 * handles de un texto usando solamente Expresiones Regulares.
 * Debes crear una expresión regular para cada caso:
 * - Handle usuario: Los que comienzan por "@"
 * - Handle hashtag: Los que comienzan por "#"
 * - Handle web: Los que comienzan por "www.", "http://", "https://" 
 *   y finalizan con un dominio (.com, .es...)
 */
const l = (x) => {
    console.log(x);
}

const rx = (t, r) => {
    return t.split(' ').filter((e => (new RegExp(r).test(e))));
}


const ejercicio = (t)=>{
    let m = {
        "user":  /^\@.*/,
        "hashtag": /^\#.*/,
        "web":  /^(www\.|http:\/\/|https:\/\/).*\.[a-z]{2,4}$/
    }
    
    return Object.fromEntries(
        Object.entries(m)
        .map(([ key, val ]) => 
            [ key, rx(t,val)]
        )
      );
}


l(ejercicio("https://x.info www.exe.x est@ texto tiene @s y #a #b c# http://exe.es"))
l(ejercicio("Atentos con el calendario de @aDEViento. Más info en: https://adviento.dev"))
l(ejercicio("#retos_de_programacion con @MoureDev. Todos los retos disponibles en https://retosdeprogramacion.com"))
l(ejercicio("Aquí no hay nada extraño"))
