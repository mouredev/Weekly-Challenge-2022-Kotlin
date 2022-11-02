"use strict";
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
Object.defineProperty(exports, "__esModule", { value: true });
exports.trickOrTreat = exports.trick = exports.treat = exports.Person = exports.TrickOrTreat = void 0;
var TrickOrTreat;
(function (TrickOrTreat) {
    TrickOrTreat["TRICK"] = "Truco";
    TrickOrTreat["TREAT"] = "Trato";
})(TrickOrTreat = exports.TrickOrTreat || (exports.TrickOrTreat = {}));
class Person {
    constructor(name, age, height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
}
exports.Person = Person;
function treat(people) {
    let sweet = ["🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"];
    let result = [];
    people.forEach((person) => {
        let sweetCount = 0;
        sweetCount += person.name.length;
        sweetCount += Math.min(Math.floor(person.age / 3), 10);
        sweetCount += Math.min(Math.floor(person.height / 50), 3) * 2;
        for (let i = 0; i < sweetCount; i++) {
            result.push(sweet[Math.floor(Math.random() * sweet.length)]);
        }
    });
    return result;
}
exports.treat = treat;
function trick(people) {
    let scares = ["🎃", "👻", "💀", "🕷", "🕸", "🦇"];
    let result = [];
    people.forEach((person) => {
        let scare = 0;
        scare += person.name.length / 2;
        if (person.age % 2 === 0) {
            scare += 2;
        }
        scare += Math.floor(people.reduce((total, person) => total + person.height, 0) / 100) * 3;
        for (let i = 0; i < scare; i++) {
            result.push(scares[Math.floor(Math.random() * scares.length)]);
        }
    });
    return result;
}
exports.trick = trick;
function trickOrTreat(trickOrTreat, people) {
    switch (trickOrTreat) {
        case TrickOrTreat.TRICK:
            return trick(people);
        case TrickOrTreat.TREAT:
            return treat(people);
    }
}
exports.trickOrTreat = trickOrTreat;
// TESTS
console.log(trickOrTreat(TrickOrTreat.TREAT, [new Person("Angel", 10, 145), new Person("Miguel Angel", 42, 178)]));
console.log(trickOrTreat(TrickOrTreat.TRICK, [new Person("Carmen", 7, 124), new Person("Brais", 38, 170)]));
