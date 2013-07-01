/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Generator;


import Entities.Entidad;
import Entities.Modelo;
import Utilities.Functions;
import Utilities.Txtbuild;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;


/**
 *
 * @author daniela.beltran
 */
public class ModeloGenerator {


  public static void generarCodigo(Modelo m) throws IOException 
  {
           
        Functions g = new Functions();
        Txtbuild t = new Txtbuild();
        
        VelocityContext contexto = new VelocityContext();
        
        Velocity.init();//inicializa el motor velocity
        
        Template plantillagenerator = null;
        
        
        
        try 
        {
            plantillagenerator=Velocity.getTemplate("plantillas/generator.vsl");
        } 
        catch (Exception e) 
        {
            System.out.println("shit");
        }
        
        
        if(plantillagenerator != null)
        {
                for (Entidad e1: m.getEntidades())
                {
            
                    try
                    {
                        
                            String nombreClase = e1.getNombre().substring(0, 1).toUpperCase() + e1.getNombre().substring(1);
                            String tablaClase = e1.getTabla();
                            String columnasClase = e1.getCampos();
                            String tipocolumnasClase = e1.getTipo();
                            String columnsize = e1.getColumnsz();
                            String autoincrement = e1.getIsautoincre();
                            String PKTable_Name = e1.getPktablename();
                            String PKColumn_Name = e1.getPkcolumnname();
                            String FKTable_Name = e1.getFktablename();
                            String FKColumn_Name = e1.getFkcolumnname();
                            
                            contexto.put("nombreClase", nombreClase);
                            contexto.put("tablaClase", tablaClase);
                            contexto.put("columnasClase", columnasClase);
                            contexto.put("tipocolumnasClase", tipocolumnasClase);
                            contexto.put("columnsize", columnsize);
                            contexto.put("autoincrement", autoincrement);
                            contexto.put("PKTable_Name", PKTable_Name);
                            contexto.put("PKColumn_Name", PKColumn_Name);
                            contexto.put("FKTable_Name", FKTable_Name);
                            contexto.put("FKColumn_Name", FKColumn_Name);
                            
                            m.getNombre();
                            m.getTabla();
                            m.getCampos();
                            m.getTipo();
                            m.getColumnsz();
                            m.getIsautoincre();
                            m.getPktablename();
                            m.getPkcolumnname();
                            m.getFktablename();
                            m.getFkcolumnname();
                            
                          
                         
                            

                            /*    g.WriterFile( g.NL() + g.NL() +"package " + nombreClase + ".data;" + g.NL() + g.NL() + g.NL() +
                                            "import java.util.ArrayList;" + g.NL() +
                                            "import java.util.List;" + g.NL() +
                                            "//import ..."+ g.NL() + g.NL() +
                                            "Public class " + tablaClase+ "DAO {"+ g.NL() + g.NL() +
                                            "public List<" + tablaClase+ "> getAll(){}// metodo" + g.NL() + g.NL() +
                                            "public void CREATE(" + tablaClase+ " nn){}// metodo" + g.NL() + g.NL() + 	
                                            "public void UPDATE(" + tablaClase+ " nn){}// metodo" + g.NL() + g.NL() +
                                            "public void DELETE(" + tablaClase+ " nn){}// metodo" + g.NL() + g.NL() +
                                            "public " + tablaClase+ " getById(int id){}// metodo"+ g.NL() + g.NL() +
                                            "}",
                                            tablaClase+ "DAO.java"); 
                                g.WriterFile( g.NL() + g.NL() +"package " + nombreClase + ".data;" + g.NL() + g.NL() + g.NL() +
                                            "import java.util.ArrayList;" + g.NL() +
                                            "import java.util.List;" + g.NL() +
                                            "//import ..."+ g.NL() + g.NL() +
                                            "Public class " + tablaClase+ " {"+ g.NL() + g.NL() +
                                            "private "+ tipocolumnasClase +" "+ columnasClase+ " ;"+ g.NL() +
                                            "-------------------------------------------------------------" +g.NL()+
                                            "columnas ......."+ columnasClase+ g.NL()+
                                            "Tipos Columnas ----"+ tipocolumnasClase+ g.NL()+
                                            "Columns Size"+ columnsize + g.NL()+
                                            "Auto_increment"+ autoincrement + g.NL()+
                                            "Primary Table Name"+ PKTable_Name +g.NL()+
                                            "Primary Column Name"+ PKColumn_Name + g.NL()+
                                            "Foreign Table Name"+ FKTable_Name + g.NL()+
                                            "Foreign Table Name"+ FKColumn_Name + g.NL()+
                                            "public List<" + tablaClase+ "> getAll(){}// metodo" + g.NL() + g.NL() +
                                            "public void CREATE(" + tablaClase+ " nn){}// metodo" + g.NL() + g.NL() + 	
                                            "public void UPDATE(" + tablaClase+ " nn){}// metodo" + g.NL() + g.NL() +
                                            "public void DELETE(" + tablaClase+ " nn){}// metodo" + g.NL() + g.NL() +
                                            "public " + tablaClase+ " getById(int id){}// metodo"+ g.NL() + g.NL() +
                                            "}",
                                            tablaClase+ ".java");
                              */  
                            BufferedWriter escritor = new BufferedWriter(new FileWriter("output/prueba.html"));
                
                            plantillagenerator.merge(contexto, escritor);
                
                            escritor.flush();
                            escritor.close();
                
                       /* System.out.println(tablaClase);
                        System.out.println(columnasClase);
                        System.out.println(tipocolumnasClase);
                        System.out.println(columnsize);
                        System.out.println(autoincrement);
                        System.out.println(PKTable_Name);
                        System.out.println(PKColumn_Name);
                        System.out.println(FKTable_Name);
                        System.out.println(FKColumn_Name);*/
                    }
                    catch (Exception e)
                    {//Catch exception if any
                            System.err.println("Error: " + e.getMessage());
                    }
            }
  }
  }
}