package View;

import Builder.ModeloBuilder;
import Entities.Modelo;
import Generator.ModeloGenerator;

public class Programa 
{
     public static void main(String[] args) {
        
        Modelo m;
        m = ModeloBuilder.cargarModelo();
        ModeloGenerator.generarCodigo(m);
        
    }
}
