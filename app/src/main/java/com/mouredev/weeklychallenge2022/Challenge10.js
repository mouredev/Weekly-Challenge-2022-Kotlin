/*
 * Reto #10
 * EXPRESIONES EQUILIBRADAS
 * Fecha publicación enunciado: 07/03/22
 * Fecha publicación resolución: 14/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que comprueba si los paréntesis, llaves y corchetes de una expresión están equilibrados.
 * - Equilibrado significa que estos delimitadores se abren y cieran en orden y de forma correcta.
 * - Paréntesis, llaves y corchetes son igual de prioritarios. No hay uno más importante que otro.
 * - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
 * - Expresión no balanceada: { a * ( c + d ) ] - 5 }
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

const openRegex = /[\{\[\(]/g; // regular expression to find open keys
const closeRegex = /[\}\]\)]/g; // regular expresion to find close keys
const keyObj = {"{":"}", "[":"]", "(":")"};

function isBalanced(exp){
	let openKeys = "";
	for(element of exp.split("")){
		if((openRegex.exec(element)) !== null) openKeys += element;
		else if((closeRegex.exec(element)) !== null){
			if(openKeys.length === 0) return false;
			openKeys = removeFromExpression(openKeys, element);
			if(openKeys === false) return false
		}
	}
	if(openKeys.length !== 0) return false;
	return true;
}

function removeFromExpression(exp, c){
	const getKey = (c) => {
		return Object.keys(keyObj).find(key => keyObj[key] === c);
	}
	if(exp.length === 0) return exp; // if exp = empty -> return exp
	if(exp.endsWith(getKey(c))) exp = exp.slice(0, exp.length-1);
	else return false;
	return exp;
}

console.log(isBalanced("{a + b [c] * (2x2)}}}}")); // false
console.log(isBalanced("{ [ a * ( c + d ) ] - 5 }")); // true
console.log(isBalanced("{ a * ( c + d ) ] - 5 }")); // false
console.log(isBalanced("{a^4 + (((ax4)}")); // false
console.log(isBalanced("{ ] a * ( c + d ) + ( 2 - 3 )[ - 5 }")); // false
console.log(isBalanced("{{{{{{(}}}}}}")); // false
console.log(isBalanced("(a")); // false
console.log(isBalanced("{ ( ) [ ] }")); // true