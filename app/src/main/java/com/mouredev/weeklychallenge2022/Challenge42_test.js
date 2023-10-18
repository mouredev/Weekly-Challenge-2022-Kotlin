const temperatureConvert = require("./Challenge42");

const tests = {
  input: [
    "-10.1 °C",
    "-10°C",
    "20 °F",
    "20.45°F",
    "0 °C",
    "-0°C",
    "-234 °F",
    "-234.7638°F",
    "125",
    "-234.sdf.23467 °F",
    "-234°F687234F",
  ],
  output: [
    { temp: 13.82, units: "°F" },
    { temp: 14, units: "°F" },
    { temp: -6.666666667, units: "°C" },
    { temp: -6.416666667, units: "°C" },
    { temp: 32, units: "°F" },
    { temp: 32, units: "°F" },
    { temp: -147.77777777, units: "°C" },
    { temp: -148.20211111, units: "°C" },
    { msg: "not valid" },
    { msg: "not valid" },
    { msg: "not valid" },
  ],
};

tests.input.forEach((test, index) => {
  console.log("\noriginal: ", test);
  const newTemp = temperatureConvert.func(test);
  console.log(newTemp);
  console.log("expected:", tests.output[index]);
});
