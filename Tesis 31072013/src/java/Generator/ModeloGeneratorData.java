



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
    
//se declaran Variables Globales 
    public static String nombreClase;
    public static String tablaClase;
    public static String columnasClase;
    public static String tipocolumnasClase;
    public static String tipocolumnasClaseMay;
    public static String columnasClaseMay;
    public static String concTypeCampo;
    
    public static ArrayList nombreArray = new ArrayList();
    public static ArrayList tablaArray = new ArrayList();
    public static ArrayList columnasArray = new ArrayList();
    public static ArrayList tipocolumnasArray = new ArrayList();

     
    public static void generarCodigo(Modelo m) throws IOException, SQLException 
      {
            ArrayList ArrConc1 = new ArrayList();
            ArrayList ArrConc2 = new ArrayList();
            for (MetaData e1: m.getMetadata())
            {

                    VelocityContext contexto = new VelocityContext();
                    Velocity.init();//inicializa el motor velocity    
                    
                    nombreClase = e1.getNombre().substring(0, 1).toUpperCase() + e1.getNombre().substring(1);
                    tablaClase = e1.getTabla();
                    columnasClase = e1.getCampos();
                    columnasClaseMay = e1.getCampos().substring(0, 1).toUpperCase() + e1.getCampos().substring(1);
                    tipocolumnasClase = e1.getTipo();
                    tipocolumnasClaseMay = e1.getTipo().substring(0, 1).toUpperCase() + e1.getTipo().substring(1);
                    
                   
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
                    contexto.put("Concatenado1", ArrConc1);
                    contexto.put("Concatenado2", ArrConc2); 


                    String R1;//mirar Buena practica ???????
                    String R2;//mirar Buena practica ???????
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
                             BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + nombreClase + "/src/java/USBBOGEDUData/" + tablaClase +  "DAO.java"));
                
                            ModeloGeneratorData.merge(contexto, escritor);
                
                            escritor.flush();
                            escritor.close();
                        }
                        catch (IOException ex) 
                            {
                                System.out.println("Plantillas Data no creadas");
                            }
                    }

                    R1 = tipocolumnasClase + " " + columnasClase + "= resultado.get" + tipocolumnasClaseMay + "(\"" + columnasClase + "\");";
                    R2 = "a.set_" + columnasClaseMay + "(" + columnasClase + ");";
                    nombreArray.add(nombreClase); 
                    tablaArray.add(tablaClase); 
                    columnasArray.add(columnasClase); 
                    tipocolumnasArray.add(tipocolumnasClase); 
                    ArrConc1.add(R1);
                    ArrConc2.add(R2);
                    
             }
                  
                  //System.out.println(typeANDCampoArray );   
                  //System.out.println(tablaArray );   
                  //System.out.println(columnasArray );   
                  //System.out.println(tipocolumnasArray );   
    }
      
}