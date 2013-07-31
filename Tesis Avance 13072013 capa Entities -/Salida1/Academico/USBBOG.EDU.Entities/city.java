package Academico .entities;

public class city 
{
        	private INT id ;
        	private INT nombre ;
        	private INT usuario ;
        	private INT clave ;
        	private INT ID ;
        	private INT Name ;
        	private INT CountryCode ;
        	private INT District ;
        	private INT Population ;
        
       
	public city() // constructor 
        { 
                        this.id = " "; // " " varian segun el tipo de dato
                        this.nombre = " "; // " " varian segun el tipo de dato
                        this.usuario = " "; // " " varian segun el tipo de dato
                        this.clave = " "; // " " varian segun el tipo de dato
                        this.ID = " "; // " " varian segun el tipo de dato
                        this.Name = " "; // " " varian segun el tipo de dato
                        this.CountryCode = " "; // " " varian segun el tipo de dato
                        this.District = " "; // " " varian segun el tipo de dato
                        this.Population = " "; // " " varian segun el tipo de dato
            	}
         
        public void set_id (INT id)
        {
		this.id = id;
	}
						
        public INT get_id()
        {
                return id;
        }	
         
        public void set_nombre (INT nombre)
        {
		this.nombre = nombre;
	}
						
        public INT get_nombre()
        {
                return nombre;
        }	
         
        public void set_usuario (INT usuario)
        {
		this.usuario = usuario;
	}
						
        public INT get_usuario()
        {
                return usuario;
        }	
         
        public void set_clave (INT clave)
        {
		this.clave = clave;
	}
						
        public INT get_clave()
        {
                return clave;
        }	
         
        public void set_ID (INT ID)
        {
		this.ID = ID;
	}
						
        public INT get_ID()
        {
                return ID;
        }	
         
        public void set_Name (INT Name)
        {
		this.Name = Name;
	}
						
        public INT get_Name()
        {
                return Name;
        }	
         
        public void set_CountryCode (INT CountryCode)
        {
		this.CountryCode = CountryCode;
	}
						
        public INT get_CountryCode()
        {
                return CountryCode;
        }	
         
        public void set_District (INT District)
        {
		this.District = District;
	}
						
        public INT get_District()
        {
                return District;
        }	
         
        public void set_Population (INT Population)
        {
		this.Population = Population;
	}
						
        public INT get_Population()
        {
                return Population;
        }	
        }