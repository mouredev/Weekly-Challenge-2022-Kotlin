SubProceso calcular_fizzbuzz(num Por Referencia)
	Si num mod 3 = 0 y num mod 5 = 0 Entonces
		Mostrar num ", fizzbuzz"
	SiNo
		Si num mod 3 = 0 Entonces
			Mostrar num ", fizz"
		SiNo
			Si num mod 5 = 0 Entonces
				Mostrar num ", buzz"
			SiNo
				Mostrar num 
			FinSi
		FinSi
		
	Fin Si
FinSubProceso

SubProceso calcular_conteo()
	Para num=1 Hasta 100 Con Paso 1 Hacer
		calcular_fizzbuzz(num)
	Fin Para
FinSubProceso

Algoritmo reto_fizzbuzz
	//package com.mouredev.weeklychallenge2022
	
	//Reto #0
	//EL FAMOSO "FIZZ BUZZ"
	//Fecha publicación enunciado: 27/12/21
	//Fecha publicación resolución: 03/01/22
	//Dificultad: FÁCIL
	//Enunciado: Escribe un programa que muestre por consola (con un print)
	//los números de 1 a 100 (ambos incluidos y con un salto de línea entre
	//cada impresión), sustituyendo los siguientes:
	// - Múltiplos de 3 por la palabra "fizz".
	// - Múltiplos de 5 por la palabra "buzz".
	// - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
	//
	// Información adicional:
	// - Usa el canal de nuestro discord (https://mouredev.com/discord) "??reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
	// - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
	// - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
	// - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
	Definir num Como Entero
	
	num = 1
	
	calcular_conteo()
	
FinAlgoritmo
