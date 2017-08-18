package facturacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import facturacion.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthStyleFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Interfaz_tipoFacturaAIngresar extends Interfaz_Login  {

	private JPanel contentPane;
	String cedula=userloged.getUsuario();
	String nombre=obtenerNombre(cedula);
	boolean Admin=isAdmin(cedula);
	public Interfaz_tipoFacturaAIngresar() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 525);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIngresoFacturaManual = new JButton("Ingreso Factura Manual");
		btnIngresoFacturaManual.setForeground(Color.WHITE);
		btnIngresoFacturaManual.setBackground(Color.DARK_GRAY);
		btnIngresoFacturaManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Registrar_factura().setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnIngresoFacturaManual.setBounds(32, 205, 187, 25);
		contentPane.add(btnIngresoFacturaManual);
		
		JButton btnIngresoFacturaElectronica = new JButton("Ingreso Factura Electronica");
		btnIngresoFacturaElectronica.setForeground(Color.WHITE);
		btnIngresoFacturaElectronica.setBackground(Color.DARK_GRAY);
		btnIngresoFacturaElectronica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new seleccion().setVisible(true);
			}
		});
		btnIngresoFacturaElectronica.setBounds(280, 205, 187, 25);
		contentPane.add(btnIngresoFacturaElectronica);
		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUsuario.setBounds(172, 63, 295, 25);
		contentPane.add(lblUsuario);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setForeground(new Color(204, 51, 0));
		lblBienvenido.setFont(new Font("Wide Latin", Font.PLAIN, 16));
		lblBienvenido.setBounds(39, 34, 410, 28);
		contentPane.add(lblBienvenido);
		lblUsuario.setText(nombre);
		
		JButton btnRegistroDeProveedores = new JButton(" Registro de proveedores");
		btnRegistroDeProveedores.setForeground(Color.WHITE);
		btnRegistroDeProveedores.setBackground(Color.DARK_GRAY);
		btnRegistroDeProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interfaz_Registro_Proveedor form= new Interfaz_Registro_Proveedor();
				form.setVisible(true);
			}
		});
		btnRegistroDeProveedores.setBounds(32, 298, 187, 25);
		contentPane.add(btnRegistroDeProveedores);
		
		JButton btnGastosPersonales = new JButton("Tipo de Ingresos Econ\u00F3micos");
		btnGastosPersonales.setForeground(Color.WHITE);
		btnGastosPersonales.setBackground(Color.DARK_GRAY);
		btnGastosPersonales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GastosPersonalesRegistro().setVisible(true);
			}
		});
		btnGastosPersonales.setBounds(244, 298, 259, 25);
		contentPane.add(btnGastosPersonales);
		
		JButton btnRegistrarNuevoGasto = new JButton("Registar Tipo Gasto de Negocio");
		btnRegistrarNuevoGasto.setBackground(Color.DARK_GRAY);
		btnRegistrarNuevoGasto.setForeground(Color.WHITE);
		btnRegistrarNuevoGasto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            new TipoGastoNegocio().setVisible(true);
			}
		});
		btnRegistrarNuevoGasto.setBounds(280, 344, 223, 25);
		contentPane.add(btnRegistrarNuevoGasto);
                
                JButton btnReportes = new JButton("Generar Reportes");
                btnReportes.setForeground(Color.RED);
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            new InterfazReportes().setVisible(true);
			}
		});
		btnReportes.setBounds(152, 451, 209, 25);
		contentPane.add(btnReportes);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\nuevo usuario.png"));
		label.setBounds(95, 42, 67, 68);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\manual.png"));
		label_1.setBounds(99, 153, 48, 41);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\xml.png"));
		label_2.setBounds(339, 153, 59, 48);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\proveedor.png"));
		label_3.setBounds(101, 236, 46, 62);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\gastospersonales.png"));
		label_4.setBounds(352, 236, 59, 51);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\tipo de gasto negocio.png"));
		label_5.setBounds(211, 334, 59, 49);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\informe.png"));
		label_6.setBounds(224, 394, 67, 56);
		contentPane.add(label_6);
		if(Admin){
			btnGastosPersonales.setVisible(true);
			btnRegistrarNuevoGasto.setVisible(true);
			lblBienvenido.setText("Bienvenido Administrador");
		}else{
			btnGastosPersonales.setVisible(false);
			btnRegistrarNuevoGasto.setVisible(false);
		}

	}
	private String obtenerNombre(String cedula2) {

	    String resultado="";
	    
	    String SSQL="SELECT Nombres,Apellidos FROM cliente WHERE documento='"+cedula2+"';";
	    System.out.println(SSQL);
	    Connection conect = null;
	    

	    try {
	    	conect=DriverManager.getConnection("jdbc:mysql://localhost/facturacioninterfaces","root","");
	        if (conect!=null){
	           System.out.println("Conexión para nombre completa");
	        }
	        Statement st = conect.createStatement();
	        ResultSet rs = st.executeQuery(SSQL);
	        
	        if(rs.next()){

	            resultado+=rs.getString("Nombres");
	            resultado+=" ";
	            resultado+=rs.getString("Apellidos");
	            System.out.println(resultado);
	        }

	    } catch (SQLException ex) {

	        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);

	    }finally{


	        try {

	            conect.close();
	            System.out.println("conexion de nombre cerrada");

	        } catch (SQLException ex) {

	            JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

	        }

	    }
	return resultado;

	}
	private boolean isAdmin(String cedula2) {

	    String resultado="";
	    
	    String SSQL="SELECT Administrador FROM cliente WHERE documento='"+cedula2+"';";
	    System.out.println(SSQL);
	    Connection conect = null;
	    

	    try {
	    	conect=DriverManager.getConnection("jdbc:mysql://localhost/facturacioninterfaces","root","");
	        if (conect!=null){
	           System.out.println("Conexión para isadmin completa");
	        }
	        Statement st = conect.createStatement();
	        ResultSet rs = st.executeQuery(SSQL);
	        
	        if(rs.next()){

	            resultado = rs.getString("Administrador");
		            
	            System.out.println(resultado);
	        }

	    } catch (SQLException ex) {

	        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);

	    }finally{


	        try {

	            conect.close();
	            System.out.println("conexion de isadmin cerrada");

	        } catch (SQLException ex) {

	            JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

	        }

	    }
	    if(resultado.equals("0")){
        	return false;
        }else{
        	return true;
        	}
	}
}

