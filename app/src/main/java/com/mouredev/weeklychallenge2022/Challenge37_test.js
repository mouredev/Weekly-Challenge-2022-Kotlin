const releaseCounting = require("./Challenge37");

const tests = {
  input: [
    ["19", "18"],
    ["19", "0"],
    ["9", "5"],
    ["3", "10"],
    ["6", "13"],
    ["0", "19"],
    ["5", "5"],
  ],
  output: [
    { years: 6, days: 71 },
    { years: 35, days: 272 },
    { years: 2, days: 361 },
    { years: 10, days: 291 },
    { years: 6, days: 142 },
    { years: 35, days: 272 },
    { years: 0, days: 0 },
  ],
};

tests.input.forEach((test, index) => {
  console.log("\noriginal:", test);
  const resp = releaseCounting.func(test);
  console.log(resp);
  console.log("expected:", tests.output[index]);
});
