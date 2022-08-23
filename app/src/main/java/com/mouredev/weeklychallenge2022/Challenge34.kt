package com.mouredev.weeklychallenge2022

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

function generateMissingNumbers($values) {
    $ret = [];
    $max = max($values);
    $min = min($values);
    
    $firstPos = 0;
    
    for ($i = $min; $i <= $max; $i++) {
        if (!in_array($i, $values)) {
            $ret[] = $i;
        }
        elseif (count($values) > ($firstPos + 1)) {
            $preValue = $values[$firstPos];
            $firstPos++;
            if ($preValue >= $values[$firstPos]) {
                throw new \Exception('El arreglo no está ordenado o tiene elementos repetidos');
            }
        }
    }
    
    return $ret;
}

$arrayTests = [
    [1,2,5,8,10],
    [-3,-2,0,4,7],
    [-20,-10,0,15,25],
    [1,2,4,5,7,7],
    [0,0,1,2,3],
    [-1, 0,2,4,6,8,10,10],
    [9,8,7,6,5],
    [1,2,3,4,5,6,5],
];

foreach ($arrayTests as $array) {
    try {
        echo "Arreglo original: " . json_encode($array) . ", sus faltantes: " . json_encode(generateMissingNumbers($array)) . "\n";        
    }
    catch(\Exception $ex) {
        echo "Error en el array " . json_encode($array, true);
        echo " ==> {$ex->getMessage()}\n";
    }
}

