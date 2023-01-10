/*
 * Reto #11
 * ELIMINANDO CARACTERES
 * Fecha publicación enunciado: 14/03/22
 * Fecha publicación resolución: 21/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos cadenas como parámetro (str1, str2) e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO estén presentes en str1.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function printNonCommon(str1, str2){
	// create two strings -> if one doesn't contain c, includes c to the other one
	let out1 = str1.split("").filter(c => !(str2.split("").includes(c))).join("");
	let out2 = str2.split("").filter(c => !(str1.split("").includes(c))).join("");
	// to print the strings
	console.log(`out1: ${out1}`);
	console.log(`out2: ${out2}`);
}

printNonCommon("naia", "larrea"); // out1: ni | out2: lrre
printNonCommon("I like Javascript", "I like Python"); // out1: Javascrp | out2: Pyhon
printNonCommon("In my spare time I often learn new things about programming", "I am also a rugby player and referee"); // out1: titwthiti | out2: d