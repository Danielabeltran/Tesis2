
package Builder;

import MetaData.MetaData;
import MetaData.Modelo;
import Utilities.Conexion_BD;
import java.io.IOException;
import java.sql.*;

public class ModeloBuilder 
{
    //Metodo carga modelo
    public static Modelo cargarModelo() throws IOException, SQLException
    {
        Conexion_BD database = new Conexion_BD();
        database.makeConnection();
        Modelo m = new Modelo();
        try 
        {
                    
            //Método para traer columnas, campos, tipo del campo, tablas etc        
            DatabaseMetaData metadata = database.connection.getMetaData(); //Método general de java para extraer metadata de la base de datos
            ResultSet resultSet2 = metadata.getColumns(null, null, null, null);//Método para obtener las columnas de los metadatos obtenidos

            while (resultSet2.next()) 
            {

                MetaData e = new MetaData();
                String vstring;
                String vint;
                String vdouble;
                vstring = "String";
                vint = "int";
                vdouble = "double";
                String nameBD = resultSet2.getString("TABLE_CAT");// retorna el nombre de la BD
                String vtablas = resultSet2.getString("TABLE_NAME");//retorna el nombre de todas las tablas de la BD
                String vcampos = resultSet2.getString("COLUMN_NAME");// retorna los campos de todas las tablas de la BD
                String vtipo = resultSet2.getString("TYPE_NAME");// retorna el tipo de datos de los campos
                String vcolumnsize = resultSet2.getString("COLUMN_SIZE");  //retorna el tamaño de la columna
                String vautoincre = resultSet2.getString("IS_AUTOINCREMENT"); //retorna si es autoincremento
                
               if(vtipo.equals("VARCHAR"))
                {
                       vtipo = vstring;
                }
                else
                
                    if(vtipo.equals("INT"))
                    {
                        vtipo = vint;
                    }
                
                else
                if(vtipo.equals("DOUBLE"))
                {
                       vtipo = vdouble;
                }
                 
                String[] nombreBD = {nameBD};
                String[] tablas = {vtablas};
                String[] campos = {vcampos};
                String[] tipo = {vtipo};
                String[] columnsize = {vcolumnsize};
                String[] autoincre = {vautoincre};

                for (String nombrebase : nombreBD)
                {
                    for (String tabla : tablas)
                    {
                        for (String campo : campos)
                            {
                                for (String tipod : tipo)
                                {
                                    for (String columnsiz : columnsize)
                                    {
                                        for (String autoincrement : autoincre)
                                        {
                                            e.setIsautoincre(autoincrement);
                                            e.setNombre(nombrebase);
                                            e.setTabla(tabla);
                                            e.setCampos(campo);
                                            e.setTipo(tipod);
                                            e.setColumnsz(columnsiz);
                                            //System.out.println(vtipo);
                                        
                                        }
                                    }
                                }
                            }
                    }
                }
                ResultSet resultSet3 = metadata.getPrimaryKeys(null, null, vtablas);
                while (resultSet3.next()) 
                {
                    //Método para traer llaves primarias
                    String vpktable_name = resultSet3.getString("TABLE_NAME"); 
                    String vpk_column_name = resultSet3.getString("COLUMN_NAME"); 

                    String[] VpkTableName = {vpktable_name};
                    String[] VpkColumnName = {vpk_column_name};

                    for (String pkTable_Name : VpkTableName)
                    {
                        for (String pkColumn_Name : VpkColumnName)
                        {
                        
                            e.setPktablename(pkTable_Name);
                            e.setPkcolumnname(pkColumn_Name);
                            m.getMetadata().add(e);
                            //System.out.println(pkTable_Name+pkColumn_Name);
                        
                        }
                    }
                 }
            
                
                /*ResultSet resultSet = metadata.getCrossReference(null, null, null, null, null, vtablas);
                while (resultSet.next()) 
                {
                    //Método para traer llaves foráneas
                    String vpktable_name = resultSet.getString("PKTABLE_NAME"); 
                    String vpk_column_name = resultSet.getString("PKCOLUMN_NAME");
                     String vfktable_name = resultSet.getString("FKTABLE_NAME"); 
                    String vfk_column_name = resultSet.getString("FKCOLUMN_NAME");

                    String[] VpkTableName = {vpktable_name};
                    String[] VpkColumnName = {vpk_column_name};
                    String[] VfkTableName = {vfktable_name};
                    String[] VfkColumnName = {vfk_column_name};

                    for (String pkTable_Name : VpkTableName)
                    {
                        for (String pkColumn_Name : VpkColumnName)
                        {
                             for (String fkTable_Name : VfkTableName)
                             {
                                for (String fkColumn_Name : VfkColumnName)
                                {
                        
                                    e.setPktablename(pkTable_Name);
                                    e.setPkcolumnname(pkColumn_Name);
                                    e.setPktablename(fkTable_Name);
                                    e.setPkcolumnname(fkColumn_Name);
                                    m.getEntidades().add(e);
                                    System.out.println(pkTable_Name+" "+ pkColumn_Name+" "+ fkTable_Name+" "+fkColumn_Name);
                                }
                             }
                        }
                        
                    }
                 }*/
            
            }
        }
        
        catch(Exception e)
        {  
        }
        return m;
        
        
    }
    
     

}
