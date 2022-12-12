/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_Controladores;

import Beans.Detalle_servicio;
import java.util.List;

public interface Interface_detalleservicio {
    
    public int insertar(Detalle_servicio d);
    
    public int actualizar(Detalle_servicio d);
    
    List<Detalle_servicio> Listado(); 
    
    public int eliminar (int id); 
    
    List<Detalle_servicio> ListadoDet(int codigo_sh);
    
    public int eliminarsh (int sh); 
    
}
