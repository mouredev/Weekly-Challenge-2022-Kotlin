/*
 * Reto #8
 * DECIMAL A BINARIO
 * Fecha publicación enunciado: 18/02/22
 * Fecha publicación resolución: 02/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa se encargue de transformar un número decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function decimalToBinary(n){
    if(n == 0) return 0; // if n = 0 -> answer = 0
    let bNum = ""; // empty string to save the answer
    while(n != 0){
        let rest = parseInt(n % 2); // rest of n/2
        n = parseInt(n / 2); // make number / 2
        bNum += rest.toString(); // add the rest to the result
    }
    let ans = ""; // empty string to create the result
    // to create a list, reverse it and add each number to the empty string
    bNum.split("").reverse().forEach(num => ans += num);
    return ans; // to return the answer
}

// to use the prompt function in the terminal
const fs = require('fs');
const prompt = msg => {
  fs.writeSync(1, String(msg));
  let s = '', buf = Buffer.alloc(1);
  while(buf[0] - 10 && buf[0] - 13)
    s += buf, fs.readSync(0, buf, 0, 1, 0);
  return s.slice(1);
};

do{
    try{
        var num = prompt("Set a number: "); // ask user for a number
        if(num === "") throw "You setted an empty string"; // if it is empty -> error
        num = Number(num); // convert the string type to number
        if(isNaN(num)) throw "You must set a number"; // if is not a number -> error
        var isError = false; // set isError to false -> breaks the do-while loop
    }
    catch(err){
        isError = true; // set isError to true
        console.error(err); // prints the error
    }
} while(isError === true); // if there was an error, ask for a number again
// result
console.log(`The number ${num} in binary is: ${decimalToBinary(num)}`);