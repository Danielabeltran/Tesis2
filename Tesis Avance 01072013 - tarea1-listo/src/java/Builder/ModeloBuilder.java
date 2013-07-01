
package Builder;

import Entities.Entidad;
import Entities.Modelo;
import java.beans.Statement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class ModeloBuilder 
{
    
    private static final String url = "jdbc:mysql://localhost:3306/academico?characterEncoding=latin1"; //Conexión por URL y localhost de la base de datos
    private static final String driver = "com.mysql.jdbc.Driver"; //Conexión por Driver
    private static final String user = "root"; //Usuario de la Base de Datos MYSQL
    private static final String password = "root"; //Clave de la Base de Datos MYSQL
    public static Connection connection;
    private ResultSet rs; //Para almacenar el resultado de la consulta
    private Statement statement; //Para ejecutar sentencias SQL y enviarlas a las Bases de Datos MYSQL
    private String error;
    
    
    
    public ModeloBuilder()// Carga el driver
    {
        this.rs = null;
        this.error = null;
        
        try
        {
           Class.forName(this.driver); 
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Error al cargar el driver de la base de datos"); //Muestra un error de carga del driver
        }
    }
    
    public Connection makeConnection() // Crea la conexion
    {
        try
        {
           this.connection = DriverManager.getConnection(this.url, this.user, this.password);
        }
        catch(SQLException e)
        {
            return null;
        }
        return this.connection;
    }
   
    public static Modelo cargarModelo() throws IOException
    {
      
        Modelo m = new Modelo();
        try 
        {
                VelocityContext contexto = new VelocityContext();
                Velocity.init();//inicializa el motor velocity
                Template plantilla = null;
        
                try 
                {
                    plantilla=Velocity.getTemplate("plantillas/builder.vsl");
                } 
                catch (Exception e) 
                {
                    System.out.println("shit");
                }
        
                if(plantilla != null)
                {
                    
                    Class.forName(driver);

                    ModeloBuilder.connection = DriverManager.getConnection(url, user, password); //Realiza la conexión a la Base de Datos con la URL, usuario y password anteriormente registrados
                    ModeloBuilder database = new ModeloBuilder();
                    database.makeConnection();
                    
                    DatabaseMetaData metadata = connection.getMetaData(); //Método general de java para extraer metadata de la base de datos
                    ResultSet resultSet2 = metadata.getColumns(null, null, null, null);//Método para obtener las columnas de los metadatos obtenidos
                
                    String nameBD = "";
                    String vtablas ="";
                    String vtipo ="";
                    String vcampos ="";
                    String vcolumnsize ="";
                    String vautoincre = "";
                    String vpktable_name = "";
                    String vpk_column_name = "";
                    String vfk_table_name = "";
                    String vfk_column_name = "";
                
                    while (resultSet2.next()) 
                        {
                            
                            Entidad e = new Entidad();
                            nameBD = resultSet2.getString("TABLE_CAT");// retorna el nombre de la BD
                            vtablas = resultSet2.getString("TABLE_NAME");//retorna el nombre de todas las tablas de la BD
                            vcampos = resultSet2.getString("COLUMN_NAME");// retorna los campos de todas las tablas de la BD
                            vtipo = resultSet2.getString("TYPE_NAME");// retorna el tipo de datos de los campos
                            vcolumnsize = resultSet2.getString("COLUMN_SIZE");  //retorna el tamaño de la columna
                            vautoincre = resultSet2.getString("IS_AUTOINCREMENT"); //retorna si es autoincremento
                            
                            String[] nombreBD = {nameBD};
                            String[] tablas = {vtablas};
                            String[] campos = {vcampos};
                            String[] tipo = {vtipo};
                            String[] columnsize = {vcolumnsize};
                            String[] autoincre = {vautoincre};
                            
                            contexto.put("nombreBD", nombreBD); //Agrega la variable nombreBD a velocity
                            contexto.put("tablas", tablas); //Agrega la variable tablas a velocity
                            contexto.put("campos", campos); //Agrega la variable campos a velocity
                            contexto.put("tipo", tipo); //Agrega la variable tipo a velocity
                            contexto.put("columnsize", columnsize); //Agrega la variable columnsize a velocity
                            contexto.put("autoincre", autoincre); //Agrega la variable autoincre a velocity
                          
                            for (String nombrebase : nombreBD)
                            {
                                
                                e.setNombre(nombrebase);
                                
                                m.getEntidades().add(e);
                                
                            }
                            for (String tabla : tablas)
                            {
                                e.setTabla(tabla);
                                
                                m.getEntidades().add(e);
                            }
                            for (String campo : campos)
                            {
                                e.setCampos(campo);
                                
                                m.getEntidades().add(e);
                            }
                            for (String tipod : tipo)
                            {
                                e.setTipo(tipod);
                                
                                m.getEntidades().add(e);
                            }
                            for (String columnsiz : columnsize)
                            {
                                e.setColumnsz(columnsiz);
                               
                                m.getEntidades().add(e);
                            }
                            for (String autoincrement : autoincre)
                            {
                                e.setIsautoincre(autoincrement);
                                
                                m.getEntidades().add(e);
                            }
                            
                             ResultSet resultSet3 = metadata.getPrimaryKeys(null, null, vtablas);
                 
                             while (resultSet3.next()) 
                                {
                                    vpktable_name = resultSet3.getString("TABLE_NAME"); 
                                    vpk_column_name = resultSet3.getString("COLUMN_NAME"); 
                                    
                                    String[] VpkTableName = {vpktable_name};
                                    String[] VpkColumnName = {vpk_column_name};
                                    
                                    for (String pkTable_Name : VpkTableName)
                                    {
                                        e.setPktablename(pkTable_Name);
                                        m.setPktablename(pkTable_Name);
                                        m.getEntidades().add(e);
                                    }
                                    for (String pkColumn_Name : VpkColumnName)
                                    {
                                        e.setPkcolumnname(pkColumn_Name);
                                        m.setPkcolumnname(pkColumn_Name);
                                        m.getEntidades().add(e);
                                    }
                                   }
                             
                         
                            ResultSet resultSet = metadata.getImportedKeys(null, null, vtablas);
                            while (resultSet.next()) 
                            {
                                vfk_table_name = resultSet.getString("FKTABLE_NAME");  //retorna la tabla que se tiene con llave foranea
                                vfk_column_name = resultSet.getString("FKCOLUMN_NAME");  //retorna la columna que se tiene con llave foranea
                                
                                String[] fkTableName = {vfk_table_name};
                                String[] fkColumnName = {vfk_column_name};
                                
                                contexto.put("fkTableName", fkTableName); //Agrega la variable fkTableName a velocity
                                contexto.put("fkColumnName", fkColumnName); //Agrega la variable fkColumnName a velocity
                          
                                
                                
                                
                                for (String fkTable_Name : fkTableName)
                                {
                                e.setFktablename(fkTable_Name);
                                m.setFktablename(fkTable_Name);
                                m.getEntidades().add(e);
                                }
                                for (String fkColumn_Name : fkColumnName)
                                {
                                e.setFkcolumnname(fkColumn_Name);
                                m.setFkcolumnname(fkColumn_Name);
                                m.getEntidades().add(e);
                                }
                            }
                        }
                }  
        }
        catch(Exception e)
        {  
        }
        return m;
    }

    public boolean closeConnection()
    {        
        try
        {
           this.connection.close();
        }
            catch(SQLException e)
            {
                return false;
            }
            return true;
    }
       
}
