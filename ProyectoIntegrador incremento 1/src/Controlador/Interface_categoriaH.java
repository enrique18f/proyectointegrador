
package Controlador;

import Beans.Categoria_Habitacion;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public interface Interface_categoriaH {
    
    public String insertar(Categoria_Habitacion ch);
    public String Actualizar(Categoria_Habitacion ch);
   
    public String ListadoCategoria(DefaultTableModel modelo);
    
    public String Anular(int codigo);
    
    public Categoria_Habitacion ConsultarPorID(int id);
}
