// Instrucciones de ejecución disponible en Challenge34.js

const lostNumbers = require("./Challenge34");

let tests = {
  input: [
    [1, 2, 3, 6, 8, 10],
    [2, 3, 6, 10],
    [10, 20],
    [5, 4, 2, 1],
    [1, "a", "b", "z"],
    [],
    5,
  ],
  output: [
    [4, 5, 7, 9],
    [4, 5, 7, 8, 9],
    [11, 12, 13, 14, 15, 16, 17, 18, 19],
    "Not correct input",
    "Not correct input",
    "Not correct input",
    "Not correct input",
  ],
};

tests.input.forEach((test, index) => {
  console.log(`\noriginal: ${test}`);
  console.log(`${lostNumbers.func(test)}`);
  console.log(`expected: ${tests.output[index]}`);
});
