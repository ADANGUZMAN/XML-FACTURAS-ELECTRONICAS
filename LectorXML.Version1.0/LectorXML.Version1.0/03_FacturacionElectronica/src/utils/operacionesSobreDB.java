package utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class operacionesSobreDB {
	//inicio metodo llenar array list
	public void llenarArrayLis(ArrayList<String> lstGeneric, String strSqlQuery, int intNUmeroColumna)
	{
		//ArrayList<String> al=new ArrayList<String>();
		Connection cnxGeneric;
		cnxGeneric=conexionDB.getConexion();
		try 
		{
			Statement us=cnxGeneric.createStatement();
			ResultSet res=us.executeQuery(strSqlQuery);
			while(res.next())
			{
				//al.add(res.getString(1));
				lstGeneric.add(res.getString(intNUmeroColumna));
			}
			res.close();
			cnxGeneric.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		/*for(String aux:al)
		{
			System.out.println(aux);
		}*/
	}
	//fin metodo llenar array list 
	//----------------------------------------------
	//inici metodo obtener id
	public String obtenerID(String strTableName, String strColumnToExtract,String strCoulumnData, String strDato)
	{
		Connection cnxGeneric;
		cnxGeneric=conexionDB.getConexion();
		String strId="";
		String strSql="select "+strColumnToExtract+" from "+strTableName+" where "+strCoulumnData+"='"+strDato+"';";
		//System.out.println(strSql);
		try 
		{
			Statement us=cnxGeneric.createStatement();
			ResultSet res=us.executeQuery(strSql);
			
			while(res.next())
			{
				strId=res.getString(1);
			}
			res.close();
			cnxGeneric.close();
			
		}catch(SQLException e)
		{
			//Logger.getLogger(jtbGeneric.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		//System.out.println(strId);
		return strId;
	}
	//fin metodo obtener id
	//----------------------------------------------------------------------------------------------
	//inicio metodo obtener columnas
	public String[] obtnerColumNames(String strTblName)
	{
		Connection cnxGeneric;
		cnxGeneric=conexionDB.getConexion();
		String nombreCol="",strArrCols[];
		try 
		{
			DatabaseMetaData metaDatos=cnxGeneric.getMetaData();
			ResultSet rs = metaDatos.getColumns("facturas_xml", null, strTblName, null);
			
			while(rs.next())
			{
				nombreCol+=rs.getString(4)+",";
			}
			
			rs.close();
			cnxGeneric.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		strArrCols=nombreCol.split(",");
		return strArrCols;
		
	}
	//fin del metodo obtener columnas
	//-------------------------------------------------------------------------------------------------
	//inicio del metodo para llenar combos
	public void llenarCombo(JComboBox<String> jcbGeneric, String strSqlQuery)
	{
		//ArrayList<String> al=new ArrayList<String>();
		Connection cnxGeneric;
		cnxGeneric=conexionDB.getConexion();
		try 
		{
			Statement us=cnxGeneric.createStatement();
			ResultSet res=us.executeQuery(strSqlQuery);
			while(res.next())
			{
				//al.add(res.getString(1));
				jcbGeneric.addItem(res.getString(1));
			}
			res.close();
			cnxGeneric.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		/*for(String aux:al)
		{
			System.out.println(aux);
		}*/
	}
	
	//fin del metodo para llenar combos
	//-------------------------------------------------------------------------------------------------
	//inicio metodo de llenado de tablas
	public void llenarJtable(JTable jtbGeneric, DefaultTableModel dmtGeneric, String strSql)
	{
		Connection cnxGeneric;
		cnxGeneric=conexionDB.getConexion();
		try 
		{
			Statement us=cnxGeneric.createStatement();
			ResultSet res=us.executeQuery(strSql);
			Object objDatosGeneric[]=new Object[jtbGeneric.getColumnCount()];
			while(res.next())
			{
				for(int i=0;i<jtbGeneric.getColumnCount();i++)
				{
					objDatosGeneric[i]=res.getObject(i+1);
				}
				dmtGeneric.addRow(objDatosGeneric);
			}
			res.close();
			cnxGeneric.close();
		}catch(SQLException e)
		{
			//Logger.getLogger(jtbGeneric.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
	}
	
	//fin metodo de llenado de tablas
	//------------------------------------------------------------------------------
	//inicio metodo de insert
	public boolean insertarDatosDB(String strTblName,String strArrColsNames[], String strArrValues[])
	{
		boolean estado=false;
		//inicio creacion de la cadena para values
		String strValues="'";
		for(int i=0; i<strArrValues.length;i++)
		{
			if(i<strArrValues.length-1)
			{
				strValues=strValues+strArrValues[i]+"','";
			}
			else
			{
				strValues=strValues+strArrValues[i]+"'";
			}
		}
		//fin de la creacion de la cadena de values
		//--------------------------------------------
		//inicio creacion de la cadena para contenido
		String strColsNames="";
		for(int i=1; i<strArrColsNames.length;i++)
		{
			if(i<strArrColsNames.length-1)
			{
			strColsNames=strColsNames+strArrColsNames[i]+",";
			}
			else
			{
				strColsNames=strColsNames+strArrColsNames[i];
			}
		}
		
		//fin de la  creacion para cadena contenido
		//-------------------------------------------
		String sqlIns="INSERT INTO "+strTblName+"("+strColsNames+") VALUES ("+strValues+");";
		Connection cnxGeneric;
		cnxGeneric=conexionDB.getConexion();
		@SuppressWarnings("unused")
		int intFilasAfectadas=0;
		try
		{
			Statement us=cnxGeneric.createStatement();
			//System.out.println(sqlIns);
			intFilasAfectadas=us.executeUpdate(sqlIns);
			us.close();
			cnxGeneric.close();
			estado=true;
		}
		catch(SQLException e)
		{
			//Logger.getLogger(jtbGeneric.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		return estado;
	}
	//fin de metodo de insert
	//----------------------------------------------------------------------------------------------
	//inicio metodo update
	public boolean  actualizarDatosDB(String strTblName, String strArrColsNames[],String strValACambiar[] ,String strIdentif)
	{
		boolean estado=false;
		//inicio string para set
		String strSet="";
		for(int i=0; i<strValACambiar.length; i++)
		{
			if(i<strValACambiar.length-1)
			{
			strSet=strSet+strArrColsNames[i+1]+"='"+strValACambiar[i]+"',";
			}
			else
			{
				strSet=strSet+strArrColsNames[i+1]+"='"+strValACambiar[i]+"'";
			}
		}
		//fin string para set 
		Connection cnxGeneric;
		cnxGeneric=conexionDB.getConexion();
		String strUpdate="UPDATE "+strTblName+" SET "+strSet+" WHERE "+strArrColsNames[0]+"='"+strIdentif+"';";
		//System.out.println(strUpdate);
		@SuppressWarnings("unused")
		int intFilasAfectadas=0;
		try
		{
			Statement us=cnxGeneric.createStatement();
			//System.out.println(sqlIns);
			intFilasAfectadas=us.executeUpdate(strUpdate);
			us.close();
			cnxGeneric.close();
			estado=true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return estado;
	}
	
	//fin del metodo update
	//--------------------------------------------------------------------------------
	//inico el metodo delete
	public boolean elimarDatosTabla(String tableName, String campo, String identificador)
	{
		boolean estado=false;
		Connection cnxGeneric;
		cnxGeneric=conexionDB.getConexion();
		
		String strDelete="DELETE FROM "+tableName+ " WHERE "+ campo+"= '"+identificador+"';";
		@SuppressWarnings("unused")
		int intFilasAfectadas=0;
		try
		{
			Statement us=cnxGeneric.createStatement();
			//System.out.println(sqlIns);
			intFilasAfectadas=us.executeUpdate(strDelete);
			us.close();
			cnxGeneric.close();
			estado=true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return estado;
		
	}
	//fi del metodo delete 
}

