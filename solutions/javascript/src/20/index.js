/**
 * It returns a promise that resolves to the sum of two numbers after a specified number of seconds
 * @param [numberOne=0] - The first number to add.
 * @param [numberTwo=0] - The second number to add.
 * @param [seconds=0] - The number of seconds to wait before resolving the promise.
 * @returns A promise that resolves to the sum of the two numbers after the specified number of seconds.
 */
const asyncSum = async (numberOne = 0, numberTwo = 0, seconds = 0) => {
  return new Promise(resolve =>
    setTimeout(() => resolve(numberOne + numberTwo), seconds * 1000)
  )
}

export default asyncSum
