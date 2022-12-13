package main

import "fmt"

func main() {
	num1, num2 := 0, 1
	for i := 0; i <= 50; i++ {
		fmt.Println(num1)
		fib := num1 + num2
		num1 = num2
		num2 = fib
	}
}
