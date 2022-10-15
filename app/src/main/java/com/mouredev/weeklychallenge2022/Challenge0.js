for (let i = 1; i <= 100; i++) {
  let divisibleTres = i % 3 == 0;
  let divisibleCinco = i % 5 == 0;

  if (divisibleCinco && divisibleTres) {
    console.log("fizzbuzz");
  }
  else if (divisibleTres) {
    console.log("fizz");
  }
  else if (divisibleCinco) {
    console.log("buzz");
  }
  else {
    console.log(i);
  }
}
