package facturacion;

import facturacion.Interfaz_Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ValidarLogin {



/**
 * @wbp.parser.entryPoint
 */
public int validar_ingreso(String user, String pass){

    String usuario = user;
    String clave = pass;

    int resultado=0;
    
    String SSQL="SELECT * FROM cliente WHERE documento='"+usuario+"' AND contrasenia='"+clave+"';";
    System.out.println(SSQL);
    Connection conect = null;
    

    try {
    	conect=DriverManager.getConnection("jdbc:mysql://localhost/facturacioninterfaces","root","");
        if (conect!=null){
           System.out.println("Conexión para login completa");
        }
        Statement st = conect.createStatement();
        ResultSet rs = st.executeQuery(SSQL);

        if(rs.next()){

            resultado=1;

        }

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, ex, "Error de conexion", JOptionPane.ERROR_MESSAGE);

    }finally{


        try {

            conect.close();
            System.out.println("conexion de login cerrada");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

        }

    }
return resultado;

}

}