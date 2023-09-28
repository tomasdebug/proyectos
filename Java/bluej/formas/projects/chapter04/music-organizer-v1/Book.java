
/**
 * Write a description of class Book here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Book extends MusicOrganizer
{
    // instance variables - replace the example below with your own
    private int hojas;
    private String titulo;

    /**
     * Constructor for objects of class Book
     */
    public Book(String titulo, int hojas)
    {
        this.hojas=hojas;
        this.titulo=titulo;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int hojasLibro()
    {
        // put your code here
        return hojas;
    }
}
