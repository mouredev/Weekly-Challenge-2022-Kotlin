// Instrucciones de ejecución disponibles en Challenge32.js

const secondBiggest = require("./Challenge32");

const test = {
  input: [
    [3, 36, 23, 61, 12, 23],
    [82, 1, 5, 12, 3, 3, 4, 4],
    [78, 23, 8, 8, 9, 10, 12, 1, 0, -1],
    [1, 2, 3, 4, 5, 6, 7, 9, 8],
  ],
  output: [36, 12, 23, 8],
};

test.input.forEach((element, index) => {
  console.log(
    `\n\noriginal: ${element} \nsecond biggest: ${secondBiggest.func(
      element
    )} \nexpected: ${test.output[index]}`
  );
});
