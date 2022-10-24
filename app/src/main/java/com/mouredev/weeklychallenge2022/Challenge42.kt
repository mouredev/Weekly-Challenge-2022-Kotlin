package com.mouredev.weeklychallenge2022

/*
 * Reto #42
 * CONVERSOR DE TEMPERATURA
 * Fecha publicación enunciado: 17/10/22
 * Fecha publicación resolución: 24/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit y viceversa.
 * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" y su unidad ("C" o "F").
 * - En caso contrario retornará un error.
 * - ¿Quieres emplear lo aprendido en este reto?
 *   Revisa el reto mensual y crea una App: https://retosdeprogramacion.com/mensuales2022
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

//Usando Javascript

let valor;
let resultado;  


function convertir (){
    valor = prompt('Ingresa un valor en °F o °C: ');
    const faren = /\d\°F$/gi
    const cent = /\d\°C$/gi
    const comprobacion = faren.test(valor);
    const comprobacion2 = cent.test(valor);
    if (comprobacion === true ){
        resultado = (parseInt(valor) - 32) / 1.8
        alert(resultado);
    } else if (comprobacion2 === true){
        resultado = parseInt(valor) * 1.8 + 32;
        alert(resultado);
    }else {
        alert ('Ingresa un valor aceptado')
    }
}

