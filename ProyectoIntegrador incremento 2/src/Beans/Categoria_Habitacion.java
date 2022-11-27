
package Beans;


public class Categoria_Habitacion {
    private int cod_categoria;
    private String descripcion;
    private Double precio;

    public Categoria_Habitacion() {
    }

    public Categoria_Habitacion(int cod_categoria, String descripcion, Double precio) {
        this.cod_categoria = cod_categoria;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
