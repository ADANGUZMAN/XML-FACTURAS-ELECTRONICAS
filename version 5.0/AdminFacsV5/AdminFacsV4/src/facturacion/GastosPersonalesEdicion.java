/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rainy
 */
public class GastosPersonalesEdicion extends Interfaz_Login {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form GastosPersonalesEdicion
     */
    
    control_existencias controlExistencias = new control_existencias();
    String cedula=userloged.getUsuario();
    DefaultTableModel datos;
    public GastosPersonalesEdicion() {
        initComponents();
        btnEditar.setEnabled(false);
        String[] colName = {"id_gasto", "codigo_cliente", "anio", "alimentacion", "vestimenta", "salud", "educacion", "vivienda","otros"};
        Object[][] tabla =controlExistencias.getSentencia().GetTabla(colName, "gasto_personal", "Select * from gasto_personal where codigo_cliente='"+cedula+"'");        
        datos = new DefaultTableModel(tabla, colName);
        tblGastosUsuario.setModel(datos);
        btnEditar.setEnabled(false);
        bloquearCajas();
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAcumulado = new javax.swing.JLabel();
        txtAlimentacion = new javax.swing.JTextField();
        lblAnio = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGastosUsuario = new javax.swing.JTable();
        lblVestimenta = new javax.swing.JLabel();
        txtVestimenta = new javax.swing.JTextField();
        lblVivienda = new javax.swing.JLabel();
        txtVivienda = new javax.swing.JTextField();
        lblEducacion = new javax.swing.JLabel();
        txtEducacion = new javax.swing.JTextField();
        lblSalud = new javax.swing.JLabel();
        txtSalud = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAcumulado.setText("Alimentacion");

        lblAnio.setText("A�o");

        txtAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblGastosUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGastosUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGastosUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGastosUsuario);

        lblVestimenta.setText("Vestimenta");

        txtVestimenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVestimentaActionPerformed(evt);
            }
        });

        lblVivienda.setText("Vivienda");

        lblEducacion.setText("Educacion");

        lblSalud.setText("Salud");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblAcumulado)
                                .addComponent(txtAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblVestimenta)
                                .addComponent(txtVestimenta, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(83, 83, 83)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtVivienda)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEducacion)
                                        .addComponent(lblVivienda))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(txtEducacion))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSalud)
                            .addComponent(txtSalud, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAnio))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAcumulado)
                    .addComponent(lblVivienda))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtVivienda)
                    .addComponent(txtAlimentacion, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVestimenta)
                    .addComponent(lblEducacion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEducacion, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtVestimenta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSalud)
                        .addGap(18, 18, 18)
                        .addComponent(txtSalud))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAnio)
                        .addGap(18, 18, 18)
                        .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if((!txtAlimentacion.getText().isEmpty())&&(!txtAnio.getText().isEmpty()))
        {
            String alimentacion, vestimenta, salud, educacion, vivienda, anio;
            alimentacion = txtAlimentacion.getText();
            vestimenta = txtVestimenta.getText();
            salud = txtSalud.getText();
            educacion = txtEducacion.getText();
            vivienda = txtVivienda.getText();
            anio = txtAnio.getText();
            
            String[] datos = {anio, alimentacion, vestimenta, salud, educacion, vivienda};
            
            boolean update =controlExistencias.getSentencia().actualizar(datos, "update gasto_personal set anio = ?, alimentacion =?, vestimenta=?, salud =?, educacion=?, vivienda=? where codigo_cliente='"+cedula+"'");
            if(update)
            {
                JOptionPane.showMessageDialog(null, "Se han actualizado los datos con Exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                bloquearCajas();
                btnEditar.setEnabled(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No se ha podido insertar los datos en la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No ha ingresado los datos a modificar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
        bloquearCajas();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblGastosUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGastosUsuarioMouseClicked
        // TODO add your handling code here:
        int fila =tblGastosUsuario.getSelectedRow();
        String alimentacion, vestimenta, salud, educacion, vivienda, anio;
        anio = tblGastosUsuario.getValueAt(fila, 2).toString();
        alimentacion = tblGastosUsuario.getValueAt(fila, 3).toString();
        vestimenta = tblGastosUsuario.getValueAt(fila, 4).toString();
        salud = tblGastosUsuario.getValueAt(fila, 5).toString();
        educacion = tblGastosUsuario.getValueAt(fila, 6).toString();
        vivienda = tblGastosUsuario.getValueAt(fila, 7).toString();
        
        txtAlimentacion.setText(alimentacion);
        txtEducacion.setText(educacion);
        txtSalud.setText(educacion);
        txtVestimenta.setText(vestimenta);
        txtVivienda.setText(vivienda);
        txtAnio.setText(anio);
        desbloquearCajas();
        btnEditar.setEnabled(true);
        
        
    }//GEN-LAST:event_tblGastosUsuarioMouseClicked

    private void txtVestimentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVestimentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVestimentaActionPerformed

    
    public void limpiar()
    {
        txtAlimentacion.setText("");
        txtAnio.setText("");
        txtAlimentacion.setText("");
        txtEducacion.setText("");
        txtSalud.setText("");
        txtVestimenta.setText("");
        txtVivienda.setText("");
    }
    
    public void bloquearCajas()
    {
        txtAlimentacion.setEnabled(false);
        txtAnio.setEnabled(false);
        txtAlimentacion.setEnabled(false);
        txtEducacion.setEnabled(false);
        txtSalud.setEnabled(false);
        txtVestimenta.setEnabled(false);
        txtVivienda.setEnabled(false);
    }
    
    public void desbloquearCajas()
    {
        txtAlimentacion.setEnabled(true);
        txtAnio.setEnabled(true);
        txtAlimentacion.setEnabled(true);
        txtEducacion.setEnabled(true);
        txtSalud.setEnabled(true);
        txtVestimenta.setEnabled(true);
        txtVivienda.setEnabled(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAcumulado;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblEducacion;
    private javax.swing.JLabel lblSalud;
    private javax.swing.JLabel lblVestimenta;
    private javax.swing.JLabel lblVivienda;
    private javax.swing.JTable tblGastosUsuario;
    private javax.swing.JTextField txtAlimentacion;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtEducacion;
    private javax.swing.JTextField txtSalud;
    private javax.swing.JTextField txtVestimenta;
    private javax.swing.JTextField txtVivienda;
    // End of variables declaration//GEN-END:variables
}
