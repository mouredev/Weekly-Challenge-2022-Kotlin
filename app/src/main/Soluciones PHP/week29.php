/*
 * Reto #29
 * ORDENA LA LISTA
 * Fecha publicación enunciado: 18/07/22
 * Fecha publicación resolución: 26/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que ordene y retorne una matriz de números.
 * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
 *   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

<?php

//Para las pruebas el conjunto donde tomará valores los elementos del array será [0,tamaño del array*10]

print_r(orderArray(generateRandomArray(5),'Asc'));
//print_r(orderArray(generateRandomArray(20),'Desc'));
//print_r(orderArray(generateRandomArray(100),'Asc'));
//print_r(orderArray(generateRandomArray(1000),'Asc'));
//print_r(orderArray(generateRandomArray(10000),'Desc'));

//Algoritmo de ordenación QuickSort

function orderArray($array,$order){

    if(count($array) <= 1 ){
        return $array;
    }

    $pivot = array_shift($array);
    $minorsArray = [];
    $highersArray =[];

    foreach($array as $value){
        if($value < $pivot){
            $minorsArray[] = $value;
        } else{
            $highersArray[] = $value;
        }
    }

    if($order == 'Asc'){
        $orderedArray = array_merge(orderArray($minorsArray,$order),[$pivot],orderArray($highersArray,$order));
    }else{
        $orderedArray = array_merge(orderArray($highersArray,$order),[$pivot],orderArray($minorsArray,$order));
    }

    return $orderedArray;
}

function generateRandomArray($sizeArray){
    $valuesSet = range(0, 10*$sizeArray);
    shuffle($valuesSet);
    return array_slice($valuesSet,0,$sizeArray);
}



