// Instrucciones de ejecución disponibles en Challenge7.js

const middleEarthBattle = require("./Challenge36");

const tests = {
  input: [
    [
      [0, 10, 20, 30, 40],
      [40, 30, 20, 10, 0],
    ],
    [
      [50, 40, 30, 20, 10],
      [10, 20, 30, 40, 50],
    ],
    [[10, 10], [30]],
  ],
  output: ["Good wins", "Bad wins", "Tie"],
};

tests.input.forEach((test, index) => {
  console.log("\nOriginal:", test);
  console.log(middleEarthBattle.func(test));
  console.log("Expected:", tests.output[index]);
});
