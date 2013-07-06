
package Utilities;

import java.sql.*;

public class Conexion_BD 
{
    //Configura la conexión con el usuario y contraseña de la base de datos academico
    
    private String url = "jdbc:mysql://localhost:3306/academico?characterEncoding=latin1";
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "root";
    private String password = "root";
    
    public static Connection connection;
    private ResultSet rs;
    private Statement statement;
    private String error;
    
    public Conexion_BD()
    {
        
        this.rs = null;
        this.error = null;
        
        try
        {
            // Carga el driver 
            Class.forName(this.driver);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Error al cargar el driver de la base de datos");
        }
    }
    
    /**
     * Cre una conexion a la base de datos
     * @return Conexion a la base de datos
     */
    public Connection makeConnection()
    {
        
        try
        {
            // Abre la conexion a la base de datos academico
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
        }
        catch(SQLException e)
        {
            return null;
        }
        
        return this.connection;
    }

    /**
     * Cierra la conexion a la base de datos
     * @return true si pudo cerra la conexion y false si no pudo
     */
    public boolean closeConnection()
    {
        
        try
        {
            // Cierra la conexion a la base de datos
            this.connection.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        
        return true;
    }
}