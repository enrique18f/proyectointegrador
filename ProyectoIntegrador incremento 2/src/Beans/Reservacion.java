/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Date;

/**
 *
 * @author User
 */
public class Reservacion {
    private int codigo;
    private String id_empleado;
    private int id_cliente;
    private String categoria_habitacion;
    private String id_numhabitacion;
    private String id_tipopago;
    private String fecha_reservacion;
    private String fecha_ingreso;
    private String fecha_salida;
    private double monto_pago;

    public Reservacion() {
    }

    public Reservacion(int codigo, String id_empleado, int id_cliente, String categoria_habitacion, String id_numhabitacion, String id_tipopago, String fecha_reservacion, String fecha_ingreso, String fecha_salida, double monto_pago) {
        this.codigo = codigo;
        this.id_empleado = id_empleado;
        this.id_cliente = id_cliente;
        this.categoria_habitacion = categoria_habitacion;
        this.id_numhabitacion = id_numhabitacion;
        this.id_tipopago = id_tipopago;
        this.fecha_reservacion = fecha_reservacion;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.monto_pago = monto_pago;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCategoria_habitacion() {
        return categoria_habitacion;
    }

    public void setCategoria_habitacion(String categoria_habitacion) {
        this.categoria_habitacion = categoria_habitacion;
    }

    public String getId_numhabitacion() {
        return id_numhabitacion;
    }

    public void setId_numhabitacion(String id_numhabitacion) {
        this.id_numhabitacion = id_numhabitacion;
    }

    public String getId_tipopago() {
        return id_tipopago;
    }

    public void setId_tipopago(String id_tipopago) {
        this.id_tipopago = id_tipopago;
    }

    public String getFecha_reservacion() {
        return fecha_reservacion;
    }

    public void setFecha_reservacion(String fecha_reservacion) {
        this.fecha_reservacion = fecha_reservacion;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }



    public double getMonto_pago() {
        return monto_pago;
    }

    public void setMonto_pago(double monto_pago) {
        this.monto_pago = monto_pago;
    }
    
}
