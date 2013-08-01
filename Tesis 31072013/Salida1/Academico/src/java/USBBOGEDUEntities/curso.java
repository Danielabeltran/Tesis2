package USBBOGEDUEntities;

public class curso 
{

  
                         private int id;
                         private String nombre;
                         private String usuario;
                         private String clave;
                         private int id;
                         private int id_Profesor;
                         private int id_Universidad;
                         private String asignatura;
                         private String grupo;
                
        public curso() // constructor 
            { 
                           
this.id=0;// " " varian segun el tipo de dato
                           
this.nombre="";// " " varian segun el tipo de dato
                           
this.usuario="";// " " varian segun el tipo de dato
                           
this.clave="";// " " varian segun el tipo de dato
                           
this.id=0;// " " varian segun el tipo de dato
                           
this.id_Profesor=0;// " " varian segun el tipo de dato
                           
this.id_Universidad=0;// " " varian segun el tipo de dato
                           
this.asignatura="";// " " varian segun el tipo de dato
                           
this.grupo="";// " " varian segun el tipo de dato
            
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
                public void set_Clave(String clave){
	this.clave = clave;
}

public String get_Clave(){
	return clave;
}
                public void set_Id(int id){
	this.id = id;
}

public int get_Id(){
	return id;
}
                public void set_Id_Profesor(int id_Profesor){
	this.id_Profesor = id_Profesor;
}

public int get_Id_Profesor(){
	return id_Profesor;
}
                public void set_Id_Universidad(int id_Universidad){
	this.id_Universidad = id_Universidad;
}

public int get_Id_Universidad(){
	return id_Universidad;
}
                public void set_Asignatura(String asignatura){
	this.asignatura = asignatura;
}

public String get_Asignatura(){
	return asignatura;
}
                public void set_Grupo(String grupo){
	this.grupo = grupo;
}

public String get_Grupo(){
	return grupo;
}
        
}


