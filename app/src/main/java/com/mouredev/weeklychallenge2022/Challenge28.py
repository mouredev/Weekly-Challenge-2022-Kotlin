'''
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
 '''

products = {
    1: ['Coca-Cola', 120, 10],
    2: ['Pollo con polea', 350, 1],
    3: ['Bocata de calamares', 400, 4],
    4: ['Chicle Boobaloo', 75, 20],
    5: ['Agua 0,50L', 100, 10]
}

validCoins = (200, 100, 50, 10, 5)

def mapCoins(amount): #Convierte una cantidad 'amount' en un array con el menor numero de monedas válidas
    coins = []
    for coin in validCoins:
        while amount >= coin:
            coins.append(coin)
            amount -= coin
    return coins

def purchase(coins=[], numChoice=0): #Recibe un array de monedas y un numero de producto. Devuelve array con producto:str, monedas sobrantes:[] y monedas no válidas:[]
    amount = 0
    invalidCoins = []
    product = ''

    for coin in coins:
        if coin in validCoins:
            amount += coin
        else:
            invalidCoins.append(coin)
    
    if numChoice not in products.keys():
        product =  'Numero de producto no válido' 
    elif products[numChoice][2] < 1:
        product = 'Producto agotado'
    elif amount < products[numChoice][1]:
        product = 'Importe insuficiente'
    else:
        amount -= products[numChoice][1]
        products[numChoice][2] -= 1
        product = products[numChoice][0]

    return [product, mapCoins(amount), invalidCoins]


def main():
    try:
        while True:
            print('\nMOURE-O-MATIC')
            print('=============\n')
            for key in products.keys():
                print(f'Nº: {key} - {products[key][0]}')
                print(f'Precio: {products[key][1]} Restantes: {products[key][2]}\n')

            insertCoins = input('Introduce las monedas, separadas por espacios (Ejemplo: 5 5 10 100): ')
            try:
                coins = [int(x) for x in insertCoins.split()]
                choice = int(input('Introduce el número de producto: '))
            except:
                print('\nAle, ya has roto la máquina por escribir cosas raras.')
                break

            print('\nComprando:\n')
            compra = purchase(coins, choice)
            
            print(f'Producto: {compra[0]}')
            print(f'Monedas devueltas: {compra[1]}')
            print(f'Monedas no válidas: {compra[2]}')

            input('\nPulsa ENTER para continuar...')

    except KeyboardInterrupt:
        print('\nGoodBye\n')

if __name__ == '__main__':
    main()
