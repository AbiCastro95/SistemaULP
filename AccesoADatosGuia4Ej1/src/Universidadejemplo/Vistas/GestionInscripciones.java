package Universidadejemplo.Vistas;

import Universidadejemplo.AccesoADatos.AlumnoData;
import Universidadejemplo.Entidades.Alumno;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abigail Castro
 */
public class GestionInscripciones extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int x, int y) {
            return false;
        }
    };

    /**
     * Creates new form GestionInscripciones
     */
    public GestionInscripciones() {
        initComponents();
        cargarCombo();
        cabeceraTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        tituloInscripciones = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelSel = new javax.swing.JLabel();
        jComboBoxAlumnos = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jRButtonInsciptas = new javax.swing.JRadioButton();
        jRButtonNoInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInscripciones = new javax.swing.JTable();
        jButtonInscribir = new javax.swing.JButton();
        jButtonAnularInscripcion = new javax.swing.JButton();

        buttonGroup.add(jRButtonInsciptas);
        buttonGroup.add(jRButtonNoInscriptas);

        setClosable(true);
        setTitle("Manejo de Inscripciones ");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(400, 450));

        tituloInscripciones.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tituloInscripciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloInscripciones.setText("INSCRIPCIONES");
        tituloInscripciones.setFocusable(false);
        tituloInscripciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelSel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSel.setText("Seleccione un alumno");
        jLabelSel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jComboBoxAlumnos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAlumnosItemStateChanged(evt);
            }
        });

        jRButtonInsciptas.setText("Materias Inscriptas");

        jRButtonNoInscriptas.setText("Materias no Inscriptas");

        jTableInscripciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableInscripciones.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane1.setViewportView(jTableInscripciones);

        jButtonInscribir.setText("Inscribir");
        jButtonInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInscribirActionPerformed(evt);
            }
        });

        jButtonAnularInscripcion.setText("Anular Inscripción");
        jButtonAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnularInscripcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tituloInscripciones)
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jRButtonInsciptas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRButtonNoInscriptas))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelSel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonInscribir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAnularInscripcion)))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tituloInscripciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSel)
                    .addComponent(jComboBoxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRButtonInsciptas)
                    .addComponent(jRButtonNoInscriptas))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnularInscripcion)
                    .addComponent(jButtonInscribir))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInscribirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonInscribirActionPerformed

    private void jButtonAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnularInscripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAnularInscripcionActionPerformed

    private void jComboBoxAlumnosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAlumnosItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAlumnosItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jButtonAnularInscripcion;
    private javax.swing.JButton jButtonInscribir;
    private javax.swing.JComboBox<Alumno> jComboBoxAlumnos;
    private javax.swing.JLabel jLabelSel;
    private javax.swing.JRadioButton jRButtonInsciptas;
    private javax.swing.JRadioButton jRButtonNoInscriptas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableInscripciones;
    private javax.swing.JLabel tituloInscripciones;
    // End of variables declaration//GEN-END:variables

    private void cargarCombo(){
        AlumnoData alumnoData = new AlumnoData();
        List<Alumno> listaAlumnos = alumnoData.listarAlumnos();
        
        for (Alumno alumno : listaAlumnos) {
            jComboBoxAlumnos.addItem(alumno);
        }
    }
    
    private void cabeceraTabla() {
        modelo.addColumn("Id Materia");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");

        jTableInscripciones.setModel(modelo);
        //Centrar títulos de la tabla
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTableInscripciones.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    private void eliminarFilas() {
        int filas = jTableInscripciones.getRowCount() - 1; //al ser un indice le resto 1
        //Como ya iniciamos la variable contadora no la incluimos en el for.
        for (; filas >= 0; filas--) {
            modelo.removeRow(filas);
        }
    }
}