
package USBBOGEDUData;

import USBBOGEDUEntities.universidad;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Universidad de Sanbuenaventura sede Bogota
 */

public class universidad\DAO {

public List<universidad> getAll(){

        // Crea la conexion a la base de datos
        ConexionDB database = new ConexionDB();
        database.makeConnection();
        
        // Crea el objeto resultado
        List<universidad> lista = new ArrayList<universidad>();

        try{
            
        // Ejecuta la sentencia en la BD
            ResultSet resultado = database.query("select * from universidad");
            
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
        String horario= resultado.getString("horario");
        int id= resultado.getInt("id");
        int id_Universidad= resultado.getInt("id_Universidad");
        int codigo= resultado.getInt("codigo");
        String nombre= resultado.getString("nombre");
        String usuario= resultado.getString("usuario");
        String clave= resultado.getString("clave");
        String email= resultado.getString("email");
        int id_Estudiante= resultado.getInt("id_Estudiante");
        int id_Curso= resultado.getInt("id_Curso");
        double corte1= resultado.getDouble("corte1");
        double corte2= resultado.getDouble("corte2");
        double corte3= resultado.getDouble("corte3");
        int id= resultado.getInt("id");
        String nombre= resultado.getString("nombre");
        String usuario= resultado.getString("usuario");
        String clave= resultado.getString("clave");
        String email= resultado.getString("email");
        int id= resultado.getInt("id");
            // crea una entidad estudiante
        universidad a = new universidad(); 
    
        a.set_Id(id);
        a.set_Nombre(nombre);
        a.set_Usuario(usuario);
        a.set_Clave(clave);
        a.set_Id(id);
        a.set_Id_Profesor(id_Profesor);
        a.set_Id_Universidad(id_Universidad);
        a.set_Asignatura(asignatura);
        a.set_Grupo(grupo);
        a.set_Horario(horario);
        a.set_Id(id);
        a.set_Id_Universidad(id_Universidad);
        a.set_Codigo(codigo);
        a.set_Nombre(nombre);
        a.set_Usuario(usuario);
        a.set_Clave(clave);
        a.set_Email(email);
        a.set_Id_Estudiante(id_Estudiante);
        a.set_Id_Curso(id_Curso);
        a.set_Corte1(corte1);
        a.set_Corte2(corte2);
        a.set_Corte3(corte3);
        a.set_Id(id);
        a.set_Nombre(nombre);
        a.set_Usuario(usuario);
        a.set_Clave(clave);
        a.set_Email(email);
        a.set_Id(id);
            // Agrega la entidad a la lista
        lista.add(a);
            }
            
        }catch(Exception e){
        }
        
        return lista;
    }

}