/*
 * Crea un programa que simule el comportamiento del sombrero selccionador del
 * universo mágico de Harry Potter.
 * - De ser posible realizará 5 preguntas (como mínimo) a través de la terminal.
 * - Cada pregunta tendrá 4 respuestas posibles (también a selecciona una a través de terminal).
 * - En función de las respuestas a las 5 preguntas deberás diseñar un algoritmo que
 *   coloque al alumno en una de las 4 casas de Hogwarts:
 *   (Gryffindor, Slytherin , Hufflepuff y Ravenclaw)
 * - Ten en cuenta los rasgos de cada casa para hacer las preguntas
 *   y crear el algoritmo seleccionador:
 *   Por ejemplo, en Slytherin se premia la ambición y la astucia.
 */

const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

const preguntas = [
    {
        pregunta: "¿Qué cualidad valoras más en una persona?",
        opciones: ["Valentía", "Ambición", "Lealtad", "Inteligencia"],
        puntos: { Gryffindor: 1, Slytherin: 2, Hufflepuff: 3, Ravenclaw: 4 },
    },
    {
        pregunta: "¿Qué harías si ves a alguien haciendo trampa en un examen?",
        opciones: [
            "Lo denuncio inmediatamente",
            "Lo ignoro, no es mi problema",
            "Ayudo a quien hizo trampa a mejorar",
            "Intento razonar con la persona",
        ],
        puntos: { Gryffindor: 1, Slytherin: 2, Hufflepuff: 3, Ravenclaw: 4 },
    },
    {
        pregunta: "¿Qué tipo de libros prefieres leer?",
        opciones: ["Aventuras", "Estrategia", "Historias conmovedoras", "Ciencia"],
        puntos: { Gryffindor: 1, Slytherin: 2, Hufflepuff: 3, Ravenclaw: 4 },
    },
    {
        pregunta: "¿Cuál de estos lugares te atrae más?",
        opciones: [
            "Un campo abierto y desafiante",
            "Un castillo con muchos secretos",
            "Un jardín acogedor",
            "Una biblioteca infinita",
        ],
        puntos: { Gryffindor: 1, Slytherin: 2, Hufflepuff: 3, Ravenclaw: 4 },
    },
    {
        pregunta: "Si tuvieras que enfrentar un desafío, ¿qué harías?",
        opciones: [
            "Voy con determinación y sin miedo",
            "Planeo cada paso meticulosamente",
            "Busco apoyo en mis amigos",
            "Investigo la mejor solución posible",
        ],
        puntos: { Gryffindor: 1, Slytherin: 2, Hufflepuff: 3, Ravenclaw: 4 },
    },
];

let puntajes = { Gryffindor: 0, Slytherin: 0, Hufflepuff: 0, Ravenclaw: 0 };
let preguntaActual = 0;

const elSombreroSeleccionador = () => {
    if (preguntaActual < preguntas.length) {
        const { pregunta, opciones, puntos } = preguntas[preguntaActual];
        console.log(`\n${pregunta}`);
        opciones.forEach((opcion, i) => console.log(`${i + 1}. ${opcion}`));
        rl.question("Elige una opción (1-4): ", (respuesta) => {
            const eleccion = parseInt(respuesta);
            if (eleccion >= 1 && eleccion <= 4) {
                Object.keys(puntajes).forEach((casa) => {
                    if (puntos[casa] === eleccion) puntajes[casa]++;
                });
                preguntaActual++;
                elSombreroSeleccionador();
            } else {
                console.log("Por favor, ingresa un número válido.");
                elSombreroSeleccionador();
            }
        });
    } else {
        rl.close();
        asignarCasa();
    }
};

const asignarCasa = () => {
    let casaAsignada = Object.keys(puntajes).reduce((a, b) => (puntajes[a] > puntajes[b] ? a : b));
    console.log(`\n¡Felicidades! Has sido asignado a ${casaAsignada} 🏰`);
};
console.log("Bienvenido al Sombrero Seleccionador de Hogwarts 🎩✨");

elSombreroSeleccionador();