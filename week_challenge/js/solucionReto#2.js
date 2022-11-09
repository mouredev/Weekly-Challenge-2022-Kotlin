"use strict";
const fib = () => {
    let index = 0;
    let next = 1;
    while (next < 50) {
        console.log(index);
        let fib = index + next;
        index = next;
        next = fib;
    }
};
fib();
