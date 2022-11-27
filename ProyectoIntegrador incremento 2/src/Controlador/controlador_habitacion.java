
package Controlador;

import Modelo_Controladores.Interface_habitaciones;
import Beans.Habitacion;
import Beans.Categoria_Habitacion;
import Vistas.Vista_Habitacion;
import java.sql.*;
import UTIL.MySQLConexion;
import java.util.*;

public class controlador_habitacion implements Interface_habitaciones{

    @Override
    public int adicion_habitacion(Habitacion e) {
        int resp = 0;
        Connection conn = null;
        try {
            
            String sql = "Insert into habitacion values(null,?,?,?)";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, e.getCod_categoria());
            st.setInt(2, e.getNumero_hab());
            st.setInt(3, e.getPiso());
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
    public List<Habitacion> ListadoHabitacion() {
        List<Habitacion> lis = new ArrayList();
        Connection conn = null;
        
        try{
          String sql = "select * from habitacion";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Habitacion hab=new Habitacion();
                hab.setId_numhabitacion(rs.getInt(1));
                hab.setCod_categoria(rs.getString(2));
                hab.setNumero_hab(rs.getInt(3));
                hab.setPiso(rs.getInt(4));
                
                lis.add(hab);
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
    public int anular_habitacion(int numero_hab) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "delete from habitacion where numero_hab= ?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,numero_hab);
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
    public int actualizar_habitacion(Habitacion e) {
         int resp = 0;
        Connection conn = null;
        try {
            String sql = "update habitacion set cod_categoria=?,numero_hab=?,piso=? where id_numhabitacion=?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(4, e.getId_numhabitacion());
            st.setString(1, e.getCod_categoria());
            st.setInt(2, e.getNumero_hab());
            st.setInt(3, e.getPiso());
            
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
    public List<Habitacion> BusquedaHabitacion(int numero_hab) {
        List<Habitacion> lis = new ArrayList();
        Connection conn = null;
        try {
            String sql = "select id_numhabitacion,cod_categoria,numero_hab,piso from habitacion where numero_hab like ?;";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,numero_hab+"%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Habitacion ap = new Habitacion();
                ap.setId_numhabitacion(rs.getInt(1));
                ap.setCod_categoria(rs.getString(2));
                ap.setNumero_hab(rs.getInt(3));
                ap.setPiso(rs.getInt(4));
                
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

}
