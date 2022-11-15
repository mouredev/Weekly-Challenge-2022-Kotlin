/*
 * Enunciado: Calcula dónde estará un robot (sus coordenadas finales) que se
 * encuentra en una cudrícula representada por los ejes "x" e "y".
 * - El robot comienza en la coordenada (0, 0).
 * - Para idicarle que se mueva, le enviamos un array formado por enteros
 *   (positivos o negativos) que indican la secuencia de pasos a dar.
 * - Por ejemplo: [10, 5, -2] indica que primero se mueve 10 pasos, se detiene,
 *   luego 5, se detiene, y finalmente 2.
 *   El resultado en este caso sería (x: -5, y: 12)
 * - Si el número de pasos es negativo, se desplazaría en sentido contrario al
 *   que está mirando.
 * - Los primeros pasos los hace en el eje "y". Interpretamos que está mirando
 *   hacia la parte positiva del eje "y".
 * - El robot tiene un fallo en su programación: cada vez que finaliza una
 *   secuencia de pasos gira 90 grados en el sentido contrario a las agujas
 *   del reloj.
 */
// Origin Cords
let x = 0;
let y = 0;
// Control value. This value indicates where the robot are facing and moving
// 1 = +Y   2 = -X   3 = -Y   4 = +X
let facing = 1;
// Arrays with the instructions for the Robot
let steps = [10, 5, -2];

steps.forEach((element) => {
    facing == 1
        ? ((y = y + element), facing++)
        : facing == 2
        ? ((x = x - element), facing++)
        : facing == 3
        ? ((y = y - element), facing++)
        : ((x = x + element), (facing = 1));
});

console.log(`El robot se ha movido desde (x: 0, y: 0) hasta (x: ${x}, y: ${y})`);
