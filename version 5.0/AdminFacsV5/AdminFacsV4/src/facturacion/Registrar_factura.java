package facturacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Registrar_factura extends Interfaz_Login{

	private JPanel contentPane;
	Sentencias_sql sensql = new Sentencias_sql();
	String cedula=userloged.getUsuario();
	private JTextField txtRuc;
	private JTextField txtValor;
	private JTextField ivatxt;
	private JTextField txtTotal;
    private Connection connection = null;
    private java.sql.ResultSet res;
	public Registrar_factura() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Daniel\\Desktop\\iconos\\3.png"));
		setTitle("Registrode Factura Manual");
		control_existencias controlExistencias = new control_existencias();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboProove = new JComboBox();
		comboProove.setForeground(Color.WHITE);
		comboProove.setBackground(Color.DARK_GRAY);
		comboProove.setSelectedIndex(-1);
		comboProove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int j=comboProove.getSelectedIndex();
				if(j>0){

					String proveedor = (String) comboProove.getSelectedItem();		
					System.out.println(proveedor);
					cargarDatosProveedor(j);
				}else{
				}
			}

			private void cargarDatosProveedor(int j) {
				control_proveedor con = new control_proveedor("No_documento","Tipo de documento","Nombre","Apellido","Nombre_comercial","Direccion","Ciudad","telefono");       
		        String[] columnas = {"Documento","Tipo de documento","Nombre","Apellido","Nombre_comercial","Direccion","Ciudad","Telefono"};
		        String[][] documentos = (String[][]) con.consulta_proveedor();
		        txtRuc.setText(documentos[j-1][0]);
		        
			}
		});
		comboProove.setBounds(107, 38, 177, 24);
		contentPane.add(comboProove);
		Object[] prov = controlExistencias.combox("proveedor","Nombre_comercial");
        comboProove.removeAllItems();
        comboProove.addItem("Seleccione un proveedor");
        for(int i=0;i<prov.length;i++){
        comboProove.addItem(prov[i]);
    }
        
		JLabel lblProveedores = new JLabel("Proveedores");
		lblProveedores.setBounds(26, 43, 87, 15);
		contentPane.add(lblProveedores);
		
		txtRuc = new JTextField();
		txtRuc.setEditable(false);
		txtRuc.setEnabled(false);
		txtRuc.setBounds(347, 38, 114, 22);
		contentPane.add(txtRuc);
		txtRuc.setColumns(10);
		
		JLabel lblRuc = new JLabel("RUC");
		lblRuc.setBounds(297, 43, 53, 15);
		contentPane.add(lblRuc);

                MaskFormatter mascara = new MaskFormatter("##-##-#########");
		JFormattedTextField txtnumFac = new JFormattedTextField(mascara);
		txtnumFac.setBounds(107, 74, 177, 24);
		contentPane.add(txtnumFac);
		
		JLabel lblNFactura = new JLabel("N\u00B0 de factura");
		lblNFactura.setBounds(10, 78, 92, 15);
		contentPane.add(lblNFactura);
		
		JDateChooser fechaFactura = new JDateChooser();
		Calendar today = Calendar.getInstance();
		fechaFactura.setDate(today.getTime());
		fechaFactura.setBounds(347, 72, 114, 26);
		contentPane.add(fechaFactura);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(297, 78, 53, 15);
		contentPane.add(lblFecha);
		
		JComboBox combGasto = new JComboBox();
		combGasto.setForeground(Color.WHITE);
		combGasto.setBackground(Color.DARK_GRAY);
        Object[] tipo = controlExistencias.combox("tipo_articulo","descripcion_articulo");
        combGasto.removeAllItems();
        combGasto.addItem("Seleccione un tipo");
        for(int i=0;i<tipo.length;i++){
        combGasto.addItem(tipo[i]);
    }
        combGasto.setBounds(119, 155, 137, 24);
		contentPane.add(combGasto);
		
		JTextArea Areatxt = new JTextArea();
		Areatxt.setBounds(97, 191, 237, 77);
		contentPane.add(Areatxt);
		
		txtValor = new JTextField();
		txtValor.setBounds(324, 158, 76, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		int contador=0;
		ArrayList<String> valor=new ArrayList<>();
		ArrayList<String> TipoGasto=new ArrayList<>();
		JButton btnGuardar = new JButton("Guardar gasto y continuar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(Color.DARK_GRAY);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboProove.getSelectedIndex()==0||txtnumFac.getText().replace("-","").trim().equals("")||combGasto.getSelectedIndex()==0||txtValor.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios revise y vuelva a ingresar");
				}else{
				comboProove.setEnabled(false);
				txtnumFac.setEnabled(false);
				fechaFactura.setEnabled(false);
                                if(isDouble(txtValor.getText())){
				TipoGasto.add((String) combGasto.getSelectedItem());
				valor.add(txtValor.getText());
				Areatxt.append((String) combGasto.getSelectedItem()+", "+txtValor.getText()+"\n");
                                }else{
                                JOptionPane.showMessageDialog(null, "ingrese un numero valido con formato 00.00 o 00,00");
                                }
				}
			}

                    private boolean isDouble(String cadena) {
                        cadena=cadena.replace(",", ".");
                        try {
		Double.parseDouble(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
                    }
		});
		btnGuardar.setBounds(347, 243, 189, 25);
		contentPane.add(btnGuardar);
		
		
		
		ivatxt = new JTextField();
		ivatxt.setBounds(171, 275, 114, 19);
		contentPane.add(ivatxt);
		ivatxt.setColumns(10);
		
		JLabel txtIva = new JLabel("IVA");
		txtIva.setBounds(100, 277, 53, 15);
		contentPane.add(txtIva);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(170, 310, 114, 19);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(100, 312, 53, 15);
		contentPane.add(lblTotal);
		
		JButton btnNewButton = new JButton("Finalizar Registro");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(ivatxt.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Ingrese el Iva de la factura");
					
				}else{
					combGasto.setEnabled(false);
					txtValor.setEnabled(false);
					Areatxt.setEnabled(false);
					btnGuardar.setEnabled(false);
					ivatxt.setEnabled(false);
				double total=0;
                                double valorFinal=0;
                                double alimentacion=0,salud=0,educacion=0,vestimenta=0,vivienda=0,otros=0;
				for (int i = 0; i < valor.size(); i++) {
					
					guardarEnBase(TipoGasto.get(i),valor.get(i),cedula);
					//total += Integer.parseInt(valor.get(i).replace(",", "."));
                                        valorFinal += Double.parseDouble(valor.get(i).replace(",", "."));
                                        if(TipoGasto.get(i).equals("alimentacion")){
                                            alimentacion+=Double.parseDouble(valor.get(i).replace(",", "."));
                                        }
                                        if(TipoGasto.get(i).equals("salud")){
                                            salud+=Double.parseDouble(valor.get(i).replace(",", "."));
                                        }
                                        if(TipoGasto.get(i).equals("educacion")){
                                            educacion+=Double.parseDouble(valor.get(i).replace(",", "."));
                                        }
                                        if(TipoGasto.get(i).equals("vestimenta")){
                                            vestimenta+=Double.parseDouble(valor.get(i).replace(",", "."));
                                        }
                                        if(TipoGasto.get(i).equals("vivienda")){
                                            vivienda+=Double.parseDouble(valor.get(i).replace(",", "."));
                                        }
                                        
				}
				//guardarEnBase("IVA",ivatxt.getText(),cedula);
                                txtTotal.setText(String.valueOf(valorFinal));
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                String date = sdf.format(fechaFactura.getDate());
                               
                                guardarFactura(alimentacion,salud,educacion,vestimenta,vivienda,otros,valorFinal,Double.parseDouble(ivatxt.getText().replace(",", ".")), date);
				JOptionPane.showMessageDialog(null, "Se ingreso correctamente los gastos");
                                btnNewButton.setEnabled(false);
				}
				}

			private void guardarEnBase(String tipoGasto, String valor, String cedula) {
				conectar();
				tipoGasto=tipoGasto.toLowerCase();
				valor = valor.replace(",", ".");
				String consulta="UPDATE gasto_personal SET "+tipoGasto+" = "+tipoGasto+" + "+valor+" WHERE codigo_cliente="+"'"+cedula+"'";
				try {
					
					System.out.println(consulta);
					connection.createStatement().execute(consulta);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private void conectar() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					return;
				}				
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost/facturacioninterfaces","root", "");

				} catch (SQLException e) {
					System.out.println("Connection Failed! Check output console");
					e.printStackTrace();
					return;
				}

				if (connection != null) {
					System.out.println("You made it, take control your database now!");
								} else {
					System.out.println("Failed to make connection!");
				}				
			}

                    private void guardarFactura(double alimentacion, double salud, double educacion, double vestimenta, double vivienda,double otros, double valorFinal, double iva, String fecha) {
                        conexion guardarFact=new conexion();
                        Connection factura = guardarFact.conectado();
                        String insert="INSERT INTO `facturaPersonal` (`Nnm_factura`, `cod_cliente`, `Nombre_empleado`, `Fecha_facturacion`, `cod_formapago`, `total_factura`, `IVA`,`alimentacion`, `salud`, `educacion`, `vestimenta`, `vivienda`, `otros`) VALUES ('"+txtnumFac.getText()+"','"+cedula+"','"+comboProove.getSelectedItem()+"','"+fecha+"','1','"+String.valueOf(valorFinal)+"','"+String.valueOf(iva)+"','"+alimentacion+"','"+salud+"','"+educacion+"','"+vestimenta+"','"+vivienda+"','"+otros+"')";    
                        System.out.println(insert);
                        try {
                                factura.createStatement().execute(insert);
                            } catch (SQLException ex) {
                                Logger.getLogger(Registrar_factura.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
		});
		btnNewButton.setBounds(236, 365, 153, 25);
		contentPane.add(btnNewButton);
                
		
		JLabel lblTipoDeGasto = new JLabel("Tipo de Gasto");
		lblTipoDeGasto.setBounds(142, 128, 114, 15);
		contentPane.add(lblTipoDeGasto);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(347, 128, 53, 15);
		contentPane.add(lblValor);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\4.png"));
		label.setBounds(417, 184, 76, 48);
		contentPane.add(label);
		
	}
}