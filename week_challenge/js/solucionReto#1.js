"use strict";
const isAnagrama = (word, wordTwo) => {
    if (word.length !== wordTwo.length)
        return false;
    const wordSorted = word.toLowerCase().split('').sort((a, b) => a > b ? 1 : -1).join('');
    const wordTwoSorted = wordTwo.toLowerCase().split('').sort((a, b) => a > b ? 1 : -1).join('');
    return wordSorted === wordTwoSorted ? true : false;
};
console.log(isAnagrama('Acuerdo', 'icuador'));
