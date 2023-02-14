/*
 * Code available in Challenge41.js
 * run: node Challenge41_test.js
 */

const ohm = require("./Challenge41");

const tests = {
  input: [
    ["1", "2.0", ""],
    ["", "2", "3"],
    ["1.2", "", "3.44"],
    ["", "", "3"],
    ["1", "2", "3"],
    ["1a", "", "3"],
    ["1.0", "ala", ""],
  ],
  output: [
    { var: "resistance", val: 0.5 },
    { var: "voltage", val: 6.0 },
    { var: "current", val: 0.35 },
    "Invalid values",
    "Invalid values",
    "Invalid values",
    "Invalid values",
  ],
};

tests.input.forEach((test, index) => {
  console.log("\noriginal:", test);
  console.log(ohm.func(test));
  console.log("expected: ", tests.output[index]);
});
