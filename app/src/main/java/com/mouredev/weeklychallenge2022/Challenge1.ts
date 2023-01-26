function anagrama(palabra1: String, palabra2: String): Boolean {
  if (palabra1.toLowerCase() === palabra2.toLowerCase()) return false;
  if (
    JSON.stringify(palabra1.toLowerCase().split("").sort()) ==
    JSON.stringify(palabra2.toLowerCase().split("").sort())
  )
    return true;
  else return false;
}
console.log(anagrama("hola", "laho"));
