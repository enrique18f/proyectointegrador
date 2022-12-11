package Vistas;

import Beans.Categoria_Habitacion;
import Beans.Reservacion;
import Beans.Tipo_Pagos;
import Controlador.*;
import UTIL.MySQLConexion;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import sun.net.www.content.audio.x_aiff;

/**
 *
 * @author User
 */
public class Vista_reservaciones extends javax.swing.JFrame {
    controlador_reservacion r=new controlador_reservacion();
    controlador_categoriaH categoria=new controlador_categoriaH();
    DefaultTableModel dt;
    
    public Vista_reservaciones() {
        initComponents();
        muestra();
        jtxtfechareservacion.setText(fechahora());
        cargarcombo(combocategoria);
        cargarcombotipopago(combotipopago);
        centrado();
        this.jtxtid.setEnabled(false);
        this.setLocationRelativeTo(null);

    }
    
        void centrado(){
        this.setLocationRelativeTo(null);
    }
        void muestra(){
        dt=(DefaultTableModel)tablareservacion.getModel();
        dt.setRowCount(0);
        for(Reservacion x: r.ListadoReservacion()){
            Object C[]={x.getCodigo(),x.getId_empleado(),x.getId_cliente(),x.getCategoria_habitacion(),x.getId_numhabitacion(),x.getFecha_reservacion(),x.getFecha_ingreso(),x.getFecha_salida(),x.getId_tipopago(),x.getMonto_pago()};
           dt.addRow(C);    
        }
    }
        
        public String  fechahora(){
        LocalDate fechaactual = LocalDate.now();
        return (fechaactual+"");
    }
    
        
        void limpia(){
        jtxtid.setText("");
        jtxtempleado.setText("");
        combocategoria.setSelectedIndex(0);
        combonumerohab.setSelectedIndex(0);
        combotipopago.setSelectedIndex(0);
        jtxtfechareservacion.setText("");
        jtxtfechaingreso.setText("");
        jtxtfechasalida.setText("");
        //fechareservacion.setCalendar(null);
        //fechaingreso.setCalendar(null);
        //fechasalida.setCalendar(null);
        jtxtcliente.setText("");
        jtxtmonto.setText("");
    }              

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnreporte = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtxtid = new javax.swing.JTextField();
        jtxtempleado = new javax.swing.JTextField();
        jtxtcliente = new javax.swing.JTextField();
        jtxtmonto = new javax.swing.JTextField();
        btnregistrar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablareservacion = new javax.swing.JTable();
        combotipopago = new javax.swing.JComboBox<>();
        combocategoria = new javax.swing.JComboBox<>();
        combonumerohab = new javax.swing.JComboBox<>();
        jtxtfechareservacion = new javax.swing.JTextField();
        jtxtfechaingreso = new javax.swing.JTextField();
        jtxtfechasalida = new javax.swing.JTextField();
        btnlimpiar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("RESERVACIONES DE CUARTO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 11, -1, -1));

        btnreporte.setText("Reporte");
        btnreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnreporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 110, 40));

        jLabel2.setText("ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel3.setText("EMPLEADO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel4.setText("CLIENTE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel5.setText("CATEGORIA HABITACION");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel6.setText("NUMERO DE HABITACION");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel7.setText("TIPO DE PAGO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 88, -1));

        jLabel8.setText("FECHA DE RESERVACION");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel9.setText("FECHA DE INGRESO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel10.setText("FECHA DE SALIDA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jLabel11.setText("MONTO A PAGAR:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));
        jPanel1.add(jtxtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 161, -1));
        jPanel1.add(jtxtempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 161, -1));
        jPanel1.add(jtxtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 161, -1));

        jtxtmonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtmontoActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtmonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 161, -1));

        btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_nuevo.png"))); // NOI18N
        btnregistrar.setText("REGISTRAR");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_modificar.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, -1, -1));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_eliminar.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 120, -1));

        tablareservacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "EMPLEADO", "CLIENTE", "CATEGORIA", "HABITACION", "FECHA DE RESERVACION", "INGRESO", "SALIDA", "TIPO DE PAGO", "MONTO"
            }
        ));
        tablareservacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablareservacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablareservacion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 815, 473));

        combotipopago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combotipopago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combotipopagoActionPerformed(evt);
            }
        });
        jPanel1.add(combotipopago, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 161, 30));

        combocategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combocategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocategoriaActionPerformed(evt);
            }
        });
        combocategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combocategoriaKeyReleased(evt);
            }
        });
        jPanel1.add(combocategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 161, -1));

        combonumerohab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combonumerohab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combonumerohabActionPerformed(evt);
            }
        });
        jPanel1.add(combonumerohab, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 161, 23));

        jtxtfechareservacion.setToolTipText("");
        jPanel1.add(jtxtfechareservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 160, -1));
        jPanel1.add(jtxtfechaingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 160, -1));
        jPanel1.add(jtxtfechasalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 160, -1));

        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btnlimpiar.setText("LIMPIAR");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 130, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtmontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtmontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtmontoActionPerformed

    private void combotipopagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combotipopagoActionPerformed

    }//GEN-LAST:event_combotipopagoActionPerformed

    private void combocategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocategoriaActionPerformed
            cargarcombohab(combonumerohab);
    }//GEN-LAST:event_combocategoriaActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        Reservacion res=new Reservacion();
        res.setCodigo(0);
        res.setId_empleado(jtxtempleado.getText());
        res.setId_cliente(Integer.parseInt(jtxtcliente.getText()));
        res.setCategoria_habitacion(combocategoria.getSelectedItem().toString());
        res.setId_numhabitacion(combonumerohab.getSelectedItem().toString());
        res.setId_tipopago(combotipopago.getSelectedItem().toString());
        res.setFecha_reservacion(jtxtfechareservacion.getText());
        res.setFecha_ingreso(jtxtfechaingreso.getText());
        res.setFecha_salida(jtxtfechasalida.getText());
        //res.setFecha_reservacion(fechareservacion.getDate());
        //res.setFecha_ingreso(fechaingreso.getDate());
        //res.setFecha_salida(fechasalida.getDate());
        res.setMonto_pago(Integer.parseInt(jtxtmonto.getText()));
        r.registrar_reservacion(res);
        muestra();
        r.enviarcorreo(jtxtcliente.getText(),combonumerohab.getSelectedItem().toString(),jtxtfechareservacion.getText(),jtxtfechaingreso.getText(),jtxtfechasalida.getText(),jtxtmonto.getText());
        
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        Reservacion res=new Reservacion();
        res.setCodigo(Integer.parseInt(jtxtid.getText()));
        res.setId_empleado(jtxtempleado.getText());
        res.setId_cliente(Integer.parseInt(jtxtcliente.getText()));
        res.setCategoria_habitacion(combocategoria.getSelectedItem().toString());
        res.setId_numhabitacion(combonumerohab.getSelectedItem().toString());
        res.setId_tipopago(combotipopago.getSelectedItem().toString());
        res.setFecha_reservacion(jtxtfechareservacion.getText());
        res.setFecha_ingreso(jtxtfechaingreso.getText());
        res.setFecha_salida(jtxtfechasalida.getText());
        res.setMonto_pago(Double.parseDouble(jtxtmonto.getText()));
        r.actualizar_reservacion(res);
        muestra();
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
            if(tablareservacion.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "elija una fila");
            return;
        }
        r.eliminar_reservacion(Integer.parseInt(jtxtid.getText()));
        muestra();
        limpia();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void tablareservacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablareservacionMouseClicked
        int f=tablareservacion.getSelectedRow();
        jtxtid.setText(tablareservacion.getValueAt(f,0).toString());
        jtxtempleado.setText(tablareservacion.getValueAt(f,1).toString());
        jtxtcliente.setText(tablareservacion.getValueAt(f,2).toString());
        combocategoria.setSelectedItem(tablareservacion.getValueAt(f,3).toString());
        combonumerohab.setSelectedItem(tablareservacion.getValueAt(f,4).toString());
        jtxtfechareservacion.setText(tablareservacion.getValueAt(f,5).toString());
        jtxtfechaingreso.setText(tablareservacion.getValueAt(f,6).toString());
        jtxtfechasalida.setText(tablareservacion.getValueAt(f,7).toString());
        combotipopago.setSelectedItem(tablareservacion.getValueAt(f,8));
        jtxtmonto.setText(tablareservacion.getValueAt(f,9).toString());
        //desactivar el textocodi
        jtxtid.setEditable(false);
        btnregistrar.setEnabled(false);
    }//GEN-LAST:event_tablareservacionMouseClicked

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpia();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreporteActionPerformed
        Map p=new HashMap();
        JasperReport report;
        JasperPrint print;
        
        try{
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/rptReserva.jrxml");
            print=JasperFillManager.fillReport(report, p,UTIL.MySQLConexion.getConexion());
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Reporte de Reservaciones");
            view.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
       }   
    }//GEN-LAST:event_btnreporteActionPerformed

    private void combonumerohabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combonumerohabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combonumerohabActionPerformed

    private void combocategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combocategoriaKeyReleased
        
    }//GEN-LAST:event_combocategoriaKeyReleased

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
            java.util.logging.Logger.getLogger(Vista_reservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_reservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_reservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_reservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_reservaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnreporte;
    private javax.swing.JComboBox<String> combocategoria;
    private javax.swing.JComboBox<String> combonumerohab;
    private javax.swing.JComboBox<String> combotipopago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtxtcliente;
    private javax.swing.JTextField jtxtempleado;
    private javax.swing.JTextField jtxtfechaingreso;
    private javax.swing.JTextField jtxtfechareservacion;
    private javax.swing.JTextField jtxtfechasalida;
    private javax.swing.JTextField jtxtid;
    private javax.swing.JTextField jtxtmonto;
    private javax.swing.JTable tablareservacion;
    // End of variables declaration//GEN-END:variables

    private void cargarcombo(JComboBox cat) {
        Connection conn = null;
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        cat.setModel(combo);
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

    private void cargarcombohab(JComboBox hab) {
        Connection conn = null;
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        hab.setModel(combo);
        controlador_categoriaH ch=new controlador_categoriaH();
        try {
          String sql = "SELECT NUMERO_HAB FROM habitacion where COD_CATEGORIA=?";
          conn = MySQLConexion.getConexion();
          PreparedStatement st = conn.prepareStatement(sql);
          st.setString(1,combocategoria.getSelectedItem().toString());
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

    private void cargarcombotipopago(JComboBox tpago) {
        Connection conn = null;
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        tpago.setModel(combo);
        controlador_tipopagos ch=new controlador_tipopagos();
        try {
          String sql = "SELECT DESCRIPCION FROM TIPOPAGOS";
          conn = MySQLConexion.getConexion();
          PreparedStatement st = conn.prepareStatement(sql);
          ResultSet rs=st.executeQuery();
          while (rs.next()){
              Tipo_Pagos tp=new Tipo_Pagos();
              tp.setDescripcion(rs.getString(1));
              ch.AgregarTipopagos(tp);
              combo.addElement(tp.getDescripcion());
          }
        } catch (Exception ex){
             ex.printStackTrace();
        }
    }
    

}
