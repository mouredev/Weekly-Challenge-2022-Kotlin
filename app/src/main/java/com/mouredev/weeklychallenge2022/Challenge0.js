// +info: https://javguerra.github.io/2022-04-22-fizzbuzz/
// @author Javier Guerra

const START = 1;
const END = 100; // START > END
let result = '0';
let x3, x5;

for (let i = START; i <= END; i++)
{
  result += ', ';
  x3 = i % 3 == 0;
  x5 = i % 5 == 0;

  if (!x3 && !x5)
    result += i;
  else {
    if (x3) result += 'fizz';
    if (x5) result += 'buzz';
  }
} // end for()

console.log (result);
