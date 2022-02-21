// Programa que invierte el texto ingresado.
// Máximo largo del texto =  100 caracteres.

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_LENGTH 101

int main(void) {
	char *user_input = malloc(MAX_LENGTH);

	printf("\nIngrese texto: ");
	fgets(user_input, MAX_LENGTH, stdin);

	printf("\nTexto invertido: ");
	for (int i = strlen(user_input) - 1; i >= 0; i--) {
		printf("%c", user_input[i]);
	}

	return 0;
}