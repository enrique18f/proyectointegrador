/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo_Controladores.Interface_empleado;
import Beans.Empleado;
import UTIL.MySQLConexion;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Jair
 */
public class controlador_empleado implements Interface_empleado {
    
    @Override
    public String insertar(Empleado o) {
        String rpta = null;
        Connection conn;
        try {
            String sql = "Insert into empleado (NOMBRE, APELLIDO, USUARIO, CONTRASEÑA, CARGO) values(?,?,?,?,?) ";
            conn = MySQLConexion.getConexion();
            
            PreparedStatement st = conn.prepareStatement (sql);
            st.setString(1, o.getNombre());
            st.setString(2, o.getApellido());
            st.setString(3, o.getUsuario());
            st.setString(4, o.getContraseña());
            st.setString(5, o.getCargo());
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Empleado registrado correctamente");
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR no se puede insertar nuevo empelado .."+ex);
            
        }
        return rpta;
    }

    @Override
    public String Actualizar(Empleado o) {
        String rpta = null;
        
        Connection conn;
        try{
            int cod = o.getId_empleado();
            System.out.println("Este es el codigo: "+cod);
            String sql = "UPDATE EMPLEADO SET NOMBRE=?, APELLIDO=?, USUARIO=?, CONTRASEÑA=?, CARGO=? WHERE ID_EMPLEADO=?;";
            
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, o.getNombre());
            st.setString(2, o.getApellido());
            st.setString(3, o.getUsuario());
            st.setString(4, o.getContraseña());
            st.setString(5, o.getCargo());
            st.setInt(6, cod);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Empleado actualizada correctamente");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR no se puede actualizar empleado .." + ex);
        }
        
        
        return rpta;
    }

    @Override
    public String Anular(int codigo) {
        String rpta = null;
        Connection conn;
        
        try {
            String sql = "DELETE FROM empleado WHERE ID_EMPLEADO=?";
            conn = MySQLConexion.getConexion();

            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,codigo);
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Empleado eliminado correctamente");
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR no se puede eliminar empleado .."+ex);
        }
        return rpta;
    }
    
    @Override
    public String ListadoEmpleado(DefaultTableModel modelo) {
        String rpta = null;
        int i = 0 ;
        Connection conn;
        try{
            String sql = "select id_empleado, nombre, apellido, usuario, contraseña, cargo FROM empleado;";
            conn = MySQLConexion.getConexion();        
            Statement s = conn.createStatement();
            ResultSet rs ;
            
            rs = s.executeQuery(sql);
            
            while(rs.next()){
                i++;
                ArrayList lista = new ArrayList();
                lista.add(rs.getInt(1));
                lista.add(rs.getString(2));
                lista.add(rs.getString(3));
                lista.add(rs.getString(4));
                lista.add(rs.getString(5));
                lista.add(rs.getString(6));
                
                Object[] fila = {lista.get(0),lista.get(1), lista.get(2), lista.get(3), lista.get(4), lista.get(5)};
                
                modelo.addRow(fila);
            }
            
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR no se pueden recuperar los registros de empleados.." + ex);
        }
        
        return rpta;
    }


    @Override
    public Empleado ConsultarPorID(int id) {
         Empleado o = new Empleado();
        Connection conn;
        
        try{
            String sql = "select id_empleado, nombre, apellido, usuario, contraseña, cargo FROM empleado where ID_EMPLEADO = "+id+";";
            conn = MySQLConexion.getConexion();        
            Statement s = conn.createStatement();
            ResultSet rs ;
            
            rs = s.executeQuery(sql);
            
            while(rs.next()){
                
                o.setId_empleado(rs.getInt(1));
                o.setNombre(rs.getString(2));
                o.setApellido(rs.getString(3));
                o.setUsuario(rs.getString(4));
                o.setContraseña(rs.getString(5));
                o.setCargo(rs.getString(6));
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR no se pueden recuperar registro por id empleado" + ex);
        }
        
        
        return o;
    }

}
