const { calculateFromFile, calculateData } = require('./Challenge21');

describe('Challenge21', () => {
  it('should return the result of the operations included in the sample file', () => {
    expect(calculateFromFile('../../app/src/main/java/com/mouredev/weeklychallenge2022/Challenge21.txt')).toBe(-14);
  });

  it('should return the result of the sample operations', () => {
    expect(calculateData(['3', '+', '2', '*', '2', '-', '1'])).toBe(6);
    expect(calculateData(['3.2', '+', '2', '*', '2', '-', '1'])).toBe(6.2);
  });

  it('should throw error because of invalid data', () => {
    expect(() => calculateData(['3', '+', '2', '*', '2', '-'])).toThrow();
    expect(() => calculateData(['3', '2', '+', '*', '2', '-', '6'])).toThrow();
    expect(() => calculateData(['3', 'hola', '+', '*', '2', '-', '3'])).toThrow();
  });
});