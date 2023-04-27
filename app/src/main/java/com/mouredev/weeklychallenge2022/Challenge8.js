//Crea un programa se encargue de transformar un número decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.

//Inicializo la bariable binary como un string vacio
//Condiciono mediante un while la repetición de la operación mientras el decimal sea mayor a 0
//Realizamos el modulo del numero y se lo asignamos al modulo
//Le concatenamos el modulo a binary
//Recalculamos el nuevo decimal
//Retornamos el binario

function decimalToBinary(decimal) {
  let binary = "";

  while(decimal > 0){
    let modulo = decimal % 2;
    binary += modulo;
    decimal = Math.floor( decimal / 2);
  }

  return Number(binary);
}

decimalToBinary(27);