/*
 * ¡Han anunciado un nuevo "The Legend of Zelda"!
 * Se llamará "Tears of the Kingdom" y se lanzará el 12 de mayo de 2023.
 * Pero, ¿recuerdas cuánto tiempo ha pasado entre los distintos
 * "The Legend of Zelda" de la historia?
 * Crea un programa que calcule cuántos años y días hay entre 2 juegos de Zelda
 * que tú selecciones.
 * - Debes buscar cada uno de los títulos y su día de lanzamiento
 *   (si no encuentras el día exacto puedes usar el mes, o incluso inventártelo)
 */

/**
 * Compara dos juegos en función de su nombre y año de lanzamiento.
 *
 * @param {{ name: string, releaseYear: string }} juego1 - Primer juego a comparar.
 * @param {{ name: string, releaseYear: string }} juego2 - Segundo juego a comparar.
 */
const lanzamientosLegendOfZelda = (juego1, juego2) => {
    const { name, releaseYear } = juego1;
    const { name: name2, releaseYear: releaseYear2 } = juego2;

    const fechaJuego1 = new Date(releaseYear);
    const fechaJuego2 = new Date(releaseYear2);

    let anios = fechaJuego2.getFullYear() - fechaJuego1.getFullYear() ;
    let meses = fechaJuego2.getMonth() - fechaJuego1.getMonth();
    let dias = fechaJuego2.getDate() - fechaJuego1.getDate();

    if ( dias < 0){
        meses--;
        const mesAnterior = new Date(fechaJuego2.getFullYear(), fechaJuego2.getMonth(), 0);
        dias += mesAnterior.getDate();
    }

    if (meses < 0) {
        anios--;
        meses += 12;
    }

    console.log( { anios, meses, dias } );
    

};

lanzamientosLegendOfZelda(
    {
        name: "The Legend of Zelda: Ocarina of Time",
        releaseYear: "12/11/1998",
    },
    {
        name: "Zelda: Majoras Mask",
        releaseYear: "11/17/2000",
    }
);
