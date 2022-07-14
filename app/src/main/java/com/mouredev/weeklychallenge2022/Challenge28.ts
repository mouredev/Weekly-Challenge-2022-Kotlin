
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
 */

const validMoney:number[] = [5, 10, 50, 100, 200];

const products = [
    { name: 'Coca-Cola', price: 100 },
    { name: 'Fanta', price: 70 },
    { name: 'Sprite', price: 10 },
    { name: 'Cerveza', price: 25 },
    { name: 'Agua', price: 50 },
    { name: 'Café', price: 10 },
    { name: 'Té', price: 20 },
    { name: 'Jugo', price: 40 },
    { name: 'Refresco', price: 35 },
    { name: 'Gaseosa', price: 15 },
    { name: 'Dulce', price: 30 },
];


const validInput = (money: number[], product: number): boolean => {
    if( product < 0 || product > products.length ) return false;
    if( money.length === 0 ) return false;
    
    let amountMoney = 0;
    for(let i = 0; i < money.length; i++) {
        if( !validMoney.includes(money[i]) ) return false;
        amountMoney += money[i];
    }
    
    if(  amountMoney < products[product].price ) return false;
    
    return true;
}



const buyProduct = (money: number[], product: number): { name: string, change: number[] } => {
    
    const ok:boolean = validInput( money, product );
    if( !ok )
        throw new Error("Invalid Input");
    
    const { name, price } = products[product];

    money.sort((a, b) => a - b);

    let pay:number = 0;
    let change:number[] = [];
    let index:number = 0;

    for( let i = 0; i < money.length; i ++ ) {
        pay += money[i];
        if( pay == price ) {
            index = i + 1;
            break;
        }

        if( pay > price ) {
            index = i + 1;
            change.push( pay - price );
            break;
        }
    }

    for(let i = index; i < money.length; i ++) change.push( money[i] );

    money.sort((a, b) => b - a);
    return { name, change };
}



// Devuelve el arreglo con el nombre del producto y la cantidad minima de monedas
// o sea, el producto se paga con las monedas mas chiquitas primero
const result = buyProduct([5, 10, 200, 5, 10, 5, 5], 3);

console.log(result);
