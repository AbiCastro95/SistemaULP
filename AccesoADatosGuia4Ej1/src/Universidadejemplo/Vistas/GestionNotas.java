package Universidadejemplo.Vistas;

import Universidadejemplo.AccesoADatos.*;
import Universidadejemplo.Entidades.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.*;

public class GestionNotas extends javax.swing.JInternalFrame {

    InscripcionData iData = new InscripcionData();
    AlumnoData aData = new AlumnoData();
    MateriaData mData = new MateriaData();

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int col) {
            if (col == 2) { //columnIndex: the column you want to make it editable
                return true;
            } else {
                return false;
            }
        }

        //Para que guarde el dato como Double
        @Override
        public Class<?> getColumnClass(int c) {
            if (c == 2) {
                return Double.class;
            }
            return Object.class;
        }
    };

    /**
     * Creates new form GestionNotas
     */
    public GestionNotas() {
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

        tituloActualizacion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelSel = new javax.swing.JLabel();
        jComboBoxAlumnos = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInscripciones = new javax.swing.JTable();

        setClosable(true);
        setTitle("Gestión de notas");
        setMinimumSize(new java.awt.Dimension(77, 22));
        setPreferredSize(new java.awt.Dimension(400, 450));

        tituloActualizacion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tituloActualizacion.setText("ACTUALIZACIÓN DE NOTAS");

        jLabelSel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSel.setText("Seleccione un alumno");
        jLabelSel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jComboBoxAlumnos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAlumnosItemStateChanged(evt);
            }
        });

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setEnabled(false);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

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
        jTableInscripciones.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTableInscripcionesPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTableInscripciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jButtonGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(tituloActualizacion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelSel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tituloActualizacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSel)
                    .addComponent(jComboBoxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButtonGuardar)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxAlumnosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAlumnosItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.DESELECTED) {
            int id = ((Alumno) jComboBoxAlumnos.getSelectedItem()).getIdAlumno();
            eliminarFilas();

            for (Inscripcion i : iData.obtenerInscripcionesPorAlumno(id)) {
                modelo.addRow(new Object[]{
                    i.getIdMateria(),
                    i.getMateria().getNombre(),
                    i.getNota()
                });
            }
            jButtonGuardar.setEnabled(false);
        }
        /*if (evt.getStateChange() == java.awt.event.ItemEvent.DESELECTED) {
        int id = ((Alumno) jComboBoxAlumnos.getSelectedItem()).getIdAlumno();
            if (jComboBoxAlumnos.getSelectedIndex() == 0) {
                comboFinal();
            }
            eliminarFilas();
            for (Inscripcion i : iData.obtenerInscripcionesPorAlumno(id)) {
                modelo.addRow(new Object[]{
                    i.getIdMateria(),
                    i.getMateria().getNombre(),
                    i.getNota()
                });
            }
        }*/
    }//GEN-LAST:event_jComboBoxAlumnosItemStateChanged

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        int filas = jTableInscripciones.getRowCount();
        for (int f = 0; f < filas; f++) {
            int idAlumno = ((Alumno) jComboBoxAlumnos.getSelectedItem()).getIdAlumno();
            int idMateria = (Integer) jTableInscripciones.getValueAt(f, 0);
            double nota = (Double) jTableInscripciones.getValueAt(f, 2);
            //Variable booleana para realizar un seguimiento de si hay una actualización pendiente
            boolean actualizacionPendiente = false;

            List<Inscripcion> inscripciones = iData.obtenerInscripcionesPorAlumno(idAlumno);
            for (Inscripcion i : inscripciones) {
                //Verifica si ma materia es la misma y si la nota es diferente
                if (i.getIdMateria() == idMateria && i.getNota() != nota) {
                    //Si no hay una actualización pendiente la registra y actualiza.
                    if (!actualizacionPendiente) {
                        actualizacionPendiente = true;
                        System.out.println("actualizado: " + idAlumno + " " + idMateria + " " + nota);
                        iData.actualizarNota(idAlumno, idMateria, nota);
                    }
                }
            }
            //Si hay una actualización pendiente notifica que no hay modificaciones
            if (!actualizacionPendiente) {
                JOptionPane.showMessageDialog(this, "No hay modificaciones.");
            }
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jTableInscripcionesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTableInscripcionesPropertyChange
        // Solo cuando se esté editando la tabla lo va a habilitar
        if (jTableInscripciones.isEditing()) {
            jButtonGuardar.setEnabled(true);
        }
    }//GEN-LAST:event_jTableInscripcionesPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<Alumno> jComboBoxAlumnos;
    private javax.swing.JLabel jLabelSel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableInscripciones;
    private javax.swing.JLabel tituloActualizacion;
    // End of variables declaration//GEN-END:variables

    private void cargarCombo() {
        jComboBoxAlumnos.addItem(new Alumno());
        for (Alumno alumno : aData.listarAlumnos()) {
            jComboBoxAlumnos.addItem(alumno);
        }
    }

    /*
    private void comboFinal() {
        jComboBoxAlumnos.removeAllItems();
        for (Alumno alumno : aData.listarAlumnos()) {
            jComboBoxAlumnos.addItem(alumno);
        }
    }
     */
    private void cabeceraTabla() {
        modelo.addColumn("Id Materia");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");

        jTableInscripciones.setModel(modelo);
        //Centrar títulos de la tabla
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTableInscripciones.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        //Centrar contenido de tabla
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTableInscripciones.setDefaultRenderer(Object.class, centerRenderer);

        jTableInscripciones.setEditingColumn(2);
    }

    private void eliminarFilas() {
        int filas = jTableInscripciones.getRowCount() - 1; //al ser un indice le resto 1
        //Como ya iniciamos la variable contadora no la incluimos en el for.
        for (; filas >= 0; filas--) {
            modelo.removeRow(filas);
        }
    }
}
