// Función para comprobar si un número es primo
function esPrimo(numero) {
  if (numero <= 1) {
    return false;
  }
  for (let i = 2; i <= numero / 2; i++) {
    if (numero % i === 0) {
      return false;
    }
  }
  return true;
}

// Comprobar si un número es primo
const numero = 23; // Cambiar el número aquí para comprobar
if (esPrimo(numero)) {
  console.log(numero + " es un número primo.");
} else {
  console.log(numero + " no es un número primo.");
}

// Imprimir los números primos entre 1 y 100
console.log("Números primos entre 1 y 100:");
for (let i = 1; i <= 100; i++) {
  if (esPrimo(i)) {
    console.log(i);
  }
}