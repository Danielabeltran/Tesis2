



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Generator;

import MetaData.MetaData;
import MetaData.Modelo;
import Utilities.Functions;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 *
 * @author jeysonvargasmartinez
 */
public class ModeloGeneratorData {
    
      public static void generarCodigo(Modelo m) throws IOException, SQLException 
      {

            for (MetaData e1: m.getMetadata())
            {

                    VelocityContext contexto = new VelocityContext();
                    Velocity.init();//inicializa el motor velocity    
                    
                    String nombreClase = e1.getNombre().substring(0, 1).toUpperCase() + e1.getNombre().substring(1);
                    String tablaClase = e1.getTabla();
                    String columnasClase = e1.getCampos();
                    String tipocolumnasClase = e1.getTipo();
                   
                    String myfolder = "Salida1/";
                    Functions g = new Functions();

                    m.getNombre();
                    m.getTabla();
                    m.getCampos();
                    m.getTipo();
                    
                    File f = new File(myfolder + nombreClase);
                    f.mkdir();
                    
                    contexto.put("nombre", nombreClase);     
                    contexto.put("tabla", tablaClase);     
                    contexto.put("campo", columnasClase); 
                    contexto.put("type", tipocolumnasClase); 
//----------Lo que esta arriba no se modifica para la generacion de ninguna Capa-------------------------//

                    Template ModeloGeneratorData = null;

                    try 
                    {
                         ModeloGeneratorData=Velocity.getTemplate("TemplatesMVC/TemplatesMVC/TData.vsl");
                          
                    }
                    catch (Exception e) 
                    {
                        System.out.println("Error creating template");
                    }
        
                   
                    if(ModeloGeneratorData != null)
                    {
                        try 
                        {
                             BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + nombreClase + "/USBBOG.EDU.Data/" + tablaClase +  "DAO.java"));
                
                            ModeloGeneratorData.merge(contexto, escritor);
                
                            escritor.flush();
                            escritor.close();
                        }
                        catch (IOException ex) 
                            {
                                System.out.println("Plantillas Data no creadas");
                            }
                    }
                    
                              
                   //System.out.println(nombreArray );
                   //System.out.println(typeArray);
                   //System.out.println(typeCampoArray);
                   

                    
             }
                   
                    
    }
      
}