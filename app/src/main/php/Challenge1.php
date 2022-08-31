<?php
/*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function esEnagrama(string $palabra1, string $palabra2){

  $palabra1 = strtolower(str_replace(" ","",$palabra1));
  $palabra2 = strtolower(str_replace(" ","",$palabra2));

  if(strlen($palabra1) != strlen($palabra2)) die("Las 2 palabras deben tener la misma logintud de caracteres");

  return str_contains($palabra1,str_shuffle($palabra2));
}

if(esEnagrama("Amor","rOmA")) print "No es anagrama";
else print "Es anagrama";