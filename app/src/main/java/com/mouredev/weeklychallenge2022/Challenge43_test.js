// Testing code with possible input

const trickOrTreat = require("./Challenge43");

const tests = {
  input: [
    { option: "trick", children: [{ name: "Javier", age: 10, height: 120 }] },
    {
      option: "treat",
      children: [{ name: "Sebastián", age: 12, height: 140 }],
    },
    {
      option: "trick",
      children: [
        { name: "Sebastián", age: 12, height: 140 },
        { name: "Javier", age: 10, height: 120 },
      ],
    },
    {
      option: "treat",
      children: [
        { name: "Sebastián", age: 12, height: 140 },
        { name: "Javier", age: 10, height: 120 },
      ],
    },
    {
      option: "treat",
      children: [
        { name: "Moe", age: 1, height: 80 },
        { name: "Wolfeschlegelsteinhausenbergerdorff", age: 118, height: 272 },
      ],
    },
    {
      option: "trick",
      children: [
        { name: "Moe", age: 1, height: 80 },
        { name: "Wolfeschlegelsteinhausenbergerdorff", age: 118, height: 272 },
      ],
    },
  ],
  output: [[8], [16], [9, 8], [16, 13], [5, 44], [1, 25]],
};

let errors = 0;
tests.input.forEach((test, index) => {
  const testFunction = trickOrTreat.func(test);
  const testNumber = testFunction.map((elem) => [...elem].length);
  const expected = tests.output[index];
  if (JSON.stringify(testNumber) != JSON.stringify(expected)) {
    errors += 1;
    console.log("\noriginal:", test);
    console.log(testFunction);
    console.log(testNumber);
    console.log("expected: ", expected);
  }
});
if (errors == 0) console.log("Tests passed, 0 errors");
if (errors != 0) console.log("Tests not passed,", errors, "errors");
