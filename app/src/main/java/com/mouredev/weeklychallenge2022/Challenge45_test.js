const waterContainers = require("./Challenge45");

const tests = {
  input: [
    [1, 2, 3, 4, 3, 2, 1],
    [4, 0, 0, 0, 4],
    [4, 0, 3, 6, 1, 3],
    [0, 0, 0, 0, 0, 0, 0],
    [],
    [4, 4, 4, 4, 4, 4, 4],
    [0, 1, 2, 1, 0, 1, 0],
    [4, 4, 4, 6, 4, 4, 4],
  ],
  output: [0, 12, 7, 0, 0, 0, 1, 0],
};

let errors = 0;
tests.input.forEach((test, index) => {
  const testFunction = waterContainers.func(test);
  const expected = tests.output[index];
  if (testFunction != expected) {
    errors += 1;
    console.log("\noriginal: ", test);
    console.log(testFunction);
    console.log("expected:", expected);
  }
});
console.log(`Tests${errors != 0 ? " not " : " "}passed, ${errors} errors.`);
