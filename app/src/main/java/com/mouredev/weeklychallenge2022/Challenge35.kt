package com.mouredev.weeklychallenge2022

/*
 * Reto #35
 * BATALLA POKÉMON
 * Fecha publicación enunciado: 29/08/22
 * Fecha publicación resolución: 06/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
 * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
 * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
 * - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
 * - El programa recibe los siguientes parámetros:
 *  - Tipo del Pokémon atacante.
 *  - Tipo del Pokémon defensor.
 *  - Ataque: Entre 1 y 100.
 *  - Defensa: Entre 1 y 100.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

class Pokemon(val tipo: String, val ataque: Int, val defensa: Int)

fun main(){
  val pokemon1 = Pokemon("Planta", 100,100)
  val pokemon2 = Pokemon("Agua", 100,100)
  enfrentamiento(pokemon1.tipo, pokemon2.tipo,pokemon1.ataque,pokemon2.defensa)
}


fun enfrentamiento(tipo1:String,tipo2:String,ataque:Int,defensa:Int):Double{
  val efectividad = efectividad(tipo1,tipo2)
  val danno = 50 * (ataque/defensa) * efectividad
  println(danno)
  return danno
}

fun efectividad(tipo1:String, tipo2:String):Double{
  val efectividad = when(tipo1){
    "Agua"->{
      when(tipo2){
        "Agua"-> 0.5
        "Fuego"-> 2
        "Planta"->0.5
        else -> 1
      }
    }
    "Fuego"->{
      when(tipo2){
        "Electrico"-> 1
        "Planta"-> 2
        else -> 0.5
      }
    }
    "Planta"->{
      when(tipo2){
        "Agua"-> 2
        "Electrico"-> 1
        else -> 0.5
      }
     }
    "Electrico"->{
      when(tipo2){
        "Agua"-> 2
        "Fuego"-> 1
        else -> 0.5
      }
    }
    else -> 1.0
  }
  return efectividad.toDouble()
}