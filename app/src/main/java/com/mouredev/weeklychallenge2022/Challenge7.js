//Debe contar cuantas veces se repite cada palabra.
//Debe mostrar el recuento final de todas las palabras.
//Los signos de puntuación no forman parte de la palabra.
//Una palabra es la misma aunque aparezca en mayúsculas o minúsculas.

//Pasos para resolverlo:
//1. Elimino signos de puntuación xxxxxxxxxxxxxxxx
//2. paso la frase a minúscula xxxxxxxxxxxxxxxxxxx
//3. convierto la frace en un array de strings. xxxxxxxxxxxxxxxx
//4. Creo un objeto vasio llamado palabras. xxxxxxxxxxxxxxxxxxxxx
//5. recorro cada elemento del array y comparo si existe en el objeto palabras:xxxxxxxxxxxxxxxxx
// No EXISTE: lo creo con la key y el value 1 (palabra : 1)xxxxxxxxxxxxxxxxxxx
//EXISTE: le sumo 1 al value. xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//. Por último recorro he imprimo cada uno de las propiedades del objeto.xxxxxxxxxxxxxxxxxxxxxxx
const frase = ("Hola mi nombre es Yorman. Mi nombre completo es Yorman Londono (Yorsh).");

const arr = frase.toLowerCase().replace(/[!"#$%&'\(\)*+,-./:;<=>?@[\]^_`{|}~]/g, '').split(' ');

const palabras ={
  
};
let contar = arr.forEach(p =>{
  if(!palabras[p])  palabras[p] = 0
  palabras[p] += 1;
});

for (let prop in palabras){
  console.log(`La palabra ${prop.toUpperCase()}, se repite ${palabras[prop]} ${palabras[prop] === 1 ? "vez": "veces"}`)
}