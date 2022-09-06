"use strict";
const isPrime = (number) => {
    let index = 1;
    let result = [];
    for (index; index <= number; index++) {
        let isRemainderZero = number % index === 0;
        if (isRemainderZero)
            result.push(number);
    }
    if (result.length === 2)
        console.log(number);
};
const oneToOneHundred = () => {
    let index = 1;
    while (index <= 100) {
        isPrime(index);
        index++;
    }
};
oneToOneHundred();
