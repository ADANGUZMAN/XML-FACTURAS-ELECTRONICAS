package facturacion;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class control_articulos {
    
    
    Sentencias_sql sensql;
   
    public control_articulos() {
        
        sensql = new Sentencias_sql();
    }

    
    /**
     *
     * @param Date
     */
    
    public boolean ingresar_articulo(String id, String descripcion, double precioventa, int stock, String tipoart, String codprov, String fechaingreso)
    {               
        
            String datos[] = {id,descripcion,Double.toString(precioventa),Integer.toString(stock),tipoart,codprov,fechaingreso};           
            return sensql.insertar(datos, "insert into articulo(id_articulo, descripcion, precio_venta, stock, cod_tipo_articulo, cod_proveedor, fecha_ingreso) values(?,?,?,?,?,?,?)");
                                  
        
    }
    
    public Object[][] consulta_articulos(){
        String[] columnas={"id_articulo","descripcion","precio_venta","stock","descripcion_articulo","Nombre_comercial","fecha_ingreso"};
        Object[][] datos = sensql.GetTabla(columnas, "articulo", "select id_articulo,descripcion,articulo.precio_venta,stock,descripcion_articulo,Nombre_comercial,fecha_ingreso from articulo,proveedor,tipo_articulo where id_tipoarticulo=cod_tipo_articulo and No_documento=cod_proveedor;");
        return datos;
    }
    
    /*public Object [][] consulta_id_articulo()
    {
        String[] columna = "";
    }*/
    
}