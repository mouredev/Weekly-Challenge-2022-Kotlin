<?php

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

function numerosPerdidos(array $input) {
	if (empty($input)) {
		throw new Exception('Proporcione un array con valores');
	}
	
	$enteros = array_filter($input, function ($valor) {
		return is_int($valor);
	});
	
	if ($enteros !== $input) {
		throw new Exception('Proporcione un array de valores enteros');
	}
	
	$enteros = array_unique($enteros);
	if ($enteros !== $input) {
		throw new Exception('Proporcione un array de valores enteros sin repetidos');
	}
	
	asort($enteros);
	if ($enteros !== $input) {
		throw new Exception('Proporcione un array de valores enteros ordenados');
	}
	
	$max = max($input);
	$min = min($input);

	$todos = range($min, $max);
	
	$result = array_diff($todos, $input);
	
	return $result;
	
}

$input1 = [];
$input2 = [1,2,3, 'texto'];
$input3 = ['1', 3, 5, 3];
$input4 = [1, 2, 3, 4, 4];
$input5 = [1, 2, 4, 3, 5];
$input6 = [1, 2, 3, 4, 5];
$input7 = [3, 5, 7, 9, 11];

try {
	// print_r(numerosPerdidos($input1)); // output: Excepción capturada: Proporcione un array con valores
	// print_r(numerosPerdidos($input2)); // output: Excepción capturada: Proporcione un array de valores enteros
	// print_r(numerosPerdidos($input3)); // output: Excepción capturada: Proporcione un array de valores enteros
	// print_r(numerosPerdidos($input4)); // output: Excepción capturada: Proporcione un array de valores enteros sin repetidos
	// print_r(numerosPerdidos($input5)); // output: Excepción capturada: Proporcione un array de valores enteros ordenados
	// print_r(numerosPerdidos($input6)); // output: array(0) {}
	print_r(numerosPerdidos($input7)); // output: [4, 6, 8, 10]
    
} catch (Exception $e) {
    echo 'Excepción capturada: ',  $e->getMessage(), "\n";
}