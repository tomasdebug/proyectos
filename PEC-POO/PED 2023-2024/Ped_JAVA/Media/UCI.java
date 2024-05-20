package Media;
/**
 * Write a description of class UCI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UCI
{
     private static int camas=30;//Las camas que tiene la UCI
     
    /**
     * Constructor for objects of class UCI
     */
    public UCI()
    {
 
    }

    /**
     * Metodo para encamar paciente
     * 
     * @param  p: paciente que se va a encamar
     */
     public static void EncamarPaciente(Paciente p)
    {
        camas --;
        p.obtenerExpediente().setIngresado(true);//se indica en que el paciente está ingresado
    }
    /**
     * Metodo para coger el numero de camas
     * 
     */
    public static int getNumCama(){
        return camas;
    }
}
