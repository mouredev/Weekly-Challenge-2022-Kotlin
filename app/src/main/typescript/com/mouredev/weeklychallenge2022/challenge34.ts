
function retornaNumFaltantes(list: number[]){
  
    const asort = list.sort((a,b)=> a-b)
    let acu: number = asort[0]
    const res:any[] = []
    
        asort.forEach(i =>{
            let tmp: any[] = []
    
            if(acu !== i){
                let j
                for(j = acu; j <i; j++){
                    tmp.push(j)
                    }
            acu = j
            res.push(tmp)
            } 
            acu ++
        })
    console.log(res.flat())
        return res.flat(2)
    }
    
    
    retornaNumFaltantes([1,4,2,3,9,12,6])

    //print [ 5, 7, 8, 10, 11 ]