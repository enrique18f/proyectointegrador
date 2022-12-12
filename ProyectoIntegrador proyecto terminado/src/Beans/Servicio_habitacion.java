/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Time;

public class Servicio_habitacion {
    int codigo_sh ;
    int codigo_reservacion;
    int dni_cliente;
    String nombre_cliente;
    String habitacion;
    String fecha_hora;
    double total;

    public Servicio_habitacion() {
    }

    public Servicio_habitacion(int codigo_sh, int codigo_reservacion, int dni_cliente, String nombre_cliente, String habitacion, String fecha_hora, double total) {
        this.codigo_sh = codigo_sh;
        this.codigo_reservacion = codigo_reservacion;
        this.dni_cliente = dni_cliente;
        this.nombre_cliente = nombre_cliente;
        this.habitacion = habitacion;
        this.fecha_hora = fecha_hora;
        this.total = total;
    }



    public int getCodigo_sh() {
        return codigo_sh;
    }

    public void setCodigo_sh(int codigo_sh) {
        this.codigo_sh = codigo_sh;
    }

    public int getCodigo_reservacion() {
        return codigo_reservacion;
    }

    public void setCodigo_reservacion(int codigo_reservacion) {
        this.codigo_reservacion = codigo_reservacion;
    }

    public int getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(int dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
