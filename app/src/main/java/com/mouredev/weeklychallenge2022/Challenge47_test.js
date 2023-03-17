const maxVowels = require("./Challenge47");

const tests = {
  input: [
    "The quick brown fox jumps over the lazy dog",
    "",
    "th nm f ths src fl",
    "a bird up, not he",
    "THE QUICK BROWN FOX JUMPS over the lazy dog",
    "AQUÍ habrá una TELEVISIÓN de México y ahí está él a gusto",
  ],
  output: ["o", "", "", "a", "o", "a"],
};

let errors = 0;
tests.input.forEach((test, index) => {
  const testFunction = maxVowels.func(test);
  const expected = tests.output[index];
  if (testFunction != expected) {
    errors += 1;
    console.log("\noriginal:", test);
    console.log(testFunction);
    console.log("expected: ", expected);
  }
});

console.log(`Tests${errors != 0 ? " not " : " "}passed, ${errors} errors`);
