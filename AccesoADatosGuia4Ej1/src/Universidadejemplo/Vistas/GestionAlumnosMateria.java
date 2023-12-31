package Universidadejemplo.Vistas;

import Universidadejemplo.AccesoADatos.*;
import Universidadejemplo.Entidades.Alumno;
import Universidadejemplo.Entidades.Materia;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GestionAlumnosMateria extends javax.swing.JInternalFrame {

    InscripcionData iData;
    MateriaData mData;

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };
        /**
         * Creates new form GestionAlumnosMateria
         */
        public GestionAlumnosMateria() {
            initComponents();
            this.iData = new InscripcionData();
            this.mData = new MateriaData();
            cargarCombo();
            cabeceraTabla();
            
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloListado = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelSel = new javax.swing.JLabel();
        jComboBoxMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMaterias = new javax.swing.JTable();

        setClosable(true);
        setTitle("Consultas por Materia");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(400, 400));

        tituloListado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tituloListado.setText("LISTADO DE ALUMNOS");

        jLabelSel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSel.setText("Seleccione una materia");
        jLabelSel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jComboBoxMateria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxMateriaItemStateChanged(evt);
            }
        });

        jTableMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableMaterias.setEnabled(false);
        jTableMaterias.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane1.setViewportView(jTableMaterias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabelSel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(tituloListado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tituloListado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSel)
                    .addComponent(jComboBoxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxMateriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxMateriaItemStateChanged
         if (evt.getStateChange() == java.awt.event.ItemEvent.DESELECTED) {
            int idMat = ((Materia)jComboBoxMateria.getSelectedItem()).getIdMateria();
            eliminarFilas();

            for (Alumno i : iData.obtenerAlumnosPorMateria(idMat)) {
                modelo.addRow(new Object[]{
                    i.getIdAlumno(),
                    i.getDni(),
                    i.getApellido(),
                    i.getNombre()
                });
            }
        }
    }//GEN-LAST:event_jComboBoxMateriaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Materia> jComboBoxMateria;
    private javax.swing.JLabel jLabelSel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableMaterias;
    private javax.swing.JLabel tituloListado;
    // End of variables declaration//GEN-END:variables

        private void cargarCombo() {
            jComboBoxMateria.addItem(new Materia());
            for (Materia materia : mData.listarMateria()) {
                jComboBoxMateria.addItem(materia);
            }
        }

        private void cabeceraTabla() {
            modelo.addColumn("Id Alumno");
            modelo.addColumn("DNI");
            modelo.addColumn("Apellido");
            modelo.addColumn("Nombre");

            jTableMaterias.setModel(modelo);
            //Centrar títulos de la tabla
            DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTableMaterias.getTableHeader().getDefaultRenderer();
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            //Centrar contenido de tabla
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            jTableMaterias.setDefaultRenderer(Object.class, centerRenderer);
        }
        
        private void eliminarFilas() {
            int filas = jTableMaterias.getRowCount() - 1; //al ser un indice le resto 1
            //Como ya iniciamos la variable contadora no la incluimos en el for.
            for (; filas >= 0; filas--) {
                modelo.removeRow(filas);
            }

        }
    }
