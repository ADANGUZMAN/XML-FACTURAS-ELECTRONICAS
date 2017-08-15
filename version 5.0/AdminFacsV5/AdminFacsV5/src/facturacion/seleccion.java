package facturacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class seleccion extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private String primero, segundo, tercero, cuarto, quinto;
    private Connection connection = null;
    private java.sql.ResultSet res;
    private  JButton btnCargarEnBase;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    seleccion frame = new seleccion();
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
    public seleccion() {
        setTitle("Organizador de Facturas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 474, 261);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(51, 153, 153));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        Button button = new Button("Buscar Factura");
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String userhome = System.getProperty("user.home");
                JFileChooser fc = new JFileChooser(userhome + "\\Desktop");
                fc.setPreferredSize(new Dimension(800, 900));
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    System.out.println("Where is your MySQL JDBC Driver?");
                    e.printStackTrace();
                    return;
                }
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost/pruebafacturas", "root", "");

                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
                    return;
                }

                if (connection != null) {
                    System.out.println("You made it, take control your database now!");
                } else {
                    System.out.println("Failed to make connection!");
                }////conexi�n

                //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
                int seleccion = fc.showOpenDialog(contentPane);

                //Si el usuario, pincha en aceptar
                if (seleccion == JFileChooser.APPROVE_OPTION) {

                    //Seleccionamos el fichero
                    File fichero = fc.getSelectedFile();

                    //Escribe la ruta del fichero seleccionado en el campo de texto
                    textField.setText(fichero.getAbsolutePath());
                }
                String cadena = textField.getText();
                cadena = cadena.replace('\\', '/');
                System.out.println(cadena);
                primero = "LOAD XML LOCAL INFILE '" + cadena + "' INTO TABLE infotributaria ROWS IDENTIFIED BY '<infoTributaria>';";
                segundo = "LOAD XML LOCAL INFILE '" + cadena + "' INTO TABLE infofactura ROWS IDENTIFIED BY '<infoFactura>';";
                tercero = "LOAD XML LOCAL INFILE '" + cadena + "' INTO TABLE detalle ROWS IDENTIFIED BY '<detalle>';";
                cuarto = "LOAD XML LOCAL INFILE '" + cadena + "' INTO TABLE impuesto ROWS IDENTIFIED BY '<impuesto>';";
                quinto = "LOAD XML LOCAL INFILE '" + cadena + "' INTO TABLE infoadicional ROWS IDENTIFIED BY '<infoAdicional>';";
                btnCargarEnBase.setEnabled(true);
            }
        });
        button.setBounds(267, 99, 117, 22);
        contentPane.add(button);

        textField = new JTextField();
        textField.setBounds(105, 146, 269, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblRuta = new JLabel("Ruta:");
        lblRuta.setBounds(61, 149, 34, 14);
        contentPane.add(lblRuta);

        JLabel lblOrganizadorDeFacturas = new JLabel("Organizar y Buscar sus facturas");
        lblOrganizadorDeFacturas.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblOrganizadorDeFacturas.setBounds(40, 11, 438, 89);
        contentPane.add(lblOrganizadorDeFacturas);

        btnCargarEnBase = new JButton("Cargar en Base de Datos");
        btnCargarEnBase.setForeground(Color.WHITE);
        btnCargarEnBase.setBackground(Color.DARK_GRAY);
        btnCargarEnBase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                try {
                    connection.createStatement().execute(primero);
                    connection.createStatement().execute(tercero);
                    connection.createStatement().execute(cuarto);
                    connection.createStatement().execute(quinto);
                    connection.createStatement().execute(segundo);
                    System.out.println(primero);
                    res = connection.createStatement().executeQuery("select secuencial from infotributaria where id=(select max(id) from infotributaria)");
                    String secuencial = "";
                    while (res.next()) {

                        secuencial = res.getString("secuencial");
                    }
                    System.out.println(secuencial);
                    res = connection.createStatement().executeQuery("select count(secuencial) from infotributaria where secuencial=" + secuencial);
                    int existe = 0;
                    while (res.next()) {

                        existe = res.getInt("count(secuencial)");
                    }
                    new InterfazClasificacionFacturasXML().setVisible(true);
                    System.out.println(existe);
                    if (existe > 1) {
                        JOptionPane.showMessageDialog(null, "factura duplicada");
                        limpiarBaseTransitoria();

                    }

                } catch (SQLException e1) {

                    e1.printStackTrace();
                }

            }
        });
        btnCargarEnBase.setBounds(149, 177, 208, 23);
        contentPane.add(btnCargarEnBase);
        btnCargarEnBase.setEnabled(false);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\Daniel\\Desktop\\iconos\\xml.png"));
        label.setBounds(177, 87, 53, 48);
        contentPane.add(label);
    }
    
    public void limpiarBaseTransitoria() {
        try {
            String vaciarTablaInfoFactura = "Delete from infoFactura";
            String vaciarTablaInfoTributaria = "Delete from infoTributaria";
            String vaciarTablaInfoAdicional = "Delete from infoFAdicional";
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

    
}
