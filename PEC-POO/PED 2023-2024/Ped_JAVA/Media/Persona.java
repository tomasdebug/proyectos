package Media;

/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persona
{
    // instance variables - replace the example below with your own
    protected int edad;
    protected String nomComp;
    protected String DNI;
   
 
 
     
    /**
     * Constructor de la clase Persona.
     * 
     * @param e La edad de la persona.
     * @param nom El nombre completo de la persona.
     * @param dni El número de DNI de la persona.
     */
    public Persona(int e,String nom,String dni)
    {
        edad=e;
        nomComp=nom;
        DNI=dni;
         
        //System.out.println("Persona añadida");
        
    }

    /**
     * Devuelve el número de DNI de la persona.
     * 
     * @return El número de DNI de la persona.
     */
    public String getDNI()
    {
        return DNI;
    }
    /**
     * Devuelve la edad de la persona.
     * 
     * @return La edad de la persona.
     */
      public int getEdad()
    {
        return edad;
    }
    
    /**
     * Devuelve el nombre completo de la persona.
     * 
     * @return El nombre completo de la persona.
     */
      public String getNom()
    {
        return nomComp;
    }
    
    
}
