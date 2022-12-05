const advent = require("./Challenge48");

const tests = {
  input: [
    new Date("2022-12-12T12:34:52+01:00"),
    new Date("2020-11-12T10:20:32+00:00"),
    new Date("2022-12-30T17:08:00+00:00"),
    new Date("2022-12-23T00:34:12-05:00"),
    new Date("2010-12-23T00:34:12+01:00"),
    new Date("2030-12-23T00:34:12+14:00"),
  ],
  output: [
    {
      gift: ["ebooks", "ecourses", "games"],
      timeLeft: {
        years: 0,
        months: 0,
        days: 0,
        hours: 12,
        minutes: 25,
        seconds: 7,
      },
    },
    {
      timeLeft: {
        years: 2,
        months: 0,
        days: 18,
        hours: 12,
        minutes: 39,
        seconds: 28,
      },
    },
    {
      timeLeft: {
        years: 0,
        months: 0,
        days: 5,
        hours: 18,
        minutes: 8,
        seconds: 1,
      },
    },
    {
      gift: ["ebooks", "ecourses", "games"],
      timeLeft: {
        years: 0,
        months: 0,
        days: 0,
        hours: 18,
        minutes: 25,
        seconds: 47,
      },
    },
    {
      timeLeft: {
        years: 11,
        months: 11,
        days: 8,
        hours: 23,
        minutes: 25,
        seconds: 48,
      },
    },
    {
      timeLeft: {
        years: 7,
        months: 11,
        days: 27,
        hours: 11,
        minutes: 34,
        seconds: 13,
      },
    },
  ],
};

let errors = 0;
tests.input.forEach((test, index) => {
  const testFunction = advent.func(test);
  const expected = tests.output[index];
  const gift = testFunction.gift;
  if (gift) {
    if (!expected.gift.includes(gift)) {
      errors += 1;
      console.log("\noriginal: ", test);
      console.log(testFunction);
      console.log("\nexpected:", expected);
    }
  }
  if (
    JSON.stringify(testFunction.timeLeft) != JSON.stringify(expected.timeLeft)
  ) {
    errors += 1;
    console.log("\noriginal: ", test);
    console.log(testFunction);
    console.log("expected: ", expected);
  }
});

console.log(`Tests${errors != 0 ? " not " : " "}passed, ${errors} errors`);
