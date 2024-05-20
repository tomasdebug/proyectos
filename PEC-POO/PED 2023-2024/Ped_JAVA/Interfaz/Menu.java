package Interfaz;
import java.util.*;
import java.io.IOException;
import Controlador.Controlador;
import Media.Paciente;
import Media.Personal;
import Media.Medicos_Especialistas;
import Media.Personal_Sanitario;
import java.util.ArrayList;


/**
 * Clase que representa el menú principal del sistema del hospital.
 * Permite al usuario interactuar con diferentes opciones del sistema.
 * 
 * @author (tomas)
 * @version (1.0)
 */
public class Menu

{   
     private Controlador controlador;
     private  static Scanner lectura = new Scanner(System.in);
     
    /**
     * Constructor de la clase Menu.
     * 
     * @param controlador El controlador que maneja la lógica del sistema del hospital.
     */
      public Menu(Controlador controlador) {
        this.controlador = controlador;
    }
     /**
     * Menu principal
     */
    public static void Main(){
     int opcion;
     //Administracion admin=controlador.getAdministracion();
     do {
            
            // Mostrar el menú
            System.out.println("");
            System.out.println("------ Menú general------");
            System.out.println("1. Iniciar Hospital");
            System.out.println("2. Menu de personal de soporte");
            System.out.println("3. Menu de personal sanitario");
            System.out.println("4. Menu de pacientes del hospital");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Leer la opción del usuario
            //el while sirve para manejar excepciones 
            while (true) {
                try {
                    System.out.print("Seleccione una opción: ");
                    opcion = Integer.parseInt(lectura.nextLine());
                    break; // Si no hay excepción, salimos del bucle
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                }
            }
            // Realizar acciones según la opción seleccionada
                  
                        try {      
            switch (opcion) {
                case 1:
                    
                 //Tengo que hacer los submenus como metodos.
                    System.out.println("Ha seleccionado la Opción 1.(Iniciar Hospital)");
                    Controlador.InstanciarDatos();//instanciamos los datos preparados anteriormente
                    break;
                    //Esto sería un submenu metodo
                case 2:   
                   subMenuEmpleados();
                    break;
                  case 3:   
                     subMenuSanitarios();
                case 4:
                    SubMenuPacientes();
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
            catch (Exception e) {
                                    System.out.println("Por favor, ingrese un input válido.");
                                    System.out.println("");
                                }

        } while (opcion != 0);

        // Cerrar el scanner al salir del bucle

        System.exit(0);
    }
    /**
     * Submenu donde administrar empleados
     */
   
        public static void subMenuEmpleados(){
         int opcion=0;
         int index=0;
     //Administracion admin=controlador.getAdministracion();
             do {
                    
                  
                                try {      
                    
                        
                         
                            System.out.println("");
                            System.out.println("------ Menú de personal de soporte------");
                            System.out.println("1. Dar de alta un empleado");
                            System.out.println("2. Dar de baja un empleado");
                            System.out.println("3. Enseñar lista de empleados ");
                            System.out.println("4. Notificar incidencia a seguridad ");
                            System.out.println("5. Asignar zona de trabajo a seguridad ");
                            System.out.println("6. Agregar problema de mantenimiento a la lista y repartirlo entre los empleados");
                            System.out.println("7. Cambiar turno de empleado");
                            System.out.println("8. Volver al menú principal ");
                  
                            System.out.println("0. Salir");
                            
                            System.out.print("Seleccione una opción: ");
                            opcion = Integer.parseInt(lectura.nextLine());
                             System.out.println("");
                            switch (opcion) {
                                case 1:
                                    //preguntamos y guardamos datos
                                    System.out.println("Por favor, ingrese la edad del empleado");
                                    int edad = lectura.nextInt();
                                    
                                                                 // Consumir la nueva línea pendiente
                                    lectura.nextLine();
                                    
                                    System.out.println("Por favor, ingrese nombre del empleado.");
                                    String nombre = lectura.nextLine();
                                    System.out.println("Por favor, ingrese DNI del empleado.");
                                    String DNI = lectura.nextLine();
                                    System.out.println("Por favor, ingrese fecha de contratacion del empleado. dd/MM/yyyy");
                                    String fecha_contratacion_empleado=lectura.nextLine();
                                    System.out.println("Por favor, ingrese su profesion");
                                    String profesion = lectura.nextLine();
                                    System.out.println("Por favor, ingrese su turno");
                                    String turno = lectura.nextLine();
                                    Controlador.getAdministracion().alta_empleado(edad,nombre,DNI,fecha_contratacion_empleado,profesion,turno);//Mandamos al controlador la orden de que coja a administrador y llame a su metodo alta empleado
                                     System.out.println("");
                                    break;
                                    case 2:
                                    System.out.println("¿Que empleado quieres dar de baja?");
                                     System.out.println("");
                                  Controlador.getAdministracion().MostrarEmpleadosSegunSector("");//Mandamos al controlador la orden de que coja a administrador y llame a su metodo mostrar empleados con un parametro "" con ese parametro estamos diciendo que queremos todos los empleados
                                    index = Integer.parseInt(lectura.nextLine());
                                    Controlador.getAdministracion().baja_empleado(opcion-1);//Mandamos al controlador la orden de que coja a administrador y llame a su metodo baja empleado para eliminar al empleado seleccionado
                                    break;
                                    
                                case 3 :
                                     System.out.println("");
                                  Controlador.getAdministracion().MostrarEmpleadosSegunSector("");//Mandamos al controlador la orden de que coja a administrador y llame a su metodo mostrar empleados con un parametro "" con ese parametro estamos diciendo que queremos todos los empleados
                                   System.out.println("");
                                     break;
                                  case 4 :
                                     System.out.println("");
                                    System.out.println("¿Cual es la incidencia?");
                                    
                                    String incidencia = lectura.nextLine();
                                     System.out.println("");
                                     
                                     System.out.println("¿Cual de los guardias de seguridad la ha encontrado?");
                                         System.out.println("");
                                    Controlador.getAdministracion().MostrarEmpleadosSegunSector("seguridad");//Mandamos al controlador la orden de que coja a administrador y llame a su mostrarempleadossegunsector "seguridad" para que nos enseñe unicamente los empleados de seguridad
                                       index = Integer.parseInt(lectura.nextLine());
                                    
                                     Controlador.getAdministracion().seg.NotificarIncidencia(incidencia,index);//Mandamos al controlador la orden de que coja a administrador y llame a la oficina de seguridad y en este se notifique la incidencia
                                     break;
                                     case 5:
                                         System.out.println("");
                                    System.out.println("¿Cual es la zona de trabajo?");
                                     System.out.println("");
                                    String zonatrab = lectura.nextLine();
                                     System.out.println("");
                                     
                                     System.out.println("¿A cual de los guardias de seguridad se le ha asignado?");
                                    
                                     Controlador.getAdministracion().MostrarEmpleadosSegunSector("seguridad");
                                     index = Integer.parseInt(lectura.nextLine());
                                    
                                     Controlador.getAdministracion().seg.asignarZonadeTrabajo(zonatrab,index);//Mandamos al controlador la orden de que coja a administrador y llame a la oficina de seguridad y en este se asigne la zona de trabajo del trabajador en cuestion
                                     
                                     break;
                                     case 6:
                                     System.out.println("");
                                     System.out.println("¿Cual es el problema?");
                                     System.out.println("");
                                     String problema = lectura.nextLine();
                                     System.out.println("");

                                     Controlador.getAdministracion().mant.AnnadirProblemaDeMantenimiento(problema);//Mandamos al controlador la orden de que coja a administrador y llame a la oficina de mantenimiento y en esta se añada la incidencia de mantenimiento
                                     
                                     System.out.println("¿Desea repartir los problemas entre los empleados de mantenimiento?y/n");
                                     String respuesta1 = lectura.nextLine().toLowerCase();
                                     if(respuesta1.equals("y")){
                                        System.out.println("Repartiendo problemas");
                                        Controlador.getAdministracion().mant.RPMEEMP();
                                        }
                                     if( respuesta1.equals ("n")){
                                         System.out.println("Entendido,los empleados se quedarán en espera de la siguiente tanda de problemas");
                                        
                                        }
                                        break;
                                    case 7:
                                        System.out.println("¿A cual de los empleados quieres cambiarle el turno?");
                                    
                                     Controlador.getAdministracion().MostrarEmpleadosSegunSector("");
                                     index = Integer.parseInt(lectura.nextLine());
                                     System.out.println("escriba que turno quiere turno(mañana/tarde)");
                                     String turno1 = lectura.nextLine();
                                     
                                     System.out.println("");
                                     Personal p=(Personal)Controlador.getAdministracion().SacarListaEspecificaEmpleados("").get(index -1);//Sacamos al personal especifico de la lista de empleados
                                     
                                     Controlador.getAdministracion().modificarTurno(p,turno1);//le cambiamos el turno
                                     
                                        
                                    case 8:
                                    System.out.println("");
                                    Main();
                                    break;
                                    case 0:
                                System.out.println("Saliendo del programa. ¡Hasta luego!");
                                break;
                                    
                                     default:
                                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                                break;
                            }
        
                }
                    catch (Exception e) {
                                    System.out.println("Por favor, ingrese un input válido.");
                                    System.out.println("");      
                                }
        
                } while (opcion != 0);
         
        System.exit(0);
        
        }
    /**
     * Submenu donde administrar sanitarios
     */
    public static void subMenuSanitarios(){
         int opcion=0;
     //Administracion admin=controlador.getAdministracion();
             do {
                    
                  
                                try {      
                    
                        
                         //Tengo que hacer los submenus como metodos.
                            System.out.println("");
                            System.out.println("------ Menú de personal sanitario------");
                            System.out.println("1. Dar de alta un sanitario");
                            System.out.println("2. Dar de baja un sanitario");
                            System.out.println("3. Enseñar lista de sanitarios ");
                            System.out.println("4. Cambiar turno de sanitario ");
                            System.out.println("5. Volver al menú principal. ");
                            System.out.println("0. Salir");
                            
                            System.out.print("Seleccione una opción: ");
                            opcion = Integer.parseInt(lectura.nextLine());
                             System.out.println("");
                            switch (opcion) {
                               
                                case 1:
                                     System.out.println("");
                                    System.out.println("Por favor, ingrese la edad del empleado");
                                    int edadS = lectura.nextInt();
                                     
                                                                 // Consumir la nueva línea pendiente
                                    lectura.nextLine();
                                    
                                    System.out.println("Por favor, ingrese nombre del empleado.");
                                    String nombreS = lectura.nextLine();
                                    System.out.println("Por favor, ingrese DNI del empleado.");
                                    String DNIS = lectura.nextLine();
                                    System.out.println("Por favor, ingrese fecha de contratacion del empleado.");
                                    String fecha_contratacion_sanitario=lectura.nextLine();
                                    System.out.println("Por favor, ingrese su profesion");
                                    String profesionS = lectura.nextLine();
                                    System.out.println("Por favor, ingrese su especialidad.");
                                    String Especialidad = lectura.nextLine();
                                    System.out.println("Por favor, ingrese su turno.");
                                    String turnoS = lectura.nextLine();
                                    
                                    Controlador.getAdministracion().alta_Sanitario(edadS,nombreS,DNIS,fecha_contratacion_sanitario,profesionS,Especialidad,turnoS);//Mandamos al controlador la orden de que coja a administrador y llame a su metodo de alta sanitario con los datos recogidos
                                    System.out.println("");
                                    break;
                                    case 2:
                                    System.out.println("");
                                    System.out.println("¿Que sanitario quieres dar de baja?");
                                    Controlador.getAdministracion().detallesSanitarios("");//Mandamos al controlador la orden de que coja a administrador y llame a su metodo detallesSanitarios ,este enseña la lista de sanitarios 
                                    
                                    opcion = Integer.parseInt(lectura.nextLine());
                                    Controlador.getAdministracion().baja_Sanitario(opcion-1);//Mandamos al controlador la orden de que coja a administrador y llame baja sanitario con la opcion elegida
                                    
                                     System.out.println("");
                                    break;
                                    case 3:
                                    System.out.println("");
                                    Controlador.getAdministracion().detallesSanitarios("");//Mandamos al controlador la orden de que coja a administrador y llame a su metodo detallesSanitarios ,este enseña la lista de sanitarios 
                                    
                                     System.out.println("");
                                    break;
                                      case 4:
                                    System.out.println("");
                                     System.out.println("¿A cual de los empleados quieres cambiarle el turno?");
                                    
                                     Controlador.getAdministracion().MostrarEmpleadosSegunSector("");
                                     int index = Integer.parseInt(lectura.nextLine());
                                     System.out.println("escriba que turno quiere turno(mañana/tarde)");
                                     String turno1 = lectura.nextLine();
                                     
                                     System.out.println("");
                                     Personal_Sanitario p=(Personal_Sanitario)Controlador.getAdministracion().SacarListaEspecificaSanitarios("").get(index -1);//Mandamos al controlador la orden de que coja a administrador y saque al personal de la lista 
                                    
                                     
                                     Controlador.getAdministracion().modificarTurno(p,turno1);//Le cambiamos el turno 
                                     
                                    
                                    break;
                                    case 5:
                                    System.out.println("");
                                    Main();
                                    break;
                                     case 0:
                                System.out.println("Saliendo del programa. ¡Hasta luego!");
                                break;
                                     default:
                                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                                break;
                            }
        
                }
                    catch (Exception e) {
                                    System.out.println("Por favor, ingrese un input válido.");
                                    System.out.println("");
                                }
        
                } while (opcion != 0);
        
        System.exit(0);
        
        
        }
     /**
     * Submenu donde administrar pacientes
     */
         public static void SubMenuPacientes(){
            int opcion=0;
             //Administracion admin=controlador.getAdministracion();
             do {
                    
                  
                                try {      
                    
                        
                         //Tengo que hacer los submenus como metodos.
                            //Esto sería un submenu metodo
                             System.out.println("");
                            System.out.println("------ Menú de pacientes del hospital------");
                            System.out.println("1. Dar de alta un paciente");
                            System.out.println("2. Dar de baja un paciente");
                            System.out.println("3. Enseñar lista de pacientes ");
                            System.out.println("4. Pedir cita a un paciente");
                            System.out.println("5. ir al medico");
                            System.out.println("6. Obtener expediente medico de un paciente");
                            System.out.println("7. Volver al menú principal. ");
                            System.out.println("0. Salir");
                            
                            System.out.print("Seleccione una opción: ");
                            opcion = Integer.parseInt(lectura.nextLine());
                             System.out.println("");
                            switch (opcion) {
                                case 1:
                                    
                                    System.out.print("Empezaremos preguntando datos basicos del paciente ,más tarde se pedirán sobre su expediente medico");
                                    System.out.println("");
                                    System.out.println("Por favor, ingrese la edad del paciente");
                                    int edad = lectura.nextInt();
                                     
                                                                 // Consumir la nueva línea pendiente
                                    lectura.nextLine();
                                    
                                    System.out.println("Por favor, ingrese nombre del paciente.");
                                    String nombre = lectura.nextLine();
                                    System.out.println("Por favor, ingrese DNI del paciente.");
                                    String DNI = lectura.nextLine();
                                    
                                    Controlador.getAdministracion().alta_paciente(edad,nombre,DNI);
                                    
                                    
                                    break;
                                    
                                    case 2:
                                          System.out.println("¿Que paciente quieres dar de baja?");
                                     System.out.println("");
                                     Controlador.getAdministracion().detallesPacientes();
                                    opcion = Integer.parseInt(lectura.nextLine());
                                    Controlador.getAdministracion().baja_paciente(opcion-1);
                                     System.out.println("");
                                     
                                    break;
                                    
                                case 3 :
                                     System.out.println("");
                                   
                                     Controlador.getAdministracion().detallesPacientes();
                                      System.out.println("");
                                     break;
                                case 4:
                                    
                                     System.out.println("¿Que paciente quiere cita?");
                                     System.out.println("");
                                     Controlador.getAdministracion().detallesPacientes();
                                              
                                     int index=  lectura.nextInt();
                                      
                                                                 // Consumir la nueva línea pendiente
                                    lectura.nextLine();
                                    
                                    //ArrayList<Paciente> p = Controlador.getAdministracion().SacarListaEspecificaSanitarios("pacientes");
                                   // Paciente pac = p.get(index - 1);
                                    Paciente pac=(Paciente) Controlador.getAdministracion().SacarListaEspecificaSanitarios("pacientes").get(index -1);//Mandamos al controlador la orden de que coja a administrador y saque al paciente seleccionado
                                    System.out.println("Por favor, ingrese fecha que le viene bien .");
                                    String fechacita = lectura.nextLine();
                                    
                                    System.out.println("Por favor, ingrese la hora de la cita");
                                    int hora = lectura.nextInt();
                                        lectura.nextLine();
                                    String horacita=Integer.toString(hora);
                                    
                                    System.out.println("¿con cual de nuestros sanitarios quiere la cita?,debe de ser con un medico especialista");
                                    Controlador.getAdministracion().detallesSanitarios("medicos_especialistas");//Mandamos al controlador la orden de que coja a administrador y saque los detalles de los sanitarios
                                    opcion = Integer.parseInt(lectura.nextLine());
                                    //Controlador.getAdministracion().SacarListaEspecificaSanitarios("medicos_especialistas").get(index -1) no se porque no funciona
                                    
                                    pac.PedirCita((Medicos_Especialistas)Controlador.getAdministracion().SacarListaEspecificaSanitarios("medicos_especialistas").get(index -1),fechacita,horacita);//Mandamos al paciente la orden de pedir cita con los argumentos seleccionados(el medico especialista seleccionado),fehcacita y la hora de la cita 
                                    
                                    break;
                                    
                                    case 5:
                                           System.out.println("¿Que paciente va a ir al medico?");
                                     System.out.println("");
                                     Controlador.getAdministracion().detallesPacientes();
                                              
                                      index=  lectura.nextInt();
                                      
                                                                 // Consumir la nueva línea pendiente
                                    lectura.nextLine();
                                    System.out.println("");
                                    Paciente p=(Paciente) Controlador.getAdministracion().SacarListaEspecificaSanitarios("pacientes").get(index -1);//Mandamos al controlador la orden de que coja a administrador y saque al paciente de la lista 
                                    Controlador.getAdministracion().CI.recetarPaciente( p, Controlador.getAdministracion());//Una vez el paciente está sacado llamamos al controlador de nuevo para que saque de administracion CI(Consultas Internas) y llame a su metodo recetar paciente 
                                    
                                    break;
                                    case 6:
                                  
                                        System.out.println("¿De que paciente quieres mostrar el expediente medico?");
                                     System.out.println("");
                                     Controlador.getAdministracion().detallesPacientes();
                                              
                                      index=  lectura.nextInt();
                                      
                                      Paciente pa=(Paciente) Controlador.getAdministracion().SacarListaEspecificaSanitarios("pacientes").get(index -1);//Cogemos el paciente
                                      Controlador.getAdministracion().mostrarExpedienteMedico(pa);//Enseñamos el expediente medico del paciente
                                                                 // Consumir la nueva línea pendiente
                                    lectura.nextLine();
                                    System.out.println("");
                                    
                                    break;
                                    case 7:
                                    System.out.println("");
                                    Main();
                                    break;
                                       case 0:
                                System.out.println("Saliendo del programa. ¡Hasta luego!");
                                break;
                                        
                                     default:
                                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                                break;
                            }
        
                }
                    catch (Exception e) {
                                    System.out.println("Por favor, ingrese un input válido.");
                                    System.out.println("");
                                }
        
                } while (opcion != 0);
                    
            System.exit(0);
        }
          
    /**
     * Metodo para printar datos mandados desde el controlador
     */
    public static void Print(String datos){
        System.out.println(datos);
    }
}
