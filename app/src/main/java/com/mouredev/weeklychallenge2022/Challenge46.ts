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


/**
 * Clase que representa un robot
 * Cada robot tiene las coordenadas (x, y) en las que se encuentra
 * y un array de pasos que debe dar.
 * Tambien tiene un atributo que indica la direccion en la que mira
 */
export class Robot {
    x: number
    y: number
    route:string
    direction: number = 0;

    constructor() {
        this.x = 0
        this.y = 0
        this.direction = 0
        this.route = ""
    }

    /**
     * Metodo que mueve al robot segun los pasos indicados en el array
     * @param steps Array de pasos a dar
     * en cada coordenadada de pasos el robot gira 90 grados hacia la izquierda
     */
    move(steps: number[]) {
        steps.forEach((step, index) => {
            switch (this.direction) {
                case 0:
                    this.y += step;
                    step >0 ? this.route+= "🡹".repeat(Math.abs(step)) : this.route+= "🡻".repeat(Math.abs(step))
                    break;
                case 1:
                    this.x -= step;
                    step >0 ? this.route+= "🡸".repeat(Math.abs(step)) : this.route+= "🡺".repeat(Math.abs(step))
                    break;
                case 2:
                    this.y -= step;
                    step >0 ? this.route+= "🡻".repeat(Math.abs(step)) : this.route+= "🡹".repeat(Math.abs(step))
                    break;
                case 3:
                    this.x += step;
                    step >0 ? this.route+= "🡺".repeat(Math.abs(step)) : this.route+= "🡸".repeat(Math.abs(step))

                    break;
            }

            this.direction = (this.direction + 1) % 4;
        })
    }

    /**
     * Funcion que resetea al robot y lo devuelve a las coordenadas iniciales
     */
    reset() {
        this.x = 0
        this.y = 0
        this.direction = 0
        this.route=""
    }

    /**
     * Devuelve las coordenadas actuales del robot
     */
    getCoordinates(): { x: number, y: number } {
        return {x: this.x, y: this.y}
    }

    /**
     * Pinta la ruta seguida actual por el robot.
     */
    getRoute():string{
        return this.route
    }
}




const robot = new Robot()

robot.move([10, 5, -2])
console.log(robot.getCoordinates())
console.log(robot.getRoute())
robot.reset()


robot.move([5,10,-5,10])
console.log(robot.getCoordinates())
console.log(robot.getRoute())


