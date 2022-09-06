"use strict";
const area = (polygon, width, heigth) => {
    if (polygon === 'triangulo') {
        console.log(`${polygon}\'s area is: ` + (width * heigth) / 2);
        return;
    }
    ;
    console.log(`${polygon}\'s are is: ` + width * heigth);
};
area('triangulo', 10, 30);
area('cuadrado', 10, 10);
area('rectangulo', 30, 10);
