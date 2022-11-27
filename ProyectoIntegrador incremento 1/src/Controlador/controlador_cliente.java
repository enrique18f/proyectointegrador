
package Controlador;

import Beans.Cliente;
import java.sql.*;
import UTIL.MySQLConexion;
import java.util.*;


public class controlador_cliente implements Interface_clientes{

    @Override
    public int adicion_cliente(Cliente e) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "Insert into clientes values(null,?,?,?,?)";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, e.getNombre());
            st.setString(2, e.getApellido());
            st.setInt(3, e.getDni());
            st.setInt(4, e.getTelefono());
            resp = st.executeUpdate(); 
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return resp;
    }

    @Override
    public List<Cliente> ListadoCliente() {
        List<Cliente> lis = new ArrayList();
        Connection conn = null; 
        
        return lis;
    }

    @Override
    public int anular_cliente(int dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar_cliente(Cliente e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> BusquedaCliente(int dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
