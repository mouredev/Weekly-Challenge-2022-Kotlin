/*
 * Reto #29
 * ORDENA LA LISTA
 * Fecha publicación enunciado: 18/07/22
 * Fecha publicación resolución: 26/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que ordene y retorne una matriz de números.
 * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
 *   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 */


// MergeSort in Typescript

function compare( left:number, right:number, order:string ) : boolean {

    switch( order ) {

        case "Asc":
            return ( left < right ); 
        case "Desc":
            return ( left > right );
        default:
            return false;
    }

}


function Sort ( list: number[], order: string ) : number[] {
    
    if( list.length == 1 ) return list;
    
    const middle = list.length / 2;

    let arrayLeft: number[] = [];
    let arrayRight: number[] = [];

    for( let i = 0; i < list.length; i ++ ) {
        if( i < middle ) arrayLeft.push(list[i]);
        else arrayRight.push(list[i]);
    }

    
    arrayLeft = Sort( arrayLeft, order );
    arrayRight = Sort( arrayRight, order );
    
    const join = Merge( arrayLeft, arrayRight, order );
    
    console.log({ 
        arrayLeft,
        arrayRight,
        join
     })

    return join;
}

function Merge ( arrayLeft: number[], arrayRight: number[], order: string ) : number[] {

    let join:number[] = [];
    const n = arrayLeft.length;
    const m = arrayRight.length;

    let l = 0, r = 0;
    while( join.length < n + m ) {

        if( l == n ) {
            join.push( arrayRight[ r ++ ] );
            continue;
        }
        if( r == m ) {
            join.push( arrayLeft[ l ++ ] );
            continue;
        }
        
        if( compare( arrayLeft[ l ], arrayRight[ r ], order ) )
            join.push( arrayLeft[ l ++ ] );
        else 
            join.push( arrayRight[ r++ ] );
    } 


    return join;
}


const list = [ 6, 5, 2, 9, 3, 9, 1, 3, 6, 8, 8, 3 ];

const sortedAsc = Sort( list, "Asc" );
const sortedDesc = Sort( list, "Desc" );

console.log({
    "Ascendente": sortedAsc,
    "Descendente": sortedDesc
});