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
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;


public class ModeloGenerator 
{
      public static void generarCodigo(Modelo m) throws IOException 
      {
           
            for (Entidad e1: m.getEntidades())
            {
                    String nombreClase = e1.getNombre().substring(0, 1).toUpperCase() + e1.getNombre().substring(1);
                                   
                    String NameDB;
                    String Campo;
                    String NameUser;
                    String myfolder = "Salida1/";
                    NameDB = nombreClase;
                    Campo = "?¡?¡";
                    NameUser = "Jeison";

                    Functions g = new Functions();
                    File f = new File(myfolder + NameDB);
                    f.mkdir();
        
                    for (int i=1; i<=2; i++)
                    {

                        g.ldir ( f + "/nbproject");    
                        g.ldir ( f + "/nbproject/private");    
                        g.ldir ( f + "/src");
                        g.ldir ( f + "/src/conf");
                        g.ldir ( f + "/src/java");
                        g.ldir ( f + "/web");
                        g.ldir ( f + "/web/WEB-INF");
                    }
        
                        Velocity.init();//inicializa el motor velocity

                        Template build = null;
                        Template index = null;
                        Template ant_deploy = null;
                        Template build_impl = null;
                        Template genfiles_properties = null;
                        Template project = null;
                        Template project_properties = null;
                        Template private_properties = null;
                        Template MANIFEST = null;

                    try 
                    {
                        build = Velocity.getTemplate("Templates/Tbuild.vsl");
                        index = Velocity.getTemplate("Templates/Tindex.vsl");
                        ant_deploy = Velocity.getTemplate("Templates/Tant_deploy.vsl"); // nota: Java no permite declarar variables con (-) se reemplaza por (_)
                        build_impl = Velocity.getTemplate("Templates/Tbuild_impl.vsl");
                        genfiles_properties = Velocity.getTemplate("Templates/Tgenfiles_properties.vsl");
                        project = Velocity.getTemplate("Templates/Tproject.vsl");
                        project_properties = Velocity.getTemplate("Templates/Tproject_properties.vsl");
                        private_properties = Velocity.getTemplate("Templates/Tprivate_properties.vsl");
                        MANIFEST = Velocity.getTemplate("Templates/TMANIFEST.vsl");
                        
                    }
                    catch (Exception e) 
                    {
                    System.out.println("Error creating template");
                    }
        
                    VelocityContext contexto = new VelocityContext();//declara una variable

                    contexto.put("Name_DB", NameDB);
                    contexto.put("Campo", Campo);
             
                    if (build != null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter("Salida1/" + NameDB + "/build.xml"));
                                build.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                System.out.println("Plantilla build.xml creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla build.xml no creada");
                            }
                    }
                    if (index != null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter("Salida1/" + NameDB + "/web/index.jsp"));

                                index.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                System.out.println("Plantilla index.jsp creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla index.jsp no creada");
                            }
                    }
                    if (ant_deploy!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter("Salida1/" + NameDB + "/nbproject/ant-deploy.xml"));

                                ant_deploy.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                System.out.println("Plantilla ant-deploy.xml creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla ant-deploy.xml no creada");
                            }
                    }
                    if (build_impl!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter("Salida1/" + NameDB + "/nbproject/build-impl.xml"));

                                build_impl.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                System.out.println("Plantilla build-impl.xml creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla build-impl.xml no creada");
                            }
                    }
                    if (genfiles_properties!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter("Salida1/" + NameDB + "/nbproject/genfiles.properties"));

                                genfiles_properties.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                System.out.println("Plantilla genfiles.properties creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla genfiles.properties no creada");
                            }
                    }
                    if (project!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter("Salida1/" + NameDB + "/nbproject/project.xml"));

                                project.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                System.out.println("Plantilla project.xml creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla project.xml no creada");
                            }
                    }
                    if (project_properties!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter("Salida1/" + NameDB + "/nbproject/project.properties"));

                                project_properties.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                System.out.println("Plantilla project.properties creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla project.properties no creada");
                            }
                    }
                    if (private_properties!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter("Salida1/" + NameDB + "/nbproject/private/private.properties"));

                                private_properties.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                System.out.println("Plantilla private.properties creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla private.properties no creada");
                            }
                    }
                    if (MANIFEST!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter("Salida1/" + NameDB + "/src/conf/MANIFEST.MF"));

                                MANIFEST.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                System.out.println("Plantilla MANIFEST.MF creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla MANIFEST.MF no creada");
                            }
                    }
            }
    }      
}