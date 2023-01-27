/*
 * Enunciado: Este es un reto especial por Halloween.
 * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco
 * o Trato" y un listado (array) de personas con las siguientes propiedades:
 * - Nombre de la niña o niño
 * - Edad
 * - Altura en centímetros
 *
 * Si las personas han pedido truco, el programa retornará sustos (aleatorios)
 * siguiendo estos criterios:
 * - Un susto por cada 2 letras del nombre por persona
 * - Dos sustos por cada edad que sea un número par
 * - Tres sustos por cada 100 cm de altura entre todas las personas
 * - Sustos: 🎃 👻 💀 🕷 🕸 🦇
 *
 * Si las personas han pedido trato, el programa retornará dulces (aleatorios)
 * siguiendo estos criterios:
 * - Un dulce por cada letra de nombre
 * - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
 * - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
 * - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩
 */
const scares = ["🎃", "👻", "💀", "🕷", "🕸", "🦇"]
const sweets = ["🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"]

const people = [
  {name: "Juan", age: 12, height: 134},
  {name: "Manola", age: 11, height: 112},
  {name: "Fernando", age: 13, height: 139},
  {name: "Josefina", age: 8, height: 124},
  {name: "Roberto", age: 14, height: 144},
]

const generateRandomEmoji = (num, arr) => {
  const randomEmojis = []
  for(let i = 0; i < num; i++) {
      const random = Math.floor((Math.random() * arr.length))
      randomEmojis.push(arr[random])
  }
  return randomEmojis
}

// Trick (Truco)
const trickOne = person => {
  const scaresByName  = Math.floor(person.name.length / 2)
  const numberOfScares = person.age % 2 === 0 ? scaresByName + 2 : scaresByName
  
  return generateRandomEmoji(numberOfScares,scares)
}

const trick = () => {
  const resultScares = people.map(person => trickOne(person)).flat()
  const alCm = Math.floor(people.reduce((acc,res) => res.height + acc,0) / 100) * 3
  
  return [...resultScares, ...generateRandomEmoji(alCm,scares)]
}

// Treating (Trato)
const treatingOne = person => {
  let numberSweets = person.name.length
  numberSweets += person.age / 3 > 3 ? 3 : Math.floor(person.age / 3)
  numberSweets +=  person.height / 50 > 3 ? 6 : Math.floor(person.height / 50) * 2
  
  return generateRandomEmoji(numberSweets,sweets)
}

const treating = () => people.map(person => treatingOne(person)).flat()

const halloweenOption = {
  "trick": trick(),
  "treating": treating()
}

const halloween = petition => {
    let result = `People chose ${petition} and the result was 🎃:\n${halloweenOption[petition]}`
    return halloweenOption[petition] ? result : "This not an option in HalloWeen 🎃"
}

halloween("trick")