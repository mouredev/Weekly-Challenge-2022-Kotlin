import chai from "chai";
import vendingMachine from "../weekly-challange-28.js";

const expect = chai.expect;

describe("vendingMachine", function () {
  it("expect to return 'Product not found'", () => {
    const enteredMoney = []; //145
    const enteredProduct = null;
    const vendingMachineResult = vendingMachine(enteredMoney, enteredProduct);
    expect(vendingMachineResult.name).to.equal("Product not found");
  });

  it("expect to return 'Not enought money'", () => {
    const enteredMoney = [5, 10, 50, 5, 5, 5];
    const enteredProduct = 12;
    const vendingMachineResult = vendingMachine(enteredMoney, enteredProduct);
    expect(vendingMachineResult.name).to.equal("Not enought money");
    expect(vendingMachineResult.change).to.equal(enteredMoney);
  });
  it("expect to return 'Entered money is not valid'", () => {
    const enteredMoney = [5, 10, 20, 50, 5, 5, 5];
    const enteredProduct = 12;
    const vendingMachineResult = vendingMachine(enteredMoney, enteredProduct);
    expect(vendingMachineResult.name).to.equal("Entered money is not valid");
    expect(vendingMachineResult.change).to.equal(enteredMoney);
  });
  it("expect to return 'Coffee' and 4 coins of 200 entering 800 and 12", () => {
    const coinsOfFive = [
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
    ];
    const coinsOfTen = [
      10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
    ];
    const coinsOfFifty = [50, 50, 50, 50, 50, 50, 50, 50];

    const enteredMoney = coinsOfFifty.concat(coinsOfTen).concat(coinsOfFive);
    const enteredProduct = 12;
    let vendingMachineResult = vendingMachine(enteredMoney, enteredProduct);
    expect(vendingMachineResult.name).to.equal("Coffee");

    expect(vendingMachineResult.change).to.deep.equal([
      {
        coin: 200,
        amount: 3,
      },
      {
        coin: 100,
        amount: 1,
      },
    ]);
  });

  it("expect to return 'Coffee' and 4 coins of 10 and 1 coin of 5 entering 145 and 12", () => {
    const enteredMoney = [5, 10, 50, 5, 5, 5, 5, 5, 5, 50]; //145
    const enteredProduct = 12;
    const vendingMachineResult = vendingMachine(enteredMoney, enteredProduct);
    expect(vendingMachineResult.name).to.equal("Coffee");
    const expectedChangeValue = [
      {
        coin: 10,
        amount: 4,
      },
      {
        coin: 5,
        amount: 1,
      },
    ];
    expect(vendingMachineResult.change).to.deep.equal(expectedChangeValue);
  });
  it("expect to return 'Energy Bar' and 1 coin of 200, 1  coin of 50, 3 coin of 10 and 1 coin of 5, entering 840 and 35", () => {
    const coinsOfFive = [
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
    ];
    const coinsOfTen = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10];
    const coinsOfFifty = [50, 50, 50, 50, 50, 50, 50, 50, 50];

    const enteredMoney = coinsOfFifty.concat(coinsOfTen).concat(coinsOfFive);
    const enteredProduct = 35;

    const vendingMachineResult = vendingMachine(enteredMoney, enteredProduct);
    expect(vendingMachineResult.name).to.equal("Energy Bar");
    const expectedChangeValue = [
      {
        coin: 200,
        amount: 1,
      },
      {
        coin: 50,
        amount: 1,
      },
      {
        coin: 10,
        amount: 3,
      },
      {
        coin: 5,
        amount: 1,
      },
    ];
    expect(vendingMachineResult.name).to.equal("Energy Bar");
    expect(vendingMachineResult.change).to.deep.equal(expectedChangeValue);
  });
  it("expect to return 'Coke Drink' and 1 coin of 200, 1  coin of 50, 3 coin of 10 and 1 coin of 5, entering 840 and 40", () => {
    const coinsOfFive = [
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
    ];
    const coinsOfTen = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10];
    const coinsOfFifty = [50, 50, 50, 50, 50, 50, 50, 50, 50];

    const enteredMoney = coinsOfFifty.concat(coinsOfTen).concat(coinsOfFive);
    const enteredProduct = 40;

    const vendingMachineResult = vendingMachine(enteredMoney, enteredProduct);
    const expectedChangeValue = [
      {
        coin: 100,
        amount: 1,
      },
      {
        coin: 10,
        amount: 3,
      },
    ];
    expect(vendingMachineResult.name).to.equal("Coke Drink");
    expect(vendingMachineResult.change).to.deep.equal(expectedChangeValue);
  });
  it("expect to return 'Energy Drink' and 7 coins of 200, 1 coin of 100, 2 coins of 10 and 1 coin of 5, entering 1680 and 40", () => {
    const coinsOfFive = [
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
    ];
    const coinsOfTen = [
      10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
      10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
    ];
    const coinsOfFifty = [
      50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
    ];

    const enteredMoney = coinsOfFifty.concat(coinsOfTen).concat(coinsOfFive);
    const enteredProduct = 17;

    const vendingMachineResult = vendingMachine(enteredMoney, enteredProduct);
    const expectedChangeValue = [
      {
        coin: 200,
        amount: 7,
      },
      {
        coin: 100,
        amount: 1,
      },
      {
        coin: 10,
        amount: 2,
      },
      {
        coin: 5,
        amount: 1,
      },
    ];
    expect(vendingMachineResult.name).to.equal("Energy Drink");
    expect(vendingMachineResult.change).to.deep.equal(expectedChangeValue);
  });

  it("expect to return 'Entered money is not valid', entering 1680 and 40", () => {
    const coinsOfFive = [
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
      5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
    ];
    const coinsOfTen = [
      10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
      10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
    ];
    const coinsOfFifty = [
      50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
    ];

    const enteredMoney = coinsOfFifty
      .concat(coinsOfTen)
      .concat(coinsOfFive)
      .concat([20, 30, 40, 50, 60, 70]);
    const enteredProduct = 17;

    const vendingMachineResult = vendingMachine(enteredMoney, enteredProduct);
    const expectedChangeValue = enteredMoney;
    expect(vendingMachineResult.name).to.equal("Entered money is not valid");
    expect(vendingMachineResult.change).to.deep.equal(expectedChangeValue);
  });
});
