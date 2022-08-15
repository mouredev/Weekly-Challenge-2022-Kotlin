package main

import (
	"fmt"
	"math/rand"
	"time"
)

// DoSliceInt: make slice with int values
func DoSliceInt(max int) (tasks []int) {
	for range [800]int{} {
		tasks = append(tasks, rand.Intn(max))
	}
	return
}

// GetMaxPairNumbers: make the compare and return the first and the second number (in that order)
func GetMaxPairNumbers(first int, second int, value int) (one int, two int) {
	if first < value {
		two = first
		one = value
	} else if second < value && first != value {
		two = value
		one = first
	} else {
		one = first
		two = second
	}
	return
}

// main: run the program
func main() {
	tasks := DoSliceInt(1000) //generate the slice
	var first int             //will containt the hightest number
	var second int            //will conteint the second hight number

	fmt.Println("tasks ::: ", tasks)
	fmt.Println("start ::: ", time.Now())
	for _, value := range tasks {
		first, second = GetMaxPairNumbers(first, second, value)
	}
	fmt.Printf("The first number is %d\n", first)
	fmt.Printf("The second number is %d\n", second)
	fmt.Println("end :::", time.Now())
}
