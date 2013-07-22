package MetaData;

import java.util.ArrayList;
import java.util.List;

public class Modelo 
{
    private String nombre;
    private String campo;
    private String tipo;
    private String pktablename;
    private String pkcolumnname;
    private String fktablename;
    private String fkcolumnname;

    public String getFkcolumnname() {
        return fkcolumnname;
    }

    public String getFktablename() {
        return fktablename;
    }

    public String getPkcolumnname() {
        return pkcolumnname;
    }

    public String getPktablename() {
        return pktablename;
    }

    public void setFkcolumnname(String fkcolumnname) {
        this.fkcolumnname = fkcolumnname;
    }

    public void setFktablename(String fktablename) {
        this.fktablename = fktablename;
    }

    public void setPkcolumnname(String pkcolumnname) {
        this.pkcolumnname = pkcolumnname;
    }

    public void setPktablename(String pktablename) {
        this.pktablename = pktablename;
    }
    

    public String getCampo() {
        return campo;
    }

    public String getColumnsz() {
        return columnsz;
    }

    public String getIsautoincre() {
        return isautoincre;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public void setColumnsz(String columnsz) {
        this.columnsz = columnsz;
    }

    public void setIsautoincre(String isautoincre) {
        this.isautoincre = isautoincre;
    }
    private String columnsz;
    private String isautoincre;
    private List<MetaData> metadata;
    private String tabla;
    
    public Modelo()
    {
        this.nombre = "";
        this.metadata = new ArrayList<MetaData>();
        this.tabla = "";
        this.campo = "";
        this.tipo = "";
    }

    public String getCampos() 
    {
        return campo;
    }

    public void setCampos(String campo) 
    {
        this.campo = campo;
        //System.out.println(nombre);
    }
    public String getTipo() 
    {
        return tipo;
    }

    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
        //System.out.println(nombre);
    }
    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
        //System.out.println(nombre);
    }
        public String getTabla() 
        {
            return tabla;
        }

        public void setTabla(String tabla) 
        {
            this.tabla = tabla;
            //System.out.println(tabla);
        }
    
            public List<MetaData> getMetadata() 
            {
                return metadata;
            }

            public void setMetadata(List<MetaData> entidades) 
            {
                this.metadata = entidades;
                //System.out.println(entidades);
            }
    
}
