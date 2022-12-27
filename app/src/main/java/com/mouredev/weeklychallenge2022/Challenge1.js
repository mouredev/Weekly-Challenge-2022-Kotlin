let message = true;

function isAnagrama(str1, str2) {
  let arrayStr1 = str1.toLowerCase().split("");
  let arrayStr2 = str2.toLowerCase().split("");
  let count = 0;

  if (arrayStr1.length != arrayStr2.length) {
    message = false
  }

  if(str1.toLowerCase() == str2.toLowerCase()){
    message = false
  }

  arrayStr1.forEach((element1) => {
    
    if (message == true){
      arrayStr2.forEach((element2) => {
        let equal = element1 == element2;
        if (equal) {
          if(count < 1){
            count = count + 1;
          }
          //console.log({ equal, count, element1, element2 });
        } else {
          //No iguales"
        }
      });
    }
    
    if (count > 1 || count == 0) {
      message = false;
      //console.log({message, count});
    } else {
      count = 0
      message = true;
      //console.log({ message, sameLetter });
    }
  });
  console.log(message);
}
// True

//isAnagrama("Amor", "Roma");
//isAnagrama("Alegan", "Angela" )
//isAnagrama("Nacionalista", "Altisonancia")
isAnagrama("Fotolitografía", "Litofotografía")
//isAnagrama("Integrarla", "Inglaterra")

// False

//isAnagrama("Hola", "Hola")
isAnagrama('adios','hola')


