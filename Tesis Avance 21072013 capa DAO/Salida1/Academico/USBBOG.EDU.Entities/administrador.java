package Academico .entities;

public class administrador 
{

  
                         private int id;
                         private String nombre;
                         private String usuario;
                         private String clave;
                
        public administrador() // constructor 
            { 
                           
this.id=0; // " " varian segun el tipo de dato
                           
this.nombre=""; // " " varian segun el tipo de dato
                           
this.usuario=""; // " " varian segun el tipo de dato
                           
this.clave=""; // " " varian segun el tipo de dato
            
            }

                public void set_id(int id){
	this.id = id;
}

public int get_id(){
	return id;
}
                public void set_nombre(String nombre){
	this.nombre = nombre;
}

public String get_nombre(){
	return nombre;
}
                public void set_usuario(String usuario){
	this.usuario = usuario;
}

public String get_usuario(){
	return usuario;
}
                public void set_clave(String clave){
	this.clave = clave;
}

public String get_clave(){
	return clave;
}
        
}


