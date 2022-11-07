
package Controlador;

import Modelo_Controladores.Interface_clientes;
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
        
        try{
          String sql = "select * from clientes";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Cliente cli=new Cliente();
                cli.setId_cliente(rs.getInt(1));
                cli.setNombre(rs.getString(2));
                cli.setApellido(rs.getString(3));
                cli.setDni(rs.getInt(4));
                cli.setTelefono(rs.getInt(5));
                
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
    

    @Override
    public int anular_cliente(int dni) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "delete from clientes where dni= ?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,dni);
            resp = st.executeUpdate();
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
        return resp;
    }

    @Override
    public int actualizar_cliente(Cliente e) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "update clientes set nombre=?,apellido=?,telefono=? where dni=?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(4, e.getDni());
            st.setString(1, e.getNombre());
            st.setString(2, e.getApellido());
            st.setInt(3, e.getTelefono());

            resp = st.executeUpdate();
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
        return resp;
    }

    @Override
    public List<Cliente> BusquedaCliente(int dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
