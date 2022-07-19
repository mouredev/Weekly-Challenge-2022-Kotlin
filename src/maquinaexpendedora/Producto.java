
package maquinaexpendedora;

import UtilidadesES.UtilidadesES;

/**
 *
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */
public class Producto {   
    private int codigo;
    private String nombre;
    private int precio;

    // Método construcor
    public Producto(int codigo, String nombre, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    //Métodos accesores
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Añadir un nuevo producto
     * @param nuevoProducto
     * @return 
     */
    public static Producto anadirProducto(Producto nuevoProducto) {
        UtilidadesES utilsES = new UtilidadesES();
        if(nuevoProducto == null) {        
            int codigo = utilsES.pedirEntero("Introduce el código del producto: ", 0, 100);
            String nombre = utilsES.pedirCadena("Introduce nombre del producto: ");
            int precio = utilsES.pedirEntero("Introduce el precio: ", 0, Integer.MAX_VALUE);
            nuevoProducto = new Producto(codigo, nombre, precio);
        }        
        return nuevoProducto;    
    }
}
