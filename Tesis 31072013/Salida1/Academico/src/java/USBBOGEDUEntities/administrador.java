package USBBOGEDUEntities;

public class administrador 
{

  
                         private int id;
                         private String nombre;
                         private String usuario;
                
        public administrador() // constructor 
            { 
                           
this.id=0;// " " varian segun el tipo de dato
                           
this.nombre="";// " " varian segun el tipo de dato
                           
this.usuario="";// " " varian segun el tipo de dato
            
            }

                public void set_Id(int id){
	this.id = id;
}

public int get_Id(){
	return id;
}
                public void set_Nombre(String nombre){
	this.nombre = nombre;
}

public String get_Nombre(){
	return nombre;
}
                public void set_Usuario(String usuario){
	this.usuario = usuario;
}

public String get_Usuario(){
	return usuario;
}
        
}


