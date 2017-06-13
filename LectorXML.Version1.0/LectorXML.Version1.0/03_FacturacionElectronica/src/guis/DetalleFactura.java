package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.SystemColor;

public class DetalleFactura extends JFrame {

	private JPanel contPaneClasificarGastos;
	private JTextField textFieldID;
	private JTextField textFieldNombre;
	private JTable tableFacturas;
	private JTable table_1;
	private JTable tabledetalle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetalleFactura frame = new DetalleFactura();
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
	public DetalleFactura() {
		setForeground(Color.RED);
		setBackground(new Color(255, 127, 80));
		setTitle("CLASIFICAR GASTOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 403);
		contPaneClasificarGastos = new JPanel();
		contPaneClasificarGastos.setBackground(new Color(240, 230, 140));
		contPaneClasificarGastos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contPaneClasificarGastos);
		contPaneClasificarGastos.setLayout(null);
		
		JLabel lblLleneLosCampos = new JLabel("Llene los campos y selecciones las facturas\r\n");
		lblLleneLosCampos.setBounds(21, 11, 305, 29);
		contPaneClasificarGastos.add(lblLleneLosCampos);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 43, 46, 14);
		contPaneClasificarGastos.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 68, 46, 14);
		contPaneClasificarGastos.add(lblNombre);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 91, 46, 14);
		contPaneClasificarGastos.add(lblFecha);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(31, 40, 157, 20);
		contPaneClasificarGastos.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(62, 65, 152, 20);
		contPaneClasificarGastos.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JDateChooser dateCalendar = new JDateChooser();
		dateCalendar.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dateCalendar.setBounds(72, 91, 144, 20);
		contPaneClasificarGastos.add(dateCalendar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(224, 40, 511, 115);
		contPaneClasificarGastos.add(scrollPane);
		
		tableFacturas = new JTable();
		tableFacturas.setModel(new DefaultTableModel(
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
		scrollPane.setViewportView(tableFacturas);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(74, 132, 89, 23);
		contPaneClasificarGastos.add(btnBuscar);
		
		JLabel lblEscojaElTipo = new JLabel("ESCOJA EL TIPO DE GASTO PARA LLENAR EL DETALLE");
		lblEscojaElTipo.setBounds(10, 164, 347, 14);
		contPaneClasificarGastos.add(lblEscojaElTipo);
		
		JRadioButton rdbtnVivienda = new JRadioButton("VIVIENDA");
		rdbtnVivienda.setBackground(new Color(240, 230, 140));
		rdbtnVivienda.setBounds(10, 177, 115, 23);
		contPaneClasificarGastos.add(rdbtnVivienda);
		
		JRadioButton rdbtnAlimentacion = new JRadioButton("ALIMENTACION");
		rdbtnAlimentacion.setBackground(new Color(240, 230, 140));
		rdbtnAlimentacion.setBounds(133, 177, 135, 23);
		contPaneClasificarGastos.add(rdbtnAlimentacion);
		
		JRadioButton rdbtnEducacion = new JRadioButton("EDUCACION");
		rdbtnEducacion.setBackground(new Color(240, 230, 140));
		rdbtnEducacion.setBounds(299, 177, 144, 23);
		contPaneClasificarGastos.add(rdbtnEducacion);
		
		JRadioButton rdbtnSalud = new JRadioButton("SALUD");
		rdbtnSalud.setBackground(new Color(240, 230, 140));
		rdbtnSalud.setBounds(445, 177, 89, 23);
		contPaneClasificarGastos.add(rdbtnSalud);
		
		JRadioButton rdbtnVestimenta = new JRadioButton("VESTIMENTA");
		rdbtnVestimenta.setBackground(new Color(240, 230, 140));
		rdbtnVestimenta.setBounds(550, 177, 109, 23);
		contPaneClasificarGastos.add(rdbtnVestimenta);
		
		JRadioButton rdbtnOtros = new JRadioButton("OTROS");
		rdbtnOtros.setBackground(new Color(240, 230, 140));
		rdbtnOtros.setBounds(689, 177, 90, 23);
		contPaneClasificarGastos.add(rdbtnOtros);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 207, 730, 115);
		contPaneClasificarGastos.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setColumnHeaderView(table_1);
		
		tabledetalle = new JTable();
		tabledetalle.setModel(new DefaultTableModel(
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
		scrollPane_1.setViewportView(tabledetalle);
		
		JButton btnCargar = new JButton("CARGAR");
		btnCargar.setBounds(116, 333, 89, 23);
		contPaneClasificarGastos.add(btnCargar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(283, 333, 102, 23);
		contPaneClasificarGastos.add(btnCancelar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(445, 333, 89, 23);
		contPaneClasificarGastos.add(btnSalir);
	}
}
