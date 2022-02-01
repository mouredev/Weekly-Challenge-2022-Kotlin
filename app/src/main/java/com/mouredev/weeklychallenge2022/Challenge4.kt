package com.mouredev.weeklychallenge2022

/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

 	fun main() {

		val poligono1 = Poligono.Triangulo
		val poligono2 = Poligono.Rectangulo
		val poligono3 = Poligono.Cuadrado

		println("El área del ${poligono1.name} es ${areaPoligono(poligono1)}")
		println("El área del ${poligono2.name} es ${areaPoligono(poligono2)}")
		println("El área del ${poligono3.name} es ${areaPoligono(poligono3)}")

 	}

// Clase para crear el tipo de objeto Poligono con una base y altura determinadas

	enum class Poligono (val base: Int, val altura: Int) {
		Triangulo(base = 3, altura = 6),
		Cuadrado(base = 4, altura = 4),
		Rectangulo(base = 5,altura = 8);

// Creamos una función interna para retornar area del poligono asignado
		fun area(): Int {
			return when (this) {
				Triangulo -> (this.base * this.altura)/2
				Cuadrado -> this.base * this.altura
				Rectangulo -> this.base + this.altura
			}
		}
	}

// Función solicitada que devuelve el área del poligono
	fun areaPoligono (figura: Poligono): Int{
		return figura.area()
	}


