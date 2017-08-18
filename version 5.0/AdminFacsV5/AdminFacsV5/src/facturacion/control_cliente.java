package facturacion;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class control_cliente extends Persona {
private Sentencias_sql sql; 


    public control_cliente(String documento, String tipo, String nombres, String apellidos, String direccion, String ciudad,String telefono, String contrasenia) {
        super(documento, tipo, nombres, apellidos, direccion, ciudad,telefono, contrasenia);
        sql = new Sentencias_sql();
    }   
    
        
   
    public boolean ingresar_cliente()
    {               
        
            String datos[] = {documento,tipo,nombres,apellidos,direccion,ciudad,telefono, contrasenia};           
            return sql.insertar(datos, "insert into cliente(Documento, cod_tipo_documento, Nombres, Apellidos, Direccion, cod_ciudad,Telefono, Contrasenia) values(?,?,?,?,?,?,?,?)");
                      
                
    }
    
    public Object[][] consulta_clientes(){
        String[] columnas={"Documento","Descripcion","Nombres","Apellidos","Direccion","Nombre_ciudad","Telefono", "Contrasenia"};
        Object[][] datos = sql.GetTabla(columnas, "cliente", "select Documento,Descripcion,Nombres,Apellidos,Direccion,Nombre_ciudad,Telefono, Contrasenia from cliente,ciudad,tipo_de_documento where id_tipo_documento=cod_tipo_documento and Codigo_ciudad=cod_ciudad;");
        return datos;
    }
    
    public boolean actualizar_cliente()
    {
        String datos[] = {nombres,apellidos,direccion,ciudad,telefono, contrasenia, documento};           
        return sql.actualizar(datos, "update cliente set Nombres=?, Apellidos=?, Direccion=?, cod_ciudad=?, Telefono=?, Contrasenia=? where documento=?");
    }
     
    
    
}