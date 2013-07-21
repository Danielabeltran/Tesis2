 package Academico .entities;

public class administrador 
{
 
                       private int id;
                       private String nombre;
                       private String usuario;
                       private int clave;
       
       
       public administrador() // constructor 
       { 
                                                                               }
       
       public void set_id (int  id)
       {
this.id = id;
}

       public int  get_id()
       {
               return id;
       }
       
       public void set_nombre (int  nombre)
       {
this.nombre = nombre;
}

       public int  get_nombre()
       {
               return nombre;
       }
       
       public void set_usuario (int  usuario)
       {
this.usuario = usuario;
}

       public int  get_usuario()
       {
               return usuario;
       }
       
       public void set_clave (int  clave)
       {
this.clave = clave;
}

       public int  get_clave()
       {
               return clave;
       }
       }