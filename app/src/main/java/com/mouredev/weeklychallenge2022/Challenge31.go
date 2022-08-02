package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
	"strings"
)

func leapYear(year int) bool {
	var leap bool
	if ((year%4 == 0) && (year%100 != 0)) || year%400 == 0 {
		leap = true
	} else {
		leap = false
	}
	return leap
}

func logError(err error) {
	if err != nil {
		log.Fatal(err)
		return
	}
}

func main() {
	fmt.Print("Ingresa el año a partir del cual quieres saber los 30 proximos años bisiestos")
	reader := bufio.NewReader(os.Stdin)
	line, err := reader.ReadString('\n')
	logError(err)

	var row string
	row = strings.Trim(line, "\r\n")
	year, err := strconv.Atoi(row)
	logError(err)

	for i := 1; i < 30; i++ {
		isALeapYear := leapYear(year + (i * 2))
		if isALeapYear {
			fmt.Println(year + (i * 2))
		}
	}
}
