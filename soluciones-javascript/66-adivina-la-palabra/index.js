/*
 * Crea un pequeño juego que consista en adivinar palabras en un número máximo de intentos:
 * - El juego comienza proponiendo una palabra aleatoria incompleta
 *   - Por ejemplo "m_ur_d_v", y el número de intentos que le quedan
 * - El usuario puede introducir únicamente una letra o una palabra (de la misma longitud que
 *   la palabra a adivinar)
 *   - Si escribe una letra y acierta, se muestra esa letra en la palabra. Si falla, se resta
 *     uno al número de intentos
 *   - Si escribe una resolución y acierta, finaliza el juego, en caso contrario, se resta uno
 *     al número de intentos
 *   - Si el contador de intentos llega a 0, el jugador pierde
 * - La palabra debe ocultar de forma aleatoria letras, y nunca puede comenzar
 *   ocultando más del 60%
 * - Puedes utilizar las palabras que quieras y el número de intentos que consideres
 */
const readline = require("readline");

const palabras = ["murcielago", "computadora", "javascript", "elefante", "hipopotamo"];

const ocultarLetras = (palabra) => {
    const numOcultas = Math.floor(palabra.length * 0.6); // Ocultar hasta un 60% de las letras
    let indices = new Set();

    while (indices.size < numOcultas) {
        let i = Math.floor(Math.random() * palabra.length);
        indices.add(i);
    }

    return palabra
        .split("")
        .map((letra, i) => (indices.has(i) ? "_" : letra))
        .join("");
};

const jugar = () => {
    const palabraSecreta = palabras[Math.floor(Math.random() * palabras.length)];
    let palabraActual = ocultarLetras(palabraSecreta);
    let intentos = 6;

    console.log("¡Bienvenido al juego de adivinar palabras!");
    console.log(`Palabra: ${palabraActual} (${intentos} intentos restantes)`);

    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
    });

    const preguntar = () => {
        if (intentos <= 0) {
            console.log(`¡Perdiste! La palabra era: ${palabraSecreta}`);
            rl.close();
            return;
        }

        rl.question("Introduce una letra o intenta adivinar la palabra: ", (entrada) => {
            entrada = entrada.toLowerCase();

            if (entrada.length === 1) {
                // Entrada de una sola letra
                if (palabraSecreta.includes(entrada)) {
                    palabraActual = palabraActual
                        .split("")
                        .map((letra, i) => (palabraSecreta[i] === entrada ? entrada : letra))
                        .join("");
                } else {
                    intentos--;
                }
            } else if (entrada.length === palabraSecreta.length) {
                // Intento de adivinar palabra completa
                if (entrada === palabraSecreta) {
                    console.log(`¡Felicidades! Adivinaste la palabra: ${palabraSecreta}`);
                    rl.close();
                    return;
                } else {
                    intentos--;
                }
            } else {
                console.log(
                    "Entrada inválida. Debe ser una letra o una palabra de la misma longitud."
                );
                preguntar();
                return;
            }

            if (palabraActual === palabraSecreta) {
                console.log(`¡Felicidades! Adivinaste la palabra: ${palabraSecreta}`);
                rl.close();
                return;
            }

            console.log(`Palabra: ${palabraActual} (${intentos} intentos restantes)`);
            preguntar();
        });
    }

    preguntar();
};

// Iniciar juego
jugar();
