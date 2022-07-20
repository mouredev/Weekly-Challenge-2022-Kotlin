/*
 * Reto #28
 * MÁQUINA EXPENDEDORA
 * Fecha publicación enunciado: 11/07/22
 * Fecha publicación resolución: 18/07/22
 * Dificultad: MEDIA
 *
 * Enunciado: Simula el funcionamiento de una máquina expendedora creando una operación
 * que reciba dinero (array de monedas) y un número que indique la selección del producto.
 * - El programa retornará el nombre del producto y un array con el dinero de vuelta (con el menor
 *   número de monedas).
 * - Si el dinero es insuficiente o el número de producto no existe, deberá indicarse con un mensaje
 *   y retornar todas las monedas.
 * - Si no hay dinero de vuelta, el array se retornará vacío.
 * - Para que resulte más simple, trabajaremos en céntimos con monedas de 5, 10, 50, 100 y 200.
 * - Debemos controlar que las monedas enviadas estén dentro de las soportadas.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

// Clase que representa a un producto de la maquina expendedora

class Product {
  String name;
  int price;
  Product({required this.name, required this.price});
}

class VendingMachine {
  List<int> _coins = []; //tipos de moneda
  List<Product> _products = []; //productos selecionables
  List<int> _coinsPay = []; //monedas en depósito ingreso/egreso

  VendingMachine({required coins, required products}) {
    _coins = coins;
    _products = products;
  }

  String getProductName(int index) => _products[index].name;

  insertCoins(List<int> pay) {
    _coinsPay = pay;
    for (var coin in pay)
      if (!_coins.contains(coin))
        throw Exception('$coin no es una moneda válida');
  }

  //Calcula del valor total de las monedas en deposito
  int _totalPay() {
    int totalPay = 0;
    for (var coin in _coinsPay) {
      totalPay += coin;
    }
    return totalPay;
  }

  //Calcula el cambio en las monedas disponibles
  List<int> _getChange(int value) {
    List<int> typesCoin = _coins;
    typesCoin.sort((a, b) => b.compareTo(a));
    List<int> exchange = [];
    int lastIndex = 0;
    while (value > 0 && value >= typesCoin.last) {
      for (int i = lastIndex; i < typesCoin.length; i++) {
        if (value >= typesCoin[i]) {
          value -= typesCoin[i];
          exchange.add(typesCoin[i]);
          break;
        }
        lastIndex = i;
      }
    }
    if (value != 0) throw Exception('Imposible encontrar cambio justo');
    return exchange;
  }

  selectOption(int option) {
    if (option < 0 || option >= _products.length)
      throw Exception('No existe la opcion $option');
    Product product = _products[option];
    int total = _totalPay();
    if (product.price > total) {
      throw Exception('Dinero ingresado insuficiente');
    }
    _coinsPay = _getChange(total - product.price);
  }

//Retona las monedas del depósito y lo vacía
  List<int> returnCoins() {
    List<int> exchange = List<int>.from(_coinsPay);
    _coinsPay.clear();
    return exchange;
  }
}

//MAIN-------------------------------------------------------------------------
void main(List<String> args) {
  List<int>? coinsMachine = [5, 10, 50, 100, 200];

  List<Product>? products = [
    Product(name: 'Cafe', price: 105),
    Product(name: 'Chocolate', price: 85),
    Product(name: 'Snacks', price: 200),
    Product(name: 'Te Verde', price: 35),
    Product(name: 'Refresco', price: 70),
    Product(name: 'Galletas', price: 160),
  ];

  VendingMachine machine = VendingMachine(
    coins: coinsMachine,
    products: products,
  );

  List<int> insertCoins = [200];
  int productOption = 0;
  try {
    machine.insertCoins(insertCoins);
    machine.selectOption(productOption);
    print('Ha adquirido ${machine.getProductName(productOption)}, Disfrútelo!');
  } catch (e) {
    print(e);
  } finally {
    print('Su dinero: ${machine.returnCoins()}');
  }
}
