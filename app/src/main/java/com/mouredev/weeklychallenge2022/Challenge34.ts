let numbers: number[] = [2, 4, 12, 24];
let lostNumbers: number[] = [];

const isNumbersTypeArray = (arrayNumber: number[]): boolean => arrayNumber.every(number => !isNaN(number) && typeof number !== 'string');

function checkNumbersArray(arrayNumbers: number[], lostNumbers: number[]): void {
    for(let i: number = 0; i < numbers.length; i++){
        if(!isNumbersTypeArray(arrayNumbers)) throw 'El Array no contiene enteros';
        if(numbers[i] > numbers[i+1]) throw 'Numeros desordenados';
        calculateLostNumbers(lostNumbers, {a: numbers[i], b: numbers[i+1]});
    }
}

function calculateLostNumbers(numbersBetween: number[], {a, b}: {a: number, b: number}): void{
    for(let i = a + 1; i < b; i++){
        numbersBetween.push(i);
    }
}

checkNumbersArray(numbers, lostNumbers);
console.log(lostNumbers);
