const binaryToDecimal = require("./Challenge38.js");

const tests = {
  input: ["00010101", "1111", "0000", "10100101", "00000001"],
  output: [21, 15, 0, 165, 1],
};

tests.input.forEach((test, index) => {
  console.log("\noriginal:", test);
  console.log(binaryToDecimal.func(test));
  console.log("expected:", tests.output[index]);
});
