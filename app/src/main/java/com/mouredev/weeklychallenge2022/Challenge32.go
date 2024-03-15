package main

import "fmt"

func main() {
	secondMayor := secondMayor(293, 56943, 595, 394, 2384, 59, 238, 594, 76)
	fmt.Println(secondMayor)
}

func secondMayor(numbers ...int) int {
	var first, second int
	if numbers[0] > numbers[1] {
		first, second = numbers[0], numbers[1]
	} else {
		first, second = numbers[1], numbers[0]
	}
	for n := 2; n < len(numbers); n++ {
		if first < numbers[n] {
			first, second = numbers[n], first
		} else if second < numbers[n] {
			second = numbers[n]
		}
	}
	return second
}