package Academico .entities;

public class administrador 
{

  
                         private INT id;
                         private VARCHAR nombre;
                         private VARCHAR usuario;
                         private VARCHAR clave;
                
        public administrador() // constructor 
            { 
                           
this.id=; // " " varian segun el tipo de dato
                           
this.nombre=; // " " varian segun el tipo de dato
                           
this.usuario=; // " " varian segun el tipo de dato
                           
this.clave=; // " " varian segun el tipo de dato
            
            }

                public void set_id(INT id){
	this.id = id;
}

public INT get_id(){
	return id;
}
                public void set_nombre(VARCHAR nombre){
	this.nombre = nombre;
}

public VARCHAR get_nombre(){
	return nombre;
}
                public void set_usuario(VARCHAR usuario){
	this.usuario = usuario;
}

public VARCHAR get_usuario(){
	return usuario;
}
                public void set_clave(VARCHAR clave){
	this.clave = clave;
}

public VARCHAR get_clave(){
	return clave;
}
        
}


