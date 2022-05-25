import fs from 'fs'

/**
 * It reads a .TXT file, replaces commas with dots, and evaluates the result
  - Each line of the file contains an operator or a number.
  - Supports integer numbers and decimal numbers.
  - Supports operators +, -, *, /.
  - After resolve the operation, the function log the result.
  - If any error exists, the function log that the operation couldn't be resolved.
 * @returns The result of the operations in the file.
 */
const txtCalculator = () => {
  const file = fs.readFileSync('src/21/Challenge21.txt', { encoding: 'utf-8' })
  try {
    const ops = file
      .split('\r\n') // convert to array splitting by lines
      .join('') // convert to string
      .replace(/,/g, '.') // replace ',' by '.'

    const result = eval(ops)
    return `El resultado de la operación ${ops} es ${result}.`
  } catch (err) {
    return 'No se han podido resolver las operaciones.'
  }
}

export default txtCalculator
