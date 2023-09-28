/**
 * An example of a method - replace this comment with your own
 *
 * @param  y   a sample parameter for a method
 * @return     the sum of x and y
 */

/**
 *Crea instancias de Furgonetas y coches
 */
public class Uso_Vehiculo
{
    public static void main(String[] args){
   /*
        Coche Renault=new Coche();
 
            System.out.println("ruedas:"+Renault.ruedas+"\n"+"peso:"+Renault.peso+"\n"+"motor:"+Renault.motor+"\n");
   
       Renault.establece_color("amarillo");
       Renault.dame_color();
       Renault.configura_asientos("si");
       Renault.Configura_climatizador("si");
       System.out.println(Renault.Dame_datos_generales());
        */
        Coche micoche1=new Coche();// solo poniendo esto ya afecto tambien al estado inicial de la furgoneta

        micoche1.establece_color("Rojo");

        Furgoneta mifurgoneta1=new Furgoneta(7,580);

        mifurgoneta1.establece_color("azul");//tienen estos metodos del coche sin tenerlos que programar,ventajitas de la herencia
        
        mifurgoneta1.configura_asientos("si");

        mifurgoneta1.Configura_climatizador("si");

        System.out.println(mifurgoneta1.Dame_datos_generales()+  " " + mifurgoneta1.dimeDatosFurgoneta());
    }
}
