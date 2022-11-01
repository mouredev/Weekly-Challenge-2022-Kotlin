const treaks = ["🎃","👻","💀","🕷","🕸","🦇"];
const treats = ["🍰","🍬","🍡","🍭","🍪","🍫","🧁","🍩"];
//console.log(treats)

const arrayResp = (resp, size) => {
   let outArray = []
   for (let i=0; i<= size; i++) {
      outArray.push(resp[Math.floor(Math.random() * (resp.length - 0) + 0)])
   }
   return outArray 
}

const halloween = (array) => {
  let totalHeight = array.reduce((acc, el) => acc+el.height, 0);
  let result = [];
  array.forEach(kid => {
     let choice = (Math.random()>=0.5)? 'truco' : 'dulce';
     let response = [];
     if (choice === 'truco') {
        let bonusName = Math.floor(kid.name.length / 2);
        let bonusAge = ((kid.age % 2)===0)? 2 : 0;
        let bonusHeight = Math.floor(totalHeight / 100 )
        let bonus = bonusAge + bonusHeight +bonusName; 
        response = arrayResp(treaks, bonus);
     } else { 
         let bonusName = kid.name.length;
         let bonusAge = (kid.age < 10)? Math.round(kid.age / 3) : 0;
         let bonusHeight = Math.floor(kid.height / 50 ) * 2; 
         let bonus = bonusAge + bonusHeight +bonusName;
         response = arrayResp(treats, bonus);
     }
     result.push(`${kid.name} que tiene ${kid.age} años y mide ${kid.height} cm, ha pedido ${choice} y le corresponden ${response}`);
  })
  return result
} 
