
package Controlador;

import Modelo_Controladores.Interface_producto;
import Beans.Producto;
import UTIL.MySQLConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class controlador_producto implements Interface_producto {
    
    
    @Override
    public String insertar_producto(Producto p) {
        String rpta = null;
        
        Connection conn;
        try {
            String sql = "Insert into producto (NOMBRE,PRECIO,STOCK) values(?,?,?)";
            conn = MySQLConexion.getConexion();

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, p.getNombre());
            st.setDouble(2, p.getPrecio());
            st.setDouble(3, p.getStock());
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Producto registrado correctamente");
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR no se puede insertar nuevos productos .."+ex);
        }
        return rpta;
    }

    @Override
    public String actualizar_producto(Producto p) {
        String rpta = null;
        
        Connection conn;
        try{
            int cod = p.getId_producto();
            System.out.println("Este es la ID: "+cod);
            String sql = "UPDATE PRODUCTO SET NOMBRE=?, PRECIO=?, STOCK=? WHERE ID_PRODUCTO=?;";
            
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1,p.getNombre());
            st.setDouble(2,p.getPrecio());
            st.setDouble(3,p.getStock());
            st.setInt(4, cod);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Producto actualizado correctamente");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR no se puede actualizar producto .." + ex);
        }
        
        
        return rpta;
    }


    @Override
    public String anular_producto(int codigo) {
        String rpta = null;
        Connection conn;
        
        try {
            String sql = "DELETE FROM producto WHERE ID_PRODUCTO=?";
            conn = MySQLConexion.getConexion();

            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,codigo);
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Producto eliminado correctamente");
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR no se puede eliminar nuevo producto .."+ex);
        }
        return rpta;
    }

    @Override
    public String ListadoCategoria(DefaultTableModel modelo) {
        String rpta = null;
        int i = 0 ;
        Connection conn;
        try{
            String sql = "select id_producto, nombre, precio, stock FROM producto;";
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
                lista.add(rs.getDouble(4));
                
                Object[] fila = {lista.get(0),lista.get(1), lista.get(2), lista.get(3),};
                
                modelo.addRow(fila);
            }
            
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR no se pueden recuperar los registros de los productos.." + ex);
        }
        
        return rpta;
    }

    @Override
    public Producto ConsultarPorID(int id) {
        
        Producto p = new Producto();
        Connection conn;
        
        try{
            String sql = "select id_producto, nombre, precio, stock FROM producto where ID_PRODUCTO = "+id+";";
            conn = MySQLConexion.getConexion();        
            Statement s = conn.createStatement();
            ResultSet rs ;
            
            rs = s.executeQuery(sql);
            
            while(rs.next()){
                
                p.setId_producto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock((int) rs.getDouble(4));
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR no se pueden recuperar registro por id categoria" + ex);
        }
        
        
        return p;
        
    }

    @Override
    public List<Producto> BusquedaProducto(String nombre) {
       List<Producto> lis = new ArrayList();
        Connection conn = null;
        try {
            String sql = "select id_producto,nombre,precio,stock from producto where nombre like ?;";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,nombre+"%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Producto ap = new Producto();
                ap.setId_producto(rs.getInt(1));
                ap.setNombre(rs.getString(2));
                ap.setPrecio(rs.getDouble(3));
                ap.setStock(rs.getInt(4));
                lis.add(ap);
            }
        } catch (Exception ax) {
            ax.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception a2) {
            }
        }

        return lis;
    }

    @Override
    public List<Producto> ListadoProducto() {
        List<Producto> lis = new ArrayList();
        Connection conn = null;
        
        try{
          String sql = "select * from producto";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Producto cli=new Producto();
                cli.setId_producto(rs.getInt(1));
                cli.setNombre(rs.getString(2));
                cli.setPrecio(rs.getInt(3));
                cli.setStock(rs.getInt(4));
                
                lis.add(cli);
            }
            } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
   }
}
