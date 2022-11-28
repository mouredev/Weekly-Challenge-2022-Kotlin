package com.mouredev.weeklychallenge2022

//Crea un función que reciba un texto y retorne 
//la vocal que más veces se repita.

void main() {
  vocalMasRepetida('marioi');
  vocalMasRepetida('marioo');
  vocalMasRepetida('eskerni');
  vocalMasRepetida('jaziel');
}

void vocalMasRepetida(String cadena) {
  var vocales = <int>[0, 0, 0, 0, 0];
  String masRepetida = "";

  for (int contador = 0; contador < cadena.length; contador++) {
    switch (cadena[contador]) {
      case 'a':
        vocales[0]++;
        break;
      case 'A':
        vocales[0]++;
        break;
      case 'e':
        vocales[1]++;
        break;
      case 'E':
        vocales[1]++;
        break;
      case 'i':
        vocales[2]++;
        break;
        case 'I':
        vocales[2]++;
        break;
      case 'o':
        vocales[3]++;
        break;
        case 'O':
        vocales[3]++;
        break;
      case 'u':
        vocales[4]++;
        break;
        case 'U':
        vocales[4]++;
        break;
    }
  }

  int mayor = 0;
  String vocal = "";

  for (int contador = 0; contador < vocales.length; contador++) {
    if (vocales[contador] > mayor) {
      mayor = vocales[contador];
      switch (contador) {
        case 0:
          vocal = "a";
          break;
        case 1:
          vocal = "e";
          break;
        case 2:
          vocal = "i";
          break;
        case 3:
          vocal = "o";
          break;
        case 4:
          vocal = "u";
          break;
      }
    }
  }

  print('la vocal mas repetida es $vocal');
}
