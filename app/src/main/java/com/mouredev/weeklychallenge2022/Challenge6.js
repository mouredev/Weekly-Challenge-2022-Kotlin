const invertirCadena = (cadena) =>{
let cadenaInvertida = "";
for(let i= cadena.length-1; i >=0; i--){
  cadenaInvertida += cadena[i];
}
console.log(cadenaInvertida);
}

const texto = "Hola Mundo";

invertirCadena(texto);