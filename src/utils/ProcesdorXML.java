package utils;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProcesdorXML {
	private String pathArchivo;

	public ProcesdorXML(String rutaArchivoXML) {
		this.pathArchivo=rutaArchivoXML;
	}

	public String[] getNodeContent(String node)
	{
		String[] arrContentList=new String[9];
		String contentList="";
		if (this.pathArchivo.trim().length()==0)
		{
			JOptionPane.showMessageDialog(null, "ERROR","NO se ha inicializado la ruta del archivo",JOptionPane.ERROR_MESSAGE);
		}
		else
		{

			//.----------------------
			try {

				File fXmlFile = new File(this.pathArchivo);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();

				NodeList nList = doc.getElementsByTagName(node);

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);

					//System.out.println("\nCurrent Element :" + nNode.getTextContent());
					//contentList.add(nNode.getTextContent());
					contentList+=nNode.getTextContent();
					String arrContenido[]=contentList.split("\n");
					if(arrContenido.length>0)
					{
						ArrayList<String>auxList=new ArrayList<String>();
						for(int i=0; i<arrContenido.length;i++)
						{
							if(arrContenido[i].length()>1)
								auxList.add(arrContenido[i]);
						}
						
						arrContentList = new String[auxList.size()];
						arrContentList = auxList.toArray(arrContentList);	
					}

				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}

			
		}
		return arrContentList;
		
	}

}
