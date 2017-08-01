package utils;
import java.sql.*;

import javax.swing.JOptionPane;
public class conexionDB 
{
	
	private static String _usuario="root";
	private static String _pwd= "";
	private static String _bd="facturas_xml";
	static String _url = "jdbc:mysql://localhost/"+_bd;
	private static Connection conexionGenerica = null;
	
	public static Connection getConexion()
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conexionGenerica= DriverManager.getConnection(_url,_usuario,_pwd);
		}
		catch(ClassNotFoundException ex)
		{
			JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
			conexionGenerica=null;
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
			conexionGenerica=null;
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
			conexionGenerica=null;
		}
		return conexionGenerica;
	}
	
	public static void cerrarConexion(Connection con)
	{
		try
		{
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}

}
