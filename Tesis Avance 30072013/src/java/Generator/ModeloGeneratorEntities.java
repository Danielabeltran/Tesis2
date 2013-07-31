/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Generator;

import Entities.Entidad;
import Entities.Modelo;
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

public class ModeloGeneratorEntities 
{
      public static void generarCodigo(Modelo m) throws IOException, SQLException 
      {
           ArrayList nombreArray = new ArrayList();
           ArrayList tablaArray = new ArrayList();
                          
            for (Entidad e1: m.getEntidades())
            {

                    VelocityContext contexto = new VelocityContext();
                    Velocity.init();//inicializa el motor velocity         
                    String nombreClase = e1.getNombre().substring(0, 1).toUpperCase() + e1.getNombre().substring(1);
                    String tablaClase = e1.getTabla();
                    String columnasClase = e1.getCampos();
                    String tipocolumnasClase = e1.getTipo();
                   
                    String NameDB;
                    String Tabla;
                    String Campo;
                    String Type;
                    
                    String myfolder = "Salida1/";
                    Functions g = new Functions();
                    
                    NameDB = nombreClase;
                    Tabla = tablaClase;
                    Campo = columnasClase;
                    Type =  tipocolumnasClase;
                    
                    String Tcampo = Campo ;
                    nombreArray.add(Tcampo);
                    
                    String Ttabla = Tabla;
                    tablaArray.add(Ttabla);
                    
                    contexto.put("Tcampo", nombreArray);     
                    
                    m.getNombre();
                    m.getTabla();
                    m.getCampos();
                    m.getTipo();
                    
                    contexto.put("NameDB", NameDB);
                    contexto.put("Tabla", Tabla);
                    contexto.put("Campo", Campo);
                    contexto.put("Type", Type);
                    
                    File f = new File(myfolder + NameDB);
                    f.mkdir();
        
                    Template ModeloGeneratorEntitites = null;

                    try 
                    {
                         ModeloGeneratorEntitites=Velocity.getTemplate("TemplatesMVC/TEntities.vsl");
                    }
                    catch (Exception e) 
                    {
                        System.out.println("Error creating template");
                    }
        
                   
                    if(ModeloGeneratorEntitites != null)
                    {
                        try 
                        {
                             BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + NameDB + "/src/java/usbbogentities/" + Tabla +  ".java"));
                
                            ModeloGeneratorEntitites.merge(contexto, escritor);
                
                            escritor.flush();
                            escritor.close();
                        }
                        catch (IOException ex) 
                            {
                                System.out.println("Plantillas entities no creadas");
                            }
                    }
                    
                              
                    System.out.println(nombreArray );
                    System.out.println(tablaArray );
                    
             }
                   
                    
    }
      
}