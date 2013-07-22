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

public class ModeloGeneratorEntities 
{
      public static void generarCodigo(Modelo m) throws IOException, SQLException 
      {
           ArrayList nombreArray = new ArrayList();
           ArrayList typeArray = new ArrayList();
           ArrayList typeCampoArray = new ArrayList();
           ArrayList ArrEjem = new ArrayList();
           ArrayList ArrConc2 = new ArrayList();
                          
            for (MetaData e1: m.getMetadata())
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
                    String Type2;
                    String R;
                    String R2;
                    String Change = "";
                    String concatenar;

                    
                    String myfolder = "Salida1/";
                    Functions g = new Functions();
                    
                    NameDB = nombreClase;
                    Tabla = tablaClase;
                    Campo = columnasClase;
                    Type =  tipocolumnasClase;
                    Type2 =  tipocolumnasClase;

                    contexto.put("Type", Type);
                    contexto.put("Type2", Type2);
                    
                    if("int".equals(tipocolumnasClase)){
                         Change = "0";
                    }
                        else 
                        if("String".equals(tipocolumnasClase)){
                        Change = "\"\"";
                        }

                    Type  = Type.concat(" ");
                    R2 = g.NL() + "this." + columnasClase + "=" + Change ; 
                    R = columnasClase + "(" + tipocolumnasClase + " " + columnasClase + ")" + "{" + g.NL() + g.TB() + "this." + columnasClase + " = " + columnasClase + ";" + g.NL() + "}" + g.NL() + g.NL() + "public " + tipocolumnasClase + " get_" + columnasClase + "(){" + g.NL() + g.TB() + "return " + columnasClase + ";" + g.NL() + "}";
                   
                    concatenar = Type.concat(columnasClase);
                    
                    
                    String Tcampo = Campo ;
                    nombreArray.add(Tcampo);
                    
                    String Ttype = Type;
                    typeArray.add(Ttype);
                    
                    typeCampoArray.add(concatenar);
                    ArrEjem.add(R);
                    ArrConc2.add(R2);
                    
                    contexto.put("Tcampo", nombreArray);     
                    contexto.put("Ttype", typeArray); 
                    contexto.put("Ttypecampo", typeCampoArray); 
                    contexto.put("Concatenado1", ArrEjem); 
                    contexto.put("Concatenado2", ArrConc2); 
                    
                    m.getNombre();
                    m.getTabla();
                    m.getCampos();
                    m.getTipo();
                    
                    
                    
                    contexto.put("NameDB", NameDB);
                    contexto.put("Tabla", Tabla);
                    contexto.put("Campo", Campo);
                    
                    
                    File f = new File(myfolder + NameDB);
                    f.mkdir();
        
                    Template ModeloGeneratorEntitites = null;

                    try 
                    {
                         ModeloGeneratorEntitites=Velocity.getTemplate("TemplatesMVC/TemplatesMVC/TEntities.vsl");
                          
                    }
                    catch (Exception e) 
                    {
                        System.out.println("Error creating template");
                    }
        
                   
                    if(ModeloGeneratorEntitites != null)
                    {
                        try 
                        {
                             BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + NameDB + "/USBBOG.EDU.Entities/" + Tabla +  ".java"));
                
                            ModeloGeneratorEntitites.merge(contexto, escritor);
                
                            escritor.flush();
                            escritor.close();
                        }
                        catch (IOException ex) 
                            {
                                System.out.println("Plantillas entities no creadas");
                            }
                    }
                    
                              
                   //System.out.println(nombreArray );
                   //System.out.println(typeArray);
                   //System.out.println(typeCampoArray);
                   System.out.println(tipocolumnasClase);
                   

                    
             }
                   
                    
    }
      
}