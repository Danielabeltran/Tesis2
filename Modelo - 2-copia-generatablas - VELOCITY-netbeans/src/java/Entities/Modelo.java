package Entities;

import java.util.ArrayList;
import java.util.List;

public class Modelo 
{
    private String nombre;
    private List<Entidad> entidades;
    
    public Modelo()
    {
        this.entidades = new ArrayList<Entidad>();
        this.nombre = "";
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public List<Entidad> getEntidades() 
    {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) 
    {
        this.entidades = entidades;
    }
}
