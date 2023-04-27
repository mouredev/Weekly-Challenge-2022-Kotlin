function calcularAreaPoligono(poligono){
   
  if(poligono === triangulo){
    const area = (poligono.base * poligono.altura)/2;
    return `El area del triangulo es ${area}`;
    
  }else if(poligono === rectangulo){
    const area = poligono.base * poligono.altura;
    return `El area del rectangulo es ${area}`;
  
  }else if(poligono === cuadrado){
    area = poligono.lado ** 2;
    return `El area del cuadrado es ${area}`
  
  }else{
    return "Poligono no soportado";
  }
  
}

const triangulo = {
 base: 4,
 altura: 2,
}

const rectangulo = {
 base: 6,
 altura: 4,
}

const cuadrado = {
 lado: 4,
}

const pentagono = {
 base: 3,
}

console.log(calcularAreaPoligono(triangulo));
console.log(calcularAreaPoligono(rectangulo));
console.log(calcularAreaPoligono(cuadrado));
console.log(calcularAreaPoligono(pentagono));