/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundovelocity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 *
 * @author daniela.beltran
 */
public class Prueba {
    
    public static void main(String[] args) 
    {
        VelocityContext contexto = new VelocityContext();
        
        
        contexto.put("foo", "funciono ....... :)");
        
         Velocity.init();//inicializa el motor velocity
        
        Template plantilla = null;
        try 
        {
            plantilla=Velocity.getTemplate("plantillas/Prueba.vsl");
        } 
        catch (Exception e) 
        {
            System.out.println("no sirvio...");
        }
        
        
        if(plantilla != null)
        {
            try 
            {
                BufferedWriter escritor = new BufferedWriter(new FileWriter("hola.html"));
                
                plantilla.merge(contexto, escritor);
                
                escritor.flush();
                escritor.close();
                
                
            } catch (IOException ex) {
                
            }
                
            
            
            
            
            
        }
        else
            System.out.println("no cargo la plantilla");
        
    }
    
}
