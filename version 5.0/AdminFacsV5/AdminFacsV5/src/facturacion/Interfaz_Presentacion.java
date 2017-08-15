package facturacion;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;

public class Interfaz_Presentacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Presentacion frame = new Interfaz_Presentacion();
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
	public Interfaz_Presentacion() {
		setTitle("LECTOR XML");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 346);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblBienvenido = new JLabel("Bienvenido al sistema");
		lblBienvenido.setFont(new Font("Dialog", Font.BOLD, 30));
		lblBienvenido.setBounds(85, 11, 450, 52);
		contentPane.add(lblBienvenido);

		JLabel lblBienvenidos = new JLabel(" de Administracion");
		lblBienvenidos.setFont(new Font("Dialog", Font.ITALIC, 30));
		lblBienvenidos.setBounds(110, 46, 450, 60);
		contentPane.add(lblBienvenidos);
		
		JLabel lblBienvenid = new JLabel("de Facturación");
		lblBienvenid.setFont(new Font("Dialog", Font.ITALIC, 30));
		lblBienvenid.setBounds(144, 98, 225, 52);
		contentPane.add(lblBienvenid);
		
		JButton btnUsuarioRegistrado = new JButton("Usuario");
		btnUsuarioRegistrado.setForeground(Color.WHITE);
		btnUsuarioRegistrado.setBackground(Color.GRAY);
		btnUsuarioRegistrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interfaz_Login frame = new Interfaz_Login();
				frame.setVisible(true);
			}
		});
		btnUsuarioRegistrado.setBounds(84, 272, 137, 25);
		contentPane.add(btnUsuarioRegistrado);
		
		JButton btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.setForeground(Color.WHITE);
		btnNuevoUsuario.setBackground(Color.DARK_GRAY);
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			new Interfaz_Clientes1().setVisible(true);	
			}
		});
		btnNuevoUsuario.setBounds(310, 272, 137, 25);
		contentPane.add(btnNuevoUsuario);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\usr (2).png"));
		lblNewLabel.setBounds(310, 138, 130, 123);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\olvidaste-tu-contrasena-de-usuario-de-oficina-de-las-preferencias-de-icono-4565-64.png"));
		lblNewLabel_1.setBounds(120, 157, 69, 104);
		contentPane.add(lblNewLabel_1);
	}
}
