
package Builder;

import Entities.Entidad;
import Entities.Modelo;
import Entities.Campo;
import java.beans.Statement;
import java.sql.*;

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
    public ModeloBuilder()
    {
        this.rs = null;
        this.error = null;
        
        try
        {
           Class.forName(this.driver); // Carga el driver
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Error al cargar el driver de la base de datos"); //Muestra un error de carga del driver
        }
    }
    
    public Connection makeConnection()
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
   
    public static Modelo cargarModelo()
    {
        Modelo m = new Modelo();
        m.setNombre("Academico");
        try 
        {
            
	    Class.forName(driver);
	    ModeloBuilder.connection = DriverManager.getConnection(url, user, password); //Realiza la conexión a la Base de Datos con la URL, usuario y password anteriormente registrados
            ModeloBuilder database = new ModeloBuilder();
            database.makeConnection();
       
            DatabaseMetaData metadata = connection.getMetaData(); 
            ResultSet resultSet2 = metadata.getColumns(connection.getCatalog(), null, null, null);
            Entidad e = new Entidad();
            String table_name ="";
            while (resultSet2.next()) 
            {
               table_name = resultSet2.getString("TABLE_NAME");
            
            String[] tablas = {table_name};
            
            for (String tabla : tablas) 
            {
                
                
                m.getEntidades().add(e);
                System.out.println(tabla);
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
