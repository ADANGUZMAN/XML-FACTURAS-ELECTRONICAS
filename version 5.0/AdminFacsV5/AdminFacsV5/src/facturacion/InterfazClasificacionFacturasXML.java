/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import com.mysql.jdbc.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Daniel
 */
public class InterfazClasificacionFacturasXML extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form InterfazClasificacionFacturasXML
     */
    
    control_existencias controlExistencias = new control_existencias();
    private java.sql.Connection connection = null;
    private java.sql.ResultSet res;
    private String usuario = "1718927716"; 
    private java.util.ArrayList<String> arreglodetalles = new ArrayList<>();
    String codigoFactura = "";
    public InterfazClasificacionFacturasXML() {
    	setTitle("Clasificaci\u00F3n de Gastos");
    	getContentPane().setBackground(new Color(51, 153, 153));
        initComponents();
        cmbDetallesFactura.setEnabled(false);
        cmbTipoGasto.setEnabled(false);
        btnIngresarGastos.setEnabled(false);
        cmbDetallesFactura.removeAllItems();
        cmbTipoGasto.removeAllItems();
        try {
                    connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pruebafacturas", "root", "");

                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
                    return;
                }

                if (connection != null) {
                    System.out.println("Conexion a base provisional lista");
                } else {
                    System.out.println("Failed to make connection!");
                }////conexi�n
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpTipoFactura = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        rbtGastosNegocio = new javax.swing.JRadioButton();
        rbtGastosNegocio.setFont(new Font("Tahoma", Font.BOLD, 15));
        rbtGastosNegocio.setBackground(new Color(51, 153, 153));
        rbtGastosPersonales = new javax.swing.JRadioButton();
        rbtGastosPersonales.setBackground(new Color(51, 153, 153));
        rbtGastosPersonales.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnIngresarGastos = new javax.swing.JButton();
        btnIngresarGastos.setForeground(Color.WHITE);
        btnIngresarGastos.setBackground(Color.DARK_GRAY);
        btnNuevaFactura = new javax.swing.JButton();
        btnNuevaFactura.setForeground(Color.WHITE);
        btnNuevaFactura.setBackground(Color.DARK_GRAY);
        lblDetallesFactura = new javax.swing.JLabel();
        lblDetallesFactura.setFont(new Font("Tahoma", Font.ITALIC, 13));
        lblTipoGasto = new javax.swing.JLabel();
        lblTipoGasto.setFont(new Font("Tahoma", Font.ITALIC, 13));
        cmbDetallesFactura = new javax.swing.JComboBox();
        cmbTipoGasto = new javax.swing.JComboBox();
        btnSalir = new javax.swing.JButton();
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBackground(Color.DARK_GRAY);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        grpTipoFactura.add(rbtGastosNegocio);
        rbtGastosNegocio.setText("Gastos de Negocio");

        grpTipoFactura.add(rbtGastosPersonales);
        rbtGastosPersonales.setText("Gastos Personales");

        btnIngresarGastos.setText("Ingresar Gastos");
        btnIngresarGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarGastosActionPerformed(evt);
            }
        });

        btnNuevaFactura.setText("Nueva Factura");
        btnNuevaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaFacturaActionPerformed(evt);
            }
        });

        lblDetallesFactura.setText("Detalles de Factura");

        lblTipoGasto.setText("Tipo de Gasto");

        cmbDetallesFactura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbTipoGasto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSalir.setText("Salir");
        btnSalir.setToolTipText("");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        
        lblNewLabel = new JLabel("");
        
        lblNewLabel_1 = new JLabel("");
        
        lblNewLabel_2 = new JLabel("\r\n");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\4.png"));
        
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\dinero-en-efectivo-cartera-monedero-icono-7127-48.png"));
        
        lblSeleccioneElTipo = new JLabel("Seleccione el tipo de Gastos de la Factura Ingresada");
        lblSeleccioneElTipo.setForeground(new Color(153, 0, 51));
        lblSeleccioneElTipo.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(47)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(10)
        							.addComponent(lblNewLabel_1))
        						.addComponent(lblNewLabel)))
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        						.addGap(33)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(cmbDetallesFactura, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
        								.addGap(81)
        								.addComponent(cmbTipoGasto, 0, 122, Short.MAX_VALUE))
        							.addGroup(layout.createSequentialGroup()
        								.addGap(9)
        								.addComponent(lblDetallesFactura)
        								.addPreferredGap(ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
        								.addComponent(lblTipoGasto, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
        							.addGroup(layout.createSequentialGroup()
        								.addGroup(layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(rbtGastosNegocio)
        									.addGroup(layout.createSequentialGroup()
        										.addGap(39)
        										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
        								.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
        								.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        									.addGroup(layout.createSequentialGroup()
        										.addComponent(rbtGastosPersonales)
        										.addPreferredGap(ComponentPlacement.RELATED))
        									.addGroup(layout.createSequentialGroup()
        										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        										.addGap(26))))
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(btnNuevaFactura, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
        								.addComponent(btnIngresarGastos, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
        								.addGap(49))))
        					.addGroup(layout.createSequentialGroup()
        						.addGap(86)
        						.addComponent(lblSeleccioneElTipo))))
        			.addGap(47)
        			.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
        			.addGap(92))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(26)
        					.addComponent(lblSeleccioneElTipo)
        					.addGap(20)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(lblNewLabel)
        							.addComponent(lblNewLabel_1))
        						.addComponent(rbtGastosPersonales))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
        					.addGap(22)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblDetallesFactura)
        						.addComponent(lblTipoGasto, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(cmbDetallesFactura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(cmbTipoGasto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(81)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnNuevaFactura)
        						.addComponent(btnSalir)
        						.addComponent(btnIngresarGastos)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(59)
        					.addComponent(rbtGastosNegocio)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(42, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaFacturaActionPerformed
        // TODO add your handling code here:
        if(grpTipoFactura.getSelection().isSelected())
        {
            Date d= new Date();
            Calendar c = new GregorianCalendar();
            c.setTime(d);
            try {
                String totalFactura = "";
                String IVA = "";
                String formapago = "1";
                res = connection.createStatement().executeQuery("select secuencial from infoTributaria where id=(select max(id) from infoTributaria)");
                while(res.next())
                {
                    codigoFactura = res.getString("secuencial");
                }
                res = connection.createStatement().executeQuery("select totalSinImpuestos from infoFactura where ID_InfoFactura = (select max(ID_InfoFactura) from infoFactura)");
                while(res.next())
                {
                    totalFactura = res.getString("totalSinImpuestos");
                }
                res = connection.createStatement().executeQuery("select totalDescuento from infoFactura where ID_InfoFactura = (select max(ID_InfoFactura) from infoFactura)");
                while(res.next())
                {
                    IVA = res.getString("totalDescuento");
                }
                String dia = Integer.toString(c.get(Calendar.DATE));
                String mes = Integer.toString(c.get(Calendar.MONTH));
                String anio = Integer.toString(c.get(Calendar.YEAR));
                String fecha = dia+"/"+mes+"/"+anio;
                String datos[] ={codigoFactura,usuario,"Desconocido", fecha, formapago, totalFactura, IVA};
                controlExistencias.getSentencia().insertar(datos, "insert into factura (Nnm_factura,cod_cliente, Nombre_empleado, Fecha_facturacion, cod_formapago, total_factura, IVA) values (?,?,?,?,?,?,?)");
                btnIngresarGastos.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rbtGastosNegocio.isSelected())
            {
                cmbDetallesFactura.setEnabled(true);
                cmbTipoGasto.setEnabled(true);
                Object[] tipo_doc = controlExistencias.combox("tipo_gasto_negocio","descripcion_tipo_gasto_negocio");
                for(int i=0;i<tipo_doc.length;i++)
                    cmbTipoGasto.addItem(tipo_doc[i]);
                
                cmbTipoGasto.setSelectedIndex(-1);
                try {
                    res = connection.createStatement().executeQuery("select descripcion from detalle");
                    while(res.next())
                    {
                        cmbDetallesFactura.addItem(res.getString("descripcion"));
                        arreglodetalles.add(res.getString("descripcion"));
                    }
                    cmbDetallesFactura.setSelectedIndex(-1);
                } catch (SQLException ex) {
                    Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            else if(rbtGastosPersonales.isSelected())
            {
               cmbDetallesFactura.setEnabled(true);
               cmbTipoGasto.setEnabled(true);
               cmbTipoGasto.addItem("Alimentaci�n");
               cmbTipoGasto.addItem("Vestimenta");
               cmbTipoGasto.addItem("Salud");
               cmbTipoGasto.addItem("Educaci�n");
               cmbTipoGasto.addItem("Vivienda");
               cmbTipoGasto.addItem("Otros");
               cmbTipoGasto.setSelectedIndex(-1);
               
               try {
                    res = connection.createStatement().executeQuery("select descripcion from detalle");
                    while(res.next())
                    {
                        cmbDetallesFactura.addItem(res.getString("descripcion"));
                        arreglodetalles.add(res.getString("descripcion"));
                    }
                    cmbDetallesFactura.setSelectedIndex(-1);
                } catch (SQLException ex) {
                    Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No ha seleccionado el tipo de factura","Error", JOptionPane.ERROR_MESSAGE);
                
            }
        }
    }//GEN-LAST:event_btnNuevaFacturaActionPerformed
    
    public void limpiarBaseTransitoria() {
        try {
            String vaciarTablaInfoFactura = "Delete from infoFactura";
            String vaciarTablaInfoTributaria = "Delete from infoTributaria";
            String vaciarTablaInfoAdicional = "Delete from infoAdicional";
            String vaciarDetalle = "Delete from detalle";
            String vaciarImpuesto = "Delete from impuesto";
            
            connection.createStatement().execute(vaciarDetalle);
            connection.createStatement().execute(vaciarImpuesto);
            connection.createStatement().execute(vaciarTablaInfoAdicional);
            connection.createStatement().execute(vaciarTablaInfoFactura);
            connection.createStatement().execute(vaciarTablaInfoTributaria);
        } catch (SQLException ex) {
            Logger.getLogger(seleccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btnIngresarGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarGastosActionPerformed
        // TODO add your handling code here:
        if((cmbDetallesFactura.getSelectedIndex()==-1)||(cmbTipoGasto.getSelectedIndex()==-1))
        {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún elemento");
        }
        else
        {
            if(rbtGastosNegocio.isSelected())
            {
                String detalle = (String)cmbDetallesFactura.getSelectedItem();
                String tipoGasto = Integer.toString(cmbTipoGasto.getSelectedIndex());
                String cantidad = "";
                try {
                    res = connection.createStatement().executeQuery("select cantidad from detalle where descripcion = '"+(String)cmbDetallesFactura.getSelectedItem()+"'");
                    while(res.next())
                    {
                        cantidad = res.getString("cantidad");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(Level.SEVERE, null, ex);
                }
                String[] datos ={usuario, tipoGasto,  cantidad};
                controlExistencias.getSentencia().insertar(datos, "insert into gasto_negocio (codigo_cliente, tipo_gasto, cantidad) values (?,?,?)");
                arreglodetalles.remove(cmbDetallesFactura.getSelectedItem());
                cmbDetallesFactura.removeAllItems();
                for(int i=0;i<arreglodetalles.size();i++)
                {
                   cmbDetallesFactura.addItem(arreglodetalles.get(i));
                }
            }
            else 
            {
                String detalle = (String)cmbDetallesFactura.getSelectedItem();
                String tipogasto = (String)cmbTipoGasto.getSelectedItem();
                String cantidad = "";
                try {
                    res = connection.createStatement().executeQuery("select cantidad from detalle where descripcion = '"+(String)cmbDetallesFactura.getSelectedItem()+"'");
                    while(res.next())
                    {
                        cantidad = res.getString("cantidad");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(Level.SEVERE, null, ex);
                }
                Date d= new Date();
                Calendar c = new GregorianCalendar();
                c.setTime(d);
                String anio = Integer.toString(c.get(Calendar.YEAR));
                String[] datos = {usuario, anio, cantidad};
                
                if(cmbTipoGasto.getSelectedItem().equals("Alimentacion"))
                {
                    controlExistencias.getSentencia().insertar(datos, "Insert into gasto_personal (codigo_cliente, anio, alimentacion) values (?,?,?)");
                    arreglodetalles.remove(cmbDetallesFactura.getSelectedItem());
                    cmbDetallesFactura.removeAllItems();
                    for(int i=0;i<arreglodetalles.size();i++)
                    {
                        cmbDetallesFactura.addItem(arreglodetalles.get(i));
                    }
                }
                else if(cmbTipoGasto.getSelectedItem().equals("Vestimenta"))
                {
                    controlExistencias.getSentencia().insertar(datos, "insert into gasto_personal (codigo_cliente, anio, vestimenta) values (?,?,?)");
                    arreglodetalles.remove(cmbDetallesFactura.getSelectedItem());
                    cmbDetallesFactura.removeAllItems();
                    for(int i=0;i<arreglodetalles.size();i++)
                    {
                        cmbDetallesFactura.addItem(arreglodetalles.get(i));
                    }
                }
                else if(cmbTipoGasto.getSelectedItem().equals("Salud"))
                {
                    controlExistencias.getSentencia().insertar(datos, "insert into gasto_personal (codigo_cliente, anio, salud) values (?,?,?)");
                    arreglodetalles.remove(cmbDetallesFactura.getSelectedItem());
                    cmbDetallesFactura.removeAllItems();
                    for(int i=0;i<arreglodetalles.size();i++)
                    {
                        cmbDetallesFactura.addItem(arreglodetalles.get(i));
                    }
                }
                else if(cmbTipoGasto.getSelectedItem().equals("Educación"))
                {
                    controlExistencias.getSentencia().insertar(datos, "insert into gasto_personal (codigo_cliente, anio, educacion) values (?,?,?)");
                    arreglodetalles.remove(cmbDetallesFactura.getSelectedItem());
                    cmbDetallesFactura.removeAllItems();
                    for(int i=0;i<arreglodetalles.size();i++)
                    {
                        cmbDetallesFactura.addItem(arreglodetalles.get(i));
                    }
                }
                else
                {
                    controlExistencias.getSentencia().insertar(datos, "insert into gasto_personal (codigo_cliente, anio, vivienda) values (?,?,?)");
                    arreglodetalles.remove(cmbDetallesFactura.getSelectedItem());
                    cmbDetallesFactura.removeAllItems();
                    for(int i=0;i<arreglodetalles.size();i++)
                    {
                        cmbDetallesFactura.addItem(arreglodetalles.get(i));
                    }
                }
            }
        }
    }//GEN-LAST:event_btnIngresarGastosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        if(arreglodetalles.size()>0)
        {
            JOptionPane.showMessageDialog(null, "No ha ingresado todos los detalles", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        this.dispose();
        limpiarBaseTransitoria();
    }//GEN-LAST:event_btnSalirActionPerformed

    public void limpiarCajas()
    {
        grpTipoFactura.clearSelection();
        cmbDetallesFactura.setSelectedIndex(-1);
        cmbTipoGasto.setSelectedIndex(-1);
        
    }
    
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
            java.util.logging.Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazClasificacionFacturasXML().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresarGastos;
    private javax.swing.JButton btnNuevaFactura;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox cmbDetallesFactura;
    private javax.swing.JComboBox cmbTipoGasto;
    private javax.swing.ButtonGroup grpTipoFactura;
    private javax.swing.JLabel lblDetallesFactura;
    private javax.swing.JLabel lblTipoGasto;
    private javax.swing.JRadioButton rbtGastosNegocio;
    private javax.swing.JRadioButton rbtGastosPersonales;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblSeleccioneElTipo;
}
