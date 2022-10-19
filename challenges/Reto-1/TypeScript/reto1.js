"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.isAnagram = void 0;
const removeAccent = (letter) => {
    const changes = {
        á: 'a',
        é: 'e',
        í: 'i',
        ï: 'i',
        ó: 'o',
        ú: 'u',
        ü: 'u',
    };
    return changes[letter] || letter;
};
const transformWord = (word) => {
    return Array.from(word.toLowerCase().replaceAll(' ', ''), removeAccent)
        .sort()
        .join('');
};
const isAnagram = (firstWord, secondWord) => {
    if (firstWord.toLowerCase() === secondWord.toLowerCase())
        return false;
    const resultFirstWord = transformWord(firstWord);
    const resultSecondWord = transformWord(secondWord);
    return resultFirstWord === resultSecondWord;
};
exports.isAnagram = isAnagram;
