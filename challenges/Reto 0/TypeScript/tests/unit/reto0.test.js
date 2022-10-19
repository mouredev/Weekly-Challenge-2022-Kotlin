const {resultPrint} = require('../../reto0');

describe('Probar función "resultPrint"', () => {
  test('3 es "fizz"', () => {
    expect(resultPrint(3)).toBe('fizz');
  });

  test('7 es "7"', () => {
    expect(resultPrint(7)).toBe('7');
  });

  test('15 es "fizzbuzz"', () => {
    expect(resultPrint(15)).toBe('fizzbuzz');
  });

  test('70 es "buzz"', () => {
    expect(resultPrint(70)).toBe('buzz');
  });
});
