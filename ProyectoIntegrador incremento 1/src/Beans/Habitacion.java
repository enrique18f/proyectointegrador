
package Beans;

public class Habitacion {
    private int id_numhabitacion;
    private int cod_categoria;
    private int piso;

    public Habitacion() {
    }

    public Habitacion(int id_numhabitacion, int cod_categoria, int piso) {
        this.id_numhabitacion = id_numhabitacion;
        this.cod_categoria = cod_categoria;
        this.piso = piso;
    }

    public int getId_numhabitacion() {
        return id_numhabitacion;
    }

    public void setId_numhabitacion(int id_numhabitacion) {
        this.id_numhabitacion = id_numhabitacion;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
    
}
