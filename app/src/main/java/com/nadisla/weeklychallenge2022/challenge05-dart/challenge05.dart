/*
* Reto #5
* ASPECT RATIO DE UNA IMAGEN
* Dificultad: DIFÍCIL
*
* Enunciado: Crea un programa que se encargue de calcular el aspect ratio de una imagen a partir de una url.
* Url de ejemplo: https://wallpaperaccess.com/full/109676.jpg
* Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.

* Challenge #5
* ASPECT RATIO OF AN IMAGE
* Difficulty: DIFFICULT
*
* Statement: Create a program that is responsible for calculating the aspect ratio of an image from a url.
* Example URL: https://wallpaperaccess.com/full/109676.jpg
* By ratio we refer for example to the "16:9" of a 1920*1080px image.
*/
import 'package:image/image.dart';
import 'package:http/http.dart' as http;

void main() {
  print("Calculating the Aspect Ratio. Please wait...⏳");
  getAspectRatio("https://wallpaperaccess.com/full/109676.jpg");
}

void getAspectRatio(String imageUrl) async {
  http.Response response = await http.get(Uri.parse(imageUrl));
  Image? image = decodeImage(response.bodyBytes);
  int width, height, gcd;
  String aspectRatio;
  if (image != null) {
    width = image.width;
    height = image.height;
    gcd = greatestCommonDivisor(width, height);
    aspectRatio = "${(width / gcd).round()}:${(height / gcd).round()}";
    print("The Aspect Ratio is: $aspectRatio");
  } else {
    print("The provided URL is not a valid image.");
  }
}

int greatestCommonDivisor(int num1, int num2) {
  List<int> divisorsNum1 = [], divisorsNum2 = [];
  int greatestCommonDivisor = 0;
  for (var div = 1; div <= num1; div++) {
    if (num1 % div == 0) {
      divisorsNum1.add(div);
    }
  }
  for (var div = 1; div <= num2; div++) {
    if (num2 % div == 0) {
      divisorsNum2.add(div);
    }
  }
  greatestCommonDivisor = Set<int>.from(divisorsNum1)
      .intersection(Set<int>.from(divisorsNum2))
      .reduce((lastValue, currentValue) =>
          lastValue > currentValue ? lastValue : currentValue);
  return greatestCommonDivisor;
}
