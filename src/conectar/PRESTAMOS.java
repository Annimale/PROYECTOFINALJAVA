/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package conectar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ivamar
 */
public class PRESTAMOS extends javax.swing.JFrame {

    /**
     * Creates new form PRESTAMOS
     */
    public PRESTAMOS() {
        initComponents();
    }

    public PRESTAMOS(Connection con) {
        super();
        initComponents();
        setTitle("PRÉSTAMOS 💰");

        cargarDatos();
        // METODO PARA CLICAR EN LA FILA Y QUE SE AUTORELLENEN LOS CAMPOS
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Obtener la fila seleccionada
                int filaSeleccionada = jTable1.getSelectedRow();

                // Verificar si se ha seleccionado una fila
                if (filaSeleccionada >= 0) {
                    // Obtener los valores de la fila seleccionada
                    String prestamo_id = jTable1.getValueAt(filaSeleccionada, 0).toString();
                    String socio_id = jTable1.getValueAt(filaSeleccionada, 1).toString();
                    String pelicula_id = jTable1.getValueAt(filaSeleccionada, 2).toString();
                    String musica_id = jTable1.getValueAt(filaSeleccionada, 3).toString();
                    String fecha_prestamo = jTable1.getValueAt(filaSeleccionada, 4).toString();
                    String fecha_devolucion = jTable1.getValueAt(filaSeleccionada, 5).toString();

                    // Establecer los valores en los campos de texto
                    jTextField1.setText(prestamo_id);
                    jTextField2.setText(socio_id);
                    jTextField3.setText(pelicula_id);
                    jTextField4.setText(musica_id);
                    jTextField5.setText(fecha_prestamo);
                    jTextField5.setText(fecha_devolucion);
                }
            }
        });

    }

    private void cargarDatos() {
        try {
            // Crear la conexión a la base de datos
            PruebaCOnectar pruebaConexion = new PruebaCOnectar();
            Connection con = pruebaConexion.getConexion();

            // Crear la sentencia SQL para obtener los datos de la tabla PELICULAS
            String sql = "SELECT * FROM prestamos";
            PreparedStatement pstmt = con.prepareStatement(sql);

            // Ejecutar la consulta y obtener el resultado
            ResultSet rs = pstmt.executeQuery();

            // Crear un objeto DefaultTableModel para almacenar los datos del ResultSet
            DefaultTableModel model = new DefaultTableModel();

            // Obtener los metadatos de las columnas
            ResultSetMetaData metaData = rs.getMetaData();

            // Obtener el número de columnas
            int columnCount = metaData.getColumnCount();

            // Agregar los nombres de las columnas al modelo
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            // Agregar los datos de las filas al modelo
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            // Establecer el modelo en el jTable1
            jTable1.setModel(model);

            // Cerrar la conexión, el PreparedStatement y el ResultSet
            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            // Manejar cualquier error
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
    }
    private boolean verificarExistenciaPrestamo(Connection con, String prestamo_id) throws Exception {
    // Crear la sentencia SQL para verificar la existencia del préstamo
    String sql = "SELECT * FROM prestamos WHERE prestamo_id = ?";
    PreparedStatement pstmt = con.prepareStatement(sql);
    pstmt.setString(1, prestamo_id);

    // Ejecutar la consulta y obtener el resultado
    ResultSet rs = pstmt.executeQuery();

    // Verificar si existe alguna fila en el resultado
    boolean existe = rs.next();

    // Cerrar el PreparedStatement y el ResultSet
    rs.close();
    pstmt.close();

    return existe;
}
    private void modificarPrestamo(Connection con, String prestamo_id, String socio_id, String pelicula_id,
                               String musica_id, String fecha_prestamo, String fecha_devolucion) throws Exception {
    // Crear la sentencia SQL para modificar el préstamo
    String sql = "UPDATE prestamos SET socio_id = ?, pelicula_id = ?, musica_id = ?, fecha_prestamo = ?, " +
            "fecha_devolucion = ? WHERE prestamo_id = ?";
    PreparedStatement pstmt = con.prepareStatement(sql);
    pstmt.setString(1, socio_id);
    pstmt.setString(2, pelicula_id);
    pstmt.setString(3, musica_id);
    pstmt.setString(4, fecha_prestamo);
    pstmt.setString(5, fecha_devolucion);
    pstmt.setString(6, prestamo_id);

    // Ejecutar la sentencia de modificación
    pstmt.executeUpdate();

    // Cerrar el PreparedStatement
    pstmt.close();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ATRAS = new javax.swing.JButton();
        INSERTAR = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        MODIFICAR = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        BORRAR = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(238, 245, 219));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 321, 149, -1));

        jLabel6.setFont(new java.awt.Font("Carlito", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha Préstamo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 316, -1, -1));

        jLabel1.setFont(new java.awt.Font("Carlito", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 99, 103));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prestamos.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 80));

        ATRAS.setBackground(new java.awt.Color(204, 204, 204));
        ATRAS.setFont(new java.awt.Font("Carlito", 1, 14)); // NOI18N
        ATRAS.setForeground(new java.awt.Color(0, 0, 0));
        ATRAS.setText("ATRAS");
        ATRAS.setAutoscrolls(true);
        ATRAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATRASActionPerformed(evt);
            }
        });
        jPanel1.add(ATRAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, -1, -1));

        INSERTAR.setBackground(new java.awt.Color(204, 204, 204));
        INSERTAR.setFont(new java.awt.Font("Carlito", 1, 14)); // NOI18N
        INSERTAR.setForeground(new java.awt.Color(0, 0, 0));
        INSERTAR.setText("INSERTAR");
        INSERTAR.setAutoscrolls(true);
        INSERTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERTARActionPerformed(evt);
            }
        });
        jPanel1.add(INSERTAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 120, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 110, 148, -1));

        jLabel2.setFont(new java.awt.Font("Carlito", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Préstamo ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 105, -1, -1));

        jLabel7.setFont(new java.awt.Font("Carlito", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Fecha Devolución");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 366, -1, -1));

        MODIFICAR.setBackground(new java.awt.Color(204, 204, 204));
        MODIFICAR.setFont(new java.awt.Font("Carlito", 1, 14)); // NOI18N
        MODIFICAR.setForeground(new java.awt.Color(0, 0, 0));
        MODIFICAR.setText("MODIFICAR ");
        MODIFICAR.setAutoscrolls(true);
        MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICARActionPerformed(evt);
            }
        });
        jPanel1.add(MODIFICAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, -1, -1));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 371, 149, -1));

        jLabel3.setFont(new java.awt.Font("Carlito", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Socio ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 152, -1, -1));

        jLabel8.setFont(new java.awt.Font("Carlito", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Ponme un 10 Carmen <3");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 570, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 640, 456));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 157, 151, -1));

        jLabel4.setFont(new java.awt.Font("Carlito", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Película ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 209, -1, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 214, 150, -1));

        jLabel5.setFont(new java.awt.Font("Carlito", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Música ID");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 264, -1, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 269, 149, -1));

        BORRAR.setBackground(new java.awt.Color(204, 204, 204));
        BORRAR.setFont(new java.awt.Font("Carlito", 1, 14)); // NOI18N
        BORRAR.setForeground(new java.awt.Color(0, 0, 0));
        BORRAR.setText("BORRAR");
        BORRAR.setAutoscrolls(true);
        BORRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BORRARActionPerformed(evt);
            }
        });
        jPanel1.add(BORRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 100, -1));

        jLabel9.setFont(new java.awt.Font("Carlito", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Hecho por Iván Torres Marcos");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 570, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ojos.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void INSERTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERTARActionPerformed
        // TODO add your handling code here:
        // Obtener los valores de los campos de texto
        String prestamo_id = jTextField1.getText();
        String socio_id = jTextField2.getText();
        String pelicula_id = jTextField3.getText();
        String musica_id = jTextField4.getText();
        String fecha_prestamo = jTextField5.getText();
        String fecha_devolucion = jTextField6.getText();

        // Crear la conexión a la base de datos
        PruebaCOnectar pruebaConexion = new PruebaCOnectar();
        Connection con = pruebaConexion.getConexion();

        try {
            // Crear la sentencia SQL de inserción
            String sql = "INSERT INTO prestamos (prestamo_id, socio_id, pelicula_id, musica_id, fecha_prestamo,fecha_devolucion) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);

            // Establecer los valores de los parámetros
            pstmt.setString(1, prestamo_id);
            pstmt.setString(2, socio_id);
            pstmt.setString(3, pelicula_id);
            pstmt.setString(4, musica_id);
            pstmt.setString(5, fecha_prestamo);
            pstmt.setString(6, fecha_devolucion);
            
            if (fecha_devolucion.compareTo(fecha_prestamo) < 0) {
                JOptionPane.showMessageDialog(this, "La fecha de devolución no puede ser menor que la fecha de préstamo");
                return; // Detener la ejecución del método
            }

            // Ejecutar la sentencia de inserción
            pstmt.executeUpdate();

            // Cerrar la conexión y el PreparedStatement
            pstmt.close();
            con.close();

            // Mostrar mensaje de éxito
            System.out.println("Inserción exitosa");

        } catch (Exception e) {
            // Manejar cualquier error
            JOptionPane.showMessageDialog(this, "Error al insertar en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        cargarDatos();
        limpiarCampos();
    }//GEN-LAST:event_INSERTARActionPerformed

    private void MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFICARActionPerformed
        // TODO add your handling code here:
        // Obtener los valores de los campos de texto
        String prestamo_id = jTextField1.getText();
        String socio_id = jTextField2.getText();
        String pelicula_id = jTextField3.getText();
        String musica_id = jTextField4.getText();
        String fecha_prestamo = jTextField5.getText();
        String fecha_devolucion = jTextField6.getText();

// Crear la conexión a la base de datos
       try { PruebaCOnectar pruebaConexion = new PruebaCOnectar();
        Connection con = pruebaConexion.getConexion();
 if (verificarExistenciaPrestamo(con, prestamo_id)) {
            // Realizar la modificación del préstamo
            modificarPrestamo(con, prestamo_id, socio_id, pelicula_id, musica_id, fecha_prestamo, fecha_devolucion);
            cargarDatos();
            limpiarCampos();
            
        } else {
            JOptionPane.showMessageDialog(this, "El préstamo con ID " + prestamo_id + " no existe");
        }
        
            // Crear la sentencia SQL de actualización
            String sql = "UPDATE prestamos SET socio_id = ?, pelicula_id = ?, musica_id = ?, fecha_prestamo = ?, fecha_devolucion = ? WHERE prestamo_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            // Establecer los valores de los parámetros
            pstmt.setString(1, socio_id);
            pstmt.setString(2, pelicula_id);
            pstmt.setString(3, musica_id);
            pstmt.setString(4, fecha_prestamo);
            pstmt.setString(5, fecha_devolucion);
            pstmt.setString(6, prestamo_id);
            
             if (fecha_devolucion.compareTo(fecha_prestamo) < 0) {
                JOptionPane.showMessageDialog(this, "La fecha de devolución no puede ser menor que la fecha de préstamo");
                return; // Detener la ejecución del método
            }

            // Ejecutar la sentencia de actualización
            pstmt.executeUpdate();

            // Cerrar la conexión y el PreparedStatement
            pstmt.close();
            con.close();

            // Mostrar mensaje de éxito
            System.out.println("Actualización exitosa");

        } catch (Exception e) {
            // Manejar cualquier error
            JOptionPane.showMessageDialog(this, "Error al insertar en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

// Cargar los datos actualizados en la tabla
        cargarDatos();
        limpiarCampos();


    }//GEN-LAST:event_MODIFICARActionPerformed

    private void BORRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BORRARActionPerformed
        // TODO add your handling code here:
        String pestamoId = jTextField1.getText();

        // Crear la conexión a la base de datos
        PruebaCOnectar pruebaConexion = new PruebaCOnectar();
        Connection con = pruebaConexion.getConexion();

        try {
            // Crear la sentencia SQL de eliminación
            String sql = "DELETE FROM peliculas WHERE pelicula_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            // Establecer el valor del parámetro
            pstmt.setString(1, pestamoId);

            // Ejecutar la sentencia de eliminación
            int filasEliminadas = pstmt.executeUpdate();

            // Cerrar el PreparedStatement y la conexión
            pstmt.close();
            con.close();

            // Mostrar mensaje de éxito si se eliminó al menos una fila
            if (filasEliminadas > 0) {
                System.out.println("Elemento eliminado correctamente");
            } else {
                System.out.println("No se encontró ningún elemento con el ID proporcionado");
            }

            // Limpiar los campos de texto y cargar nuevamente los datos en la tabla
            limpiarCampos();
            cargarDatos();

        } catch (Exception e) {
            // Manejar cualquier error
            JOptionPane.showMessageDialog(this, "Error al insertar en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_BORRARActionPerformed

    private void ATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATRASActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_ATRASActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

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
            java.util.logging.Logger.getLogger(PRESTAMOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PRESTAMOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PRESTAMOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PRESTAMOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PRESTAMOS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ATRAS;
    private javax.swing.JButton BORRAR;
    private javax.swing.JButton INSERTAR;
    private javax.swing.JButton MODIFICAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
