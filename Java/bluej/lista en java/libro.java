
/**
 * Write a description of class libro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class libro
{
    // instance variables - replace the example below with your own
    private String titulo;
    
    private String autor;
       
    private String isbn;

    /**
     * Constructor for objects of class libro
     */
    public libro(String titulo,String autor,String isbn)
    {
        // initialise instance variables
        this.titulo=titulo;
        this.autor=autor;
        this.isbn=isbn;
    }

  
    public String getTitulo(){ return titulo;}
    
    public void setTitulo(String titulo){ this.titulo=titulo;}
    
    public String getAutor() {return autor;}
    
     public void setAutor(String autor){this.autor=autor;}
     
    public String getIsbn(){return isbn;}
    
    public void setIsbn(String isbn){ this.isbn=isbn; }
}
