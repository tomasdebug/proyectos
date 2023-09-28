import java.util.*;

class Empleado{
    

       public Empleado(String nom,double sue, int anno ,int mes,int dia){
            
            nombre=nom;
            
            sueldo=sue;
            
           GregorianCalendar calendario=new GregorianCalendar(anno,mes-1,dia);//crea un calendario,con esos parametros ,se le resta 1 porque empieza desde 0 los meses
            
            altaContrato=calendario.getTime();
        
        }

            // se pueden declarar al final
      String nombre;
      double sueldo;
      Date altaContrato;
        //getters
        public String DameNombre(){
            return nombre;
        
        }
        
        public double DameSueldo(){
            return sueldo;
        
        }
        public Date DameFechaAlta(){
            return altaContrato;
        
        }
        public void SubirSueldo(double porcentaje){//setter
            double aumento=sueldo*porcentaje/100;
            
            sueldo+=aumento;
            
        }
            public String dameDatos() {
        return "El empleado se llama " + nombre + " Y un salario de " + sueldo;
    }
    
    }
