// solucion reto#3
// dificultad : media

// Es un numero prime ? 

//Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
// Hecho esto, imprime los números primos entre 1 y 100.

const isPrime = (number:number):void => {
    
    let index:number = 1;
    let result:number[] = [];

    for (index; index <= number; index++) {

        let isRemainderZero:boolean = number%index === 0;
        if (isRemainderZero ) result.push(number);
    }

    if (result.length === 2) console.log(number);
};

const oneToOneHundred = ():void => {

    let index:number = 1;

    while (index <= 100 ) {
        isPrime(index);
        index++;
    }
}

oneToOneHundred();

//big(0) time complexity = 0(n^^2)
//big(0) space complexity = 0(n^^2)


