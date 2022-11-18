/*
 * Reto #17
 * LA CARRERA DE OBSTÁCULOS
 * Fecha publicación enunciado: 25/04/22
 * Fecha publicación resolución: 02/05/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que evalúe si un/a atleta ha superado correctamente una
 * carrera de obstáculos.
 * - La función recibirá dos parámetros:
 *      - Un array que sólo puede contener String con las palabras "run" o "jump"
 *      - Un String que represente la pista y sólo puede contener "_" (suelo) o "|" (valla)
 * - La función imprimirá cómo ha finalizado la carrera:
 *      - Si el/a atleta hace "run" en "_" (suelo) y "jump" en "|" (valla) será correcto y no
 *        variará el símbolo de esa parte de la pista.
 *      - Si hace "jump" en "_" (suelo), se variará la pista por "x".
 *      - Si hace "run" en "|" (valla), se variará la pista por "/".
 * - La función retornará un Boolean que indique si ha superado la carrera.
 * Para ello tiene que realizar la opción correcta en cada tramo de la pista.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

const goodActions = {"RUN":"_", "JUMP":"|"};

function checkResult(actions, track){
	// check which one has a bigger length
	let totalActions = (actions.length > track.length)? actions.length : track.length;
	let minActions = (actions.length < track.length)? actions.length : track.length;
	let athleteTrack = ""; // empty string to save the athetes actions compared to the track
	for(let i=0; i<totalActions; i++){
		if(i >= minActions) athleteTrack += "?"; // if one of the tracks is bigger, add "?"
		else{
			if(goodActions[actions[i]] === track[i]) athleteTrack += track[i]; // the track and actions are good
			else if(actions[i]==="RUN" && track[i]==="|") athleteTrack += "/"; // run when should jump
			else if(actions[i]==="JUMP" && track[i]==="_") athleteTrack += "x"; // jump when sould run
			else athleteTrack += "?"; // if the input is different than it should
		}
	}
	// to print the result track
	console.log(athleteTrack);
	/* this is what is gonna be printed for each race
	Race 1 -> _|_|_ 
	Race 2 -> _/_|_ 
	Race 3 -> _/x|_ 
	Race 4 -> _/x|_?? 
	Race 5 -> _|_|? 
	Race 6 -> _|_|_?? 
	Race 7 -> ||||| 
	Race 8 -> ||?||
	*/
	// returns a boolean -> if every actions are "_" or "|" then is a true, else is a false
	return athleteTrack.split("").every(action => action === "_" || action === "|");
}

console.log(`Race 1 result: ${checkResult(["RUN", "JUMP", "RUN", "JUMP", "RUN"], "_|_|_")}`) // Race 1 result: true
console.log(`Race 2 result: ${checkResult(["RUN", "RUN", "RUN", "JUMP", "RUN"], "_|_|_")}`) // Race 2 result: false
console.log(`Race 3 result: ${checkResult(["RUN", "RUN", "JUMP", "JUMP", "RUN"], "_|_|_")}`) // Race 3 result: false
console.log(`Race 4 result: ${checkResult(["RUN", "RUN", "JUMP", "JUMP", "RUN"], "_|_|_|_")}`) // Race 4 result: false
console.log(`Race 5 result: ${checkResult(["RUN", "JUMP", "RUN", "JUMP"], "_|_|_")}`) // Race 5 result: false
console.log(`Race 6 result: ${checkResult(["RUN", "JUMP", "RUN", "JUMP", "RUN", "JUMP", "RUN"], "_|_|_")}`) // Race 6 result: false
console.log(`Race 7 result: ${checkResult(["JUMP", "JUMP", "JUMP", "JUMP", "JUMP"], "|||||")}`) // Race 7 result: true
console.log(`Race 8 result: ${checkResult(["JUMP", "JUMP", "JUMP", "JUMP", "JUMP"], "||?||")}`) // Race 8 result: false