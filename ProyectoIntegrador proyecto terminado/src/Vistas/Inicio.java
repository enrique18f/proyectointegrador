/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

/**
 *
 * @author User
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    void centrado(){
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuhabitacion = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuclientes = new javax.swing.JMenuItem();
        menucategoriahab = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menutipodepagos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menureservaciones = new javax.swing.JMenuItem();
        menuservicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hoteleria_opcion_1-1920x1080-1.jpg"))); // NOI18N

        jMenu1.setText("Configuracion del hotel");

        menuhabitacion.setText("Habitaciones");
        menuhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuhabitacionActionPerformed(evt);
            }
        });
        jMenu1.add(menuhabitacion);

        jMenuItem2.setText("Productos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        menuclientes.setText("Clientes");
        menuclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuclientesActionPerformed(evt);
            }
        });
        jMenu1.add(menuclientes);

        menucategoriahab.setText("Empleados");
        menucategoriahab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menucategoriahabActionPerformed(evt);
            }
        });
        jMenu1.add(menucategoriahab);

        jMenuItem5.setText("Categoria de Habitaciones");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        menutipodepagos.setText("Tipos de pago");
        menutipodepagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menutipodepagosActionPerformed(evt);
            }
        });
        jMenu1.add(menutipodepagos);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Servicios");

        menureservaciones.setText("Reservacion de cuartos");
        menureservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menureservacionesActionPerformed(evt);
            }
        });
        jMenu2.add(menureservaciones);

        menuservicio.setText("Servicio a la habitacion");
        menuservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuservicioActionPerformed(evt);
            }
        });
        jMenu2.add(menuservicio);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuhabitacionActionPerformed
        Vista_Habitacion c = new Vista_Habitacion();
        c.setVisible(true);
    }//GEN-LAST:event_menuhabitacionActionPerformed

    private void menuclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuclientesActionPerformed
        maestro_cliente c = new maestro_cliente();
        c.setVisible(true);
       
    }//GEN-LAST:event_menuclientesActionPerformed

    private void menucategoriahabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menucategoriahabActionPerformed
        Vista_Empleado c = new Vista_Empleado();
        c.setVisible(true);
        
    }//GEN-LAST:event_menucategoriahabActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        CategoriaHabitacion c = new CategoriaHabitacion();
        c.setVisible(true);
       
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void menutipodepagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menutipodepagosActionPerformed
        Tipopago c = new Tipopago();
        c.setVisible(true);
    }//GEN-LAST:event_menutipodepagosActionPerformed

    private void menureservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menureservacionesActionPerformed
        Vista_reservaciones c = new Vista_reservaciones();
        c.setVisible(true);
        
    }//GEN-LAST:event_menureservacionesActionPerformed

    private void menuservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuservicioActionPerformed
        Vista_servicio c = new Vista_servicio();
        c.setVisible(true);
        
    }//GEN-LAST:event_menuservicioActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       vista_producto c = new vista_producto();
       c.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem menucategoriahab;
    private javax.swing.JMenuItem menuclientes;
    private javax.swing.JMenuItem menuhabitacion;
    private javax.swing.JMenuItem menureservaciones;
    private javax.swing.JMenuItem menuservicio;
    private javax.swing.JMenuItem menutipodepagos;
    // End of variables declaration//GEN-END:variables
}
