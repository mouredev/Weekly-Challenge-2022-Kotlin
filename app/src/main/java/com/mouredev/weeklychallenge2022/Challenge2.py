def fibonacci(num1: int, num2: int):
  for i in range(0,51):
    print(num1)
    fib = num1 + num2
    num1 = num2
    num2 = fib

fibonacci(0,1)