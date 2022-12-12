/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Beans.Cliente;
import Beans.Habitacion;
import Beans.Categoria_Habitacion;
import UTIL.MySQLConexion;
import Controlador.controlador_habitacion;
import Controlador.controlador_categoriaH;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author User
 */
public class Vista_Habitacion extends javax.swing.JFrame {

    
    controlador_habitacion ch=new controlador_habitacion();
    controlador_categoriaH cth=new controlador_categoriaH();
    DefaultTableModel dt;
    
    public Vista_Habitacion() {
        initComponents();
        muestra();
        this.jtxtidhab.setEnabled(false);
        cargarcombo(combocategoria);
        this.setLocationRelativeTo(null);
        
    }
    
    void muestra(){
        dt=(DefaultTableModel)tablahabitaciones.getModel();
        dt.setRowCount(0);
        for(Habitacion x:ch.ListadoHabitacion()){
            Object C[]={x.getId_numhabitacion(),x.getCod_categoria(),x.getNumero_hab(),x.getPiso()};
           dt.addRow(C);    
        }
    }
    
    void muestra2(String cod){
        try {
      dt=(DefaultTableModel)tablahabitaciones.getModel();
      dt.setRowCount(0);
      for(Habitacion x:ch.BusquedaHabitacion(Integer.parseInt(cod))){
          Object v[]={x.getId_numhabitacion(),x.getCod_categoria(),x.getNumero_hab(),x.getPiso()};
        dt.addRow(v);
         
      }
        } catch (Exception e) {
        }
  } 

    
    void limpia(){
        jtxtidhab.setText("");
        jtxtnumerohab.setText("");
        jtxtpiso.setText("");
        btnregistrar.setEnabled(true);
    }              
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtnumerohab = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtpiso = new javax.swing.JTextField();
        jtxtidhab = new javax.swing.JTextField();
        btnregistrar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablahabitaciones = new javax.swing.JTable();
        combocategoria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("REGISTRO DE HABITACIONES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jButton1.setText("Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 100, 40));

        jLabel2.setText("ID :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 61, -1, -1));

        jLabel3.setText("CATEGORIA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel4.setText("NUMERO DE HABITACION:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 130, -1));
        jPanel1.add(jtxtnumerohab, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 160, -1));

        jLabel5.setText("PISO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        jPanel1.add(jtxtpiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 160, -1));
        jPanel1.add(jtxtidhab, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 160, -1));

        btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_grabar.png"))); // NOI18N
        btnregistrar.setText("REGISTRAR");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_eliminar.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, -1));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_modificar.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btnlimpiar.setText("LIMPIAR");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, -1, -1));

        tablahabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Categoria", "N° de Habitacion", "Piso"
            }
        ));
        tablahabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablahabitacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablahabitaciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 652, 272));

        combocategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(combocategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 160, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpia();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        Habitacion hab=new Habitacion();
        hab.setId_numhabitacion(0);
        hab.setCod_categoria(combocategoria.getSelectedItem().toString());
        hab.setNumero_hab(Integer.parseInt(jtxtnumerohab.getText()));
        hab.setPiso(Integer.parseInt(jtxtpiso.getText()));
        ch.adicion_habitacion(hab);
        muestra();
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if(tablahabitaciones.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "elija una fila");
            return;
        }
        ch.anular_habitacion(Integer.parseInt(jtxtnumerohab.getText()));
        muestra();
        limpia();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        Habitacion hab=new Habitacion();
        hab.setId_numhabitacion(Integer.parseInt(jtxtidhab.getText()));
        hab.setCod_categoria(combocategoria.getSelectedItem().toString());
        // res.setCategoria_habitacion(combocategoria.getSelectedItem().toString());
        hab.setNumero_hab(Integer.parseInt(jtxtnumerohab.getText()));
        hab.setPiso(Integer.parseInt(jtxtpiso.getText()));
        ch.actualizar_habitacion(hab);
        muestra();
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void tablahabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablahabitacionesMouseClicked
        int f=tablahabitaciones.getSelectedRow();
        jtxtidhab.setText(tablahabitaciones.getValueAt(f,0).toString());
        combocategoria.setSelectedItem(tablahabitaciones.getValueAt(f,1).toString());
        jtxtnumerohab.setText(tablahabitaciones.getValueAt(f,2).toString());
        jtxtpiso.setText(tablahabitaciones.getValueAt(f,3).toString());
        
        //desactivar el textocodi
        jtxtidhab.setEditable(false);
        btnregistrar.setEnabled(false);
    }//GEN-LAST:event_tablahabitacionesMouseClicked

    private void combocategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocategoriaActionPerformed

    }//GEN-LAST:event_combocategoriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Map p=new HashMap();
        JasperReport report;
        JasperPrint print;
        
        try{
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/rpHabitaciones.jrxml");
            print=JasperFillManager.fillReport(report, p,UTIL.MySQLConexion.getConexion());
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Reporte de Habitaciones");
            view.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista_Habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_Habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_Habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_Habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_Habitacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JComboBox<String> combocategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtxtidhab;
    private javax.swing.JTextField jtxtnumerohab;
    private javax.swing.JTextField jtxtpiso;
    private javax.swing.JTable tablahabitaciones;
    // End of variables declaration//GEN-END:variables

    private void cargarcombo(JComboBox e) {
        Connection conn = null;
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        e.setModel(combo);
        controlador_categoriaH ch=new controlador_categoriaH();
        try {
          String sql = "SELECT DESCRIPCION FROM categoria_habitacion";
          conn = MySQLConexion.getConexion();
          PreparedStatement st = conn.prepareStatement(sql);
          ResultSet rs=st.executeQuery();
          while (rs.next()){
              Categoria_Habitacion a=new Categoria_Habitacion();
              a.setDescripcion(rs.getString(1));
              ch.AgregarCategorias(a);
              combo.addElement(a.getDescripcion());
          }
        } catch (Exception ex){
             ex.printStackTrace();
        }
    }
}
