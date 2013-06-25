package Entities;
import java.sql.*;

public class Campo 
{
    public String nombreTabla;
    private String nombreColumna;
    private String tipoDato;
    private String tipoNombre;
    private String tamañoColumna;
    private String llavePrimaria;
    private String llaveForanea;
    private boolean incremental;

    public void setIncremental(boolean incremental) 
    {
        this.incremental = incremental;
    }

    public void setLlaveForanea(String llaveForanea) 
    {
        this.llaveForanea = llaveForanea;
    }

    public void setLlavePrimaria(String llavePrimaria) 
    {
        this.llavePrimaria = llavePrimaria;
    }

    public void setNombreColumna(String nombreColumna) 
    {
        this.nombreColumna = nombreColumna;
    }

    public void setNombreTabla(String nombreTabla) 
    {
        this.nombreTabla = nombreTabla;
    }

    public void setTamañoColumna(String tamañoColumna) 
    {
        this.tamañoColumna = tamañoColumna;
    }

    public void setTipoDato(String tipoDato) 
    {
        this.tipoDato = tipoDato;
    }

    public void setTipoNombre(String tipoNombre) 
    {
        this.tipoNombre = tipoNombre;
    }
    

    public boolean isIncremental() 
    {
        return incremental;
    }

    public String getLlaveForanea() 
    {
        return llaveForanea;
    }

    public String getLlavePrimaria() 
    {
        return llavePrimaria;
    }

    public String getNombreColumna() 
    {
        return nombreColumna;
    }

    public String getNombreTabla() 
    {
        return nombreTabla;
    }

    public String getTamañoColumna() 
    {
        return tamañoColumna;
    }

    public String getTipoDato() 
    {
        return tipoDato;
    }

    public String getTipoNombre() 
    {
        return tipoNombre;
    }
}
