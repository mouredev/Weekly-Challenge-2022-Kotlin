const {Rectangle, Square, Triangle} = require('../../reto4');

describe('Test "Rectangle" class', () => {
  test('Area of rectangle is 30', () => {
    const rectangle = new Rectangle(10, 3);

    expect(rectangle.getArea()).toBe(30);
  });
});

describe('Test "Square" class', () => {
  test('Area of square is 100', () => {
    const square = new Square(10);

    expect(square.getArea()).toBe(100);
  });
});

describe('Test "Triangle" class', () => {
  test('Area of triangle is 25', () => {
    const triangle = new Triangle(5, 10);

    expect(triangle.getArea()).toBe(25);
  });
});
