-- package com.mouredev.weeklychallenge2022

{-
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 -}
 
module Challenge32 where

import Data.List

lista :: [Integer]
lista = [1,4,5,3,2,10,8,9,7,6]

segundoMayor :: [Integer] -> Integer
segundoMayor xs = maximum (filter (< maximum xs) xs)

secGreatest :: [Integer] -> Integer
secGreatest xs = last $ sort $ delete (maximum xs) xs

segMay :: [Integer] -> Integer
segMay xs = head $ tail $ reverse $ sort xs

secGrtst :: [Integer] -> Integer
secGrtst xs = last $ init $ sort xs
