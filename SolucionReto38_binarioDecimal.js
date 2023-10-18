function binarioDecimal(numBinarioRecibido) {
  var decimal = 0,
    exponente = 0;
  var digito;
  var esBinario = true;
  var mensajeError = "Error: Binario no valido";

  while (numBinarioRecibido != 0) {
    digito = numBinarioRecibido % 10;
    if (digito != 0 && digito != 1) {
      //si no es 0 ó 1
      esBinario = false; //no es un número binario
      break;
    } else {
      numBinarioRecibido = Number.parseInt(numBinarioRecibido / 10);
      decimal = decimal + digito * 2 ** exponente;
      ++exponente;
    }
  }

  if (!esBinario) {
    return mensajeError;
  }

  return decimal;
}

console.log(binarioDecimal(102));
console.log(binarioDecimal(101101));
console.log(binarioDecimal(111));
console.log(binarioDecimal(1010101));
