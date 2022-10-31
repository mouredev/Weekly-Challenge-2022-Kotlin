package com.mouredev.weeklychallenge2022

/*
 * Reto #43
 * TRUCO O TRATO
 * Fecha publicación enunciado: 24/10/22
 * Fecha publicación resolución: 02/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Este es un reto especial por Halloween.
 * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco o Trato" y
 * un listado (array) de personas con las siguientes propiedades:
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
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


people = [
  {name: 'Rodolfo', age: 5, height: 100, choise: 'trick'},
  {name: 'Daniel', age: 10, height: 120, choise: 'treat'},
  {name: 'Luis', age: 14, height: 130, choise: 'treat'},
  {name: 'Maria', age: 20, height: 170, choise: 'trick'}
]

tricks = ['🎃','👻','💀','🕷','🕸','🦇']
treats = ['🍰','🍬','🍡', '🍭', '🍪', '🍫', '🧁', '🍩']

const peopleTricked = people.filter(person => person.choise === 'trick')
const peopleTreated = people.filter(person => person.choise === 'treat')

const getRandomArray = (array, length) => {
  var randomArray = []
  
  for (var element = 0; element < length; element++) {
    const randomIndex = Math.round(Math.random() * (array.length-1))
    randomArray.push(array[randomIndex])
  }
  
  return randomArray
}

peopleTricked.map((person) => {
    const nameTrick = Math.round(person.name.length / 2)
    const ageTrick = (person.age % 2 === 0) ? 2 : 0
    const heightTrick = Math.round(person.height / 100) * 3
    
    const tricksToPerson = nameTrick + ageTrick + heightTrick
    const scares = getRandomArray(tricks, tricksToPerson)

    return {...person, scares}
})

/*
  [
    {
      name: 'Rodolfo',
      age: 5,
      height: 100,
      choise: 'trick',
      scares: [
        '💀', '👻', '💀',
        '💀', '🕸',  '🕸',
        '🕸'
      ]
    },
    {
      name: 'Maria',
      age: 20,
      height: 170,
      choise: 'trick',
      scares: [
        '🕷',  '👻', '🕸',
        '🕸',  '🕷',  '🦇',
        '🎃', '🕷',  '🕸',
        '💀', '💀'
      ]
    }
  ]
*/

peopleTreated.map((person) => {
  const nameLetterTreat = person.name.length
  
  const ageDivided3 = Math.round(person.age / 3)
  const ageTreat = (ageDivided3 < 10) ? ageDivided3 : 10
  
  const heightDivided50 = Math.round(person.height / 50)
  const heightDividedMoreThan3 = heightDivided50 < 3 ? heightDivided50 : 3
  const heightTreat = heightDividedMoreThan3 * 2
  
  const treatsToPerson = nameLetterTreat + ageTreat + heightTreat
  const sweets = getRandomArray(treats, treatsToPerson)
  
  return {...person, sweets}
})

/*
  [
    {
      name: 'Daniel',
      age: 10,
      height: 120,
      choise: 'treat',
      sweets: [
        '🍡', '🍩', '🍭',
        '🍭', '🍫', '🍭',
        '🍪', '🍰', '🧁',
        '🍬', '🧁', '🍭',
        '🧁'
      ]
    },
    {
      name: 'Luis',
      age: 14,
      height: 130,
      choise: 'treat',
      sweets: [
        '🍫', '🍩', '🧁', '🍬',
        '🍡', '🍭', '🍰', '🧁',
        '🍬', '🍰', '🍫', '🍭',
        '🍬', '🍬', '🍪'
      ]
    }
  ]
*/