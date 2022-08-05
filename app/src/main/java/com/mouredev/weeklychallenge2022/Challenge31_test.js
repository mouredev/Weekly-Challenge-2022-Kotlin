const returnLeapYear = require("./Challenge31");

const test = { input: [4, 20, 1800, 1900, 2100, 2200, 2300, 2500, 2000, 2400] };

test.input.forEach((element) => {
  console.log(`Year: ${element}: \n ${returnLeapYear.func(element)}`);
});
