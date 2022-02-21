//
// Reto 7: Contando Palabras.
//
// Devuelve cuántas veces se repite una palabra (dada por el usuario) dentro de un texto (dado por
// el usuario), siguiendo las siguientes reglas:
//
//   1. Las mayúsculas no son consideradas.
//   2. No se consideran palabras dentro de otras, deben estar separadas por espacios, o signos
//      de puntuación.
//   3. Los caracteres especiales son considerados como espacios (ejemplo: 'pre-entreno' es
//      equivalente a dos palabras: 'pre' y 'entreno').
//
//
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

#define MAX_LENGTH 500

int count_occurrences (char *text, char *word);
char *to_lowercase (char *string);
char *replace_special (char *string);

int main (void) {
    char *text = malloc(MAX_LENGTH);
    char *word = malloc(MAX_LENGTH);
    int count;

    printf("Ingrese el texto: ");
    fgets(text, MAX_LENGTH, stdin);
    printf("Ingrese la palabra: ");
    fgets(word, MAX_LENGTH, stdin);
    printf("\n");

    text = to_lowercase(text);
    word = to_lowercase(word);

    text = replace_special(text);

    count = count_occurrences(text, word);
    printf("Número de veces que se repite: %d", count);

    return 0;
}

int count_occurrences (char *text, char *word) {
    int i, j, temp, check_len;
    int count = 0;
    int text_len = strlen(text);
    int word_len = strlen(word) - 1;

    for (i = 0; i < text_len; i++) {
        temp = i;

        for (j = 0; j < word_len; j++) {
            if (text[i] == word[j]) {
                i++;
            }
        }
        check_len = i - temp;

        if (check_len == word_len && text[i] == ' ' && text[i - word_len-1] == ' ') {
            count++;
        } else if (check_len == word_len && text[i] == ' ' && i - word_len == 0) {
            count++;
        } else if (check_len == word_len && i == text_len-1 && text[i - word_len-1] == ' ') {
            count++;
        }

        i = temp;
    }

    return count;
}

char *to_lowercase (char *string) {
    int i;

    for (i = 0; string[i]; i++) {
        string[i] = tolower(string[i]);
    }

    return string;
}

char *replace_special (char *string) {
    int i;
    char non_special_chars[26] = "abcdefghijklmnopqrstuvwxyz";

    for (i = 0; string[i]; i++) {
        if (strchr(non_special_chars, string[i]) == NULL) {
            string[i] = ' ';
        }
    }

    return string;
}
