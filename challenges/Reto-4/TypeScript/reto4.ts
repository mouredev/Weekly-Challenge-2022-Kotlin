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

interface Polygon {
  printArea(): void;
  getArea(): number;
}

export class Triangle implements Polygon {
  constructor(private base: number, private height: number) {}

  public getArea(): number {
    return (this.base * this.height) / 2;
  }

  public printArea(): void {
    console.log(`El área del triángulo es de ${this.getArea()}.`);
  }
}

export class Rectangle implements Polygon {
  constructor(private base: number, private height: number) {}

  public getArea(): number {
    return this.base * this.height;
  }

  public printArea(): void {
    console.log(`El área del rectángulo es de ${this.getArea()}.`);
  }
}

export class Square implements Polygon {
  constructor(private side: number) {}

  public getArea(): number {
    return this.side * this.side;
  }

  public printArea(): void {
    console.log(`El área del cuadrado es de ${this.getArea()}.`);
  }
}

const polygons = [new Triangle(3, 7), new Rectangle(8, 4), new Square(5)];

polygons.forEach((polygon) => polygon.printArea());
