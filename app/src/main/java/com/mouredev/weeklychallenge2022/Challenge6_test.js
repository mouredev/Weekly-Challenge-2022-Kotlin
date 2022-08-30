// Instrucciones de ejecución disponibles en Challenge6.js

const reverseString = require("./Challenge6");

tests = {
  input: ["Hola mundo", "Hello world", "here goes some text to be inverted"],
  output: ["odnum aloH", "dlrow olleH", "detrevni eb ot txet emos seog ereh"],
};

tests.input.forEach((test, index) => {
  console.log(
    `\noriginal: ${test} \nresp: ${reverseString.func(test)} \nexpected: ${
      tests.output[index]
    }`
  );
});
