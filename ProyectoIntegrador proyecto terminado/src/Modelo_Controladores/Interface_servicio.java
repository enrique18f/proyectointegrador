/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_Controladores;

import Beans.Servicio_habitacion;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public interface Interface_servicio {
    
    public int insertar(Servicio_habitacion p);
    
    public int actualizar(Servicio_habitacion p);
    
    List<Servicio_habitacion> Listado(); 
    
    public int eliminar (int codigo); 
    
    List<Servicio_habitacion> BusquedaNombre(String nombre);

}
