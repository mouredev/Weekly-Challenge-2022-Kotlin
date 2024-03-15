package main

import "fmt"

func main() {
	i := 1
	for i <= 100 {
		byThree := i%3 == 0
		byFive := i%5 == 0

		if byThree && byFive {
			fmt.Printf("%d FIZZ BUZZ\n", i)
		} else if byFive {
			fmt.Printf("%d BUZZ\n", i)
		} else if byThree {
			fmt.Printf("%d FIZZ\n", i)
		} else {
			fmt.Println(i)
		}

		i++
	}
}
