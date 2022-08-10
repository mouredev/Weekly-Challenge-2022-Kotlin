package com.mouredev.weeklychallenge2022

/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */

<?php //Resolucion Reto 32 by @fedex6 (fGarciaDelRio) con una pequeña mejora para poder usar en otros casos.
function mostrarMayor($lista, $cual){
  rsort($lista); //Ordena Descendente
  array_unshift($lista, " "); //Las cosas que no hay que hacer... "numeros magicos" :P
  
  //Control 
  if( ($cual > count($lista)) || ($cual == 0) ){
    $respuesta = '[ error ] El numero solicitado esta fuera del rango: 1 al '.count($lista);
  } else {
    $respuesta = 'El '.$cual.'º mayor del listado es: '.$lista[$cual]; 
  }

  return $respuesta;
}

// Lista de Numeros
$listaNumeros = array(819, 884, 952, 959, 85, 998, 114, 611, 166, 43);
$listaRandom = array();
  for($i = 0; $i <= 100; $i++){
    array_push($listaRandom, rand());
  }


// Ahora si, a mostrarlos
echo 'Lista dada: '.mostrarMayor($listaNumeros, 2);
  echo '<br />';
echo 'Lista Random: '.mostrarMayor($listaRandom, 2);

/* Este comentario solo es para ese 1nut1l que dice que nos pagan por cantidad de lineas de codigo
*
* Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
* Ut porttitor leo a diam sollicitudin tempor id eu. 
* Turpis tincidunt id aliquet risus feugiat in ante metus dictum. 
* Non consectetur a erat nam at lectus urna duis convallis. 
* Scelerisque in dictum non consectetur a erat nam at. 
* Elementum pulvinar etiam non quam lacus suspendisse faucibus. 
* A diam maecenas sed enim ut. 
* Mattis nunc sed blandit libero volutpat sed. 
* Massa tempor nec feugiat nisl pretium fusce id velit. 
* Varius duis at consectetur lorem donec massa sapien. 
* Morbi quis commodo odio aenean sed adipiscing. 
* Egestas purus viverra accumsan in nisl nisi scelerisque eu.
*
*/
?>