package com.mouredev.weeklychallenge2022

/*
 * Reto #19
 * CONVERSOR TIEMPO
 * Fecha publicación enunciado: 09/05/22
 * Fecha publicación resolución: 16/05/22
 * Dificultad: FACIL
 *
 * Enunciado: Crea una función que reciba días, horas, minutos y segundos (como enteros) y retorne su resultado en milisegundos.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

/*
 * DISCLAIMER:
 * He usado el ejercicio como campo de pruebas para dejar fluir mis conocimientos de programación funcional.
 * En ella se aplican conceptos cómo la composición, funciones de primera clase y de orden superior,
 * funciones y expresiones puras (excepto main ;) ) y mónadas.
 * No pretende ser un how-to de como resolver el reto de forma funcional, es más un showroom de diferentes técnicas
 * y bastante over-engineering
 */

// region Maybe mini-library

sealed class Maybe<out T> {
    class Just<T>(val value: T) : Maybe<T>()
    object Nothing : Maybe<kotlin.Nothing>()
}

// Mete un valor dentro del contexto de un Maybe
fun <T> just(value: T): Maybe<T> = Maybe.Just(value)

// Esa función hace que Maybe sea un FUNCTOR
// Eleva una función al contexto de Maybe
// Sin usar, por ahora
// map :: (a -> b) -> m a -> m b
fun <P, R> Maybe<P>.map(f: (P) -> R): Maybe<R> = when (this) {
    is Maybe.Nothing -> this
    is Maybe.Just -> Maybe.Just(f(value))
}

// Esa función hace que Maybe sea una MÓNADA
// Habilita la posibilidad de encadenar funciones monádicas (entre otras cosas)
// flatMap :: m a -> (a -> m b) -> m b
fun <P, R> Maybe<P>.flatMap(f: (P) -> Maybe<R>) = when (this) {
    is Maybe.Nothing -> this
    is Maybe.Just -> f(value)
}

// Devuelve el valor que hay en Maybe, si no existe devuelve el valor fallback.
fun <T> fromMaybe(maybe: Maybe<T>, fallbackValue: T): T = when (maybe) {
    is Maybe.Nothing -> fallbackValue
    is Maybe.Just -> maybe.value
}

// Compone 2 funciones, en el sentido matemático de la palabra -> f(x)=z, g(y)=x => f.g => f(g(y))=z
infix fun <P1, R, P2> ((P1) -> Maybe<R>).composeMaybe(f: (P2) -> Maybe<P1>): (P2) -> Maybe<R> =
    { p1: P2 -> f(p1).flatMap { this(it) } }

// endregion

// Recibe un valor y un callback, si el valor es inferior a cero, devuelve Nothing, si no, pasa el
// valor al callback y lo envuelve en un Maybe.
fun applyIfPositive(number: Long, callback: (Long) -> Long): Maybe<Long> =
    if (number < 0) Maybe.Nothing
    else just(callback(number))

val secondsToMilliseconds: (Long) -> Maybe<Long> =
    { sec -> applyIfPositive(sec) { it * 1000 } }

val minutesToSeconds: (Long) -> Maybe<Long> =
    { min -> applyIfPositive(min) { it * 60 } }

val hoursToMinutes: (Long) -> Maybe<Long> = minutesToSeconds

val daysToHours: (Long) -> Maybe<Long> =
    { day -> applyIfPositive(day) { it * 24 } }

val minutesToMilliseconds = secondsToMilliseconds composeMaybe minutesToSeconds
val hoursToMilliseconds = minutesToMilliseconds composeMaybe hoursToMinutes
val daysToMilliseconds = hoursToMilliseconds composeMaybe daysToHours

val timeToMilliseconds: (Int, Int, Int, Int) -> Maybe<Long> = { days, hours, minutes, seconds ->
    just(days.toLong()).flatMap(daysToMilliseconds).flatMap { daysInMs ->
        just(hours.toLong()).flatMap(hoursToMilliseconds).flatMap { hoursInMs ->
            just(minutes.toLong()).flatMap(minutesToMilliseconds).flatMap { minutesInMs ->
                just(seconds.toLong()).flatMap(secondsToMilliseconds).flatMap { secondsInMs ->
                    just(daysInMs + hoursInMs + minutesInMs + secondsInMs)
                }
            }
        }
    }
}

fun main() {
    println(fromMaybe(timeToMilliseconds(345, 237, 89, 8273), 0))
    println(fromMaybe(timeToMilliseconds(5, -7, 34, 1), 0))
}
