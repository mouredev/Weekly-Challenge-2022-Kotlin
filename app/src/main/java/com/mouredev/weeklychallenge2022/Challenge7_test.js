// Instrucciones de ejecución disponibles en Challenge7.js

const stringCount = require("./Challenge7");

tests = {
  input: [
    "Here goes some text",
    "AQUÍ VA TEXTO AQUÍ",
    "Aquí! no aquí completos!",
    "Hola, mi nombre es carlos. Mi nombre completo es Carlos Ayala (test1)",
  ],
  output: [
    { here: 1, goes: 1, some: 1, text: 1 },
    { aquí: 2, va: 1, texto: 1 },
    { aquí: 2, no: 1, completos: 1 },
    {
      hola: 1,
      mi: 2,
      nombre: 2,
      es: 2,
      carlos: 2,
      completo: 1,
      ayala: 1,
      test1: 1,
    },
  ],
};

tests.input.forEach((test, index) => {
  console.log(`\noriginal: ${test}`);
  resp = stringCount.func(test);
  for (let key in resp) {
    console.log(
      `${key} se ha repetido ${resp[key]} ${resp[key] > 1 ? "veces" : "vez"}`
    );
  }
  console.log(`expected: ${tests.output[index]}`);
});
