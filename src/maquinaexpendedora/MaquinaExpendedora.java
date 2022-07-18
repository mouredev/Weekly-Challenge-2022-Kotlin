package maquinaexpendedora;

import UtilidadesES.UtilidadesES;
import java.util.List;
import java.util.ArrayList;

/**
 *  Enunciado: Simula el funcionamiento de una máquina expendedora creando una operación
 * que reciba dinero (array de monedas) y un número que indique la selección del producto.
 * - El programa retornará el nombre del producto y un array con el dinero de vuelta (con el menor
 *   número de monedas).
 * - Si el dinero es insuficiente o el número de producto no existe, deberá indicarse con un mensaje
 *   y retornar todas las monedas.
 * - Si no hay dinero de vuelta, el array se retornará vacío.
 * - Para que resulte más simple, trabajaremos en céntimos con monedas de 5, 10, 50, 100 y 200.
 * - Debemos controlar que las monedas enviadas estén dentro de las soportadas.
 *
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */
public class MaquinaExpendedora {
    final static int CINCO_CENTIMOS = 0;
    final static int DIEZ_CENTIMOS = 1;
    final static int CINCUENTA_CENTIMOS = 2;
    final static int CIEN_CENTIMOS = 3;
    final static int DOSCIENTOS_CENTIMOS = 4; 
    
    final static int SALIR = 0;    
    final static String TRIA_OPCION = "Selecciona una opcion: ";
    final static String PRODUCTO_EXISTENTE = "\nERROR. El producto ya existe.\n";
    final static String PRODUCTO_INEXISTENTE = "\nERROR. El producto no existe.\n";
    final static String ERROR_SWITCH = "\nERROR. Opción no contemplada.\n";
    final static String ERROR_MONEDA = "\nERROR. Tipo de moneda no permitida.\n";
    final static String DINERO_INSUFICIENTE = "\nERROR. El importe comprado és superior a la cantidad pagada.\n";
    final static String NO_HAY_CAMBIO = "\nERROR. No hay suficiente cambio para la devolución.\n";
    
    private List<Producto> producto = new ArrayList<>();  
    private int[] caja = new int[5];
    private int[] moneda = {5, 10, 50, 100, 200};
    
    UtilidadesES utilsES;

    public static void main(String[] args) {
        MaquinaExpendedora maquinaExpenedora = new MaquinaExpendedora();
        maquinaExpenedora.inicio();        
    }
    private void inicio() {
        utilsES = new UtilidadesES();
        
        inicializar();      // Carga monedas en la caja y crea un producto

        String[] menu = {
            "Salir",
            "Màquina expenedora",
            "Productos",
            "Comprar"
        };
        int opcion;
        
        do {
            utilsES.mostrarMenu("Menú principal", menu);
            opcion = utilsES.pedirEntero(TRIA_OPCION, SALIR, menu.length-1);
            switch(opcion){
                case SALIR:
                    System.out.println("\nHasta la próxima!!!!\n");
                    break;
                case 1:
                    maquinaExpendedora();
                    break;
                case 2:
                    productos();
                    break;
                case 3:
                    comprar();
                    break;
                default:                     
                    System.out.println(ERROR_SWITCH);
            }            
        } while(opcion != SALIR);
        
    }

    
    /**
     * Màquina expendedora
     */
    public void maquinaExpendedora() {
        utilsES = new UtilidadesES();
        
        String[] menu = {
            "Volver menú principal",
            "Ver monedas",
            "Intorducir monedas"
        };
        int opcion;
        
        do {
            utilsES.mostrarMenu("Caja máquina expendedora", menu);
            opcion = utilsES.pedirEntero(TRIA_OPCION, SALIR, menu.length -1);
            switch(opcion) {
                case 1:
                    verMonedas();
                    break;
                case 2:
                    anadirMonedas();                    
                    break;
                default:                     
                    System.out.println(ERROR_SWITCH);
            }
        } while(opcion != SALIR);
    }
    /**
     * Ver cantidades de monedas que hay en la caja
     */
    public void verMonedas() {     
        System.out.println("Monedas en la caja\n");
        System.out.println("5 cenitmos : " + monedas(CINCO_CENTIMOS));
        System.out.println("10 centimos: " + monedas(DIEZ_CENTIMOS));
        System.out.println("50 centimos: " + monedas(CINCUENTA_CENTIMOS));
        System.out.println("100 centimos: " + monedas(CIEN_CENTIMOS));
        System.out.println("200 centimos: " + monedas(DOSCIENTOS_CENTIMOS) + "\n");        
    }
    /**
     * Añade monedas a la caja
     */
    public void anadirMonedas() {
        utilsES = new UtilidadesES();
        
        int tipoMoneda;        
        int cantidad;
        
        do {
            tipoMoneda = utilsES.pedirEntero("Tipo de moneda a insertar (0 para salir): ", 0, Integer.MAX_VALUE);
            if(tipoMoneda != 0) {
                cantidad = utilsES.pedirEntero("Cantidad de moneda a insertar: ", 0, Integer.MAX_VALUE);
                switch(tipoMoneda) {
                    case 5:
                        caja[CINCO_CENTIMOS] += cantidad;
                        break;
                    case 10:
                        caja[DIEZ_CENTIMOS] += cantidad;
                        break;   
                    case 50:
                        caja[CINCUENTA_CENTIMOS] += cantidad;
                        break;    
                    case 100:
                        caja[CIEN_CENTIMOS] += cantidad;
                        break;   
                    case 200:
                        caja[DOSCIENTOS_CENTIMOS] += cantidad;
                        break;                          
                    default:
                        System.out.println(ERROR_MONEDA);                    
                }
            }
        } while(tipoMoneda != 0);        
    }
    /**
     * Devuelve las monedas que hay del tipo pasado por parámetro
     * @param tipo
     * @return      
     */
    public int monedas(int tipo) {        
        return caja[tipo];
    }

    
    /**
     * Productos 
     */
    public void productos() {
        utilsES = new UtilidadesES();
        
        String[] menu = {
            "Volver menú principal",
            "Listar productos",
            "Alta producto",          
            "Eliminar producto"
        };
        int opcion;
        
        do {
            utilsES.mostrarMenu("Menú productos", menu);
            opcion = utilsES.pedirEntero(TRIA_OPCION, SALIR, menu.length -1);
            switch(opcion) {
                case 1:
                    listarProductos();
                    break;
                case 2:
                    altaProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                default:                     
                    System.out.println(ERROR_SWITCH);
            }
        } while(opcion != SALIR);
    }
    /**
     * Lista los productos dados de alta
     */
    public void listarProductos() {
        for (Producto productos : producto) {
            System.out.println("Codigo: " + productos.getCodigo() + ", Nombre: " + productos.getNombre() + ", Precio: " + productos.getPrecio() + "€");
        }
    }
    /**
     * Añade un producto si no existe 
     */
    public void altaProducto() {
        Producto nuevoProducto;
        nuevoProducto = Producto.anadirProducto(null);
        if(posicionProducto(nuevoProducto.getCodigo()) != -1) {
            System.out.println(PRODUCTO_EXISTENTE);
        } else {
            producto.add(nuevoProducto);
        }
    }
    /**
     * Elimina un producto
     */
    public void eliminarProducto() {
        utilsES = new UtilidadesES();
        
        int codigo = utilsES.pedirEntero("Que producto quieres eliminar: ", 0, Integer.MAX_VALUE);
        int posicion = posicionProducto(codigo);
                       
        if(posicion != -1) {
            producto.remove(posicion);
        } else {
            System.out.println(PRODUCTO_INEXISTENTE);
        }
    }
  
    /**
     * Busca la posición de un producto 
     * Si no existe devuelve -1
     * @param codigo
     * @return 
     */
    public int posicionProducto(int codigo) {
        int posicion = -1;
        
        for(int i = 0; i < producto.size(); i++) {
            if(producto.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        return posicion;        
    }
    
    /**
     * Comprar
     */
    public void comprar() {
        utilsES = new UtilidadesES();
        
        int codigoProducto;
        int cantidadProductoAComprar;        
        int posicionProductoAComprar;
        int importePagado;
        int importeCompra;
        int[] devolucion = new int[5];
        
        do {
            codigoProducto = utilsES.pedirEntero("Codigo producto a comprar: ", 0, Integer.MAX_VALUE);
            posicionProductoAComprar = posicionProducto(codigoProducto);
            if(posicionProductoAComprar == -1) {
                System.out.println(PRODUCTO_INEXISTENTE);
            }
        } while(posicionProductoAComprar == -1);
        
        cantidadProductoAComprar = utilsES.pedirEntero("Cantidad producto a comprar: ", 0, Integer.MAX_VALUE);
        importePagado = pagar();
        importeCompra = cantidadProductoAComprar * (producto.get(posicionProductoAComprar)).getPrecio();
        
        devolucion = calcularDevolucion(importePagado, importeCompra);
        
        System.out.println("\nMonedas a devolver\n");
        for(int i = 0; i < devolucion.length; i++) {
            System.out.println(moneda[i] + "€ - " + devolucion[i]);
        }
    
    }
    /**
     * pagar una compra
     * @return 
     */
    public int pagar() {
        utilsES = new UtilidadesES();
        
        int cantidadPagada = 0;
        int tipoMoneda;
        int cantidadMoneda;        
        
        System.out.println("\nPagar la compra\n");
        do {  
            tipoMoneda = utilsES.pedirEntero("Tipo de moneda (0 para salir) : ", 0, Integer.MAX_VALUE);
            if(tipoMoneda != 0) {
                cantidadMoneda = utilsES.pedirEntero("Cantidad monedas pagadas: ", 0, Integer.MAX_VALUE);
                switch(tipoMoneda) {
                    case 5:
                        cantidadPagada =+ (5 * cantidadMoneda);
                        break;
                    case 10:
                        cantidadPagada =+ (10 * cantidadMoneda);
                        break;
                    case 50:
                        cantidadPagada =+ (50 * cantidadMoneda);
                        break;    
                    case 100:
                        cantidadPagada =+ (100 * cantidadMoneda);
                        break; 
                    case 200:
                        cantidadPagada =+ (200 * cantidadMoneda);
                        break;                        
                    default:
                        System.out.println(ERROR_MONEDA);   
                }
            }
        } while(tipoMoneda != 0);
        
        return cantidadPagada;
    }
    /**
     * Calcula la devolución de la compra
     * @param pagado
     * @param importeCompra
     * @return 
     */
    public int[] calcularDevolucion(int pagado, int importeCompra) {
        int[] devolucion = new int[5];
        int importeADevolver = pagado - importeCompra;      
    
        if(importeADevolver == 0) {
            System.out.println("\nSe ha introducido el importe justo.\n");
        } else if(importeADevolver > 0 ) {
            if(importeADevolver/200 > 0 && caja[DOSCIENTOS_CENTIMOS] > 0) {
                devolucion[DOSCIENTOS_CENTIMOS] = calcularMonedasDevolver(DOSCIENTOS_CENTIMOS, importeADevolver);
                importeADevolver = importeADevolver - devolucion[DOSCIENTOS_CENTIMOS] * 200;
            }
                        
            if(importeADevolver/100 > 0 && caja[CIEN_CENTIMOS] > 0) {
                devolucion[CIEN_CENTIMOS] = calcularMonedasDevolver(CIEN_CENTIMOS, importeADevolver);
                importeADevolver = importeADevolver - devolucion[CIEN_CENTIMOS] * 100;           
            } 
                          
            if(importeADevolver/50 > 0 && caja[CINCUENTA_CENTIMOS] > 0) {
                devolucion[CINCUENTA_CENTIMOS] = calcularMonedasDevolver(CINCUENTA_CENTIMOS, importeADevolver);
                importeADevolver = importeADevolver - devolucion[CINCUENTA_CENTIMOS] * 50;           
            }  
            
            if(importeADevolver/10 > 0 && caja[DIEZ_CENTIMOS] > 0) {     
                devolucion[DIEZ_CENTIMOS] = calcularMonedasDevolver(DIEZ_CENTIMOS, importeADevolver); 
                importeADevolver = importeADevolver - devolucion[DIEZ_CENTIMOS] * 10;  
            }
            
            
            if(importeADevolver/5 > 0 && caja[CINCO_CENTIMOS] > 0) {
                devolucion[CINCO_CENTIMOS] = calcularMonedasDevolver(CINCO_CENTIMOS, importeADevolver);
                importeADevolver = importeADevolver - devolucion[CINCO_CENTIMOS] * 5;           
            } 
            
        } else {
            System.out.println(DINERO_INSUFICIENTE);            
        }   
        if(importeADevolver == 0) {
            actualizarCaja(devolucion);
            return devolucion;
        } else {
            System.out.println(NO_HAY_CAMBIO);
            return new int[5];
        }
    }
    /**
     * Si hay suficientes monedas devuelve valor pasado por parámetro
     * si no hay suficiente, devuelve la cantidad de moenda en caja
     * @param tipoMoneda
     * @param cantidadDevolver
     * @return 
     */    
    public int calcularMonedasDevolver(int tipoMoneda, int cantidadDevolver) {        
        
        if((caja[tipoMoneda] * moneda[tipoMoneda]) < cantidadDevolver) {
            System.out.println("-----" + caja[tipoMoneda]);
            return caja[tipoMoneda];            
        } else {            
            return cantidadDevolver / moneda[tipoMoneda];
        }
    }  
    /**
     * Actualiza las monedas en caja 
     * @param cambio 
     */
    public void actualizarCaja(int[] cambio) {
        for(int i = 0; i < caja.length; i++) {
            caja[i] = caja[i] - cambio[i];
        }        
    }
    /**
     * Crea un producto y pone monedas en la caja 
     */
    public void inicializar() {
        // Inicializao caja
        for(int i = 0; i < caja.length; i ++) {
            caja[i] = i * 2;
        }
        // Inicializo producto
        Producto producto1= new Producto(1,"Pizza",10);
        producto.add(producto1);
    }
}