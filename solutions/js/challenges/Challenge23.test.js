const { getMCD, getMcm } = require('./Challenge23');

describe('get MCD', () => {
  test('get correct mcd', () => {
    expect(getMCD(81, 27)).toBe(27);
    expect(getMCD(8, 12)).toBe(4);
    expect(getMCD(6, 9)).toBe(3);
  });

  test('should throw error', () => {
    expect(() => getMCD(81)).toThrow();
    expect(() => getMCD(-1, 3)).toThrow();
    expect(() => getMCD(-1, '1')).toThrow();
  });
});

describe('get mcm', () => {
  test('get correct mcm', () => {
    expect(getMcm(180, 324)).toBe(1620);
  });

  test('should throw error', () => {
    expect(() => getMcm(81)).toThrow();
    expect(() => getMcm(-1, 3)).toThrow();
    expect(() => getMcm(-1, '1')).toThrow();
  });
});