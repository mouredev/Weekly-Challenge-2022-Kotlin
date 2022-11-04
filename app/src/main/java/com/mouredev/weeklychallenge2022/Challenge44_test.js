const boomerangFind = require("./Challenge44");

const tests = {
  input: [
    [3, 2, 2, 1, 2],
    [5, 4, 3, 2, 3, 2, 1, 5, 2, 8],
    [72, 1, 1, 6, 2, -1, 7],
    [1, 5, 3, 2, 3, 2, 5, 4],
    [],
  ],
  output: [
    { nro: 1, boomerangs: [[2, 1, 2]] },
    {
      nro: 2,
      boomerangs: [
        [3, 2, 3],
        [2, 3, 2],
      ],
    },
    { nro: 0, boomerangs: [] },
    {
      nro: 2,
      boomerangs: [
        [3, 2, 3],
        [2, 3, 2],
      ],
    },
    { nro: 0, boomerangs: [] },
  ],
};

let errors = 0;
tests.input.forEach((test, index) => {
  const testFunction = boomerangFind.func(test);
  const expected = tests.output[index];
  if (JSON.stringify(expected) != JSON.stringify(testFunction)) {
    errors += 1;
    console.log("\noriginal: ", test);
    console.log(testFunction);
    console.log("expected:", expected);
  }
});

console.log(`Tests ${errors != 0 ? "not" : ""} passed. ${errors} errors`);
