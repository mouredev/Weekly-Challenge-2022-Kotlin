package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strings"
)

func imprimirPalabras(letras int, palabras []string) {
	for _, palabra := range palabras {
		if letras == len(palabra) {
			fmt.Printf("* %s *\n", palabra)
		} else {
			fmt.Printf("* %s", palabra)
			for i := 0; i < (letras - len(palabra) + 1); i++ {
				fmt.Print(" ")
			}
			fmt.Printf("*\n")
		}
	}
}

func imprimirAsteriscos(letras int) {
	for i := 0; i < letras+4; i++ {
		fmt.Print("*")
	}
	fmt.Print("\n")
}

func main() {
	var caracteres int
	fmt.Printf("Por favor introduce la cadena que quieres enmarcar: ")
	lectura := bufio.NewReader(os.Stdin)
	cadena, err := lectura.ReadString('\n')
	if err != nil {
		log.Fatal(err)
		return
	}
	palabras := strings.Fields(cadena)
	for _, palabra := range palabras {
		if caracteres == 0 {
			caracteres = len(palabra)
		} else if caracteres < len(palabra) {
			caracteres = len(palabra)
		}
	}

	imprimirAsteriscos(caracteres)
	imprimirPalabras(caracteres, palabras)
	imprimirAsteriscos(caracteres)
}
