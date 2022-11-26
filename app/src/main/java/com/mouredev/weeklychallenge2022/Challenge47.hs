 -- Reto #47
 -- VOCAL MÁS COMÚN
 -- Fecha publicación enunciado: 21/11/22
 -- Fecha publicación resolución: 28/11/22
 -- Dificultad: FÁCIL
 --
 -- Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 -- Si no hay vocales podrá devolver vacío.
 --
 -- Información adicional:
 -- - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 --   para preguntas, dudas o prestar ayuda a la comunidad.
 -- - Tienes toda la información sobre los retos semanales en
 --   https://retosdeprogramacion.com/semanales2022.

module Challenge47 where

import qualified Data.Map as Map

vocals :: [Char]
vocals = ['a', 'e', 'i', 'o', 'u']

vocal :: (Num a) => Map.Map Char a
vocal = Map.empty

count :: (Enum b, Num b) => Map.Map Char b ->  String -> Map.Map Char b
count v [] = v
count v (t:ts)
  | Map.member t v = count (Map.update (\x -> Just (succ x)) t v) ts
  | elem t vocals = count (Map.insert t 1 v) ts
  | otherwise = count v ts

mostRepeatedVocal :: (Ord v, Enum v, Num v) => String -> Map.Map Char v
mostRepeatedVocal txt = Map.filterWithKey (\_ v -> maximum counter == v) $ result
  where
    result = count vocal txt
    counter = Map.elems result

test :: String
test = "The quick brown fox jumps over the lazy dog"

loremIpsum :: String
loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"

result txt = "The most repeated vocal(s): " ++ res
  where
    res = (Map.keys $ mostRepeatedVocal txt)
