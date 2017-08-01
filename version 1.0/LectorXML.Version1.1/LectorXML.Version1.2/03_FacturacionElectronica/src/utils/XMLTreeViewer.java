package utils;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import guis.DetalleFactura;
import guis.DetalleTotales;
import guis.usuariosLogin;

public class XMLTreeViewer extends DefaultHandler {

	private JTree xmlJTree;
	DefaultTreeModel treeModel;
	int lineCounter;
	DefaultMutableTreeNode base = new DefaultMutableTreeNode("Visor XML");
	static XMLTreeViewer treeViewer = null;
	JTextField txtFile = null;

	@Override
	public void startElement(String uri, String localName, String tagName, Attributes attr) throws SAXException {

		DefaultMutableTreeNode current = new DefaultMutableTreeNode(tagName);

		base.add(current);
		base = current;

		for (int i = 0; i < attr.getLength(); i++) {
			DefaultMutableTreeNode currentAtt = new DefaultMutableTreeNode(attr.getLocalName(i) + " = "
					+ attr.getValue(i));
			base.add(currentAtt);
		}
	}

	public void skippedEntity(String name) throws SAXException {
		System.out.println("Skipped Entity: '" + name + "'");
	}

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		 base = new DefaultMutableTreeNode("XML Viewer");
		((DefaultTreeModel) xmlJTree.getModel()).setRoot(base);
	}

	public void characters(char[] ch, int start, int length) throws SAXException {

		String s = new String(ch, start, length).trim();
		if (!s.equals("")) {
			DefaultMutableTreeNode current = new DefaultMutableTreeNode("Descrioption : " + s);
			base.add(current);

		}
	}

	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {

		base = (DefaultMutableTreeNode) base.getParent();
	}

	/*public static void main(String[] args) {
		treeViewer = new XMLTreeViewer();
		// treeViewer.xmlSetUp();
		treeViewer.createUI();

	}*/

	@Override
	public void endDocument() throws SAXException {
		// Refresh JTree
		((DefaultTreeModel) xmlJTree.getModel()).reload();
		//expandAll(xmlJTree);
	}

	public void expandAll(JTree tree) {
		int row = 0;
		while (row < tree.getRowCount()) {
			tree.expandRow(row);
			row++;
		}
	}

	public void xmlSetUp(File xmlFile) {
		try {
			SAXParserFactory fact = SAXParserFactory.newInstance();
			SAXParser parser = fact.newSAXParser();
			parser.parse(xmlFile, this);

		} catch (Exception e) {

		}
	}
	
	private void escribirArchivoXml(String[] textoAEscribirse,String nombreArchivo)
	{
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombreArchivo);
            pw = new PrintWriter(fichero);
            
            for (String aux: textoAEscribirse)
			{
				pw.println(aux);
			}

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}

	public void createUI() {

		treeModel = new DefaultTreeModel(base);
		xmlJTree = new JTree(treeModel);
		JScrollPane scrollPane = new JScrollPane(xmlJTree);

		JFrame windows = new JFrame();

		windows.setTitle("CAPTURADOR DE FACTURAS XML");

		JPanel pnl = new JPanel();
		pnl.setBackground(new Color(240, 230, 140));
		pnl.setLayout(null);
		JLabel lbl = new JLabel("Buscar Archivo :");
		txtFile = new JTextField("Nombre del archivo seleccionado");
		JButton btn = new JButton("Seleccionar Archivo");
		JButton btn1 = new JButton("Guardar Factura");
		JButton btn2 = new JButton("Cancelar");
		JButton btn3 = new JButton("Salir");
		//JButton btn4 = new JButton("Tipo de Gastos");
		//JButton btn5 = new JButton("Totales");

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				/*JFileChooser fileopen = new JFileChooser();
				FileFilter filter = new FileNameExtensionFilter("xml files", "xml");
				fileopen.addChoosableFileFilter(filter);

				int ret = fileopen.showDialog(null, "Abrir Archivo");

				if (ret == JFileChooser.APPROVE_OPTION) {
					File file = fileopen.getSelectedFile();
					txtFile.setText(file.getPath() + File.separator + file.getName());
					xmlSetUp(file);
				}*/
				//Creamos el objeto JFileChooser
				JFileChooser fc=new JFileChooser();

				//Indicamos lo que podemos seleccionar
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				//Creamos el filtro
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.XML", "xml");

				//Le indicamos el filtro
				fc.setFileFilter(filtro);

				//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
				int seleccion=fc.showOpenDialog(windows);

				//Si el usuario, pincha en aceptar
				if(seleccion==JFileChooser.APPROVE_OPTION)
				{
					//Seleccionamos el fichero
					File fichero=fc.getSelectedFile();
					//Ecribe la ruta del fichero seleccionado en el campo de texto
					//jtfPath.setText(fichero.getAbsolutePath());
					ProcesdorXML procesador=new ProcesdorXML(fichero.getAbsolutePath());
					String pathArchivo=fichero.getParent()+"\\";
					String nombreArchivo=fichero.getName();
					String nombreArchivoSinExtension=nombreArchivo.substring(0,nombreArchivo.indexOf('.'));
					escribirArchivoXml(procesador.getNodeContent("comprobante"), ".\\facturasFinales\\"+nombreArchivoSinExtension+"_comp.xml");
					File file = new File(pathArchivo+nombreArchivoSinExtension+"_comp.xml");
					txtFile.setText(file.getPath() + File.separator + file.getName());
					xmlSetUp(file);
					
				}
				
				//procesamiento archivo xml 
				

			}
		});
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(null, "Su Factura ha sido Guardada en la carpeta FACTURAS FINALES");
				System.out.close();
			}
			});
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					JOptionPane.showMessageDialog(null, "Favor Vuelva a escoger una factura");
					System.out.close();
				}
				});
			btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(null, "Esta seguro que desea salir del la aplicación ");
				System.exit(0);
				}
				});

			JButton btn4 = new JButton("Tipo de Gastos");
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DetalleFactura dett= new DetalleFactura();
					dett.setVisible(true);
					//XMLTreeViewer.this.dispose();
					}
			});
						
			JButton btn5 = new JButton("TOTALES");
			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DetalleTotales total= new DetalleTotales();
					total.setVisible(true);
					//XMLTreeViewer.this.dispose();
					}
			});
			
			
			lbl.setBounds(0, 0, 100, 30);
			txtFile.setBounds(110, 0, 250, 30);
			btn.setBounds(360, 0, 200, 30);
			btn1.setBounds(750, 200, 200, 30);
			btn2.setBounds(750, 300, 200, 30);
			btn3.setBounds(750, 400, 200, 30);
			btn4.setBounds(100, 600, 200, 30);
			btn5.setBounds(400, 600, 200, 30);
			scrollPane.setBounds(0, 50, 700, 500);

			pnl.add(lbl);

			pnl.add(txtFile);
			pnl.add(btn);
			pnl.add(btn1);
			pnl.add(btn2);
			pnl.add(btn3);
			pnl.add(btn4);
			pnl.add(btn5);
			pnl.add(scrollPane);

			windows.add(pnl);
			windows.setSize(1000, 700);
			windows.setVisible(true);
			windows.setDefaultCloseOperation( windows.EXIT_ON_CLOSE);
		}

	}
