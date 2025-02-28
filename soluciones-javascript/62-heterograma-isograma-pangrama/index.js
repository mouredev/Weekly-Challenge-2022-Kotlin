/*
 * Crea 3 funciones, cada una encargada de detectar si una cadena de
 * texto es un heterograma, un isograma o un pangrama.
 * - Debes buscar la definición de cada uno de estos términos.
 */

function esHeterograma(texto) {
    const letras = new Set();
    for (let letra of texto.toLowerCase().replace(/[^a-záéíóúüñ]/g, "")) {
        if (letras.has(letra)) return false;
        letras.add(letra);
    }
    return true;
}

function esIsograma(texto) {
    const conteo = {};
    const letras = texto.toLowerCase().replace(/[^a-záéíóúüñ]/g, "");

    for (let letra of letras) {
        conteo[letra] = (conteo[letra] || 0) + 1;
    }

    const valores = Object.values(conteo);
    return valores.every(v => v === valores[0]);
}

function esPangrama(texto) {
    const alfabeto = new Set("abcdefghijklmnñopqrstuvwxyz");
    const letrasEnTexto = new Set(texto.toLowerCase().replace(/[^a-záéíóúüñ]/g, ""));
    return [...alfabeto].every(letra => letrasEnTexto.has(letra));
}

// Ejemplos de uso
console.log(esHeterograma("murciélago"));
console.log(esIsograma("murciélago"));
console.log(esPangrama("El veloz murciélago hindú comía feliz cardillo y kiwi."));