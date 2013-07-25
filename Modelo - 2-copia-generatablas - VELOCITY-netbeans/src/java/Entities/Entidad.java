
package Entities;

import java.util.List;

public class Entidad 
{
    private List<Campo> campos;
    private String nombre;
    private String Tabla;

    public String getTabla() {
        return Tabla;
    }

    public void setTabla(String Tabla) {
        this.Tabla = Tabla;
    }
    
    

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Campo> getCampos() {
        return campos;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
    
}
