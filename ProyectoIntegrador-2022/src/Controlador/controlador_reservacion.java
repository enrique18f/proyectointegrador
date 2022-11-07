/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Beans.Reservacion;
import UTIL.MySQLConexion;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class controlador_reservacion implements Modelo_Controladores.Interface_reservacion{

    @Override
    public int registrar_reservacion(Reservacion e) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "Insert into reservacion values(null,?,?,?,?,?,?,?,?,?)";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, e.getId_empleado());
            st.setInt(2, e.getId_cliente());
            st.setString(3, e.getCategoria_habitacion());
            st.setString(4, e.getId_numhabitacion());
            st.setString(5, e.getId_tipopago());
            st.setString(6, e.getFecha_reservacion());
            st.setString(7, e.getFecha_ingreso());
            st.setString(8, e.getFecha_salida());
            st.setDouble(9, e.getMonto_pago());
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
    public List<Reservacion> ListadoReservacion() {
         List<Reservacion> lis = new ArrayList();
        Connection conn = null;
        try{
          String sql = "select * from reservacion";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Reservacion re=new Reservacion();
                re.setCodigo(rs.getInt(1));
                re.setId_empleado(rs.getString(2));
                re.setId_cliente(rs.getInt(3));
                re.setCategoria_habitacion(rs.getString(4));
                re.setId_numhabitacion(rs.getString(5));
                re.setId_tipopago(rs.getString(6));
                re.setFecha_reservacion(rs.getString(7));
                re.setFecha_ingreso(rs.getString(8));
                re.setFecha_salida(rs.getString(9));
                re.setMonto_pago(rs.getDouble(10));
                
                lis.add(re);
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
    public int eliminar_reservacion(int codigo) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "delete from reservacion where codigo= ?";
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
    public int actualizar_reservacion(Reservacion e) {
                int resp = 0;
        Connection conn = null;
        try {
            String sql = "update reservacion set id_empleado=?,id_cliente=?,categoria_habitacion=?,id_numhabitacion=?,id_tipodepago=?,fecha_reservacion=?,fecha_ingreso=?,fecha_salida=?,monto_pago=? where CODIGO=?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(10, e.getCodigo());
            st.setString(1, e.getId_empleado());
            st.setInt(2, e.getId_cliente());
            st.setString(3, e.getCategoria_habitacion());
            st.setString(4, e.getId_numhabitacion());
            st.setString(5, e.getId_tipopago());
            st.setString(6, e.getFecha_reservacion());
            st.setString(7, e.getFecha_ingreso());
            st.setString(8, e.getFecha_salida());
            st.setDouble(9, e.getMonto_pago());

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


}
