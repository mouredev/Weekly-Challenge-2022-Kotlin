const array1 = [1, 0, 1, 0, 3, 5, 7, 4, 7, 4];

const array2 = [5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5];

let boomerangs = [];

const findBoomerangs = (arr) => {
  let index = 0;
  for (let i = 0; i < arr.length - 2; i++) {
    if (arr[index] != arr[index + 1] && arr[index] === arr[index + 2]) {
      boomerangs.push([arr[index], arr[index + 1], arr[index + 2]]);
      index++;
    } else {
      index++;
    }
  }

  // Muestra la cantidad de boomerangs encontrados
  console.log(
    `El número de boomerangs en el array inicial es de: ${boomerangs.length}`
  );

  // Muestra los boomerangs encontrados.
  console.log(boomerangs);
  boomerangs = [];
};

findBoomerangs(array1);

// Otro array para probar:
// findBoomerangs(array2);
