const triangle = require("./Challenge40.js");

const tests = {
  input: [1, 2, 3, 4, 0],
  output: [
    [[1]],
    [[1], [1, 1]],
    [[1], [1, 1], [1, 2, 1]],
    [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]],
    [],
  ],
};

tests.input.forEach((test, index) => {
  console.log("\noriginal:", test);
  const pascalTriangle = triangle.func(test);
  pascalTriangle;
  console.log("expected: ", tests.output[index]);
});
