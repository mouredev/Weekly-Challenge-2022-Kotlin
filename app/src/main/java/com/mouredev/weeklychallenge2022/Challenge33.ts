
/*
 * Reto #33
 * CICLO SEXAGENARIO CHINO
 * Fecha publicación enunciado: 15/08/22
 * Fecha publicación resolución: 22/08/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un función, que dado un año, indique el elemento y animal correspondiente
 * en el ciclo sexagenario del zodíaco chino.
 * - Información: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
 * - El ciclo sexagenario se corresponde con la combinación de los elementos madera,
 *   fuego, tierra, metal, agua y los animales rata, buey, tigre, conejo, dragón, serpiente,
 *   caballo, oveja, mono, gallo, perro, cerdo (en este orden).
 * - Cada elemento se repite dos años seguidos.
 * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */


export enum Element {
    WOOD = "Madera",
    FIRE = "Fuego",
    EARTH = "Tierra",
    METAL = "Metal",
    WATER = "Agua"
}

export enum Animal {
    RAT = "Rata",
    BULL = "Buey",
    TIGER = "Tigre",
    RABBIT = "Conejo",
    DRAGON = "Dragón",
    SNAKE = "Serpiente",
    HORSE = "Caballo",
    SHEEP = "Oveja",
    MONKEY = "Mono",
    ROOSTER = "Gallo",
    DOG = "Perro",
    PIG = "Cerdo"
}


const initiaL_YEAR = 1984

export function sexagenarianCycle(year: number): string {

    let mapelement = new Map<number, Element>();

    mapelement.set(0, Element.WOOD);
    mapelement.set(1, Element.WOOD);
    mapelement.set(2, Element.FIRE);
    mapelement.set(3, Element.FIRE);
    mapelement.set(4, Element.EARTH);
    mapelement.set(5, Element.EARTH);
    mapelement.set(6, Element.METAL);
    mapelement.set(7, Element.METAL);
    mapelement.set(8, Element.WATER);
    mapelement.set(9, Element.WATER);

    let mapanimal = new Map<number, Animal>();

    mapanimal.set(0, Animal.RAT);
    mapanimal.set(1, Animal.BULL);
    mapanimal.set(2, Animal.TIGER);
    mapanimal.set(3, Animal.RABBIT);
    mapanimal.set(4, Animal.DRAGON);
    mapanimal.set(5, Animal.SNAKE);
    mapanimal.set(6, Animal.HORSE);
    mapanimal.set(7, Animal.SHEEP);
    mapanimal.set(8, Animal.MONKEY);
    mapanimal.set(9, Animal.ROOSTER);
    mapanimal.set(10, Animal.DOG);
    mapanimal.set(11, Animal.PIG);



    let yearElement = mapelement.get((year -initiaL_YEAR) % mapelement.size) as string
    let yearAnimal = mapanimal.get((year -initiaL_YEAR) % mapanimal.size) as string


    return `${year} ${yearElement} ${yearAnimal}`
}


console.log(sexagenarianCycle(1984))
console.log(sexagenarianCycle(2011))
console.log(sexagenarianCycle(2018))