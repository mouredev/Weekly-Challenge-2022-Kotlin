package main

import "fmt"

func main() {
	fmt.Println(isAnagram("zorra", "arroz"))
	fmt.Println(isAnagram("zorra", "zorra"))
}

func isAnagram(word1 string, word2 string) bool {
	var wordAnagram string
	for i := len(word1); i > 0; i-- {
		wordAnagram += string(word1[i-1])
	}
	if wordAnagram == word2 {
		return true
	}

	return false
}
