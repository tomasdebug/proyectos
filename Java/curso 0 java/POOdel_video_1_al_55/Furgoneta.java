
/**
 * Write a description of class Furgoneta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Furgoneta extends Coche
{   //extends indica que hereda del coche,convirtiendo a coche en superclase(clase padre) y a furgoneta en subclase(clase hijo)
    // instance variables - replace the example below with your own
    private int capacidad_carga;

    private int plazas_extra;

    //hereda tambien el constructor,el estado inicial del coche
    //ahora tenemos que hacer el estado inicial de la furgoneta

    public Furgoneta(int plazas_extra , int capacidad_carga){
       super();//llama al constructor de la clase padre,si el constructor de la clase padre necesitará argumentos se los tendriamos que dar
        this.plazas_extra = plazas_extra;//this diferencia la variable de clase de la del argumento
        this.capacidad_carga = capacidad_carga;


    }

    public String dimeDatosFurgoneta(){

        return "La capacidad de la furgoneta es: " + capacidad_carga + "y las plazas extra son: " + plazas_extra ;

    }

  
}
