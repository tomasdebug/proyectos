
/**
 * Write a description of class Module here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Module
{
    // instance variables - replace the example below with your own
    private String code;

    private String Nombre;
    
    private int Edad;
    
    
    
    
    
    /**
     * Constructor for objects of class Module
     */
    public Module(String codigo)
    {
        // initialise instance variables
        code=codigo;
        
    }
    public Module(String MyName, int myAge)
    {
        // initialise instance variables
        Nombre=MyName;
        Edad=myAge;
        
    }
    public void GetName()
    {
        // put your code here
        System.out.println("Su nombre es "+ Nombre);
    }

   
}
