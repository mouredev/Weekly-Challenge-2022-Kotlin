//
// Reto 9: Traductor de Código Morse.
//
// Caracteres soportados:
//     a b c d e f g h i j k l m n o p q r s t u v w x y z 1 2 3 4 5 6 7 8 9 0 . , ? / "
// Los caracteres que no aparezcan, son considerados como espacios.
//
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>


#define MAX_LENGTH 500

int check_if_string_or_morse (char *string);    // 1 para string, 0 para morse.
char *string_to_morse (char *string);
char *to_lowercase (char *string);
char *morse_to_string (char *morse);


int main (void) {
    char *user_input = malloc(MAX_LENGTH);
    int i;

    printf("\nIngrese texto: ");
    fgets(user_input, MAX_LENGTH, stdin);

    if (check_if_string_or_morse(user_input)) {
        char *morse_output = string_to_morse(user_input);
        printf("Código Morse: %s", morse_output);
    } else {
        char *string_output = morse_to_string(user_input);
        printf("String: %s", string_output);
    }

    return 0;
}

int check_if_string_or_morse (char *string) {
    char *string_lower = malloc(MAX_LENGTH);
    char *possible_characters = "abcdefghijklmnopqrstuvwxyz1234567890.,?/";
    int i;

    for (i = 0; i < strlen(string); i++) {
        if (strchr(possible_characters, string[i]) && string[i] != '.') {
            return 1;
        } else if (string[i] == '"') {
            return 1;
        }
    }

    return 0;
}

char *string_to_morse (char *string) {
    char *string_lower = malloc(MAX_LENGTH);
    char *output = malloc(7 * MAX_LENGTH);
    int i;
    int j = 0;

    string_lower = to_lowercase(string);

    for (i = 0; i < strlen(string_lower); i++) {
        if (string_lower[i] == 'a') {
            output[j] = '.';
            output[j + 1] = '-';
            output[j + 2] = ' ';
            j = j + 3;
        } else if (string_lower[i] == 'b') {
            output[j] = '-';
            output[j + 1] = '.';
            output[j + 2] = '.';
            output[j + 3] = '.';
            output[j + 4] = ' ';
            j = j + 5;
        } else if (string_lower[i] == 'c') {
            if (string_lower[i + 1] == 'h') {
                i++;
                output[j] = '-';
                output[j + 1] = '-';
                output[j + 2] = '-';
                output[j + 3] = '-';
                output[j + 4] = ' ';
                j = j + 5;
            } else {
                output[j] = '-';
                output[j + 1] = '.';
                output[j + 2] = '-';
                output[j + 3] = '.';
                output[j + 4] = ' ';
                j = j + 5;
            }
        } else if (string_lower[i] == 'd') {
            output[j] = '-';
            output[j + 1] = '.';
            output[j + 2] = '.';
            output[j + 3] = ' ';
            j = j + 4;
        } else if (string_lower[i] == 'e') {
            output[j] = '.';
            output[j + 1] = ' ';
            j = j + 2;
        } else if (string_lower[i] == 'f') {
            output[j] = '.';
            output[j + 1] = '.';
            output[j + 2] = '-';
            output[j + 3] = '.';
            output[j + 4] = ' ';
            j = j + 5;
        } else if (string_lower[i] == 'g') {
            output[j] = '-';
            output[j + 1] = '-';
            output[j + 2] = '.';
            output[j + 3] = ' ';
            j = j + 4;
        } else if (string_lower[i] == 'h') {
            output[j] = '.';
            output[j + 1] = '.';
            output[j + 2] = '.';
            output[j + 3] = '.';
            output[j + 4] = ' ';
            j = j + 5;
        } else if (string_lower[i] == 'i') {
            output[j] = 'i';
            output[j + 1] = '.';
            output[j + 2] = ' ';
            j = j + 3;
        } else if (string_lower[i] == 'j') {
            output[j] = '.';
            output[j + 1] = '-';
            output[j + 2] = '-';
            output[j + 3] = '-';
            output[j + 4] = ' ';
            j = j + 5;
        } else if (string_lower[i] == 'k') {
            output[j] = '-';
            output[j + 1] = '.';
            output[j + 2] = '-';
            output[j + 3] = ' ';
            j = j + 4;
        } else if (string_lower[i] == 'l') {
            output[j] = '.';
            output[j + 1] = '-';
            output[j + 2] = '.';
            output[j + 3] = '.';
            output[j + 4] = ' ';
            j = j + 5;
        } else if (string_lower[i] == 'm') {
            output[j] = '-';
            output[j + 1] = '-';
            output[j + 2] = ' ';
            j = j + 3;
        } else if (string_lower[i] == 'n') {
            output[j] = '-';
            output[j + 1] = '.';
            output[j + 2] = ' ';
            j = j + 3;
/*      } else if (string_lower[i] == 'ñ') {    // No se como poner la Ñ en C
              output[j] = '-';
              output[j + 1] = '-';
              output[j + 2] = '.';
              output[j + 3] = '-';
              output[j + 4] = '-';
              output[j + 5] = ' ';
              j = j + 6;*/
        } else if (string_lower[i] == 'o') {
            output[j] = '-';
            output[j + 1] = '-';
            output[j + 2] = '-';
            output[j + 3] = ' ';
            j = j + 4;
        } else if (string_lower[i] == 'p') {
            output[j] = '.';
            output[j + 1] = '-';
            output[j + 2] = '-';
            output[j + 3] = '.';
            output[j + 4] = ' ';
            j = j + 5;
        } else if (string_lower[i] == 'q') {
            output[j] = '-';
            output[j + 1] = '-';
            output[j + 2] = '.';
            output[j + 3] = '-';
            output[j + 4] = ' ';
            j = j + 5;
        } else if (string_lower[i] == 'r') {
            output[j] = '.';
            output[j + 1] = '-';
            output[j + 2] = '.';
            output[j + 3] = ' ';
            j = j + 4;
        } else if (string_lower[i] == 's') {
            output[j] = '.';
            output[j + 1] = '.';
            output[j + 2] = '.';
            output[j + 3] = ' ';
            j = j + 4;
        } else if (string_lower[i] == 't') {
            output[j] = '-';
            output[j + 1] = ' ';
            j = j + 2;
        } else if (string_lower[i] == 'u') {
            output[j] = '.';
            output[j + 1] = '.';
            output[j + 2] = '-';
            output[j + 3] = ' ';
            j = j + 4;
        } else if (string_lower[i] == 'v') {
            output[j] = '.';
            output[j + 1] = '.';
            output[j + 2] = '.';
            output[j + 3] = '-';
            output[j + 4] = ' ';
            j = j + 5;
        } else if (string_lower[i] == 'w') {
            output[j] = '.';
            output[j + 1] = '-';
            output[j + 2] = '-';
            output[j + 3] = ' ';
            j = j + 4;
        } else if (string_lower[i] == 'x') {
            output[j] = '-';
            output[j + 1] = '.';
            output[j + 2] = '.';
            output[j + 3] = '-';
            output[j + 4] = ' ';
            j = j + 5;
        } else if (string_lower[i] == 'y') {
            output[j] = '-';
            output[j + 1] = '.';
            output[j + 2] = '-';
            output[j + 3] = '-';
            output[j + 4] = ' ';
            j = j + 5;
        } else if (string_lower[i] == 'z') {
            output[j] = '-';
            output[j + 1] = '-';
            output[j + 2] = '.';
            output[j + 3] = '.';
            output[j + 4] = ' ';
            j = j + 5;
        } else if (string_lower[i] == '0') {
            output[j] = '-';
            output[j + 1] = '-';
            output[j + 2] = '-';
            output[j + 3] = '-';
            output[j + 4] = '-';
            output[j + 5] = ' ';
            j = j + 6;
        } else if (string_lower[i] == '1') {
            output[j] = '.';
            output[j + 1] = '-';
            output[j + 2] = '-';
            output[j + 3] = '-';
            output[j + 4] = '-';
            output[j + 5] = ' ';
            j = j + 6;
        } else if (string_lower[i] == '2') {
            output[j] = '.';
            output[j + 1] = '.';
            output[j + 2] = '-';
            output[j + 3] = '-';
            output[j + 4] = '-';
            output[j + 5] = ' ';
            j = j + 6;
        } else if (string_lower[i] == '3') {
            output[j] = '.';
            output[j + 1] = '.';
            output[j + 2] = '.';
            output[j + 3] = '-';
            output[j + 4] = '-';
            output[j + 5] = ' ';
            j = j + 6;
        } else if (string_lower[i] == '4') {
            output[j] = '.';
            output[j + 1] = '.';
            output[j + 2] = '.';
            output[j + 3] = '.';
            output[j + 4] = '-';
            output[j + 5] = ' ';
            j = j + 6;
        } else if (string_lower[i] == '5') {
            output[j] = '.';
            output[j + 1] = '.';
            output[j + 2] = '.';
            output[j + 3] = '.';
            output[j + 4] = '.';
            output[j + 5] = ' ';
            j = j + 6;
        } else if (string_lower[i] == '6') {
            output[j] = '-';
            output[j + 1] = '.';
            output[j + 2] = '.';
            output[j + 3] = '.';
            output[j + 4] = '.';
            output[j + 5] = ' ';
            j = j + 6;
        } else if (string_lower[i] == '7') {
            output[j] = '-';
            output[j + 1] = '-';
            output[j + 2] = '.';
            output[j + 3] = '.';
            output[j + 4] = '.';
            output[j + 5] = ' ';
            j = j + 6;
        } else if (string_lower[i] == '8') {
            output[j] = '-';
            output[j + 1] = '-';
            output[j + 2] = '-';
            output[j + 3] = '.';
            output[j + 4] = '.';
            output[j + 5] = ' ';
            j = j + 6;
        } else if (string_lower[i] == '9') {
            output[j] = '-';
            output[j + 1] = '-';
            output[j + 2] = '-';
            output[j + 3] = '-';
            output[j + 4] = '.';
            output[j + 5] = ' ';
            j = j + 6;
        } else if (string_lower[i] == '.') {
            output[j] = '.';
            output[j + 1] = '-';
            output[j + 2] = '.';
            output[j + 3] = '-';
            output[j + 4] = '.';
            output[j + 5] = '-';
            output[j + 6] = ' ';
            j = j + 7;
        } else if (string_lower[i] == ',') {
            output[j] = '-';
            output[j + 1] = '-';
            output[j + 2] = '.';
            output[j + 3] = '.';
            output[j + 4] = '-';
            output[j + 5] = '-';
            output[j + 6] = ' ';
            j = j + 7;
        } else if (string_lower[i] == '?') {
            output[j] = '.';
            output[j + 1] = '.';
            output[j + 2] = '-';
            output[j + 3] = '-';
            output[j + 4] = '.';
            output[j + 5] = '.';
            output[j + 6] = ' ';
            j = j + 7;
        } else if (string_lower[i] == '"') {
            output[j] = '.';
            output[j + 1] = '-';
            output[j + 2] = '.';
            output[j + 3] = '.';
            output[j + 4] = '-';
            output[j + 5] = '.';
            output[j + 6] = ' ';
            j = j + 7;
        } else if (string_lower[i] == '/') {
            output[j] = '-';
            output[j + 1] = '.';
            output[j + 2] = '.';
            output[j + 3] = '-';
            output[j + 4] = '.';
            output[j + 5] = ' ';
            j = j + 6;
        } else {
            output[j] = ' ';
            j = j + 1;
        }
    }

    return output;
}

char *to_lowercase (char *string) {
    int i;

    for (i = 0; string[i]; i++) {
        string[i] = tolower(string[i]);
    }

    return string;
}

char *morse_to_string (char *morse) {
    char *output = malloc(MAX_LENGTH);
    int i;
    int j = 0;

    for (i = 0; i < strlen(morse); i++) {
        if (morse[i] == '.') {
            i++;
            if (morse[i] == '.') {
                i++;
                if (morse[i] == '.') {
                    i++;
                    if (morse[i] == '.') {
                        i++;
                        if (morse[i] == '.') {
                            i++;
                            output[j] = '5';
                            j++;
                        } else if (morse[i] == '-') {
                            i++;
                            output[j] = '4';
                            j++;
                        } else {
                            output[j] = 'H';
                            j++;
                        }
                    } else if (morse[i] == '-') {
                        i++;
                        if (morse[i] == '-') {
                            i++;
                            output[j] = '3';
                            j++;
                        } else {
                            output[j] = 'V';
                            j++;
                        }
                    } else {
                        output[j] = 'S';
                        j++;
                    }
                } else if (morse[i] == '-') {
                    i++;
                    if (morse[i] == '.') {
                        i++;
                        output[j] = 'F';
                        j++;
                    } else if (morse[i] == '-') {
                        i++;
                        if (morse[i] == '.') {
                            i++;
                            if (morse[i] == '.') {
                                i++;
                                output[j] = '?';
                                j++;
                            }
                        } else if (morse[i] == '-') {
                            i++;
                            output[j] = '2';
                            j++;
                        }
                    } else {
                        output[j] = 'U';
                        j++;
                    }
                } else {
                    output[j] = 'I';
                    j++;
                }
            } else if (morse[i] == '-') {
                i++;
                if (morse[i] == '.') {
                    i++;
                    if (morse[i] == '.') {
                        i++;
                        if (morse[i] == '-') {
                            i++;
                            if (morse[i] == '.') {
                                i++;
                                output[j] = '"';
                                j++;
                            }
                        } else {
                            output[j] = 'L';
                            j++;
                        }
                    } else if (morse[i] == '-') {
                        i++;
                        if (morse[i] == '.') {
                            i++;
                            if (morse[i] == '-') {
                                i++;
                                output[j] = '.';
                                j++;
                            }
                        }
                    } else {
                        output[j] = 'R';
                        j++;
                    }
                } else if (morse[i] == '-') {
                    i++;
                    if (morse[i] == '.') {
                        i++;
                        output[j] = 'P';
                        j++;
                    } else if (morse[i] == '-') {
                        i++;
                        if (morse[i] == '-') {
                            i++;
                            output[j] = '1';
                            j++;
                        } else {
                            output[j] = 'J';
                            j++;
                        }
                    } else {
                        output[j] = 'W';
                        j++;
                    }
                } else {
                    output[j] = 'A';
                    j++;
                }
            } else {
                output[j] = 'E';
                j++;
            }

        } else if (morse[i] == '-') {
            i++;
            if (morse[i] == '.') {
                i++;
                if (morse[i] == '.') {
                    i++;
                    if (morse[i] == '.') {
                        i++;
                        if (morse[i] == '.') {
                            i++;
                            output[j] = '6';
                            j++;
                        } else {
                            output[j] = 'B';
                            j++;
                        }
                    } else if (morse[i] == '-') {
                        i++;
                        if (morse[i] == '.') {
                            i++;
                            output[j] = '/';
                            j++;
                        } else {
                            output[j] = 'X';
                            j++;
                        }
                    } else {
                        output[j] = 'D';
                        j++;
                    }
                } else if (morse[i] == '-') {
                    i++;
                    if (morse[i] == '.') {
                        i++;
                        output[j] = 'C';
                        j++;
                    } else if (morse[i] == '-') {
                        i++;
                        output[j] = 'Y';
                        j++;
                    } else {
                        output[j] = 'K';
                        j++;
                    }
                } else {
                    output[j] = 'N';
                    j++;
                }
            } else if (morse[i] == '-') {
                i++;
                if (morse[i] == '.') {
                    i++;
                    if (morse[i] == '.') {
                        i++;
                        if (morse[i] == '.') {
                            i++;
                            output[j] = '7';
                            j++;
                        } else if (morse[i] == '-') {
                            i++;
                            if (morse[i] == '-') {
                                i++;
                                output[j] = ',';
                                j++;
                            }
                        } else {
                            output[j] = 'Z';
                            j++;
                        }
                    } else if (morse[i] == '-') {
                        i++;
                        if (morse[i] == '-') {
                            i++;
                            //output[j] = 'Ñ';
                            //j++;
                        } else {
                            output[j] = 'Q';
                            j++;
                        }
                    } else {
                        output[j] = 'G';
                        j++;
                    }
                } else if (morse[i] == '-') {
                    i++;
                    if (morse[i] == '.') {
                        i++;
                        if (morse[i] == '.') {
                            i++;
                            output[j] = '8';
                            j++;
                        }
                    } else if (morse[i] == '-') {
                        i++;
                        if (morse[i] == '.') {
                            i++;
                            output[j] = '9';
                            j++;
                        } else if (morse[i] == '-') {
                            i++;
                            output[j] = '0';
                            j++;
                        } else {
                            output[j] = 'C';
                            j++;
                            output[j] = 'H';
                            j++;
                        }
                    } else {
                        output[j] = 'O';
                        j++;
                    }
                } else {
                    output[j] = 'M';
                    j++;
                }
            } else {
                output[j] = 'T';
                j++;
            }
        } else {
            output[j] = ' ';
            j++;
        }
    }

    return output;
}
