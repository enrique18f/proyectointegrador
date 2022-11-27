/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Beans.Tipo_Pagos;
import UTIL.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class controlador_tipopagos implements Modelo_Controladores.Interface_tipopagos {
    ArrayList<Tipo_Pagos>listas;
    
    public controlador_tipopagos(){
        listas=new ArrayList();
    }
    
    public void AgregarTipopagos(Tipo_Pagos a){
        listas.add(a);
    }
    
    @Override
    public int agregar_tipopago(Tipo_Pagos t) {
        int resp = 0;
        Connection conn = null;
        try {
            String sql = "Insert into tipopagos values(null,?)";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, t.getDescripcion());
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
    public List<Tipo_Pagos> Listadotipopagos() {
        List<Tipo_Pagos> lis = new ArrayList();
        Connection conn = null;
        
        try{
          String sql = "select * from tipopagos";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Tipo_Pagos tp=new Tipo_Pagos();
                tp.setId(rs.getInt(1));
                tp.setDescripcion(rs.getString(2));
                
                lis.add(tp);
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
    public int eliminar(int id) {
                int resp = 0;
        Connection conn = null;
        try {
            String sql = "delete from tipopagos where ID_TIPOPAGO= ?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
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
    public int actualizar_tipopago(Tipo_Pagos t) {
                int resp = 0;
        Connection conn = null;
        try {
            String sql = "update tipopagos set descripcion=? where dni=?";
            conn = MySQLConexion.getConexion();
            //prepara una sentencia para ejecutar instrucciones sql
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(2, t.getId());
            st.setString(1, t.getDescripcion());

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
