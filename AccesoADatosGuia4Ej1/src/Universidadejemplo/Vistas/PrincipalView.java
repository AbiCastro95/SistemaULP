/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Universidadejemplo.Vistas;

/**
 *
 * @author Abigail Castro
 */
public class PrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalView
     */
    public PrincipalView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAlumno = new javax.swing.JMenu();
        jMenuItemFormAlumno = new javax.swing.JMenuItem();
        jMenuMateria = new javax.swing.JMenu();
        jMenuItemFormMat = new javax.swing.JMenuItem();
        jMenuAdministracion = new javax.swing.JMenu();
        jMenuItemAdmInscripcion = new javax.swing.JMenuItem();
        jMenuItemAdmNotas = new javax.swing.JMenuItem();
        jMenuConsultas = new javax.swing.JMenu();
        jMenuItemAlumnoPorMat = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema ULP");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        jMenuAlumno.setText("Alumno");

        jMenuItemFormAlumno.setText("Formulario de Alumno");
        jMenuItemFormAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFormAlumnoActionPerformed(evt);
            }
        });
        jMenuAlumno.add(jMenuItemFormAlumno);

        jMenuBar1.add(jMenuAlumno);

        jMenuMateria.setText("Materia");

        jMenuItemFormMat.setText("Formulario de Materia");
        jMenuItemFormMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFormMatActionPerformed(evt);
            }
        });
        jMenuMateria.add(jMenuItemFormMat);

        jMenuBar1.add(jMenuMateria);

        jMenuAdministracion.setText("Administración");

        jMenuItemAdmInscripcion.setText("Manejo de Inscripciones");
        jMenuAdministracion.add(jMenuItemAdmInscripcion);

        jMenuItemAdmNotas.setText("Manipulación de Notas");
        jMenuAdministracion.add(jMenuItemAdmNotas);

        jMenuBar1.add(jMenuAdministracion);

        jMenuConsultas.setText("Consultas");

        jMenuItemAlumnoPorMat.setText("Alumnos por Materia");
        jMenuConsultas.add(jMenuItemAlumnoPorMat);

        jMenuBar1.add(jMenuConsultas);

        jMenuSalir.setText("Salir");
        jMenuBar1.add(jMenuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemFormAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFormAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemFormAlumnoActionPerformed

    private void jMenuItemFormMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFormMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemFormMatActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenuAdministracion;
    private javax.swing.JMenu jMenuAlumno;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConsultas;
    private javax.swing.JMenuItem jMenuItemAdmInscripcion;
    private javax.swing.JMenuItem jMenuItemAdmNotas;
    private javax.swing.JMenuItem jMenuItemAlumnoPorMat;
    private javax.swing.JMenuItem jMenuItemFormAlumno;
    private javax.swing.JMenuItem jMenuItemFormMat;
    private javax.swing.JMenu jMenuMateria;
    private javax.swing.JMenu jMenuSalir;
    // End of variables declaration//GEN-END:variables
}