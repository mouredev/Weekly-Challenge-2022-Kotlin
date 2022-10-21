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
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var PolygonAbstract = /** @class */ (function () {
    function PolygonAbstract(namePolygon) {
        this.namePolygon = namePolygon;
    }
    PolygonAbstract.prototype.printArea = function () {
        console.log("El \u00E1rea del ".concat(this.namePolygon, " es: ").concat(this.area, "."));
    };
    return PolygonAbstract;
}());
var TriangleAbstract = /** @class */ (function (_super) {
    __extends(TriangleAbstract, _super);
    function TriangleAbstract(base, height) {
        var _this = _super.call(this, 'triángulo') || this;
        _this.base = base;
        _this.height = height;
        return _this;
    }
    Object.defineProperty(TriangleAbstract.prototype, "area", {
        get: function () {
            return (this.base * this.height) / 2;
        },
        enumerable: false,
        configurable: true
    });
    return TriangleAbstract;
}(PolygonAbstract));
var RectangleAbstract = /** @class */ (function (_super) {
    __extends(RectangleAbstract, _super);
    function RectangleAbstract(base, height) {
        var _this = _super.call(this, 'rectángulo') || this;
        _this.base = base;
        _this.height = height;
        return _this;
    }
    Object.defineProperty(RectangleAbstract.prototype, "area", {
        get: function () {
            return this.base * this.height;
        },
        enumerable: false,
        configurable: true
    });
    return RectangleAbstract;
}(PolygonAbstract));
var SquareAbstract = /** @class */ (function (_super) {
    __extends(SquareAbstract, _super);
    function SquareAbstract(side) {
        var _this = _super.call(this, 'cuadrado') || this;
        _this.side = side;
        return _this;
    }
    Object.defineProperty(SquareAbstract.prototype, "area", {
        get: function () {
            return this.side * this.side;
        },
        enumerable: false,
        configurable: true
    });
    return SquareAbstract;
}(PolygonAbstract));
var polygonsAbstract = [
    new TriangleAbstract(3, 7),
    new RectangleAbstract(8, 4),
    new SquareAbstract(5),
];
polygonsAbstract.forEach(function (polygon) { return polygon.printArea(); });
