
package USBBOGEDUData;

import USBBOGEDUEntities.curso;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Universidad de Sanbuenaventura sede Bogota
 */

public class curso\DAO {

public List<curso> getAll(){

        // Crea la conexion a la base de datos
        ConexionDB database = new ConexionDB();
        database.makeConnection();
        
        // Crea el objeto resultado
        List<curso> lista = new ArrayList<curso>();

        try{
            
        // Ejecuta la sentencia en la BD
            ResultSet resultado = database.query("select * from curso");
            
        // Recorre el resultado para transformar a entidades
        while (resultado.next()) {
        
        // Obtiene los datos del registro actual
                
        int id= resultado.getInt("id");
        String nombre= resultado.getString("nombre");
        String usuario= resultado.getString("usuario");
        String clave= resultado.getString("clave");
        int id= resultado.getInt("id");
        int id_Profesor= resultado.getInt("id_Profesor");
        int id_Universidad= resultado.getInt("id_Universidad");
        String asignatura= resultado.getString("asignatura");
        String grupo= resultado.getString("grupo");
            // crea una entidad estudiante
        curso a = new curso(); 
    
        a.set_Id(id);
        a.set_Nombre(nombre);
        a.set_Usuario(usuario);
        a.set_Clave(clave);
        a.set_Id(id);
        a.set_Id_Profesor(id_Profesor);
        a.set_Id_Universidad(id_Universidad);
        a.set_Asignatura(asignatura);
        a.set_Grupo(grupo);
            // Agrega la entidad a la lista
        lista.add(a);
            }
            
        }catch(Exception e){
        }
        
        return lista;
    }

}