/*
 * Calcula dónde estará un robot (sus coordenadas finales) que se
 * encuentra en una cuadrícula representada por los ejes "x" e "y".
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

/**
 * 
 * @param {Array} secuenciaDePasos 
 */
const dondeEstaElRobot = ( secuenciaDePasos ) => {

    const coordenadas = { x: 0, y: 0 };
    const direcciones = ['y+', 'x-', 'y-', 'x+'];
    
    for (let i = 0; i < secuenciaDePasos.length; i++) {
        
        let direccionActual = direcciones[ i % 4 ];
        let pasos = secuenciaDePasos[i];

        if(pasos < 0){
            pasos = Math.abs(pasos);
            switch (direccionActual) {
                case 'y+': direccionActual = 'y-'; break;
                case 'x-': direccionActual = 'x+'; break;
                case 'y-': direccionActual = 'y+'; break;
                case 'x+': direccionActual = 'x-'; break;
            }
        }
        
        switch (direccionActual) {
            case 'y+': coordenadas.y += pasos; break;
            case 'x-': coordenadas.x -= pasos; break;
            case 'y-': coordenadas.y -= pasos; break;
            case 'x+': coordenadas.x += pasos; break;
        }

    }

    return coordenadas; 

}

console.log(dondeEstaElRobot([10, 5, -2]));
console.log(dondeEstaElRobot([-10, -5, 2]));
console.log(dondeEstaElRobot([-10, -5, 4]));