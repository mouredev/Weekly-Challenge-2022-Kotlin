import chai from "chai";

import { before } from "mocha";

import getDiffBetweenTwoGames from "../weekly-challenges/weekly-challenge-37/weekly-challenge-37.js";
import zeldaJSON from "../weekly-challenges/weekly-challenge-37/zeldas.json" assert { type: "json" };

const expect = chai.expect;
const allZeldaInfo = zeldaJSON.data.sort(
  (a, b) => new Date(a.released_date) - new Date(b.released_date)
);
describe("getDiffBetweenTwoGames", function () {
  it("should return 34 years and 84 days when entering first (1986) and last (2020) zelda game", () => {
    const enteredGameOlder = allZeldaInfo[0];
    const enteredGameNewer = allZeldaInfo[allZeldaInfo.length - 1];

    const expectedResult = getDiffBetweenTwoGames(
      enteredGameOlder,
      enteredGameNewer
    );
    expect(expectedResult.years).to.equal(34);
    expect(expectedResult.days).to.equal(92);
  });

  it("should return 18 years and 105 days filtering Ocarina of Time (1998) and Breath of the Wild (2017) zelda game", () => {
    const enteredGameOlder = allZeldaInfo.filter(
      (game) => game.name === "The Legend of Zelda: Ocarina of Time"
    )[0];
    const enteredGameNewer = allZeldaInfo.filter(
      (game) => game.name === "The Legend of Zelda: Breath of the Wild"
    )[0];

    const expectedResult = getDiffBetweenTwoGames(
      enteredGameOlder,
      enteredGameNewer
    );
    expect(expectedResult.years).to.equal(18);
    expect(expectedResult.days).to.equal(110);
  });

  it("should return 8 years and 26 days filtering The Legend of Zelda: Phantom Hourglass (October 1, 2007) and The Legend of Zelda: Tri Force Heroes (October 23, 2015) zelda game", () => {
    const enteredGameOlder = allZeldaInfo.filter(
      (game) => game.name === "The Legend of Zelda: Tri Force Heroes"
    )[0];
    const enteredGameNewer = allZeldaInfo.filter(
      (game) => game.name === "The Legend of Zelda: Phantom Hourglass"
    )[0];

    const expectedResult = getDiffBetweenTwoGames(
      enteredGameOlder,
      enteredGameNewer
    );
    expect(expectedResult.years).to.equal(8);
    expect(expectedResult.days).to.equal(26);
  });
});
