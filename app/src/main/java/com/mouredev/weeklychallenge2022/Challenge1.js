const esAnagrama = (a,b) =>{
  p1 = a.toLowerCase();
  p2 = b.toLowerCase().split("").reverse().join("");
  if(p1 === p2) return true;
    return false;
}