/*
 * Reto #24
 * ITERATION MASTER
 * Fecha publicación enunciado: 13/06/22
 * Fecha publicación resolución: 20/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Quiero contar del 1 al 100 de uno en uno (imprimiendo cada uno). ¿De cuántas maneras eres capaz de hacerlo? Crea el código para cada una de ellas.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

// 1
for(let i=1; i<=100; i++){
	console.log(i);
}

// 2
var i = 1;
while(i<=100){
	console.log(i);
	i++;
}

// 3
var i = 1;
do{
	console.log(i);
	i++;
}while(i<=100);

// 4
// defines a function that creates an array of numbers from 'start' to 'end'
const range = (start, end) => Array.from('x'.repeat(end - start), (_, i) => start + i);
for(n of range(1, 100+1)){
	console.log(n);	
}

// 5
function print100(n){
	if(n<=100){
		console.log(n);
		print100(n + 1);
	}
}
print100(1);

// 6
var i = 0;
while(true){
	console.log(i);
	i++;
	if(i === 101) break;
}