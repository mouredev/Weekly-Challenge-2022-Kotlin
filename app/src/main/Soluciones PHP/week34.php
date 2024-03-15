/*
* Reto #34
* LOS NÚMEROS PERDIDOS
* Fecha publicación enunciado: 22/08/22
* Fecha publicación resolución: 29/08/22
* Dificultad: FÁCIL
*
* Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
* y retorne todos los que faltan entre el mayor y el menor.
* - Lanza un error si el array de entrada no es correcto.
*
* Información adicional:
* - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
*   para preguntas, dudas o prestar ayuda a la comunidad.
* - Tienes toda la información sobre los retos semanales en
*   https://retosdeprogramacion.com/semanales2022.
*
*/

<?php
printMissingNumbers([1,4,6]);
printMissingNumbers([1,4,3,6]);
printMissingNumbers([1,4,4,6]);
printMissingNumbers([]);
printMissingNumbers([1,4,5,7,9,12]);


function printMissingNumbers($array){
    if(checkArray($array)) {
        $max = $array[count($array) - 1];
        $min = $array[0];
        $respuesta = 'Lista de numeros que faltan entre el mayor y el menor:';
        for($i = $max; $i > $min; $i--){
            if (!in_array($i,$array)){
                $respuesta .= ' '.$i.' -';
            }
        }
        echo trim($respuesta,'-').PHP_EOL;
    }else{
        echo 'Error: array no válido'.PHP_EOL;
    }
}


function checkArray($array){
    if(count($array) == 0){
        return false;
    }
    $anterior = null;
    foreach ($array as $key=>$value){
        if($key > 0){
            if($value<=$anterior){
                return false;
            }
        }
        $anterior = $value;
    }
    return true;
}