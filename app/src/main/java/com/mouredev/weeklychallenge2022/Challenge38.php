<?php

declare(strict_types=1);

/*
 * Reto #38
 * BINARIO A DECIMAL
 * Fecha publicación enunciado: 19/09/22
 * Fecha publicación resolución: 27/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

$binary     = (string) ($argv[1] ?? 10111); // 23
$decimal    = convertBinaryToDecimal($binary);

echo "The decimal of \"{$binary}\" is: {$decimal}." . PHP_EOL;

function convertBinaryToDecimal(string $binary): int {

    $binary = str_split($binary);
    $binary = array_reverse($binary);

    array_walk($binary, function (string &$number, int $index) {
        $number = $number * 2 ** $index;
    });

    $decimal = (int) array_sum($binary);

    return $decimal;

}
