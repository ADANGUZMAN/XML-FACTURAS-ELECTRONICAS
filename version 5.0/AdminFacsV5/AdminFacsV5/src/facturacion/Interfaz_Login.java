package facturacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Interfaz_Login extends JFrame {

	private JPanel contentPane;
	private JTextField cedulatxt;
	private JPasswordField contrasenatxt;
	public static UsuarioLogeado userloged;
	
	public Interfaz_Login() {
		setTitle("LECTOR XML");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 423, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscuelaPolitcnicaNacional = new JLabel("ESCUELA POLITÉCNICA NACIONAL");
		lblEscuelaPolitcnicaNacional.setFont(new Font("Arial Black", Font.ITALIC, 11));
		lblEscuelaPolitcnicaNacional.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscuelaPolitcnicaNacional.setBounds(57, 0, 262, 28);
		contentPane.add(lblEscuelaPolitcnicaNacional);
		
		
		JLabel lblFacultadIngenieriaEn = new JLabel("FACULTAD INGENIERIA EN SISTEMAS");
		lblFacultadIngenieriaEn.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacultadIngenieriaEn.setBounds(44, 26, 271, 28);
		contentPane.add(lblFacultadIngenieriaEn);
		
		JLabel lblAplicacionesEnAmbientes = new JLabel("APLICACIONES EN AMBIENTES LIBRES\r\n");
		lblAplicacionesEnAmbientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAplicacionesEnAmbientes.setBounds(67, 49, 250, 28);
		contentPane.add(lblAplicacionesEnAmbientes);
		
		JLabel lblPeriodoAcademico = new JLabel("PERIODO ACADEMICO 2017");
		lblPeriodoAcademico.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeriodoAcademico.setBounds(77, 65, 200, 28);
		contentPane.add(lblPeriodoAcademico);
		
		JLabel lblCapturadorDeFacturas = new JLabel("CAPTURADOR DE FACTURAS XML");
		lblCapturadorDeFacturas.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblCapturadorDeFacturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCapturadorDeFacturas.setBounds(73, 104, 227, 28);
		contentPane.add(lblCapturadorDeFacturas);
		
		JLabel lblFecha = new JLabel("FECHA 08/08/2017");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setBounds(77, 88, 200, 28);
		contentPane.add(lblFecha);
		
		
		
		JLabel lblCdula = new JLabel("Cedula:");
		lblCdula.setBounds(44, 293, 82, 36);
		contentPane.add(lblCdula);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(44, 324, 80, 36);
		contentPane.add(lblContrasea);
		
		/*JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Interfaz_Login.class.getResource("logo.png")));
		lblNewLabel.setBounds(150, 127, 158, 170);
		contentPane.add(lblNewLabel);*/
		
		cedulatxt = new JTextField();
		cedulatxt.setBounds(124, 301, 151, 20);
		contentPane.add(cedulatxt);
		cedulatxt.setColumns(10);
		
		contrasenatxt = new JPasswordField();
		contrasenatxt.setBounds(124, 332, 153, 20);
		contentPane.add(contrasenatxt);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setBackground(Color.DARK_GRAY);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 char clave[]=contrasenatxt.getPassword();
				 String clavedef=new String(clave);
				 ValidarLogin validador= new ValidarLogin();
				 if (validador.validar_ingreso(cedulatxt.getText(),clavedef)==1){

					 JOptionPane.showMessageDialog(null, "Bienvenido\n"+ "Has ingresado satisfactoriamente a"
					 		+ "l sistema",  null,JOptionPane.INFORMATION_MESSAGE);
                                      setVisible(false);
				      userloged = new UsuarioLogeado();
				      userloged.setPass(clavedef);
				      userloged.setUsuario(cedulatxt.getText());
				      new Interfaz_tipoFacturaAIngresar().setVisible(true);

				      }else {
	                    JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
	                    + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
	                    JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		
		
		btnIngresar.setBounds(149, 370, 110, 25);
		contentPane.add(btnIngresar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\logo.png"));
		lblNewLabel.setBounds(126, 143, 151, 152);
		contentPane.add(lblNewLabel);
		
	}
}
