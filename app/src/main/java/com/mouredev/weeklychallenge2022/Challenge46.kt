package com.mouredev.weeklychallenge2022

/*
 * Reto #46
 * ¿DÓNDE ESTÁ EL ROBOT?
 * Fecha publicación enunciado: 14/10/22
 * Fecha publicación resolución: 21/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Calcula dónde estará un robot (sus coordenadas finales) que se encuentra en una cudrícula
 * representada por los ejes "x" e "y".
 * - El robot comienza en la coordenada (0, 0).
 * - Para idicarle que se mueva, le enviamos un array formado por enteros (positivos o negativos)
 *   que indican la secuencia de pasos a dar.
 *  - Por ejemplo: [10, 5, -2] indica que primero se mueve 10 pasos, se detiene, luego 5, se detiene,
 *    y finalmente 2. El resultado en este caso sería (x: -5, y: 12)
 * - Si el número de pasos es negativo, se desplazaría en sentido contrario al que está mirando.
 * - Los primeros pasos los hace en el eje "y". Interpretamos que está mirando hacia la parte
 *   positiva del eje "y".
 * - El robot tiene un fallo en su programación: cada vez que finaliza una secuencia de pasos gira
 *   90 grados en el sentido contrario a las agujas del reloj.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

const calculatePositionRobot = (steps) => {
 
  const position = [0, 0];
  let direction = ['+', 'y'];
 
  if(steps?.length <= 0) {
    return position;
  }
 
  steps.forEach(step => {
    const posOperation = direction[1] === 'x' ? 0 : 1;
    const operation = direction[0] === '+' ? 1 : -1;
   
    position[posOperation] = position[posOperation] +  (step * operation);
    direction = robotErrorDirection(direction);
   
  });
 
  return position;
 
}

const robotErrorDirection = (direction) => {
 const newDirection = [,];
 (direction[1] === 'y') ? newDirection[1]= 'x' : newDirection[1]= 'y';
 (direction[1] === 'y') ? (direction[0]=== '+' ? newDirection[0] = '-' : newDirection[0] ='+' ) : newDirection[0] = direction[0];
  return newDirection;
}



console.log(calculatePositionRobot([1, 1, 1, 1])); //[0,0]
console.log(calculatePositionRobot([1, -1, 1, -1])); //[0,0]
console.log(calculatePositionRobot([-1, 1, -1, 1])); //[0,0]
console.log(calculatePositionRobot([-1, -1, -1, -1])); //[0,0]
console.log(calculatePositionRobot([1, -1, -1, -1])); //[0,2]
console.log(calculatePositionRobot([10, 5, -2]));//[-5,12]