/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Generator;

import Entities.Entidad;
import Entities.Modelo;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author daniela.beltran
 */
public class ModeloGenerator {

    
  public static void generarCodigo(Modelo m) {
        
        for (Entidad e1: m.getEntidades()) {
            
            try{
                // Pone la primera letra en mayuscula
                String nombreClase = e1.getNombre().substring(0, 1).toUpperCase() + e1.getNombre().substring(1);

                // Create file 
                FileWriter fstream = new FileWriter(nombreClase + ".java");
                BufferedWriter out = new BufferedWriter(fstream);
                out.write("package " + m.getNombre() + ".entities;\n");
                
                
                out.write("public class " + nombreClase + "{\n");
                out.write("    public " + nombreClase + "(){\n");
                out.write("    }\n");
                out.write("}\n");                   
                
                //Close the output stream
                out.close();
            }catch (Exception e){//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }
        }
       
    }
}


