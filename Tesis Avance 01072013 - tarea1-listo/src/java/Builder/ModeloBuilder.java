
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
                    
                   DatabaseMetaData meta = connection.getMetaData();
                    ResultSet res = meta.getTables(null, null, null, 
                        new String[] {"TABLE"});
                    System.out.println("List of tables: "); 
                    while (res.next()) {
                        System.out.println(
                            "   "+res.getString("TABLE_CAT") 
                       ); 
                    }
                    res.close();  

                
                            
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
