



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
    
    public static String nombreClase;
    public static String tablaClase;
    public static String columnasClase;
    public static String tipocolumnasClase;
    
    public static ArrayList nombreArray = new ArrayList();
    public static ArrayList tablaArray = new ArrayList();
    public static ArrayList columnasArray = new ArrayList();
    public static ArrayList tipocolumnasArray = new ArrayList();
    

    
    public static void generarCodigo(Modelo m) throws IOException, SQLException 
      {
          //MetaData e2 = new MetaData();
          
        
          
            for (MetaData e1: m.getMetadata())
            {

                    VelocityContext contexto = new VelocityContext();
                    Velocity.init();//inicializa el motor velocity    
                    
                    nombreClase = e1.getNombre().substring(0, 1).toUpperCase() + e1.getNombre().substring(1);
                    tablaClase = e1.getTabla();
                    columnasClase = e1.getCampos();
                    tipocolumnasClase = e1.getTipo();
                   
                    String myfolder = "Salida1/";
                    Functions g = new Functions();

                    m.getNombre();
                    m.getTabla();
                    m.getCampo();
                    m.getTipo();
                    
                    File f = new File(myfolder + nombreClase);
                    f.mkdir();
                    
                    contexto.put("nombre", nombreClase);  //nombre al que responde velocity   
                    contexto.put("tabla", tablaClase);     
                    contexto.put("campo", columnasClase); 
                    contexto.put("type", tipocolumnasClase); 
                    contexto.put("Anombre", nombreArray); 
                    contexto.put("Atabla", tablaArray); 
                    contexto.put("Acolumnas", columnasArray); 
                    contexto.put("Atipocolumnas", tipocolumnasArray); 

//----------Lo que esta arriba no se modifica para la generacion de ninguna Capa-------------------------//

                    Template ModeloGeneratorData = null;//crea un template en java

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
                    
                    
                    nombreArray.add(nombreClase); 
                    tablaArray.add(tablaClase); 
                    columnasArray.add(columnasClase); 
                    tipocolumnasArray.add(tipocolumnasClase); 
                   
                    
             }
                  
                  System.out.println(nombreArray );   
                  System.out.println(tablaArray );   
                  System.out.println(columnasArray );   
                  System.out.println(tipocolumnasArray );   
    }
      
}