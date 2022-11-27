/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_Controladores;

import Beans.Empleado;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jair
 */
public interface Interface_empleado {
    public String insertar (Empleado o);
   public String Actualizar (Empleado o);
   public String ListadoEmpleado(DefaultTableModel modelo);
   
   public String Anular(int codigo);
   
   public Empleado ConsultarPorID(int id);
}
