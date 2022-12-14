const {isAnagram} = require('../../reto1');

describe('Test "isAnagram" function', () => {
  test('1st anagram: false', () => {
    expect(isAnagram('alo', 'hola')).toBeFalsy();
  });

  test('2nd anagram: Lord Voldemort', () => {
    expect(isAnagram('I am Lord Voldemort', 'Tom Marvolo Riddle')).toBeTruthy();
  });

  test('3rd anagram: Patria', () => {
    expect(isAnagram('Patria', 'pirata')).toBeTruthy();
  });

  test('4th anagram: alegría (acento)', () => {
    expect(isAnagram('alegría', 'Algeria')).toBeTruthy();
  });

  test('5th anagram: false', () => {
    expect(isAnagram('love', 'amor')).toBeFalsy();
  });
});
