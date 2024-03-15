function fizzBuzz(num) {
  for (let i = 1; i <= num; i++) {
    let multiTres = i % 3;
    let multiCinco = i % 5;

    if (multiTres == 0 && multiCinco == 0) {
      console.log("fizzbuzz");
    } else if (multiTres == 0) {
      console.log("fizz");
    } else if (multiCinco == 0) {
      console.log("buzz");
    } else {
      console.log(i);
    }
  }
}

fizzBuzz(100);
