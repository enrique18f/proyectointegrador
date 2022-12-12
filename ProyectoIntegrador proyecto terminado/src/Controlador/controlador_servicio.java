
package Controlador;

import Beans.Servicio_habitacion;
import Modelo_Controladores.Interface_servicio;
import UTIL.MySQLConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class controlador_servicio implements Interface_servicio{

    @Override
    public int insertar(Servicio_habitacion p) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "Insert into servicio_habitacion values(?,?,?,?,?,?,?)";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement (sql);
            st.setInt(1, p.getCodigo_sh());
            st.setInt(2, p.getCodigo_reservacion());
            st.setInt(3, p.getDni_cliente());
            st.setString(4, p.getNombre_cliente());
            st.setString(5, p.getHabitacion());
            st.setString(6, p.getFecha_hora());
            st.setDouble(7, p.getTotal());
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
    public int actualizar(Servicio_habitacion p) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "update servicio_habitacion set codigo_reservacion=?,dni_cliente=?,nombre_cliente=?,habitacion=?,fecha_hora=?,total=? where codigo_sh=?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(6, p.getCodigo_sh());
            st.setInt(1, p.getCodigo_reservacion());
            st.setInt(2, p.getDni_cliente());
            st.setString(3, p.getNombre_cliente());
            st.setString(4, p.getHabitacion());
            st.setString(5, p.getFecha_hora());
            st.setDouble(6, p.getTotal());
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
    public int eliminar(int codigo) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "delete from servicio_habitacion where codigo_sh= ?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,codigo);
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
    public List<Servicio_habitacion> Listado() {
        List<Servicio_habitacion> lis = new ArrayList();
        Connection conn = null;
        
        try{
          String sql = "select * from servicio_habitacion";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Servicio_habitacion cli=new Servicio_habitacion();
                cli.setCodigo_sh(rs.getInt(1));
                cli.setCodigo_reservacion(rs.getInt(2));
                cli.setDni_cliente(rs.getInt(3));
                cli.setNombre_cliente(rs.getString(4));
                cli.setHabitacion(rs.getString(5));
                cli.setFecha_hora(rs.getString(6));
                cli.setTotal(rs.getDouble(7));
                
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
    
    public String nroPedido() {
        String pedido = "";
        Connection conn = null;
        try {
            String sql = "select max(codigo_sh) from servicio_habitacion";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pedido = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return pedido;
    }

    @Override
    public List<Servicio_habitacion> BusquedaNombre(String nombre) {
        List<Servicio_habitacion> lis = new ArrayList();
        Connection conn = null;
        try {
            String sql = "select codigo_sh,codigo_reservacion,dni_cliente,nombre_cliente,habitacion,fecha_hora from servicio_habitacion where nombre_cliente like ?;";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,nombre+"%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Servicio_habitacion ap = new Servicio_habitacion();
                ap.setCodigo_sh(rs.getInt(1));
                ap.setCodigo_reservacion(rs.getInt(2));
                ap.setDni_cliente(rs.getInt(3));
                ap.setNombre_cliente(rs.getString(4));
                ap.setHabitacion(rs.getString(5));
                ap.setFecha_hora(rs.getString(6));
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
    

