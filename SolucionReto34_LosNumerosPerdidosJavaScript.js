//función para saber si esta ordenado el array recibido
function arrayIsOrden(datos) {
let result = true;
for (let i = 0; i < datos.length; i++) {
if (datos[i] <= datos[i - 1]) {
result = false;
break;
}
}
return result;
}

//función principal para determinar que números faltantes del array recibido
function numsFaltantes(datosRecibidos) {
let contador = 0;
let numsFaltntes = [];
let resultado = "Error: el dato recibido no es un array valido";

if (Array.isArray(datosRecibidos) && datosRecibidos.length >= 2 && arrayIsOrden(datosRecibidos)) {
let ultimoElemento = datosRecibidos[datosRecibidos.length - 1];
let primerElemento = datosRecibidos[0];

for (var i = primerElemento; i <= ultimoElemento; i++) {
  if (!datosRecibidos.includes(i)) {
    contador++;
    numsFaltntes.push(i);
    if (contador > 1) {
      resultado = numsFaltntes;
    } else {
      resultado = i;
    }
  }
}
}

return resultado;
}

console.log(numsFaltantes([1, 3]));
console.log(numsFaltantes([0, 2, 3]));
console.log(numsFaltantes([5, 6, 1, 2, 3, 7, 0]));
console.log(numsFaltantes([3, 0, 1]));
console.log(numsFaltantes([1, 2, 3, 5, 6, 7, 10, 15]));
console.log(numsFaltantes([1, 2, 5]));
