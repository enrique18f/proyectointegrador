/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Beans.Tipo_Pagos;
import Controlador.controlador_tipopagos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Tipopago extends javax.swing.JFrame {
    
    controlador_tipopagos cc=new controlador_tipopagos();
    DefaultTableModel dt;
    
    public Tipopago() {
        initComponents();
        muestra();
        this.jtxtid.setEnabled(false);
        this.setLocationRelativeTo(null);

    }
    
    void muestra(){
        dt=(DefaultTableModel)tabletipopagos.getModel();
        dt.setRowCount(0);
        for (Tipo_Pagos x: cc.Listadotipopagos()){
            Object t[]={x.getId(),x.getDescripcion()};
         dt.addRow(t);
        }
      
     }
            
    
    void limpia(){
        jtxtid.setText("");
        jtxtdescripcion.setText("");
        jbtnagregar.setEnabled(true);
        jtxtdescripcion.requestFocus();
    }      


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtdescripcion = new javax.swing.JTextField();
        jbtnagregar = new javax.swing.JButton();
        jbtneliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabletipopagos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jbtnmodificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("REGISTRAR TIPOS DE PAGO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel2.setText("ID: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));
        jPanel1.add(jtxtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 187, -1));

        jLabel3.setText("DESCRIPCION:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));
        jPanel1.add(jtxtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 187, -1));

        jbtnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_grabar.png"))); // NOI18N
        jbtnagregar.setText("Agregar");
        jbtnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnagregarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jbtneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_eliminar.png"))); // NOI18N
        jbtneliminar.setText("Eliminar");
        jbtneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtneliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        tabletipopagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Descripcion"
            }
        ));
        tabletipopagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabletipopagosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabletipopagos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 486, 303));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -6, 920, 580));

        jbtnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_modificar.png"))); // NOI18N
        jbtnmodificar.setText("Modificar");
        jbtnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnmodificarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnagregarActionPerformed
        Tipo_Pagos tp=new Tipo_Pagos();
        tp.setId(0);
        tp.setDescripcion(jtxtdescripcion.getText());

        cc.agregar_tipopago(tp);
        muestra();
    }//GEN-LAST:event_jbtnagregarActionPerformed

    private void jbtnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnmodificarActionPerformed
        //Tipo_Pagos tp=new Tipo_Pagos();
        //tp.setId(0);
        //tp.setDescripcion(jtxtdescripcion.getText());
        //cc.actualizar_tipopago(tp);
        //muestra();
    }//GEN-LAST:event_jbtnmodificarActionPerformed

    private void jbtneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtneliminarActionPerformed
         if(tabletipopagos.getSelectedRow()==-1){
         JOptionPane.showMessageDialog(null, "Elija una fila");
            return;
        }
        cc.eliminar(Integer.parseInt(jtxtid.getText()));
        muestra();
        limpia();
    }//GEN-LAST:event_jbtneliminarActionPerformed

    private void tabletipopagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabletipopagosMouseClicked
        int f=tabletipopagos.getSelectedRow();
        jtxtid.setText(tabletipopagos.getValueAt(f,0).toString());
        jtxtdescripcion.setText(tabletipopagos.getValueAt(f,1).toString());
        //desactivar el textocodi
        jtxtid.setEditable(false);
        jbtnagregar.setEnabled(false);
    }//GEN-LAST:event_tabletipopagosMouseClicked

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
            java.util.logging.Logger.getLogger(Tipopago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tipopago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tipopago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tipopago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tipopago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnagregar;
    private javax.swing.JButton jbtneliminar;
    private javax.swing.JButton jbtnmodificar;
    private javax.swing.JTextField jtxtdescripcion;
    private javax.swing.JTextField jtxtid;
    private javax.swing.JTable tabletipopagos;
    // End of variables declaration//GEN-END:variables
}
