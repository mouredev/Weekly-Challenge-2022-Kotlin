function fibonacci(num) {
  let num1 = 0;
  let num2 = 1;
  let sum = 0;
  console.log("0");
  for (let i = 0; i < num; i++) {
    sum = num1 + num2;
    num2 = num1;
    num1 = sum;
    console.log(sum);
  }
}
fibonacci(50);
