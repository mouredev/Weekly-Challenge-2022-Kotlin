// solucion reto #4
// Dificultad facil

// ÁREA DE UN POLÍGONO

// Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
// La función recibirá por parámetro sólo UN polígono a la vez.
// Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
// Imprime el cálculo del área de un polígono de cada tipo.


//area del triangulo (b x h) / 2 = a
// area del cuadrado (l x l) = a
// area del rectangulo (b x h) = a

const area = (polygon:string, width:number, heigth:number):void => {

     if (polygon === 'triangulo') {
          console.log(`${polygon}\'s area is: ` + (width * heigth)/2 );
          return
     };
     
     console.log(`${polygon}\'s are is: ` + width * heigth );
};

area('triangulo', 10, 30);
area('cuadrado', 10, 10);
area('rectangulo', 30, 10);

//big(0) time complexity = 0(1)
//big(0) space complexity = 0(1)

