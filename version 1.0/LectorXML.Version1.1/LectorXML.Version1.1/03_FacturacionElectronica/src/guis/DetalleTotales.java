package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class DetalleTotales extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetalleTotales frame = new DetalleTotales();
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
	public DetalleTotales() {
		setTitle("TOTALES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscojaLaCategoria = new JLabel("ESCOJA LA CATEGORIA QUE DESEA VISUALIZAR SUS TOTALES");
		lblEscojaLaCategoria.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEscojaLaCategoria.setBounds(32, 11, 487, 25);
		contentPane.add(lblEscojaLaCategoria);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(32, 47, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 72, 68, 14);
		contentPane.add(lblNombre);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(10, 97, 68, 30);
		contentPane.add(lblFecha);
		
		textField = new JTextField();
		textField.setBounds(81, 47, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 69, 133, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(81, 97, 131, 30);
		contentPane.add(monthChooser);
		
		JLabel lblTipoDeGasto = new JLabel("Tipo de Gasto:");
		lblTipoDeGasto.setBounds(245, 47, 123, 14);
		contentPane.add(lblTipoDeGasto);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("VIVIENDA");
		rdbtnNewRadioButton.setBackground(new Color(240, 230, 140));
		rdbtnNewRadioButton.setBounds(231, 68, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("ALIMENTACION");
		rdbtnNewRadioButton_1.setBackground(new Color(240, 230, 140));
		rdbtnNewRadioButton_1.setBounds(353, 68, 123, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("SALUD");
		rdbtnNewRadioButton_2.setBackground(new Color(240, 230, 140));
		rdbtnNewRadioButton_2.setBounds(231, 93, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("VESTIMENTA");
		rdbtnNewRadioButton_3.setBackground(new Color(240, 230, 140));
		rdbtnNewRadioButton_3.setBounds(353, 93, 123, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("EDUCACION");
		rdbtnNewRadioButton_4.setBackground(new Color(240, 230, 140));
		rdbtnNewRadioButton_4.setBounds(231, 119, 109, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("OTROS");
		rdbtnNewRadioButton_5.setBackground(new Color(240, 230, 140));
		rdbtnNewRadioButton_5.setBounds(353, 119, 109, 23);
		contentPane.add(rdbtnNewRadioButton_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 229, 387, -71);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 150, 476, 115);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(114, 279, 109, 23);
		contentPane.add(btnCancelar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(326, 276, 89, 23);
		contentPane.add(btnSalir);
	}
}
