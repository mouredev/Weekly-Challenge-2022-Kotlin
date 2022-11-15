const robotPosition = require("./Challenge46");

const tests = {
  input: [
    [10, 5, -2],
    [0, 0],
    [10, 10, 10, 10],
    [5, 10, -5, 10],
    [10, -5, 10, 5],
    [],
  ],
  output: [
    { x: -5, y: 12 },
    { x: 0, y: 0 },
    { x: 0, y: 0 },
    { x: 0, y: 10 },
    { x: 10, y: 0 },
    { x: 0, y: 0 },
  ],
};

let errors = 0;
tests.input.forEach((test, index) => {
  const testFunction = robotPosition.func(test);
  const expected = tests.output[index];
  if (JSON.stringify(testFunction) != JSON.stringify(expected)) {
    errors += 1;
    console.log("\noriginal:", test);
    console.log(testFunction);
    console.log("expected:", expected);
  }
});

console.log(`Tests${errors != 0 ? " not " : " "}passed, ${errors} errors`);
