package facturacion;

import javax.swing.JOptionPane;

public class control_proveedor {
    
private String Nombre_comercial;
Sentencias_sql sql;
private String documento;
private String tipo;
private String nombres;
private String apellidos;
private String direccion;
private String ciudad;
private String telefono;



    public control_proveedor(String documento, String tipo, String nombres, String apellidos, String Nombre_comercial, String direccion, String ciudad,String telefono)
    {
        
        this.tipo = tipo;
        this.telefono = telefono;
        this.nombres = nombres;
        this.documento = documento;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.apellidos =apellidos;
        this.Nombre_comercial=Nombre_comercial;
        sql = new Sentencias_sql();
    }
    
    
    
    public boolean ingresar_proveedor()
    {               
       
            String datos[] = {documento,tipo,nombres,apellidos,Nombre_comercial,direccion,ciudad, telefono};           
            return sql.insertar(datos, "insert into proveedor(No_documento, cod_tipo_documento, Nombre, Apellido,Nombre_comercial,direccion, cod_ciudad, Telefono) values(?,?,?,?,?,?,?,?)");
                                  
        
        
    }
    public Object[][] consulta_proveedor(){
        String[] columnas={"No_documento","Descripcion","Nombre","Apellido","Nombre_comercial","Direccion","Nombre_ciudad","Telefono"};
        Object[][] datos = sql.GetTabla(columnas, "proveedor", "select No_documento,Descripcion,Nombre,Apellido,Nombre_comercial,Direccion,Nombre_ciudad,Telefono from proveedor,ciudad,tipo_de_documento where id_tipo_documento=cod_tipo_documento and Codigo_ciudad=cod_ciudad;");
        return datos;
    }
}
