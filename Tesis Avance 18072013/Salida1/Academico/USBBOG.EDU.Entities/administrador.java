package Academico .entities;

public class administrador 
{
               
                            int , id
                    int , nombre
                    int , usuario
                    int , clave
                                    String , id
                    String , nombre
                    String , usuario
                    String , clave
                                    String , id
                    String , nombre
                    String , usuario
                    String , clave
                                    double , id
                    double , nombre
                    double , usuario
                    double , clave
                
                   
     
        
        
        public administrador() // constructor 
        { 
                        this.id = " "; // " " varian segun el tipo de dato
                        this.nombre = " "; // " " varian segun el tipo de dato
                        this.usuario = " "; // " " varian segun el tipo de dato
                        this.clave = " "; // " " varian segun el tipo de dato
            	}
         
        public void set_id ([int, String, String, double] id)
        {
		this.id = id;
	}
						
        public [int, String, String, double] get_id()
        {
                return id;
        }	
         
        public void set_nombre ([int, String, String, double] nombre)
        {
		this.nombre = nombre;
	}
						
        public [int, String, String, double] get_nombre()
        {
                return nombre;
        }	
         
        public void set_usuario ([int, String, String, double] usuario)
        {
		this.usuario = usuario;
	}
						
        public [int, String, String, double] get_usuario()
        {
                return usuario;
        }	
         
        public void set_clave ([int, String, String, double] clave)
        {
		this.clave = clave;
	}
						
        public [int, String, String, double] get_clave()
        {
                return clave;
        }	
        }