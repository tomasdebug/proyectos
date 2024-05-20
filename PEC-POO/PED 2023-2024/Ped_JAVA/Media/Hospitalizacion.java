package Media;
/**
 * Write a description of class Hospitalizacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hospitalizacion
{
    // instance variables - replace the example below with your own
    private static int camas=90;//Camas del hospital quitando urgencias
    
    /**
     * Constructor for objects of class Hospitalizacion
     */
    public Hospitalizacion()
    {
        
    }

    /**
     *metodo para ingresar pacientes
     *
     * @param p :paciente que se va a ingresar
     */
    public static void EncamarPaciente(Paciente p)
    {
        camas --;
        p.obtenerExpediente().setIngresado(true);//se indica en el expediente que está ingresado
    }
     /**
     *metodo para sacar el numero de camas disponibles
     *
     */
    public int getNumCama(){
        return camas;
    }
}
