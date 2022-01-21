package com.mouredev.weeklychallenge2022

/*
 * Reto #3
 * ¿ES UN NÚMERO PRIMO?
 * Fecha publicación enunciado: 17/01/22
 * Fecha publicación resolución: 24/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 *
 * Está hecho en javascript, espero que se entienda quería participar de alguna manera y pues aquí está
 */



var primo = 1;

for (var i=2; i<=100; i++) {
    var dos = 0;
    var tres = 0;
    var cinco = 0;
    var siete = 0;
    dos = i % 2;
    tres = i % 3;
    cinco = i % 5;
    siete = i % 7;

    if (primo == 1 && i > 2 && dos == 0) primo = 0;
    if (primo == 1 && i > 3 && tres==0) primo = 0;
    if (primo == 1 && i > 5 && cinco==0) primo  = 0;
    if (primo == 1 && i > 7 && siete==0) primo = 0;

    if(primo == 1) console.log(i);

    primo = 1;
}
