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