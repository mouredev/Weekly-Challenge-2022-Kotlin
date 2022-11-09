"use strict";
const main = () => {
    let index = 0;
    for (index; index <= 100; index++) {
        let isDivisionbyThree = index % 3 === 0;
        let isDivisionByFive = index % 5 === 0;
        if (isDivisionbyThree && isDivisionByFive) {
            console.log('fizzbuzz', index);
        }
        if (isDivisionByFive) {
            console.log('buzz');
        }
        if (isDivisionbyThree) {
            console.log('fizz');
        }
    }
};
main();
