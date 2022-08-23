const calculateArea = require("./Challenge4");

const test = {
  input: [
    ["triangle", 10, 10],
    ["rectangle", 10, 10],
    ["square", 10],
    ["rectangle", 5, 5],
    ["triangle", 10, 5],
  ],
};

test.input.forEach((element) => {
  console.log(`${element[0]} area: ${calculateArea.func(...element)}`);
});
