/*
 * Reto #26
 * CUADRADO Y TRIÁNGULO 2D
 * Fecha publicación enunciado: 27/06/22
 * Fecha publicación resolución: 07/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
 * - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
 * - EXTRA: ¿Eres capaz de dibujar más figuras?
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function drawPolygon(size, type){
	if(size < 2) console.log("Size must be bigger than 1."); // if size<2 says that it must be bigger
	// create a function that creates a range of values between 'start' and 'end' (doesn't take the 'end' value)
	const range = (start, end) => Array.from('x'.repeat(end - start), (_, i) => start + i);
	// for loop from 1 to size
	for(value of range(1, size+1)){
		if(type === "square"){
			console.log("* ".repeat(size));
		}
		else if(type === "triangle"){
			console.log("* ".repeat(value));
		}
	}
}

drawPolygon(10, "square");
drawPolygon(15, "triangle");