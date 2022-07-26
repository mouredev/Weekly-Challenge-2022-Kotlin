const DEFAULT_QUANTITY = 4;

function main(text: string): string {
  let longitude = 0;
  let transformedWord = "";

  if (!text) return "";

  const words = text.split(" ");
  longitude = getMaxLongitude(words);

  for (let word of words) {
    while (word.length < longitude) word += " ";
    transformedWord += "* " + word + " *\n";
  }

  const asterisks = generateAsterisks(longitude);
  transformedWord = asterisks + transformedWord + asterisks;

  return transformedWord;
}

const getMaxLongitude = (words: string[]): number => {
  let longitude = 0;
  for (let word of words)
    longitude = longitude > word.length ? longitude : word.length;
  return longitude;
};

const generateAsterisks = (quantity: number): string => {
  let asterisks = "";
  for (let i = 0; i < quantity + DEFAULT_QUANTITY; i++) asterisks += "*";
  return asterisks + "\n";
};

console.log(main("Hola"));
console.log(main("¿Qué te parece el reto?"));
console.log(main("Tres tristes tigres, tragaban trigo en un trigal, en tres tristes trastos, tragaban trigo tres tristes tigres"));
