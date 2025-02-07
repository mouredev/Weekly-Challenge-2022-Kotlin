/*
 * Crea una función que reciba días, horas, minutos y segundos (como enteros)
 * y retorne su resultado en milisegundos.
 */

const conversorTiempo = (dias, horas, minutos, segundos) => {

    if ( 
        typeof dias !== "number" || dias < 0 ||
        typeof horas !== "number" || dias < 0 ||
        typeof minutos !== "number" || dias < 0||
        typeof segundos !== "number" || dias < 0
    )
        throw new Error("Los datos deben ser númericos y mayor o igual a cero");

    const diasASegundos = (((dias * 24) * 60) * 60);
    const horasASegundos = ((horas * 60) * 60);
    const minutosASegundos = ((minutos * 60));

    return ( (diasASegundos + horasASegundos + minutosASegundos) * 1000 );

}

console.log(conversorTiempo(1,1,1,1));