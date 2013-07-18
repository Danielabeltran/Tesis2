
package Entities;

import java.sql.ResultSet;
import java.util.List;

public class Entidad 
{
    private String tabla;
    private String nombre;
    private String campos;
    private String tipo;
    private String columnsz;
    private String isautoincre;
    private String pktablename;
    private String pkcolumnname;
    private String fktablename;
    private String fkcolumnname;

    public String getFkcolumnname() 
    {
        return fkcolumnname;
    }

    public String getFktablename() 
    {
        return fktablename;
    }

    public String getPkcolumnname() 
    {
        return pkcolumnname;
    }

    public String getPktablename() 
    {
        return pktablename;
    }

    public void setFkcolumnname(String fkcolumnname) 
    {
        this.fkcolumnname = fkcolumnname;
    }

    public void setFktablename(String fktablename) 
    {
        this.fktablename = fktablename;
    }

    public void setPkcolumnname(String pkcolumnname) 
    {
        this.pkcolumnname = pkcolumnname;
    }

    public void setPktablename(String pktablename) 
    {
        this.pktablename = pktablename;
    }
    
    public void setColumnsz(String columnsz) 
    {
        this.columnsz = columnsz;
    }

    public void setIsautoincre(String isautoincre) 
    {
        this.isautoincre = isautoincre;
    }

    public String getColumnsz() 
    {
        return columnsz;
    }

    public String getIsautoincre() 
    {
        return isautoincre;
    }
    
    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
    }    
    
    public String getTipo() 
    {
        return tipo;
    }
    
    public void setCampos(String campos) 
    {
        this.campos = campos;
    }
    
    public String getCampos() 
    {
        return campos;
    }
    
    public void setTabla(String tabla) 
    {
        this.tabla = tabla;
    }
    
    public String getTabla() 
    {
        return tabla;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    
    public String getNombre() 
    {
         return nombre;
    }

    public void setFkcolumnname(ResultSet resultado) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
