package ordenalista;


/**
 *  Reto #29
 *   Enunciado: Crea una función que ordene y retorne una matriz de números.
 * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
 *   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 * 
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */
public class OrdenaLista {

     public static void main(String[] args) {
        OrdenaLista ordenaLista = new OrdenaLista();
        ordenaLista.inicio();
    }
    private void inicio() {
        int[] array = crearArray(10);
   
        System.out.println("Mostramos array inicial sin ordenar");
        mostrarArray(array);
        
        System.out.println("Array ordenado Ascendente");       
        mostrarArray(ordenarArray(array,"Asc"));
                
        System.out.println("Array ordenado Descendente");
        mostrarArray(ordenarArray(array,"Desc"));
        
        
    }
    /**
     * Crea un array de enteros aleatorios
     * @param dimension
     * @return 
     */
    public int[] crearArray(int dimension) {
        int[] array = new int[dimension];

        for(int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()* dimension);
        }        
        return array;
    }
    /**
     * Muestra los valores de un array
     * @param array 
     */
    public void mostrarArray(int[] array) {       
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    /**
     * Ordena un array por método burbuja 
     * @param array
     * @param tipoOrdenacion
     * @return 
     */
    public int[] ordenarArray(int[] array, String tipoOrdenacion) {       
        switch(tipoOrdenacion) {
            case "Asc":
            case "asc":
            case "ASC":
                array = burbujaAscendente(array);
                break;
            case "Desc":
            case "desc" :
            case "DESC":
                array = burbujaDescendente(array);
                break;
            default:
                System.out.println("Tipo de ordenación incorrecta.");                 
                
        }
        return array;       
    }
    /**
     * Ordenacion ascendente
     * @param array
     * @return 
     */
    public int[] burbujaAscendente(int[] array) {
        int intercanvio;
        
        for(int i = 0; i < array.length-1; i++) {
            for(int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    intercanvio = array[i];
                    array[i] =  array[j];    
                    array[j] = intercanvio;                                         
                }
            }
        }
        return array;
    }
    /**
     * Ordenacion descendente
     * @param array
     * @return 
     */
    
    public int[] burbujaDescendente(int[] array) {
        int intercanvio;
        
        for(int i = 0; i < array.length-1; i++) {
            for(int j = i+1; j < array.length; j++) {
                if(array[i] < array[j]) {
                    intercanvio = array[i];
                    array[i] =  array[j];    
                    array[j] = intercanvio;                                            
                }
            }
        }
        return array;
    }    
    
}
