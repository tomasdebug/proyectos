package Controlador;
import Interfaz.Menu;
import Media.Administracion;
import java.time.LocalDate;


/**
 * Write a description of class Controlador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controlador
{
   

      private static Administracion admin = new Administracion(); // Campo público para la instancia de Administracion

    public Controlador() {
        // Inicializa la instancia de Administracion en el constructor del controlador
        
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void InstanciarDatos(){
        
       
              
               //INTANCIAMOS EL PERSONAL
            
            admin.alta_empleado(37, "Laura Sánchez", "67891234F", "03/07/1989","Cafeteria","tarde");
            admin.alta_empleado(37, "Laura Sánchez", "67891234F", "03/07/1989","Cafeteria","mañana");
            admin.alta_empleado(37, "Laura Sánchez", "67891234F", "03/07/1989","Cafeteria","noche");
        
                
             //admin.alta_Sanitario(37, "Laura Sánchez", "67891234F", "03/07/1989","medicos_especialistas","Aparato_Digestivo");
             
            admin.alta_empleado(37, "Laura Sánchez", "67891234F", "03/07/1989","Parking","tarde");
            admin.alta_empleado(37, "Laura Sánchez", "67891234F", "03/07/1989","Seguridad","mañana");
            admin.alta_empleado(37, "Laura Sánchez", "67891234F", "03/07/1989","Seguridad","tarde");
            admin.alta_empleado(37, "Laura Sánchez", "67891234F", "03/07/1989","Mantenimiento","mañana");
            admin.alta_empleado(37, "Laura Sánchez", "67891234F", "03/07/1989","Mantenimiento","mañana");
            admin.alta_empleado(37, "Laura Sánchez", "67891234F", "03/07/1989","Mantenimiento","tarde");
            admin.alta_empleado(37, "Laura Sánchez", "67891234F", "03/07/1989","Mantenimiento","tarde");
                
            //Si quiero sacar una lista especifica de cada sector.Tambien se puede usar admin.listanoseque
             admin.alta_paciente(40, "María García", "87654321B", "O_POSITIVO",
                    new String[]{"aparato_digestivo", "cardiología"},
                    new LocalDate[]{LocalDate.of(2023, 5, 15), LocalDate.of(2022, 10, 8)}

            );
             admin.alta_paciente(35, "Pedro López", "98765432C", "B_NEGATIVO",
                    new String[]{"traumatología", "oftalmología"},
                    new LocalDate[]{LocalDate.of(2022, 8, 20), LocalDate.of(2023, 3, 10)}
                  
            );
    
             admin.alta_paciente(50, "Ana Martínez", "76543210D", "AB_POSITIVO",
                    new String[]{"medicina_interna", "dermatología"},
                    new LocalDate[]{LocalDate.of(2022, 11, 10), LocalDate.of(2022, 12, 5)}
                   
            );
    
             admin.alta_paciente(45, "Juan Pérez", "01234567E", "A_NEGATIVO",
                    new String[]{"psiquiatría", "oncología"},
                    new LocalDate[]{LocalDate.of(2022, 9, 5), LocalDate.of(2023, 2, 15)}
                    
            );
    
             admin.alta_paciente(55, "Luisa Fernández", "23456789F", "A_POSITIVO",
                    new String[]{"cirugía_general", "oftalmología"},
                    new LocalDate[]{LocalDate.of(2022, 7, 15), LocalDate.of(2023, 4, 20)}
                    
            );
              // Crear 10 medicos_especialistas
        for (int i = 0; i < 10; i++) {
            int edad = 30 + i; // Edad ficticia para cada sanitario
            String nomComp = "Sanitario" + (i + 1); // Nombre ficticio para cada sanitario
            String DNI = "1234567" + i + "X"; // DNI ficticio para cada sanitario
            String fecha_contratacion = "14/03/2024"; // Fecha ficticia de contratación para cada sanitario
            String turno;
            if (i % 2 == 0) {
                turno = "mañana";
            } else {
                turno = "tarde";
            }
            //APROVECHAMOS I PARA CREAR 5 ENFERMEROS
                if(i<=5){
                
                admin.alta_Sanitario(edad, nomComp, DNI, fecha_contratacion, "enfermero", "", turno);
            }
                
            // Asignar especialidades a los primeros 3 sanitarios
            String especialidad;
            if (i < 3) {
                switch (i) {
                    case 0:
                        especialidad = "aparato_digestivo";
                        break;
                    case 1:
                        especialidad = "cardiología";
                        break;
                    case 2:
                        especialidad = "cirugía_general";
                        break;
                    default:
                        especialidad = "medicina_interna"; // Por defecto, otros sanitarios serán de medicina interna
                        break;
                }
            } else {
                // Para los restantes, se les asignará una especialidad diferente
                switch (i % 6) {
                    case 0:
                        especialidad = "dermatología";
                        break;
                    case 1:
                        especialidad = "oncología";
                        break;
                    case 2:
                        especialidad = "oftalmología";
                        break;
                    case 3:
                        especialidad = "psiquiatría";
                        break;
                    case 4:
                        especialidad = "traumatología";
                        break;
                    default:
                        especialidad = "medicina_interna"; // Por defecto, otros sanitarios serán de medicina interna
                        break;
                }
            }
    
            // Añadir el sanitario con los datos generados
            admin.alta_Sanitario(edad, nomComp, DNI, fecha_contratacion, "medicos_especialista", especialidad, turno);
        }
         
    
           //Si quiero coger un empleado en concreto de cada lista,tambien se puede hacer  admin.caf.lis_empleados.get(1);
    
           //Codigo administracion del hospital
           //Fallos
           //METODOS MANTENIMIENTO
           admin.mant.AnnadirProblemaDeMantenimiento("tuberia rota en UCI");
           admin.mant.AnnadirProblemaDeMantenimiento("tuberia rota en UCI");
           admin.mant.AnnadirProblemaDeMantenimiento("tuberia rota en UCI");
           admin.mant.AnnadirProblemaDeMantenimiento("tuberia rota en UCI");
           admin.mant.AnnadirProblemaDeMantenimiento("tuberia rota en UCI");
           admin.mant.AnnadirProblemaDeMantenimiento("tuberia rota en UCI");
           admin.mant.AnnadirProblemaDeMantenimiento("tuberia rota en UCI");
           admin.mant.AnnadirProblemaDeMantenimiento("tuberia rota en UCI");
           
         
           
         
    }
    /**
     * Metodo para mandar datos a la interfaz del MVC y que está los imprima
     * @param datos: string con los datos a imprimir
     */
    public static void MandarDatos(String datos){
        Menu.Print(datos);
    }
    /**
     * Metodo para sacar los datos del paquete Media del modelo MVC
     */
    public static Administracion getAdministracion(){
        return admin;        
    }
}
