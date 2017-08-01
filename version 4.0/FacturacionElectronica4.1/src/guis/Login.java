package guis;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Login extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrase�a;


	public Login() {
		setTitle("LECTOR XML");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEscuelaPolitcnicaNacional = new JLabel("ESCUELA POLIT�CNICA NACIONAL");
		lblEscuelaPolitcnicaNacional.setFont(new Font("Arial Black", Font.ITALIC, 11));
		lblEscuelaPolitcnicaNacional.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscuelaPolitcnicaNacional.setBounds(94, 0, 262, 28);
		contentPane.add(lblEscuelaPolitcnicaNacional);

		JLabel lblFacultadIngenieriaEn = new JLabel("FACULTAD DE INGENIERIA EN SISTEMAS");
		lblFacultadIngenieriaEn.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacultadIngenieriaEn.setBounds(94, 26, 271, 28);
		contentPane.add(lblFacultadIngenieriaEn);

		JLabel lblAplicacionesEnAmbientes = new JLabel("APLICACIONES EN AMBIENTES LIBRES\r\n");
		lblAplicacionesEnAmbientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAplicacionesEnAmbientes.setBounds(104, 49, 250, 28);
		contentPane.add(lblAplicacionesEnAmbientes);

		JLabel lblPeriodoAcademico = new JLabel("PERIODO ACAD�MICO 2017-A");
		lblPeriodoAcademico.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeriodoAcademico.setBounds(119, 65, 200, 28);
		contentPane.add(lblPeriodoAcademico);

		JLabel lblCapturadorDeFacturas = new JLabel("CAPTURADOR DE FACTURAS XML");
		lblCapturadorDeFacturas.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblCapturadorDeFacturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCapturadorDeFacturas.setBounds(114, 88, 227, 28);
		contentPane.add(lblCapturadorDeFacturas);

		JLabel lblFecha = new JLabel("FECHA 31/07/2017");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setBounds(119, 104, 200, 28);
		contentPane.add(lblFecha);

		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setBounds(96, 293, 82, 36);
		contentPane.add(lblUsuario);

		JLabel lblClave = new JLabel("CLAVE:");
		lblClave.setBounds(94, 324, 60, 36);
		contentPane.add(lblClave);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(188, 301, 151, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usuariosLogin usu= new usuariosLogin();
						if (!usu.ValidarUsuarios(txtUsuario.getText(), new String(txtContrase�a.getPassword()))){
							JOptionPane.showMessageDialog(null, "NOMBRE DE USUARIO O CONTRASE�A INV�LIDOS");
							txtContrase�a.setText("");
							txtUsuario.setText("");
							txtUsuario.requestFocusInWindow();
							return;
						}
						Gui_carga principal=new Gui_carga();
						principal.setVisible(true);
			}
		});
		btnEntrar.setBounds(94, 372, 89, 23);
		contentPane.add(btnEntrar);

		JButton btnSalirLogin = new JButton("SALIR");
		btnSalirLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�Esta seguro que desea salir de la aplicaci�n?");
			System.exit(0);


			}
		});
		btnSalirLogin.setBounds(250, 372, 89, 23);
		contentPane.add(btnSalirLogin);

		txtContrase�a = new JPasswordField();
		txtContrase�a.setBounds(186, 332, 153, 20);
		contentPane.add(txtContrase�a);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("logo.png")));
		lblNewLabel.setBounds(150, 127, 158, 170);
		contentPane.add(lblNewLabel);
	}
}
