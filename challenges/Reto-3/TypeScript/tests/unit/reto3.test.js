const {isPrimeNumber} = require('../../reto3');

describe('Test "isPrimeNumber" function', () => {
  test('1 not is prime', () => {
    expect(isPrimeNumber(1)).toBeFalsy();
  });

  test('2 is prime', () => {
    expect(isPrimeNumber(2)).toBeTruthy();
  });

  test('7 is prime', () => {
    expect(isPrimeNumber(7)).toBeTruthy();
  });

  test('11 is prime', () => {
    expect(isPrimeNumber(2)).toBeTruthy();
  });

  test('54 not is prime', () => {
    expect(isPrimeNumber(54)).toBeFalsy();
  });

  test('71 is prime', () => {
    expect(isPrimeNumber(71)).toBeTruthy();
  });

  test('97 is prime', () => {
    expect(isPrimeNumber(97)).toBeTruthy();
  });

  test('98 not is prime', () => {
    expect(isPrimeNumber(98)).toBeFalsy();
  });
});
