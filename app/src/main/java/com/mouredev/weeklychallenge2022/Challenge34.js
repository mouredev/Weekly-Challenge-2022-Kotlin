const numbers = [1,2,4,6,8,10,11,15];  // correct array
// const numbers = [1,3,5,6,8,2] // incorrect array

const getMissing = () => {
  let missing = [];

  for (let i = 0; i < numbers.length; i++) { // check array
    if (
      numbers.at(-1) <= numbers[0] ||
      numbers[i] >= numbers[i + 1] ||
      numbers[i + 1] <= numbers[i]
    ) {
      console.error("El array de entrada no es correcto");
      return;
    }
  }

  for (let i = numbers[0]; i <= numbers.at(-1); i++) { // get missing numbers
    if (!numbers.includes(i)) {
      missing.push(i);    
    }
  }
  console.log(`Los numeros faltantes entre el ${numbers.at(0)} y el ${numbers.at(-1)} son: ${missing}`);
  return missing;
};

getMissing()