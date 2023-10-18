function quicksortPivoteInicio(datos) {
  if (datos.length <= 1) {
    return datos;
  }

  let pivote = datos[0];
  let subArrayIzquierdo = [];
  let subArrayDerecho = [];

  for (var i = 1; i < datos.length; i++) {
    if (datos[i] <= pivote) {
      subArrayIzquierdo.push(datos[i]);
    } else {
      subArrayDerecho.push(datos[i]);
    }
  }

  return quicksortPivoteInicio(subArrayIzquierdo).concat(pivote,quicksortPivoteInicio(subArrayDerecho));
}

var sinOrdenar = [23, 45, 16, 37, 3, 99, 22];
var ordenado = quicksortPivoteFinal(sinOrdenar);

//! Otra forma de usar el quickSort en javaScrip
function quicksortPivoteFinal(datos) {
  if (datos.length <= 1) {
    return datos;
  }

  let subArrayIzquierdo = [];
  let subArrayDerecho = [];
  let pivote = datos.pop();

  for (var i = 0; i < datos.length; i++) {
    datos[i] <= pivote
      ? subArrayIzquierdo.push(datos[i])
      : subArrayDerecho.push(datos[i]);
  }

  return quicksortPivoteFinal(subArrayIzquierdo).concat(pivote,quicksortPivoteFinal(subArrayDerecho));
}

console.log(ordenado);
