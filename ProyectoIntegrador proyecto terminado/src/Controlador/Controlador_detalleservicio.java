
package Controlador;

import Beans.Detalle_servicio;
import UTIL.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Controlador_detalleservicio implements Modelo_Controladores.Interface_detalleservicio{

    @Override
    public int insertar(Detalle_servicio d) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "Insert into detalle_servicio values(null,?,?,?,?,?,?)";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement (sql);
            st.setInt(1, d.getCodigo_sh());
            st.setInt(2, d.getId_produto());
            st.setString(3, d.getNombre_producto());
            st.setDouble(4, d.getPreciopro());
            st.setInt(5, d.getCantidad());
            st.setDouble(6, d.getTotal());
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
    public int actualizar(Detalle_servicio d) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "update detalle_servicio set codigo_sh=?,id_producto=?,nombre_producto=?,preciopro=?,cantidad=?,total=? where id_detalle=?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(7, d.getId_detalle());
            st.setInt(1, d.getCodigo_sh());
            st.setInt(2, d.getId_produto());
            st.setString(3, d.getNombre_producto());
            st.setDouble(4, d.getPreciopro());
            st.setInt(5, d.getCantidad());
            st.setDouble(6, d.getTotal());
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
    public List<Detalle_servicio> Listado() {
        List<Detalle_servicio> lis = new ArrayList();
        Connection conn = null;
        try{
          String sql = "select * from detalle_servicio";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Detalle_servicio cli=new Detalle_servicio();
                cli.setId_detalle(rs.getInt(1));
                cli.setCodigo_sh(rs.getInt(2));
                cli.setId_produto(rs.getInt(3));
                cli.setNombre_producto(rs.getString(4));
                cli.setPreciopro(rs.getDouble(5));
                cli.setCantidad(rs.getInt(6));
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

    @Override
    public int eliminar(int id_detalle) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "delete from detalle_servicio where id_detalle= ?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id_detalle);
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
    public List<Detalle_servicio> ListadoDet(int codigo_sh) {
           List<Detalle_servicio> lis = new ArrayList();
        Connection conn = null;
        try {
            String sql = "select * from detalle_servicio where codigo_sh=? ";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, codigo_sh);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Detalle_servicio ep = new Detalle_servicio();
                ep.setId_detalle(rs.getInt(1));
                ep.setCodigo_sh(rs.getInt(2));
                ep.setId_produto(rs.getInt(3));
                ep.setNombre_producto(rs.getString(4));
                ep.setPreciopro(rs.getDouble(5));
                ep.setCantidad(rs.getInt(6));
                ep.setTotal(rs.getDouble(7));

                lis.add(ep);
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
    public int eliminarsh(int sh) {
              int resp = 0;
        Connection conn = null;
        try {
            String sql = "delete from detalle_servicio where codigo_sh= ?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,sh);
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
 
    

