import asyncSum from './src/20/index.js'
import calculator from './src/21/index.js'

const main = () => {
  // #20
  asyncSum(5, 1, 2).then(r => console.log(r))

  // #21
  console.log(calculator())
}

main()
