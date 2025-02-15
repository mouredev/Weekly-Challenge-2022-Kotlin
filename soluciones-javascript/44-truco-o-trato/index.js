/*
 * Este es un reto especial por Halloween.
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
 * - En caso contrario retornará un error.
 */

const trucoOTrato = (decision, arrayDePersonas) => {
    const sustos = ["🎃", "👻", "💀", "🕷", "🕸", "🦇"];
    const dulces = ["🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"];
    const resultado = [];

    if (decision === "Truco") {
        let sumaEdades = 0;

        arrayDePersonas.forEach((element) => {
            const [nombre, edad, centimetro] = element;

            // Un susto por cada 2 letras del nombre por persona
            if (nombre.length % 2 === 0) {
                for (let i = 0; i < nombre.length / 2; i++) {
                    resultado.push(sustos[Math.floor(Math.random() * 6)]);
                }
            } else {
                for (let i = 0; i < (nombre.length - 1) / 2; i++) {
                    resultado.push(sustos[Math.floor(Math.random() * 6)]);
                }
            }

            // Dos sustos por cada edad que sea un número par
            if (edad % 2 === 0) {
                for (let i = 0; i < 2; i++) {
                    resultado.push(sustos[Math.floor(Math.random() * 6)]);
                }
            }

            sumaEdades += centimetro;
        });

        // Tres sustos por cada 100 cm de altura entre todas las personas
        for (let i = 100; i <= sumaEdades; i += 100) {
            for (let j = 0; j < 3; j++) {
                resultado.push(sustos[Math.floor(Math.random() * 6)]);
            }
        }
    } else if (decision === "Trato") {
        arrayDePersonas.forEach((element) => {
            const [nombre, edad, centimetro] = element;

            // Un dulce por cada letra de nombre
            for (let i = 0; i < nombre.length; i++) {
                resultado.push(dulces[Math.floor(Math.random() * 8)]);
            }

            // Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
            for (let j = 0; j < edad; j += 3) {
                resultado.push(dulces[Math.floor(Math.random() * 8)]);
            }

            // Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
            for (let y = 0; y < 150; y += 50) {
                if ( y > centimetro ) return resultado; 
                resultado.push(dulces[Math.floor(Math.random() * 8)]);
            }

        });
    } else {
        return "Error"; 
    }

    return resultado.join(" ");
};

const personas = [
    ["Juan", 10, 100],
    ["Pablo", 8, 120],
    ["Carla", 7, 80],
    ["Lina", 9, 110],
];

console.log("Truco" + trucoOTrato("Truco", personas) + "\n");
console.log("Trato" + trucoOTrato("Trato", personas) + "\n");
