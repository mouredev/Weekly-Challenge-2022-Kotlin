// Instrucciones de ejecución disponible en Challenge33.js

const chineseYearCycle = require("./Challenge33");

const tests = {
  input: [
    1924,
    1970,
    1978,
    1910,
    1990,
    1850,
    2060,
    10,
    60,
    1750,
    2160,
    -1,
    "test",
    0,
    -246,
    4,
    1,
    2,
    3,
  ],
  output: [
    { animal: "rat", element: "wood" },
    { animal: "dog", element: "metal" },
    { animal: "horse", element: "earth" },
    { animal: "dog", element: "metal" },
    { animal: "horse", element: "metal" },
    { animal: "dog", element: "metal" },
    { animal: "dragon", element: "metal" },
    { animal: "horse", element: "metal" },
    { animal: "monkey", element: "metal" },
    { animal: "horse", element: "metal" },
    { animal: "monkey", element: "metal" },
    { animal: "monkey", element: "metal" },
    { msg: "test no es un año válido" },
    { msg: "0 no es un año válido" },
    { animal: "rabbit", element: "wood" },
    { animal: "rat", element: "wood" },
    { animal: "rooster", element: "metal" },
    { animal: "dog", element: "water" },
    { animal: "pig", element: "water" },
  ],
};

tests.input.forEach((test, index) => {
  const chineseCycle = chineseYearCycle.func(test);
  if (chineseCycle["msg"]) {
    console.log(`\n${test}: no es un año válido`);
  } else {
    console.log(
      `\n${test}: ${chineseCycle["animal"]} - ${chineseCycle["element"]}`
    );
  }
  console.log("expected:", tests["output"][index]);
});
