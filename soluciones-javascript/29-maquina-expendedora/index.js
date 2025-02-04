/*
 * Simula el funcionamiento de una máquina expendedora creando una operación
 * que reciba dinero (array de monedas) y un número que indique la selección
 * del producto.
 * - El programa retornará el nombre del producto y un array con el dinero
 *   de vuelta (con el menor número de monedas).
 * - Si el dinero es insuficiente o el número de producto no existe,
 *   deberá indicarse con un mensaje y retornar todas las monedas.
 * - Si no hay dinero de vuelta, el array se retornará vacío.
 * - Para que resulte más simple, trabajaremos en céntimos con monedas
 *   de 5, 10, 50, 100 y 200.
 * - Debemos controlar que las monedas enviadas estén dentro de las soportadas.
 */

const productos = [
    { codigo: "A1", nombre: "Papitas de Pollo", precio: 100 },
    { codigo: "A3", nombre: "Doritos dinamita", precio: 100 },
    { codigo: "B1", nombre: "agua", precio: 10 },
    { codigo: "B2", nombre: "agua con gas", precio: 100 },
    { codigo: "B3", nombre: "agua con sabor a fresa", precio: 100 },
    { codigo: "C1", nombre: "Gomitas", precio: 100 },
    { codigo: "C2", nombre: "Trululu", precio: 100 },
    { codigo: "C3", nombre: "gomitas acidas", precio: 100 },
    { codigo: "D1", nombre: "Coca Cola", precio: 200 },
    { codigo: "D2", nombre: "Fanta", precio: 200 },
    { codigo: "D3", nombre: "Sprite", precio: 200 },
    { codigo: "E1", nombre: "Margaritas Naturales", precio: 100 },
    { codigo: "E2", nombre: "Margaritas Picantes", precio: 100 },
    { codigo: "E3", nombre: "Doritos", precio: 100 },
];

const monedasSoportadas = [5, 10, 50, 100, 200];

const calcularCambio = (cambio) => {
    let resultado = [];

    for (let moneda of monedasSoportadas.sort((a, b) => b - a)) {
        while (cambio >= moneda) {

            resultado.push(moneda);

            cambio -= moneda;
        }
    }

    return resultado; 
};

/**
 * Simula el funcionamiento de una máquina expendedora.
 *
 * @param {Object} param0 - Objeto con la información del pedido.
 * @param {number[]} param0.dinero - Array de monedas ingresadas en la máquina.
 * @param {string} param0.seleccionProducto - Código del producto seleccionado.
 * @returns {string|Object} Mensaje de error o un objeto con el producto y el cambio.
 */
const maquinaExpendedora = ({ dinero, seleccionProducto }) => {
    // Validar que todas las monedas ingresadas sean soportadas
    if (!dinero.every((m) => monedasSoportadas.includes(m))) {
        return "Error: Se han Ingresado monedas no soportadas. Se devuelve el dinero";
    }

    const producto = productos.find((p) => p.codigo === seleccionProducto);

    const dineroTotal = dinero.reduce((acc, moneda) => acc + moneda, 0);

    // Si el producto no existe, devolver dinero
    if (!producto) {
        return "Error: Producto no encontrado. Se devuelve el dinero.";
    }

    // Si el dinero es insuficiente, devolver dinero
    if (dineroTotal < producto.precio) {
        return "Error: Dinero insuficiente. Se devuelve el dinero.";
    }

    const cambio = calcularCambio(dineroTotal - producto.precio);

    return {
        producto: producto.nombre,
        cambio
    };
};

console.log(maquinaExpendedora({ dinero: [100, 50, 50], seleccionProducto: "A1" }));
// { producto: 'Papitas de Pollo', cambio: [100] }

console.log(maquinaExpendedora({ dinero: [5, 10, 50], seleccionProducto: "B1" }));
// { producto: 'Agua', cambio: [50, 10, 5] }

console.log(maquinaExpendedora({ dinero: [100, 100], seleccionProducto: "D1" }));
// { producto: 'Coca Cola', cambio: [] }

console.log(maquinaExpendedora({ dinero: [200], seleccionProducto: "Z1" }));
// "Error: Producto no encontrado. Se devuelve el dinero."

console.log(maquinaExpendedora({ dinero: [500], seleccionProducto: "A1" }));
// "Error: Se han ingresado monedas no soportadas. Se devuelve el dinero."
