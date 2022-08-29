<?php

/**
 * @throws Exception
 */
function numerosPerdidos($array): array
{
    if (empty($array)) {
        return $array;
    }
    if (!isNumericArray($array)) {
        throw new Exception("El array no es válido");
    }

    $arrayRango = range(min($array), max($array));

    return array_diff($arrayRango, $array);
}


function isNumericArray($array): bool
{
    foreach ($array as $num) {
        if (!is_numeric($num)) {
            return false;
        }
    }
    return true;
}
