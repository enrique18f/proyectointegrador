
package Beans;

public class Habitacion {
    private int id_numhabitacion;
    private String cod_categoria;
    private int numero_hab;
    private int piso;

    public Habitacion() {
    }

    public Habitacion(int id_numhabitacion, String cod_categoria, int numero_hab, int piso) {
        this.id_numhabitacion = id_numhabitacion;
        this.cod_categoria = cod_categoria;
        this.numero_hab = numero_hab;
        this.piso = piso;
    }

    public int getId_numhabitacion() {
        return id_numhabitacion;
    }

    public void setId_numhabitacion(int id_numhabitacion) {
        this.id_numhabitacion = id_numhabitacion;
    }

    public String getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(String cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public int getNumero_hab() {
        return numero_hab;
    }

    public void setNumero_hab(int numero_hab) {
        this.numero_hab = numero_hab;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }


    
}
