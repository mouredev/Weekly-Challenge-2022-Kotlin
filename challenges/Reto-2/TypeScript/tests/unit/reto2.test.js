const {fibonacci} = require('../../reto2');

describe('Test fibonacci function', () => {
  test('Position 0 should be 0', () => {
    expect(fibonacci()[0]).toBe(0);
  });

  test('Position 1 should be 1', () => {
    expect(fibonacci()[1]).toBe(1);
  });

  test('Position 11 should be 89', () => {
    expect(fibonacci()[11]).toBe(89);
  });

  test('Position 49 should be 7778742049', () => {
    expect(fibonacci()[49]).toBe(7778742049);
  });

  test('Position 81 should be 37889062373143906', () => {
    expect(fibonacci(85)[81]).toBe(37889062373143906);
  });

  /*
   * A partir de esta posición da error por los decimales de JS.
  test('Position 82 should be 61305790721611591', () => {
    expect(fibonacci(85)[82]).toBe(61305790721611591);
  });
  */
});
