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
    private int id_empleado;
    private int id_cliente;
    private int id_numhabitacion;
    private int id_tipopago;
    private Date fecha_reservacion;
    private Date fecha_ingreso;
    private Date fecha_salida;
    private double monto_pago;

    public Reservacion() {
    }

    public Reservacion(int codigo, int id_empleado, int id_cliente, int id_numhabitacion, int id_tipopago, Date fecha_reservacion, Date fecha_ingreso, Date fecha_salida, double monto_pago) {
        this.codigo = codigo;
        this.id_empleado = id_empleado;
        this.id_cliente = id_cliente;
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

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_numhabitacion() {
        return id_numhabitacion;
    }

    public void setId_numhabitacion(int id_numhabitacion) {
        this.id_numhabitacion = id_numhabitacion;
    }

    public int getId_tipopago() {
        return id_tipopago;
    }

    public void setId_tipopago(int id_tipopago) {
        this.id_tipopago = id_tipopago;
    }

    public Date getFecha_reservacion() {
        return fecha_reservacion;
    }

    public void setFecha_reservacion(Date fecha_reservacion) {
        this.fecha_reservacion = fecha_reservacion;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public double getMonto_pago() {
        return monto_pago;
    }

    public void setMonto_pago(double monto_pago) {
        this.monto_pago = monto_pago;
    }
    
}
