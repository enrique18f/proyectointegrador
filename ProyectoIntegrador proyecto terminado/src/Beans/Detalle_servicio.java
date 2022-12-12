
package Beans;

public class Detalle_servicio {
    int id_detalle;
    int codigo_sh;
    int id_produto;
    String nombre_producto;
    double preciopro;
    int cantidad;
    double total;
    

    public Detalle_servicio() {
    }

    public Detalle_servicio(int id_detalle, int codigo_sh, int id_produto, String nombre_producto, double preciopro, int cantidad, double total) {
        this.id_detalle = id_detalle;
        this.codigo_sh = codigo_sh;
        this.id_produto = id_produto;
        this.nombre_producto = nombre_producto;
        this.preciopro = preciopro;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getCodigo_sh() {
        return codigo_sh;
    }

    public void setCodigo_sh(int codigo_sh) {
        this.codigo_sh = codigo_sh;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPreciopro() {
        return preciopro;
    }

    public void setPreciopro(double preciopro) {
        this.preciopro = preciopro;
    }
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    
}
