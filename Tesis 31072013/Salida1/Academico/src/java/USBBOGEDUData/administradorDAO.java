
package USBBOGEDUData;

import USBBOGEDUEntities.administrador;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Universidad de Sanbuenaventura sede Bogota
 */

public class administrador\DAO {

public List<administrador> getAll(){

        // Crea la conexion a la base de datos
        ConexionDB database = new ConexionDB();
        database.makeConnection();
        
        // Crea el objeto resultado
        List<administrador> lista = new ArrayList<administrador>();

        try{
            
        // Ejecuta la sentencia en la BD
            ResultSet resultado = database.query("select * from administrador");
            
        // Recorre el resultado para transformar a entidades
        while (resultado.next()) {
        
        // Obtiene los datos del registro actual
                
        int id= resultado.getInt("id");
        String nombre= resultado.getString("nombre");
        String usuario= resultado.getString("usuario");
            // crea una entidad estudiante
        administrador a = new administrador(); 
    
        a.set_Id(id);
        a.set_Nombre(nombre);
        a.set_Usuario(usuario);
            // Agrega la entidad a la lista
        lista.add(a);
            }
            
        }catch(Exception e){
        }
        
        return lista;
    }

}