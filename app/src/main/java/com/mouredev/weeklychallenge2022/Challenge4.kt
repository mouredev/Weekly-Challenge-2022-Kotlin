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
 abstract class Figura(val nombre: String) {
   
   abstract fun area(): Double
   fun imprimir(){
       println("El ${nombre} tiene un área de ${"%.2f".format(area())}")
   }
}
class Cuadrado(nombre: String, val lado: Double): Figura(nombre) {
    override fun area() = lado * lado
}
class Triangulo(nombre: String, val base: Double, val altura: Double): Figura (nombre){
    override fun area() = base* altura /2
}

class Circulo(nombre: String, val radio: Double): Figura(nombre) {
   override fun area() = Math.PI * Math.pow(radio, 2.0)      
}


fun main() {
   
   val cuadrado = Cuadrado("Cuadrado", 3.5)
   cuadrado.imprimir() // El Cuadrado tiene un área de 12.25
   
    
   val triangulo = Triangulo("Triángulo", 3.0, 6.0)
   triangulo.imprimir()
    
   val circulo = Circulo("Círculo", 4.0)   
   circulo.imprimir() // El Círculo tiene un área de 50.27
}

