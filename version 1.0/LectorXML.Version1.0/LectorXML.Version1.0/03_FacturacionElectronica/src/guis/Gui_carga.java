package guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import utils.ProcesdorXML;
import utils.operacionesSobreDB;

public class Gui_carga extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfPath;
	private JTextField pro_nombres;
	private JTextField pro_apellidos;
	private JTextField pro_ruc;
	private JTextField pro_dir;
	private JTextField pro_ciudad;
	private JTextField cli_ruc;
	private JTextField cli_nombres;
	private JTextField cli_apellidos;
	private JTextField fac_fecha;
	private JTextField fac_numero;
	private JTextField fac_acatgoria;
	private JTextField fac_subtotal;
	private JTextField fac_iva;
	private JTextField fac_descuento;
	private JTextField fac_total;
	private JButton jbtnCargar,btnGuardar,btnCancelar,	btnSalir;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebaCArga frame = new pruebaCArga();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui_carga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblArchivo = new JLabel("ARCHIVO:");
		lblArchivo.setBounds(10, 11, 89, 14);
		contentPane.add(lblArchivo);

		jtfPath = new JTextField();
		jtfPath.setBounds(96, 8, 408, 20);
		contentPane.add(jtfPath);
		jtfPath.setColumns(10);

		jbtnCargar = new JButton("CARGAR");
		jbtnCargar.setBounds(516, 7, 89, 23);
		contentPane.add(jbtnCargar);
		jbtnCargar.setActionCommand("load");
		jbtnCargar.addActionListener(this);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 36, 164, 290);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 22, 46, 14);
		panel.add(lblNombres);

		pro_nombres = new JTextField();
		pro_nombres.setEnabled(false);
		pro_nombres.setBounds(10, 47, 144, 20);
		panel.add(pro_nombres);
		pro_nombres.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 78, 46, 14);
		panel.add(lblApellidos);

		pro_apellidos = new JTextField();
		pro_apellidos.setEnabled(false);
		pro_apellidos.setBounds(10, 103, 144, 20);
		panel.add(pro_apellidos);
		pro_apellidos.setColumns(10);

		JLabel lblRuc = new JLabel("RUC:");
		lblRuc.setBounds(10, 134, 46, 14);
		panel.add(lblRuc);

		pro_ruc = new JTextField();
		pro_ruc.setEnabled(false);
		pro_ruc.setBounds(10, 159, 144, 20);
		panel.add(pro_ruc);
		pro_ruc.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 190, 81, 14);
		panel.add(lblDireccion);

		pro_dir = new JTextField();
		pro_dir.setEnabled(false);
		pro_dir.setBounds(10, 207, 144, 20);
		panel.add(pro_dir);
		pro_dir.setColumns(10);

		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 238, 46, 14);
		panel.add(lblCiudad);

		pro_ciudad = new JTextField();
		pro_ciudad.setEnabled(false);
		pro_ciudad.setBounds(10, 255, 144, 20);
		panel.add(pro_ciudad);
		pro_ciudad.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(211, 39, 183, 205);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblRuc_1 = new JLabel("RUC:");
		lblRuc_1.setBounds(10, 21, 46, 14);
		panel_1.add(lblRuc_1);

		cli_ruc = new JTextField();
		cli_ruc.setEnabled(false);
		cli_ruc.setBounds(10, 46, 163, 20);
		panel_1.add(cli_ruc);
		cli_ruc.setColumns(10);

		JLabel lblNombres_1 = new JLabel("Nombres:");
		lblNombres_1.setBounds(10, 80, 46, 14);
		panel_1.add(lblNombres_1);

		cli_nombres = new JTextField();
		cli_nombres.setEnabled(false);
		cli_nombres.setColumns(10);
		cli_nombres.setBounds(10, 105, 163, 20);
		panel_1.add(cli_nombres);

		JLabel lblApellidos_1 = new JLabel("Apellidos:");
		lblApellidos_1.setBounds(10, 136, 63, 14);
		panel_1.add(lblApellidos_1);

		cli_apellidos = new JTextField();
		cli_apellidos.setEnabled(false);
		cli_apellidos.setColumns(10);
		cli_apellidos.setBounds(10, 161, 163, 20);
		panel_1.add(cli_apellidos);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Factura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(422, 39, 183, 382);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblFecha = new JLabel("fecha:");
		lblFecha.setBounds(10, 22, 46, 14);
		panel_2.add(lblFecha);

		fac_fecha = new JTextField();
		fac_fecha.setEnabled(false);
		fac_fecha.setColumns(10);
		fac_fecha.setBounds(10, 37, 163, 20);
		panel_2.add(fac_fecha);

		JLabel lblNroFactura = new JLabel("Nro FActura:");
		lblNroFactura.setBounds(10, 68, 101, 14);
		panel_2.add(lblNroFactura);

		fac_numero = new JTextField();
		fac_numero.setEnabled(false);
		fac_numero.setColumns(10);
		fac_numero.setBounds(10, 93, 163, 20);
		panel_2.add(fac_numero);

		JLabel lblCtaegoria = new JLabel("Ctaegoria:");
		lblCtaegoria.setBounds(10, 124, 89, 14);
		panel_2.add(lblCtaegoria);

		fac_acatgoria = new JTextField();
		fac_acatgoria.setEnabled(false);
		fac_acatgoria.setColumns(10);
		fac_acatgoria.setBounds(10, 143, 163, 20);
		panel_2.add(fac_acatgoria);

		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setBounds(10, 168, 89, 14);
		panel_2.add(lblSubtotal);

		fac_subtotal = new JTextField();
		fac_subtotal.setEnabled(false);
		fac_subtotal.setColumns(10);
		fac_subtotal.setBounds(10, 190, 163, 20);
		panel_2.add(fac_subtotal);

		JLabel lblVenia = new JLabel("Venia:");
		lblVenia.setBounds(10, 221, 46, 14);
		panel_2.add(lblVenia);

		fac_iva = new JTextField();
		fac_iva.setEnabled(false);
		fac_iva.setColumns(10);
		fac_iva.setBounds(10, 241, 163, 20);
		panel_2.add(fac_iva);

		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setBounds(10, 272, 74, 14);
		panel_2.add(lblDescuento);

		fac_descuento = new JTextField();
		fac_descuento.setEnabled(false);
		fac_descuento.setColumns(10);
		fac_descuento.setBounds(10, 290, 163, 20);
		panel_2.add(fac_descuento);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(10, 321, 46, 14);
		panel_2.add(lblTotal);

		fac_total = new JTextField();
		fac_total.setEnabled(false);
		fac_total.setColumns(10);
		fac_total.setBounds(10, 340, 163, 20);
		panel_2.add(fac_total);

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(52, 372, 89, 23);
		contentPane.add(btnGuardar);
		btnGuardar.setActionCommand("save");
		btnGuardar.addActionListener(this);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(173, 372, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.setActionCommand("cancel");
		btnCancelar.addActionListener(this);


		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(284, 372, 89, 23);
		contentPane.add(btnSalir);
		btnSalir.setActionCommand("quit");
		btnSalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String accion=e.getActionCommand();
		if (accion.equals("load"))
		{
			//Creamos el objeto JFileChooser
			JFileChooser fc=new JFileChooser();

			//Indicamos lo que podemos seleccionar
			fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

			//Creamos el filtro
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.XML", "xml");

			//Le indicamos el filtro
			fc.setFileFilter(filtro);

			//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
			int seleccion=fc.showOpenDialog(contentPane);

			//Si el usuario, pincha en aceptar
			if(seleccion==JFileChooser.APPROVE_OPTION)
			{
				//Seleccionamos el fichero
				File fichero=fc.getSelectedFile();
				//Ecribe la ruta del fichero seleccionado en el campo de texto
				jtfPath.setText(fichero.getAbsolutePath());
			}
			
			//procesamiento archivo xml 
			ProcesdorXML procesador=new ProcesdorXML(jtfPath.getText());
			String datClientes[]=procesador.getNodeContent("cliente");
			String datProveedor[]=procesador.getNodeContent("proveedor");
			String dataFactura[]=procesador.getNodeContent("identificadores");
			pro_nombres.setText(datProveedor[0].trim());
			pro_apellidos.setText(datProveedor[1].trim());
			pro_ruc.setText(datProveedor[2].trim());
			pro_dir.setText(datProveedor[3].trim());
			pro_ciudad.setText(datProveedor[4].trim());
			
			cli_ruc.setText(datClientes[0].trim());
			cli_nombres.setText(datClientes[1].trim());
			cli_apellidos.setText(datClientes[2].trim());
			
			fac_fecha.setText(dataFactura[0].trim());
			fac_numero.setText(dataFactura[1].trim());
			fac_acatgoria.setText(dataFactura[2].trim());
			fac_subtotal.setText(dataFactura[3].trim());
			fac_iva.setText(dataFactura[4].trim());
			fac_descuento.setText(dataFactura[5].trim());
			fac_total.setText(dataFactura[6].trim());	
		}



		if (accion.equals("save"))
		{
			if(jtfPath.getText().trim().length()>0)
			{
				operacionesSobreDB operador=new operacionesSobreDB();
				
				if(operador.insertarDatosDB("cliente", operador.obtnerColumNames("cliente"), new String[]{
						cli_ruc.getText(),cli_apellidos.getText()+" "+cli_nombres.getText()
				}) &&
				operador.insertarDatosDB("factura", operador.obtnerColumNames("factura"), new String[]{
					fac_numero.getText(),fac_fecha.getText(),fac_acatgoria.getText(), 
					fac_subtotal.getText(), fac_iva.getText(), fac_total.getText(),
					operador.obtenerID("cliente", operador.obtnerColumNames("cliente")[0], 
							operador.obtnerColumNames("cliente")[1], cli_ruc.getText())
				}) &&
				operador.insertarDatosDB("proveedor", operador.obtnerColumNames("proveedor"),new String[]{
						pro_apellidos.getText()+" "+pro_nombres.getText(),pro_ruc.getText(), 
						pro_dir.getText(), pro_ciudad.getText(),operador.obtenerID("factura",
								operador.obtnerColumNames("factura")[0],operador.obtnerColumNames("factura")[1] , fac_numero.getText())
				})
				)
					JOptionPane.showMessageDialog(null, "GUARDAO EXITOSO");
				else
					JOptionPane.showMessageDialog(null, "ERROR INESPERADO");
					
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Aun no se ha seleccionado el archivo", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}
		if (accion.equals("cancel"))
		{
			pro_nombres.setText("");
			pro_apellidos.setText("");
			pro_ruc.setText("");
			pro_dir.setText("");
			pro_ciudad.setText("");
			
			cli_ruc.setText("");
			cli_nombres.setText("");
			cli_apellidos.setText("");
			
			fac_fecha.setText("");
			fac_numero.setText("");
			fac_acatgoria.setText("");
			fac_subtotal.setText("");
			fac_iva.setText("");
			fac_descuento.setText("");
			fac_total.setText("");
		}
		if (accion.equals("quit"))
		{

		}


	}
}
