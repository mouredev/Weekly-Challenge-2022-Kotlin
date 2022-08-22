module Solution_33.Library

let private elements =
    seq {
        "madera"
        "fuego"
        "tierra"
        "metal"
        "agua"
    }

let private animals =
    seq {
        "rata"
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
        "cerdo"
    }

let CalculateZodiacSigns year =
    (year % 60) - 4
    |> fun cycleIndex -> (cycleIndex % 12, (cycleIndex % 10) / 2)
    |> fun (animalIndex, elementIndex) -> (Seq.item animalIndex animals, Seq.item elementIndex elements)
