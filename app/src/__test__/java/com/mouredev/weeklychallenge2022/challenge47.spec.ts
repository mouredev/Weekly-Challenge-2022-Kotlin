import { describe, it, expect } from '@jest/globals';

import mostRepeatedVowel from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge47';

describe('Challenge 47', () => {
  it('should return the most common vowel', () => {
    expect(mostRepeatedVowel('aaaaaeeeeiiioou')).toStrictEqual(['a']);
  });

  it('should return the most common vowel regardless of the accent', () => {
    expect(mostRepeatedVowel('AáaaaEeeeIiiOoU')).toStrictEqual(['a', 'e']);
  });

  it('should return the most common vowel regardless of the order', () => {
    expect(mostRepeatedVowel('eeeeiiioouaaaaa')).toStrictEqual(['a']);
  });

  it('must return the most common vowel regardless of accent or other character.', () => {
    expect(mostRepeatedVowel('.-Aá?aaaBbEeeweIiiOoU:')).toStrictEqual(['a', 'e']);
  });
  it('must return the most common vowel regardless of accent, space or other character.', () => {
    expect(mostRepeatedVowel('.-Aá?aaa BbEeew eIiiOoU:')).toStrictEqual(['a', 'e']);
  });

  it('should return all vowels', () => {
    expect(mostRepeatedVowel('aeiou')).toEqual(['a', 'e', 'i', 'o', 'u']);
  });

  it('should return an empty array', () => {
    expect(mostRepeatedVowel('brp qyz')).toEqual([]);
  });
});
