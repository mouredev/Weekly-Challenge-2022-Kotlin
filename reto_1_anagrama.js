function esAnagrama(word1, word2) {
  let count = 0;
  for (letter1 of word1.toUpperCase()) {
    for (letter2 of word2.toUpperCase()) {
      if (letter1 === letter2) count += 1;
    }
  }
  if (count === word1.length) return true;
  else return false;
}

const result = esAnagrama("cuantos", "sotncua");
console.log(result);
