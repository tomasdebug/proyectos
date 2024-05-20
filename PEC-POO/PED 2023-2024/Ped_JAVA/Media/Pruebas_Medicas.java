package Media;
import Controlador.Controlador;
/**
 * Write a description of class Pruebas_Medicas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pruebas_Medicas
{
    

    /**
     * Constructor for objects of class Pruebas_Medicas
     */
    public Pruebas_Medicas()
    {
      
    }

    /**
     *Esta clase sería usada por consultas externas ,pero me dí cuenta de lo redundante que era y dejé así.
     */
    public static void realizarEcografia(Paciente p)
    {
        String datos;
        datos=("Ecografia hecha a "+ p.nomComp + "Enhorabuena vas a traer a una bendicion igual de desastrosa que tú Dios bendiga america");
        Controlador.MandarDatos(datos);
    }
     public static void realizarRayosX(Paciente p)
    {
         String datos;
         datos=("RayosX hechos a "+ p.nomComp + "tienes 210/206 huesos rotos ¿Como sigues vivo?");
          Controlador.MandarDatos(datos);
    }
     public static void realizarAnalitica(Paciente p)
    {
         String datos;
         datos=("Analitica hecha a "+ p.nomComp + "Enhorabuena tienes sida");
          Controlador.MandarDatos(datos);
    }
      public static void realizarResonanciaMagnetico(Paciente p)
    {
         String datos;
         datos=("ResonanciaMagnetica hecha a "+ p.nomComp + "Enhorabuena estás bien");
          Controlador.MandarDatos(datos);
    }
}
