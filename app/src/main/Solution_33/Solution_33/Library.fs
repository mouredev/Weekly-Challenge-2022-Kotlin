module Solution_33.Library

type ZodiacSign = ZodiacSign of string
type Element = Element of string
type ChineseYear = ZodiacSign * Element

let private signs: ZodiacSign list =
    [ "rata"
      "buey"
      "tigre"
      "conejo"
      "dragón"
      "serpiente"
      "caballo"
      "oveja"
      "mono"
      "gallo"
      "perro"
      "cerdo" ]
    |> List.map ZodiacSign

let private elements: Element list =
    [ "madera"
      "fuego"
      "tierra"
      "metal"
      "agua" ]
    |> List.map Element

let private GetZodiacSign (i: int) : ZodiacSign = signs[i % 12]
let private GetElement (i: int) : Element = elements[(i % 10) / 2]

let ToString ((sign, element): ChineseYear) : string = $"{sign}, {element}"

let CalculateChineseYear (year: int) : ChineseYear =
    (year % 60) - 4
    |> fun cycleIndex -> (GetZodiacSign cycleIndex, GetElement cycleIndex)
