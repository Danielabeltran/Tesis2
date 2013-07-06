
package Builder;

import Entities.Entidad;
import Entities.Modelo;
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

                Entidad e = new Entidad();
                String nameBD = resultSet2.getString("TABLE_CAT");// retorna el nombre de la BD
                String vtablas = resultSet2.getString("TABLE_NAME");//retorna el nombre de todas las tablas de la BD
                String vcampos = resultSet2.getString("COLUMN_NAME");// retorna los campos de todas las tablas de la BD
                String vtipo = resultSet2.getString("TYPE_NAME");// retorna el tipo de datos de los campos
                String vcolumnsize = resultSet2.getString("COLUMN_SIZE");  //retorna el tamaño de la columna
                String vautoincre = resultSet2.getString("IS_AUTOINCREMENT"); //retorna si es autoincremento

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
                                         e.setNombre(nombrebase);
                                         e.setTabla(tabla);
                                         e.setCampos(campo);
                                         e.setTipo(tipod);
                                         e.setColumnsz(columnsiz);
                                         e.setIsautoincre(autoincrement);
                                         m.getEntidades().add(e);
                                     }
                                 }
                             }
                         }
                     }
                }

                //Método para traer llaves primarias
                resultSet2 = metadata.getPrimaryKeys(null, null, vtablas);

                String vpktable_name = resultSet2.getString("TABLE_NAME"); 
                String vpk_column_name = resultSet2.getString("COLUMN_NAME"); 

                String[] VpkTableName = {vpktable_name};
                String[] VpkColumnName = {vpk_column_name};

                for (String pkTable_Name : VpkTableName)
                {
                    for (String pkColumn_Name : VpkColumnName)
                    {
                        e.setPktablename(pkTable_Name);
                        e.setPkcolumnname(pkColumn_Name);
                        m.getEntidades().add(e);
                    }
                }
                

                //Método para traer llaves foraneas
                resultSet2 = metadata.getImportedKeys(database.connection.getCatalog(), nameBD, vtablas);
                String vfk_table_name = resultSet2.getString("FKTABLE_NAME");  //retorna la tabla que se tiene con llave foranea
                String vfk_column_name = resultSet2.getString("FKCOLUMN_NAME");  //retorna la columna que se tiene con llave foranea

                String[] fkTableName = {vfk_table_name};
                String[] fkColumnName = {vfk_column_name};

                for (String fkTable_Name : fkTableName)
                {
                    for (String fkColumn_Name : fkColumnName)
                    {
                        e.setFktablename(fkTable_Name);
                        e.setFkcolumnname(fkColumn_Name);
                        m.getEntidades().add(e);
                    }
                
                
               }
            }
        }
        
        catch(Exception e)
        {  
        }
        return m;
    }
}
