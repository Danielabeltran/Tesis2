package usbbogentities;

public class city 
{
        	private int id ;
        	private int nombre ;
        	private int usuario ;
        	private int clave ;
        	private int ID ;
        	private int Name ;
        	private int CountryCode ;
        	private int District ;
        	private int Population ;
        
       
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
         
        public void set_id (int id)
        {
		this.id = id;
	}
						
        public int get_id()
        {
                return id;
        }	
         
        public void set_nombre (int nombre)
        {
		this.nombre = nombre;
	}
						
        public int get_nombre()
        {
                return nombre;
        }	
         
        public void set_usuario (int usuario)
        {
		this.usuario = usuario;
	}
						
        public int get_usuario()
        {
                return usuario;
        }	
         
        public void set_clave (int clave)
        {
		this.clave = clave;
	}
						
        public int get_clave()
        {
                return clave;
        }	
         
        public void set_ID (int ID)
        {
		this.ID = ID;
	}
						
        public int get_ID()
        {
                return ID;
        }	
         
        public void set_Name (int Name)
        {
		this.Name = Name;
	}
						
        public int get_Name()
        {
                return Name;
        }	
         
        public void set_CountryCode (int CountryCode)
        {
		this.CountryCode = CountryCode;
	}
						
        public int get_CountryCode()
        {
                return CountryCode;
        }	
         
        public void set_District (int District)
        {
		this.District = District;
	}
						
        public int get_District()
        {
                return District;
        }	
         
        public void set_Population (int Population)
        {
		this.Population = Population;
	}
						
        public int get_Population()
        {
                return Population;
        }	
        }