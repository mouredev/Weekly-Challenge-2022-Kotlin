import chai from "chai";
import sort from "../weekly-challenges/weekly-challenge-29.js";

const expect = chai.expect;

describe("sort", function () {
  it("expect to return empty array when not entering array as input", () => {
    const enteredArray = [];
    const enteredOption = null;
    const sortResult = sort(enteredArray, enteredOption);
    expect(sortResult).to.deep.equal(enteredArray);
  });

  it("expect to return ordered array when inputting [8, 2, 4, 6, 9] and enteredOption as Asc", () => {
    const enteredArray = [8, 2, 4, 6, 9];
    const enteredOption = "Asc"; //Ascending order, min then max
    const sortResult = sort(enteredArray, enteredOption);
    expect(sortResult).to.deep.equal(enteredArray.sort((a, b) => a - b));
  });

  it("expect to return ordered array when inputting [8, 2, 4, 6, 9] and enteredOption as Desc", () => {
    const enteredArray = [8, 2, 4, 6, 9];
    const enteredOption = "Desc"; //Descending order, max to min
    const sortResult = sort(enteredArray, enteredOption);
    expect(sortResult).to.deep.equal(enteredArray.sort((a, b) => b - a));
  });

  it("expect to return ordered array when inputting [4, 8, 6, 2, 9, 44, 8] and enteredOption as Asc", () => {
    const enteredArray = [4, 8, 6, 2, 9, 44, 8];
    const enteredOption = "Asc"; //Ascending order, min then max
    const sortResult = sort(enteredArray, enteredOption);
    expect(sortResult).to.deep.equal(enteredArray.sort((a, b) => a - b));
  });

  it("expect to return ordered array when inputting [4, 8, 6, 2, 9, 44, 8] and enteredOption as Asc", () => {
    const enteredArray = [4, 8, 6, 2, 9, 44, 8];
    const enteredOption = "Desc"; //Ascending order, min then max
    const sortResult = sort(enteredArray, enteredOption);
    expect(sortResult).to.deep.equal(enteredArray.sort((a, b) => b - a));
  });

  it("expect to return ordered array when inputting [345, 34, 76, 865, 3456, 346, 2345, 4531, 154, 1345, 2345, 5674, 3568, 9,9068, 19, 98, 49, 9078, 7098, 9, 41234, 789, 4, 764, 84, 6578, 356724,567, 245, 6243, 513, 451, 345134, 62, 4573, 56, 5789, 5780, 890, 0, 0, 0] and enteredOption as Asc", () => {
    const enteredArray = [
      345, 34, 76, 865, 3456, 346, 2345, 4531, 154, 1345, 2345, 5674, 3568, 9,
      9068, 19, 98, 49, 9078, 7098, 9, 41234, 789, 4, 764, 84, 6578, 356724,
      567, 245, 6243, 513, 451, 345134, 62, 4573, 56, 5789, 5780, 890, 0, 0, 0,
    ];
    const enteredOption = "Asc"; //Ascending order, min then max
    const sortResult = sort(enteredArray, enteredOption);
    expect(sortResult).to.deep.equal(enteredArray.sort((a, b) => a - b));
  });
  it("expect to return ordered array when inputting [345, 34, 76, 865, 3456, 346, 2345, 4531, 154, 1345, 2345, 5674, 3568, 9,9068, 19, 98, 49, 9078, 7098, 9, 41234, 789, 4, 764, 84, 6578, 356724,567, 245, 6243, 513, 451, 345134, 62, 4573, 56, 5789, 5780, 890, 0, 0, 0] and enteredOption as Desc", () => {
    const enteredArray = [
      345, 34, 76, 865, 3456, 346, 2345, 4531, 154, 1345, 2345, 5674, 3568, 9,
      9068, 19, 98, 49, 9078, 7098, 9, 41234, 789, 4, 764, 84, 6578, 356724,
      567, 245, 6243, 513, 451, 345134, 62, 4573, 56, 5789, 5780, 890, 0, 0, 0,
    ];
    const enteredOption = "Desc"; //Ascending order, min then max
    const sortResult = sort(enteredArray, enteredOption);
    expect(sortResult).to.deep.equal(enteredArray.sort((a, b) => b - a));
  });
});
