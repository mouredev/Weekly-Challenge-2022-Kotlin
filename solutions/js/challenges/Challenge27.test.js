const { areOrthogonal } = require('./Challenge27');

describe('check if vectors in 2D are orthogonal', () => {
  test('Are orthogonal', () => {
    expect(areOrthogonal([1, 2], [-2, 1])).toBe(true);
  });

  test('Are not orthogonal', () => {
    expect(areOrthogonal([2, 9], [-1, 2])).toBe(false);
  });
});