const karaca = require("./Challenge50");

const tests = {
  input: [
    { input: "apple", func: "encryption" },
    { input: "0n0n0baca", func: "decryption" },
    { input: "this is a long sentence", func: "encryption" },
    { input: "t0htaca s0waca 0aca gn3laca 1cn1tn1saca", func: "decryption" },
    { input: "this is a long sentence", func: "decryption" },
    { input: "t0htaca s0waca 0 gn3laca 1cn1tn1saca", func: "decryption" },
  ],
  output: [
    "1lpp0aca",
    "banana",
    "s2htaca s2aca 0aca gn3laca 1cn1tn1saca",
    "that was a long sentence",
    "not encrypted input",
    "not encrypted input",
  ],
};

let errors = 0;
tests.input.forEach((test, index) => {
  const testFunction = karaca.func(test);
  const expected = tests.output[index];
  if (testFunction != expected) {
    errors += 1;
    console.log("\noriginal:", test);
    console.log(testFunction);
    console.log("expected:", expected);
  }
});

console.log(`Tests${errors != 0 ? " not " : " "}passed, ${errors} errors`);
