const products = [
  { productName: "Coffee", productCost: 100, productId: 12 },
  { productName: "Potato Chips", productCost: 105, productId: 14 },
  { productName: "Energy Drink", productCost: 155, productId: 17 },
  { productName: "Coke Drink", productCost: 710, productId: 40 },
  { productName: "Energy Bar", productCost: 555, productId: 35 },
];
const legalTenderEuroCoins = [5, 10, 50, 100, 200];

const vendingMachine = (money, productId) => {
  let response = {
    name: "",
    change: [],
  };

  const moneyValidation = money.map((coin) =>
    legalTenderEuroCoins.includes(coin)
  );

  if (moneyValidation.every((validation) => validation)) {
    const sumEnteredMoney = Number.parseFloat(
      money.reduce(
        (previousValue, currentValue) => previousValue + currentValue,
        0
      )
    );

    const desiredProduct = products.find(
      (product) => product.productId === productId
    );

    if (typeof desiredProduct === "undefined")
      response = {
        name: ERRORS.PRODUCT_NOT_FOUND,
        change: money,
      };
    else if (sumEnteredMoney < desiredProduct.productCost) {
      response = {
        name: ERRORS.MONEY_NOT_ENOUGHT,
        change: money,
      };
    } else {
      response.name = desiredProduct.productName;

      const changeTotalMoney = sumEnteredMoney - desiredProduct.productCost;
      let change = (changeTotalMoney / 1).toFixed(2);
      const legalTenderEuroCoinsOrdered = legalTenderEuroCoins.sort(
        (a, b) => b - a
      );
      /**
       * I filter all ordered legal tender coins to only have the ones whose module is less than itself,
       * meaning that it could be a potential coin multiplier
       * For example, I have 45, and 45 % 10 is 5, so 45 = 10 * 4 + 5
       */
      const coinsToBeReturned = legalTenderEuroCoinsOrdered.filter((coin) => {
        const mod = change % coin;
        if (mod === Math.trunc(change)) return false;
        else return true;
      });

      coinsToBeReturned.map((coin) => {
        if (coin !== "undefined") {
          let amount = change / coin;
          const isAmountDecimal = amount % 1 !== 0;

          let moneyObj = {};

          if (isAmountDecimal) {
            const division = change / coin;
            amount = Math.trunc(division);
          }

          ({ moneyObj, change } = checkIfAmountIsZeroIfNotPushMoney(
            moneyObj,
            coin,
            amount,
            response,
            change
          ));
        }
      });
    }
  } else {
    response = {
      name: ERRORS.MONEY_NOT_VALID,
      change: money,
    };
  }

  return response;
};

export default vendingMachine;

function checkIfAmountIsZeroIfNotPushMoney(
  moneyObj,
  coin,
  amount,
  response,
  change
) {
  moneyObj = { coin: coin, amount: amount };
  if (amount !== 0) {
    response.change.push(moneyObj);
    change = change - amount * coin;
  }
  return { moneyObj, change };
}

const ERRORS = {
  MONEY_NOT_VALID: "Entered money is not valid",
  MONEY_NOT_ENOUGHT: "Not enought money",
  PRODUCT_NOT_FOUND: "Product not found",
};
