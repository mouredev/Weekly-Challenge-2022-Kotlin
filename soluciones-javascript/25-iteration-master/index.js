/*
 * Quiero contar del 1 al 100 de uno en uno (imprimiendo cada uno).
 * ¿De cuántas maneras eres capaz de hacerlo?
 * Crea el código para cada una de ellas.
 */


/**
 * Función que imprime números de 1 al 100
 * @param {Number} forma: 1: 'for'  | 2: 'while' | 3: 'Recursividad' 
 */
const iterationMaster = (forma) => {

    if(forma === 1){

        for (let i = 1; i <= 100; i++) {
            console.log(i);
        }

    } else if ( forma === 2 ) {
        let i = 1; 
        while (i <= 100) {
            console.log(i);
            i++;
        }
    } else if( forma === 3 ) {

        const imprimirRecursivamente = (i = 1) => {
            if ( i > 100 ) return; 
            console.log(i);
            imprimirRecursivamente( i + 1);
        }

        imprimirRecursivamente();
    }else {
        console.log('No hay forma con dicho parametro');
    }

}


// iterationMaster(1);
//iterationMaster(2);
iterationMaster(3);
