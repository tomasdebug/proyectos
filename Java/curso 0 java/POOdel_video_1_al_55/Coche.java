
/**
 * Write a description of class Coche here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coche
{
    // instance variables - replace the example below with your own
     private int ruedas;/*
     el private hace que solo sea visible en esta clase 
     muy util cuando queremos encapsular las cosas
     */
    /*variables generales de cualquier coche*/
     private int largo;
     
     private int ancho;
     
     private int motor;
     
     private int peso_plataforma;
     
     /*variables especificas*/
     
     private String color;
     
     private int peso_total;
     
     private boolean asientos_cuero, climatizador;
     

    /**
     * Constructor for objects of class Coche
     */
    public Coche()
    {
      ruedas=4;
      peso_plataforma=300;
      motor=1800;
      ancho=30;
      largo=400;
    }
   
    public String Dame_datos_generales(){//creo una funcion que me devuelva cosas con lo declarado en la clase(GETTER)
    
        return "La plataforma del vehículo tiene " + ruedas + " ruedas "+
        "Mide " + largo/100 +" metros con un ancho de " + ancho +" cm "+ " y un peso de plataforma "+
        peso_plataforma + " kg ";
    }
    
    public void establece_color(String color_coche){
    
     color=color_coche;
    }
     public String dame_color(){
    
     return "El color es" + color;
    }
    public void configura_asientos(String asientos_cuero){
    
        if(asientos_cuero.equalsIgnoreCase("si")){
        
            this.asientos_cuero=true;//utilizo el this para indicar que es el de la clase
        
        }else{
        
             this.asientos_cuero=false;
        }
        
    }
    public String dime_asientos(){
    if(asientos_cuero==true){
    
        return "El coche tiene asientos de cuero";
    }
    else{
        return "El coche es de fabrica";
        }
    }
    
    public void Configura_climatizador(String climatizador){//SETTER
    
        if(climatizador.equalsIgnoreCase("si")){
            this.climatizador=true;
        
        }else{
            this.climatizador=false;
        }
    }
    public String dime_climatizador(){
        if(climatizador==true){
        
            return"El coche incorpora climatizador";
        }else{
            return"El coche lleva aire acondicionado";
        }
        
    }
    public String dime_peso_coche(){//SETTER + GETTER(NO RECOMENDABLE)
    
        int peso_carroceria=500;//variable de ambito local
       
        
        if(asientos_cuero==true){
        
            peso_carroceria+=50;       
        }
        if(climatizador==true){
        
            peso_carroceria+=20;
        }
         peso_total=peso_plataforma + peso_carroceria;
         return "El peso del coche es"+ peso_total;
        }
    public int Precio_coche(){//GETTER
        int precio_final=10000;
        if(asientos_cuero==true){
        
            precio_final+=2000;
        }
        if(climatizador==true){
        
        
            precio_final+=1500;
        }
        return precio_final;
    }
    
}

