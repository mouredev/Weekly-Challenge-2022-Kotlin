let numPrime = [];
function isPrime(num) {
  let i = 0;
  let result;
  if (num < 2) {
    result = false;
  } else if (num == 2 || num == 3 || num == 5) {
    numPrime.push(num);
    result = true;
  } else {
    do {
      result = num % numPrime[i] != 0;
      i++;
    } while (result && i <= numPrime.length - 1);
    if (result) {
      numPrime.push(num);
    }
  }
  return result;
}

for (let i = 1; i <= 100; i++) {
  if (isPrime(i)) {
    console.log(i);
  }
}
console.log(numPrime);
