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
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

class Polygon { // parent class
    // protected atributes
    _base;
    _height;
    // parent constructor
    constructor(b, h){
        this._base = b;
        this._height = h;
    }
    // method
    area(){
        return this._base * this._height;
    }
}

class Triangle extends Polygon { // child class
    constructor(b, h) {
        super(b,h); // to use the parent's constructor
    }
    area(){
        return (this._base * this._height) / 2; // the area of a triangle
    }
}

class Square extends Polygon { // child class
    constructor(b){
        super(b,b); // to use the parent's constructor
    }
    area(){
        return super.area(); // to use the parent's area() method
    }
}

class Rectangle extends Polygon { // child class
    constructor(b, h){
        super(b,h); // to use the parent's constructor
    }
    area(){
        return super.area(); // to use the parent's area() method
    }
}

// ONE FUNCTION that receives one polygon and returns its area
function printArea(polygon){
    return polygon.area();
}

// calculate the area of the following polygons:
console.log(printArea(new Triangle(4,5))); // 10
console.log(printArea(new Square(5))); // 25
console.log(printArea(new Rectangle(25,4))); // 100