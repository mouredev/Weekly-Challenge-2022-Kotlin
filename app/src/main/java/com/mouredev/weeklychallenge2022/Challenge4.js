
/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 */

class Poligono{
    constructor(){}
    static area(){}
}

class Triangulo extends Poligono{
    constructor(){
        return super.area();
    }
    static area(base, altura){
        this.base = base;
        this.altura = altura;
        return console.log(`El Área del Triángulo es: ${(this.base*this.altura)/2}`);
    }
}

class Cuadrado extends Poligono{
    constructor(){
        return super.area();
    }
    static area(lado){
        this.lado = lado;
        return console.log(`El Área del Cuadrado es: ${this.lado*this.lado}`);
    }
}

class Rectangulo extends Poligono{
    constructor(){
        return super.area();
    }
    static area(alto, ancho){
        this.alto = alto;
        this.ancho = ancho;
        return console.log(`El Área del Rectángulo es: ${this.alto*this.ancho}`);
    }
}

const areaPoligono = poligono =>{ return Poligono.area(poligono);} 

areaPoligono(Triangulo.area(12, 15));
areaPoligono(Cuadrado.area(8));
areaPoligono(Rectangulo.area(7, 4));

