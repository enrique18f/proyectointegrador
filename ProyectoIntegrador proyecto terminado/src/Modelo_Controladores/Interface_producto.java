package Modelo_Controladores;

import Beans.Producto;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public interface Interface_producto {
    
    public String insertar_producto(Producto p);
    
    public String actualizar_producto(Producto p);
    
    public String ListadoCategoria(DefaultTableModel modelo); 
    
    List<Producto> ListadoProducto ();
    
    public String anular_producto(int codigo); 
    
    public Producto ConsultarPorID(int id);
    
    List<Producto> BusquedaProducto (String nombre);
}
