
package Controlador;

import Modelo_Controladores.Interface_categoriaH;
import Beans.Categoria_Habitacion;
import UTIL.MySQLConexion;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class controlador_categoriaH implements Interface_categoriaH{
    ArrayList<Categoria_Habitacion>lista;
    
    public controlador_categoriaH(){
        lista=new ArrayList();
    }
    
    public void AgregarCategorias(Categoria_Habitacion a){
        lista.add(a);
    }
    
    @Override
    public String insertar(Categoria_Habitacion ch) {
        String rpta = null;
        
        Connection conn;
        try {
            String sql = "Insert into categoria_habitacion (DESCRIPCION,PRECIO) values(?,?)";
            conn = MySQLConexion.getConexion();

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, ch.getDescripcion());
            st.setDouble(2, ch.getPrecio());
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Categoria registrada correctamente");
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR no se puede insertar nueva categoria .."+ex);
        }
        return rpta;
    }

    @Override
    public String Actualizar(Categoria_Habitacion ch) {
        String rpta = null;
        
        Connection conn;
        try{
            int cod = ch.getCod_categoria();
            System.out.println("Este es el codigo: "+cod);
            String sql = "UPDATE CATEGORIA_HABITACION SET DESCRIPCION=?, PRECIO=? WHERE COD_CATEGORIA=?;";
            
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1,ch.getDescripcion());
            st.setDouble(2,ch.getPrecio());
            st.setInt(3, cod);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Categoria actualizada correctamente");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR no se puede actualizar categoria .." + ex);
        }
        
        
        return rpta;
    }


    @Override
    public String Anular(int codigo) {
        String rpta = null;
        Connection conn;
        
        try {
            String sql = "DELETE FROM categoria_habitacion WHERE COD_CATEGORIA=?";
            conn = MySQLConexion.getConexion();

            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,codigo);
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Categoria eliminada correctamente");
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR no se puede eliminar nueva categoria .."+ex);
        }
        return rpta;
    }

    @Override
    public String ListadoCategoria(DefaultTableModel modelo) {
        String rpta = null;
        int i = 0 ;
        Connection conn;
        try{
            String sql = "select cod_categoria, descripcion, precio FROM categoria_habitacion;";
            conn = MySQLConexion.getConexion();        
            Statement s = conn.createStatement();
            ResultSet rs ;
            
            rs = s.executeQuery(sql);
            
            while(rs.next()){
                i++;
                ArrayList lista = new ArrayList();
                lista.add(rs.getInt(1));
                lista.add(rs.getString(2));
                lista.add(rs.getDouble(3));
                
                Object[] fila = {lista.get(0),lista.get(1), lista.get(2)};
                
                modelo.addRow(fila);
            }
            
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR no se pueden recuperar los registros de categorias.." + ex);
        }
        
        return rpta;
    }

    @Override
    public Categoria_Habitacion ConsultarPorID(int id) {
        
        Categoria_Habitacion ch = new Categoria_Habitacion();
        Connection conn;
        
        try{
            String sql = "select cod_categoria, descripcion, precio FROM categoria_habitacion where COD_CATEGORIA = "+id+";";
            conn = MySQLConexion.getConexion();        
            Statement s = conn.createStatement();
            ResultSet rs ;
            
            rs = s.executeQuery(sql);
            
            while(rs.next()){
                
                ch.setCod_categoria(rs.getInt(1));
                ch.setDescripcion(rs.getString(2));
                ch.setPrecio(rs.getDouble(3));
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR no se pueden recuperar registro por id categoria" + ex);
        }
        
        
        return ch;
        
    }


    
}
