package main

import (
	"fmt"
	"math/rand"
	"time"
)

type TPersona struct {
	nombre string
	edad   int
	altura int
}

type Halloween interface {
	calcularPremioPorNombre(text string) int
	calcularPremioPorEdad(edad int) int
	calcularPremioPorAltura(altura int) int
	calcularPremios(personas []TPersona) int
	getPremios() []string
}

type Truco struct{}
type Trato struct{}

func (h Truco) calcularPremioPorNombre(nombre string) int {
	return len(nombre) / 2
}
func (h Truco) calcularPremioPorEdad(edad int) int {
	if edad%2 == 0 {
		return 2
	}
	return 0
}
func (h Truco) calcularPremioPorAltura(alturaTotal int) int {
	return 3 * (alturaTotal / 100)
}
func (h Truco) calcularPremios(personas []TPersona) int {
	total := 0
	totalEdad := 0
	for _, v := range personas {
		total += h.calcularPremioPorNombre(v.nombre)
		total += h.calcularPremioPorAltura(v.altura)
		totalEdad += v.edad
	}
	total += h.calcularPremioPorEdad(totalEdad)
	return total
}

func (h Truco) getPremios() []string {
	return []string{"🎃"," 👻", "💀", "🕷", "🕸", "🦇"}
}

func (h Trato) calcularPremioPorNombre(nombre string) int {
	return len(nombre)
}
func (h Trato) calcularPremioPorEdad(edad int) int {
	if edad > 10 {
		edad = 10
	}
	return edad / 3
}
func (h Trato) calcularPremioPorAltura(altura int) int {
	if altura > 150 {
		altura = 150
	}
	return 2 * altura / 50
}
func (h Trato) calcularPremios(personas []TPersona) int {
	total := 0
	for _, v := range personas {
		total += h.calcularPremioPorNombre(v.nombre)
		total += h.calcularPremioPorAltura(v.altura)
		total += h.calcularPremioPorEdad(v.edad)
	}
	return total
}

func (h Trato) getPremios() []string {
	return []string{"🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"}
}

func imprimirAleatorio(lista []string, cantidadAleatorio int) {
	rand.Seed(time.Now().UnixNano())
	max := len(lista)
	for i := 0; i < cantidadAleatorio; i++ {
		fmt.Print(lista[rand.Intn(max)])
	}
}

func main() {
	fmt.Println("Halloween")

	personas := make([]TPersona, 100, 100)
	var trucootrato string
	var opcion string
	cont := 0
	for {
		fmt.Println("Registro ", cont+1)
		fmt.Print("Ingrese un nombre...:")
		fmt.Scanln(&personas[cont].nombre)

		fmt.Print("Ingrese su edad...:")
		fmt.Scanln(&personas[cont].edad)

		fmt.Print("Ingrese su altura...:")
		fmt.Scanln(&personas[cont].altura)
		cont++

		fmt.Print("Desea ingresar mas datos Si(S) o No(N)..:")
		fmt.Scanln(&opcion)
		if (opcion == "N") || (opcion == "n") {
			break
		}
	}

	fmt.Print("Escoja Truco(T) o Trato(K)...:")
	fmt.Scanln(&trucootrato)

	var t Halloween
	if trucootrato == "T" {
		t = Truco{}
	} else {
		t = Trato{}
	}
	imprimirAleatorio(t.getPremios(), t.calcularPremios(personas))
}
