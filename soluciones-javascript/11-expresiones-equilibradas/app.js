/*
 * Crea un programa que comprueba si los paréntesis, llaves y corchetes
 * de una expresión están equilibrados.
 * - Equilibrado significa que estos delimitadores se abren y cieran
 *   en orden y de forma correcta.
 * - Paréntesis, llaves y corchetes son igual de prioritarios.
 *   No hay uno más importante que otro.
 * - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
 * - Expresión no balanceada: { a * ( c + d ) ] - 5 }
 */

/**
 *
 * @param {String} expression
 */
const isBalanced = (expression) => {
    const expressionWithoutSpace = expression.replace(/\s+/g, "");

    let stackExpr = [];

    for (let i = 0; i < expressionWithoutSpace.length; i++) {
        const char = expressionWithoutSpace[i];

        if (char === "{" || char === "[" || char === "(") {
            stackExpr.push(char);
        } else if (char === "}" || char === "]" || char === ")") {
            if (stackExpr.length === 0) {
                return false;
            }

            const last = stackExpr.pop();

            if (
                (char === "}" && last !== "{") ||
                (char === "]" && last !== "[") ||
                (char === ")" && last !== "(")
            ) {
                return false;
            }
        }
    }

    return stackExpr.length === 0;
};

console.log(isBalanced("{ [ a * ( c + d ) ] - 5 }"));
console.log(isBalanced("{ a * ( c + d ) ] - 5 }"));
console.log(isBalanced("{ [ ((a - b) + (-4 * a)) * ( c + d ) ] - 5 }"));
