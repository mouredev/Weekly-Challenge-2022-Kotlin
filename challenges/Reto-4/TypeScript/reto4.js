"use strict";
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
Object.defineProperty(exports, "__esModule", { value: true });
exports.Square = exports.Rectangle = exports.Triangle = void 0;
var Triangle = /** @class */ (function () {
    function Triangle(base, height) {
        this.base = base;
        this.height = height;
    }
    Triangle.prototype.getArea = function () {
        return (this.base * this.height) / 2;
    };
    Triangle.prototype.printArea = function () {
        console.log("El \u00E1rea del tri\u00E1ngulo es de ".concat(this.getArea(), "."));
    };
    return Triangle;
}());
exports.Triangle = Triangle;
var Rectangle = /** @class */ (function () {
    function Rectangle(base, height) {
        this.base = base;
        this.height = height;
    }
    Rectangle.prototype.getArea = function () {
        return this.base * this.height;
    };
    Rectangle.prototype.printArea = function () {
        console.log("El \u00E1rea del rect\u00E1ngulo es de ".concat(this.getArea(), "."));
    };
    return Rectangle;
}());
exports.Rectangle = Rectangle;
var Square = /** @class */ (function () {
    function Square(side) {
        this.side = side;
    }
    Square.prototype.getArea = function () {
        return this.side * this.side;
    };
    Square.prototype.printArea = function () {
        console.log("El \u00E1rea del cuadrado es de ".concat(this.getArea(), "."));
    };
    return Square;
}());
exports.Square = Square;
var polygons = [new Triangle(3, 7), new Rectangle(8, 4), new Square(5)];
polygons.forEach(function (polygon) { return polygon.printArea(); });
