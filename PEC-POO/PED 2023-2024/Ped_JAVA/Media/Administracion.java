package Media;

import java.util.*;
import java.time.*;
import Controlador.Controlador;

public class Administracion 
{
      // ArrayList para almacenar empleados de diferentes áreas
     private ArrayList<Personal_Soporte_Hospital> lis_empleados;
     private ArrayList<P_Mantenimiento> lis_mantenimiento;
     private ArrayList<P_Parking> lis_parking;
     private ArrayList<P_Seguridad> lis_seguratas;
     private ArrayList<P_Cafeteria> lis_empcaf;
     public Cafeteria caf = new Cafeteria(lis_empcaf);//instanciamos la cafeteria con el nuevo personal
     public Parking park = new Parking(lis_parking);//instanciamos la parking con el nuevo personal
     public Oficina_Mantenimiento mant= new Oficina_Mantenimiento(lis_mantenimiento);//Lo mismo con los demás
     public Oficina_Seguridad seg = new Oficina_Seguridad(lis_seguratas);
     public Consultas_externas CI= new Consultas_externas();
     private ArrayList<Personal_Sanitario> lis_Sanitarios;
     private ArrayList<Enfermeros> lis_Enfermeros;
     private ArrayList<Medicos_Especialistas> lis_Med;
     private  static Scanner lectura = new Scanner(System.in);
     private ArrayList<Paciente> lis_pacientes;
    
    /**
     * Constructor for objects of class Administracion
     */
    public Administracion()
    {
     
        //list emplados:
        //listgeneral
        lis_empleados = new ArrayList<Personal_Soporte_Hospital>();//inicializo la lista de empleados
        //listespecifica
        lis_mantenimiento=new ArrayList<P_Mantenimiento>();
        lis_parking=new ArrayList<P_Parking> ();
        lis_seguratas=new ArrayList<P_Seguridad> ();
        lis_empcaf=new ArrayList<P_Cafeteria>();
        //lista de Sanitarios  
        lis_Sanitarios = new ArrayList<Personal_Sanitario>();
        lis_Med= new ArrayList<Medicos_Especialistas>();
        lis_Enfermeros= new ArrayList<Enfermeros>();
        lis_pacientes = new ArrayList<Paciente>();//inicializo la lista de empleados

    }
    //general
       /**
     * Modifica el turno de trabajo de un empleado específico.
     *
     * @param p El empleado al que se le modificará el turno.
     * @param Turno El nuevo turno de trabajo que se asignará al empleado.
     */
    public void modificarTurno(Personal p, String Turno) {
        // Llama al método setTurno del objeto Personal para modificar el turno
        p.setTurno(Turno);
    }

   //seccion de recursos humanos
   
   //Empleados de soporte
     /**
 * Agrega un nuevo empleado al sistema, dependiendo de su profesión.
 *
 * @param edad La edad del empleado.
 * @param nomComp El nombre completo del empleado.
 * @param DNI El número de identificación del empleado.
 * @param fecha_de_incorporacion La fecha de incorporación del empleado al sistema.
 * @param profesion La profesión del empleado.
 * @param turno El turno de trabajo del empleado.
 */
public void alta_empleado(int edad, String nomComp, String DNI, String fecha_de_incorporacion, String profesion, String turno) {
    // Convertir la profesión a minúsculas para facilitar la comparación
    String profesionLower = profesion.toLowerCase();
    String datos;

    // Selecciona el tipo de empleado según la profesión
    switch (profesionLower) {
        case "mantenimiento":
            // Crea un nuevo empleado de mantenimiento
            P_Mantenimiento mantenimiento = new P_Mantenimiento(edad, nomComp, DNI, fecha_de_incorporacion, turno);
            // Agrega el empleado a la lista general y a la lista específica de mantenimiento
            lis_empleados.add(mantenimiento);
            lis_mantenimiento.add(mantenimiento);
            // Actualiza la instancia de Oficina_Mantenimiento con la nueva lista de mantenimiento
            mant = new Oficina_Mantenimiento(lis_mantenimiento);
            datos = "Empleado de mantenimiento añadido";
            Controlador.MandarDatos(datos);
            break;
        case "seguridad":
            // Crea un nuevo empleado de seguridad
            P_Seguridad seguridad = new P_Seguridad(edad, nomComp, DNI, fecha_de_incorporacion, turno);
            // Agrega el empleado a la lista general y a la lista específica de seguridad
            lis_empleados.add(seguridad);
            lis_seguratas.add(seguridad);
            // Actualiza la instancia de Oficina_Seguridad con la nueva lista de seguridad
            seg = new Oficina_Seguridad(lis_seguratas);
            datos = "Empleado de seguridad añadido";
            Controlador.MandarDatos(datos);
            break;
        case "parking":
            // Crea un nuevo empleado de parking
            P_Parking parking = new P_Parking(edad, nomComp, DNI, fecha_de_incorporacion, turno);
            // Agrega el empleado a la lista general y a la lista específica de parking
            lis_empleados.add(parking);
            lis_parking.add(parking);
            // Actualiza la instancia de Parking con la nueva lista de parking
            park = new Parking(lis_parking);
            datos = "Empleado de aparcamiento añadido";
            Controlador.MandarDatos(datos);
            break;
        case "cafeteria":
            // Crea un nuevo empleado de cafetería
            P_Cafeteria cafeteria = new P_Cafeteria(edad, nomComp, DNI, fecha_de_incorporacion, turno);
            // Agrega el empleado a la lista general y a la lista específica de cafetería
            lis_empleados.add(cafeteria);
            lis_empcaf.add(cafeteria);
            // Actualiza la instancia de Cafeteria con la nueva lista de personal de cafetería
            caf = new Cafeteria(lis_empcaf);
            datos = "Empleado de cafetería añadido";
            Controlador.MandarDatos(datos);
            break;
        default:
            // Si la profesión no coincide con ninguna de las opciones anteriores, se considera personal de soporte hospitalario por defecto
            Personal_Soporte_Hospital soporte = new Personal_Soporte_Hospital(edad, nomComp, DNI, fecha_de_incorporacion, turno);
            // Agrega el empleado a la lista general de empleados
            lis_empleados.add(soporte);
            datos = "Empleado de soporte hospitalario añadido";
            Controlador.MandarDatos(datos);
            break;
    }
}



        /**
     * Da de baja a un empleado específico.
     *
     * @param p El empleado que se dará de baja.
     */
    public void baja_empleado(Personal_Soporte_Hospital p) {
        // Obtener la profesión del empleado para eliminarlo de la lista correspondiente
        String prof = p.profesion.toLowerCase();
        
        // Eliminar al empleado de la lista general de empleados
        lis_empleados.remove(p);
    
        // Eliminar al empleado de la lista específica según su profesión
        switch (prof) {
            case "mantenimiento":
                lis_mantenimiento.remove(p);
                break;
            case "seguridad":
                lis_seguratas.remove(p);
                break;
            case "parking":
                lis_parking.remove(p);
                break;
            case "cafeteria":
                lis_empcaf.remove(p);
                break;
            default:
                // No se realiza ninguna acción si la profesión no coincide con ninguna de las opciones anteriores
                break;
        }
        // Notificar que el empleado ha sido dado de baja
        Controlador.MandarDatos("Empleado dado de baja");
    }
       /**
     * Da de baja a un empleado específico utilizando su índice en la lista de empleados.
     *
     * @param index El índice del empleado que se dará de baja.
     */
    public void baja_empleado(int index) {
        // Obtener al empleado de la lista según el índice proporcionado
        Personal_Soporte_Hospital p = lis_empleados.get(index - 1);
        
        // Obtener la profesión del empleado para eliminarlo de la lista correspondiente
        String prof = p.profesion.toLowerCase();
        
        // Eliminar al empleado de la lista general de empleados
        lis_empleados.remove(p);
    
        // Eliminar al empleado de la lista específica según su profesión
        switch (prof) {
            case "mantenimiento":
                lis_mantenimiento.remove(p);
                break;
            case "seguridad":
                lis_seguratas.remove(p);
                break;
            case "parking":
                lis_parking.remove(p);
                break;
            case "cafeteria":
                lis_empcaf.remove(p);
                break;
            default:
                // No se realiza ninguna acción si la profesión no coincide con ninguna de las opciones anteriores
                break;
        }
        // Notificar que el empleado ha sido dado de baja
        Controlador.MandarDatos("Empleado dado de baja");
    }

        /**
     * Devuelve una lista específica de empleados según el sector requerido.
     *
     * @param SectorRequerrido El sector del que se desea obtener la lista de empleados.
     * @return Una lista de empleados del sector especificado.
     */
    public ArrayList SacarListaEspecificaEmpleados(String SectorRequerrido) {
        String sectLower = SectorRequerrido.toLowerCase();
        String datos;
        switch (sectLower) {
            case "mantenimiento":
               
                return lis_mantenimiento;
            case "seguridad":

                return lis_seguratas;
            case "parking":
           
                return lis_parking;
            case "cafeteria":
            
                return lis_empcaf;
            default:
                // Si el sector no coincide con ninguna de las opciones anteriores,
                // se devuelve la lista de empleados general.
               
                break;
        }
        return lis_empleados;
    }
    /**
     * Muestra los empleados según el sector requerido.
     *
     * @param SectorRequerrido El sector del que se desea mostrar los empleados.
     */
    public void MostrarEmpleadosSegunSector(String SectorRequerrido){
         // Comprobación del sector requerido
           if(SectorRequerrido.equals("mantenimiento")){
                 // Mostrar lista de empleados de mantenimiento
                String datos = String.format("%-3s   %-4s   %-18s   %-9s   %-15s   %-10s%n", "ID", "Edad", "Nombre completo", "DNI", "Fecha nacimiento", "Profesion");
                Controlador.MandarDatos(datos);
                int i = 1;
                for (P_Mantenimiento e : lis_mantenimiento) {
                   
                       datos = String.format("%-3d   %-4d   %-18s   %-9s   %-15s   %-10s %s", i, e.edad, e.nomComp, e.DNI, e.fecha_de_incorporacion, e.profesion, e.turno);
                    Controlador.MandarDatos(datos);
                    i++;
                }
            
            }
            if(SectorRequerrido.equals("seguridad")){
          // Mostrar lista de empleados de seguridad
                int i =1;
                  String datos = String.format("%-3s   %-4s   %-18s   %-9s   %-15s   %-10s%n", "ID", "Edad", "Nombre completo", "DNI", "Fecha nacimiento", "Profesion");
            Controlador.MandarDatos(datos);
                 for(P_Seguridad e:lis_seguratas){
                    
                       datos = String.format("%-3d   %-4d   %-18s   %-9s   %-15s   %-10s %s", i, e.edad, e.nomComp, e.DNI, e.fecha_de_incorporacion, e.profesion, e.turno);
                    Controlador.MandarDatos(datos);
                    i++;
                    }
            
            }
             if(SectorRequerrido.equals("parking")){
                  // Mostrar lista de empleados de parking
                int i =1;
              String datos = String.format("%-3s   %-4s   %-18s   %-9s   %-15s   %-10s%n", "ID", "Edad", "Nombre completo", "DNI", "Fecha nacimiento", "Profesion");
            Controlador.MandarDatos(datos);
                 for(P_Parking e:lis_parking){
                    
                      datos = String.format("%-3d   %-4d   %-18s   %-9s   %-15s   %-10s %s", i, e.edad, e.nomComp, e.DNI, e.fecha_de_incorporacion, e.profesion, e.turno);
                    Controlador.MandarDatos(datos);
                    i++;
                    }
           
            }
             if(SectorRequerrido.equals("cafeteria")){
                    // Mostrar lista de empleados de cafeteria
                int i =1;
                 String datos = String.format("%-3s   %-4s   %-18s   %-9s   %-15s   %-10s%n", "ID", "Edad", "Nombre completo", "DNI", "Fecha nacimiento", "Profesion");
                Controlador.MandarDatos(datos);
                 for(P_Cafeteria e:lis_empcaf){
                    
                    datos = String.format("%-3d   %-4d   %-18s   %-9s   %-15s   %-10s %s", i, e.edad, e.nomComp, e.DNI, e.fecha_de_incorporacion, e.profesion, e.turno);
                    Controlador.MandarDatos(datos);
                    i++;
                    }
            
            }
             if(SectorRequerrido.equals("")){
                  // Mostrar lista de todos los empleados
                int i =1;
                 String datos = String.format("%-3s   %-4s   %-18s   %-9s   %-15s   %-10s%n", "ID", "Edad", "Nombre completo", "DNI", "Fecha nacimiento", "Profesion");
                Controlador.MandarDatos(datos);
                for (Personal_Soporte_Hospital e : lis_empleados) {
                    datos = String.format("%-3d   %-4d   %-18s   %-9s   %-15s   %-10s %s", i, e.edad, e.nomComp, e.DNI, e.fecha_de_incorporacion, e.profesion, e.turno);
                    Controlador.MandarDatos(datos);
                    i++;
                }
            }

        }

    //PersonalMedico
        
        /**
         * Agrega un nuevo empleado sanitario al sistema.
         *
         * @param edad La edad del empleado.
         * @param nomComp El nombre completo del empleado.
         * @param DNI El DNI del empleado.
         * @param fecha_contratacion La fecha de contratación del empleado.
         * @param profesion La profesión del empleado.
         * @param especialidad La especialidad del empleado (solo para médicos especialistas).
         * @param turno El turno de trabajo del empleado.
         */
        public void alta_Sanitario(int edad, String nomComp, String DNI, String fecha_contratacion, String profesion, String especialidad, String turno) {
        String datos;
        String prlw = profesion.toLowerCase();
        switch (prlw) {
            case "enfermero":
                // Crear y agregar un enfermero al sistema
                Enfermeros enf = new Enfermeros(edad, nomComp, DNI, fecha_contratacion, turno);
                lis_Enfermeros.add(enf);
                lis_Sanitarios.add(enf);
                datos = ("Empleado de enfermeria añadido");
                Controlador.MandarDatos(datos);
                break;
            case "medicos_especialista":
                // Crear y agregar un médico especialista al sistema
                String especialidadLower = especialidad.toLowerCase();
                switch (especialidadLower) {
                    // Verificar la especialidad y crear un médico especialista correspondiente
                    case "aparato_digestivo":
                    case "cardiología":
                    // Otras especialidades...
                    Medicos_Especialistas med = new Medicos_Especialistas(edad, nomComp, DNI, fecha_contratacion, especialidad, turno);
                    lis_Med.add(med);
                    lis_Sanitarios.add(med);
                    datos = ("Empleado de medicina especialista añadido");
                    Controlador.MandarDatos(datos);
                    break;
                }
                break;
            default:
                // Si la profesión no coincide, se asume que es personal de soporte sanitario y se agrega
                Personal_Sanitario sanitario = new Personal_Sanitario(edad, nomComp, DNI, fecha_contratacion, turno);
                lis_Sanitarios.add(sanitario);
                datos = ("Debido a que la especialidad no coincide se ha supuesto que es personal de soporte sanitario y se ha añadido");
                Controlador.MandarDatos(datos);
                break;
        }
    }

   
        /**
     * Elimina un empleado sanitario del sistema.
     *
     * @param p El empleado sanitario a eliminar.
     */
    public void baja_Sanitario(Personal_Sanitario p) {
        String datos;
        // Determinar la profesión del empleado para eliminarlo de la lista correspondiente
        String prof = p.profesion.toLowerCase();
        switch (prof) {
            case "enfermeros":
                lis_Enfermeros.remove(p);
                break;
            case "medicos_especialistas":
                lis_Med.remove(p);
                break;
        }
        // Eliminar al empleado de la lista de empleados sanitarios
        lis_Sanitarios.remove(p);
        datos = ("Empleado quitado");
        Controlador.MandarDatos(datos);
    }

         /**
     * Elimina un empleado sanitario del sistema según su índice en la lista.
     *
     * @param index El índice del empleado sanitario a eliminar.
     */
    public void baja_Sanitario(int index) {
        // Obtener el empleado sanitario según su índice en la lista de empleados
        Personal_Soporte_Hospital p = lis_empleados.get(index - 1);
        String prof = p.profesion.toLowerCase();
        // Determinar la profesión del empleado para eliminarlo de la lista correspondiente
        switch (prof) {
            case "enfermeros":
                lis_Enfermeros.remove(p);
                break;
            case "medicos_especialistas":
                lis_Med.remove(p);
                break;
        }
        // Eliminar al empleado de la lista de empleados sanitarios
        lis_Sanitarios.remove(p);
    }
     
         /**
     * Devuelve una lista específica de sanitarios según el sector requerido.
     *
     * @param SectorRequerrido El sector del que se desea obtener la lista de sanitarios.
     * @return Una lista de sanitarios del sector especificado.
     */
    public ArrayList SacarListaEspecificaSanitarios(String SectorRequerrido) {
        String sectLower = SectorRequerrido.toLowerCase();
        switch (sectLower) {
            case "enfermeros":
                // Devolver lista de enfermeros
                return lis_Enfermeros;
            case "medicos_especialistas":
                // Devolver lista de médicos especialistas
                return lis_Med;
            case "pacientes":
                // Devolver lista de pacientes
                return lis_pacientes;
            default:
                // Si el sector no coincide con ninguna de las opciones anteriores,
                // se devuelve la lista de sanitarios general.
                return lis_Sanitarios;
        }
    }
          /**
     * Devuelve una lista de médicos especialistas que no están ocupados en el momento especificado.
     * 
     * @param hora La hora actual para determinar la disponibilidad de los médicos.
     * @return Una lista de médicos especialistas disponibles.
     */
     public ArrayList<Medicos_Especialistas> SacarLisMedNoOcupados(int hora){
            //saco la lista de medicos_especialistas disponibles
             ArrayList<Medicos_Especialistas> lismedDisponibles=new ArrayList<Medicos_Especialistas>();
              boolean ocupado = true;
            for(Medicos_Especialistas e:lis_Med){
                //determino el turno de cada uno
                e.setDisponibilidad(true);//al principio todos estan ocupados o no disponibles y segun sea el turno de mañana o tarde vamos sacando los que estan disponibles
             if(6.00 <hora && hora <15 && e.getTurno().equals("mañana")){//si el medico tiene el turno de mañana...
               e.setDisponibilidad(false);
                 ocupado = false;
                }
             if(16 <hora && hora <21 && e.getTurno().equals("tarde")){//si el medico tiene el turno de tarde 
                 e.setDisponibilidad(false);
                 ocupado = false;
                
                }
             if(ocupado==false){//si el medico tiene el turno de tarde 
                
                lismedDisponibles.add(e);
                }
            }
            
      return lismedDisponibles;
     }
         /**
     * Devuelve una lista de médicos especialistas que no están ocupados en el momento especificado.
     * 
     * @param hora La hora actual para determinar la disponibilidad de los médicos.
     * @return Una lista de enfermeros disponibles.
     */
         public ArrayList<Enfermeros> SacarLisEnfNoOcupados(int hora){
           //  ArrayList<Enfermeros> lismed=SacarListaEspecificaSanitarios("Enfermeros");
             
             ArrayList<Enfermeros> lismedDisponibles=new ArrayList<Enfermeros>();
            boolean ocupado = true;
            for(Enfermeros e:lis_Enfermeros){
                 e.setDisponibilidad(true);//al principio todos estan ocupados o no disponibles y segun sea el turno de mañana o tarde vamos sacando los que estan disponibles
             if(6.00 <hora && hora <15 && e.getTurno().equals("mañana")){//turno mañana agregar que no este tampoco en la hora de alguna cita
               e.setDisponibilidad(false);
                 ocupado = false;
                }
             if(16 <hora && hora <21 && e.getTurno().equals("tarde")){//turno tarde
                 e.setDisponibilidad(false);
                 ocupado = false;
                
                }
             if(ocupado==false){
                
                lismedDisponibles.add(e);
                }
            }
          
      return lismedDisponibles;
     
     }
         /**
     * Muestra los detalles de los enfermeros y médicos especialistas.
     * Envía los datos al controlador para mostrarlos en la interfaz de usuario.
     */
      public void detallesSanitarios(String esp){
           int i = 1; // Variable para numerar los sanitarios
          switch(esp.toLowerCase())
          {
            case "enfermeros":
                 String datos=("Enfermeros:");
            // Enviar datos al controlador (posiblemente a la interfaz de usuario)
            Controlador.MandarDatos(datos);
            Controlador.MandarDatos(""); // Línea en blanco para separar
            // Formato de encabezado para los detalles de los enfermeros
            datos = String.format("%-3s   %-4s   %-18s   %-9s   %-15s   %-10s%n", "ID", "Edad", "Nombre completo", "DNI", "Fecha nacimiento", "Profesion");
            // Enviar encabezado al controlador
            Controlador.MandarDatos(datos);
            // Recorrer la lista de enfermeros para mostrar sus detalles
            for(Enfermeros e : lis_Enfermeros){
                // Formato de datos para cada enfermero
                datos = String.format("%-3d   %-4d   %-18s   %-9s   %-15s   %-10s %s", i, e.edad, e.nomComp, e.DNI, e.fecha_de_incorporacion, e.profesion, e.turno);
                // Enviar datos al controlador
                Controlador.MandarDatos(datos);
                i++; // Incrementar el contador
            }
            break;
                case "medicos_especialistas":
                    
                         datos=("Medicos Especialistas:");
            Controlador.MandarDatos(datos);
            Controlador.MandarDatos(""); // Línea en blanco para separar
            // Formato de encabezado para los detalles de los médicos especialistas
            datos = String.format("%-3s   %-4s   %-18s   %-9s   %-15s   %-10s%n", "ID", "Edad", "Nombre completo", "DNI", "Fecha nacimiento", "Profesion");
            Controlador.MandarDatos(datos);
            // Recorrer la lista de médicos especialistas para mostrar sus detalles
            for(Medicos_Especialistas e : lis_Med){
                // Formato de datos para cada médico especialista
                datos = String.format("%-3d   %-4d   %-18s   %-9s   %-15s   %-10s %s", i, e.edad, e.nomComp, e.DNI, e.fecha_de_incorporacion, e.profesion, e.turno);
                // Enviar datos al controlador
                Controlador.MandarDatos(datos);
                i++; // Incrementar el contador
            }
            break;
            default:
                      // Mostrar detalles de los enfermeros
             datos=("Enfermeros:");
            // Enviar datos al controlador (posiblemente a la interfaz de usuario)
            Controlador.MandarDatos(datos);
            Controlador.MandarDatos(""); // Línea en blanco para separar
            // Formato de encabezado para los detalles de los enfermeros
            datos = String.format("%-3s   %-4s   %-18s   %-9s   %-15s   %-10s%n", "ID", "Edad", "Nombre completo", "DNI", "Fecha nacimiento", "Profesion");
            // Enviar encabezado al controlador
            Controlador.MandarDatos(datos);
            // Recorrer la lista de enfermeros para mostrar sus detalles
            for(Enfermeros e : lis_Enfermeros){
                // Formato de datos para cada enfermero
                datos = String.format("%-3d   %-4d   %-18s   %-9s   %-15s   %-10s %s", i, e.edad, e.nomComp, e.DNI, e.fecha_de_incorporacion, e.profesion, e.turno);
                // Enviar datos al controlador
                Controlador.MandarDatos(datos);
                i++; // Incrementar el contador
            }
            // Mostrar detalles de los médicos especialistas
            datos=("Medicos Especialistas:");
            Controlador.MandarDatos(datos);
            Controlador.MandarDatos(""); // Línea en blanco para separar
            // Formato de encabezado para los detalles de los médicos especialistas
            datos = String.format("%-3s   %-4s   %-18s   %-9s   %-15s   %-10s%n", "ID", "Edad", "Nombre completo", "DNI", "Fecha nacimiento", "Profesion");
            Controlador.MandarDatos(datos);
            // Recorrer la lista de médicos especialistas para mostrar sus detalles
            for(Medicos_Especialistas e : lis_Med){
                // Formato de datos para cada médico especialista
                datos = String.format("%-3d   %-4d   %-18s   %-9s   %-15s   %-10s %s", i, e.edad, e.nomComp, e.DNI, e.fecha_de_incorporacion, e.profesion, e.turno);
                // Enviar datos al controlador
                Controlador.MandarDatos(datos);
                i++; // Incrementar el contador
            }
            }
    }
    public void getCitasSanitario(LocalDate fecha,String DNI){
        String datos;
        for(Medicos_Especialistas m:lis_Med){
            if(m.getDNI().equals(DNI)){
                if(m.getListaCitas().size()!=0){
                    
                    for(Cita c:m.getListaCitas()){
                        LocalDate fechacita=c.getFechacita().getFecha();
                        if(fechacita.equals(fecha)){
                            datos=("Usted tiene una cita a las : " + fechacita.toString()+ " con el paciente "+ c.getPaciente().getNom());
                            
                        }
                    }
                
                }
            }
        }
    
    }
    //Pacientes
    
      /**
     * Añade un paciente a la lista de pacientes.
     * Envía un mensaje al controlador para notificar que el paciente ha sido añadido.
     *
     * @param p El paciente a añadir.
     */
    public void alta_paciente(Paciente p){
        String datos;
        // Añadir el paciente a la lista de pacientes
        lis_pacientes.add(p);
        // Mensaje indicando que el paciente ha sido añadido
        datos=("Paciente añadido");
        // Enviar mensaje al controlador
        Controlador.MandarDatos(datos);
    }
       /**
     * Añade un paciente a la lista de pacientes utilizando los datos proporcionados.
     * Crea un nuevo objeto Paciente con los datos de entrada y lo añade a la lista de pacientes.
     * Envía un mensaje al controlador para notificar que el paciente ha sido añadido.
     *
     * @param edad La edad del paciente.
     * @param nombrecompleto El nombre completo del paciente.
     * @param dni El DNI del paciente.
     * @param exp El expediente médico del paciente.
     */
    public void alta_paciente(int edad, String nombrecompleto, String dni, ExpedienteMedico exp){
        String datos;
        // Crear un nuevo objeto Paciente con los datos proporcionados
        Paciente p = new Paciente(edad, nombrecompleto, dni, exp);
        // Añadir el paciente a la lista de pacientes
        lis_pacientes.add(p);
        // Mensaje indicando que el paciente ha sido añadido
        datos=("Paciente añadido");
        // Enviar mensaje al controlador
        Controlador.MandarDatos(datos);
    }
        /**
     * Añade un paciente a la lista de pacientes utilizando los datos proporcionados.
     * Crea un nuevo objeto Paciente con los datos de entrada y lo añade a la lista de pacientes.
     * Envía un mensaje al controlador para notificar que el paciente ha sido añadido.
     * Este metodo solo es usado cuando se quiere crear un paciente infectado y no tratado
     *
     * @param edad La edad del paciente.
     * @param nombrecompleto El nombre completo del paciente.
     * @param dni El DNI del paciente.
     * @param tipoSangre El tipo de sangre del paciente.
     * @param lista_enfermedades Un arreglo de strings que contiene las enfermedades del paciente.
     * @param fechas_concepcion Un arreglo de fechas que contiene las fechas de concepción de las enfermedades del paciente.
     * @param fechas_tratamiento Un arreglo de fechas que contiene las fechas de tratamiento de las enfermedades del paciente.
     */
    public void alta_paciente(int edad, String nombrecompleto, String dni, String tipoSangre, String[] lista_enfermedades, LocalDate[] fechas_concepcion) {
        ExpedienteMedico.TipoSangre tipo = ExpedienteMedico.TipoSangre.valueOf(tipoSangre.toUpperCase());//Convertimos el tipo de Sangre a enum 
        // Crear una lista de enfermedades a partir de los arreglos proporcionados
        ArrayList<Enfermedad> enfermedades = new ArrayList<>();
        for (int i = 0; i < lista_enfermedades.length; i++) {
            //Añadimos las enfermedades
            enfermedades.add(new Enfermedad(lista_enfermedades[i], fechas_concepcion[i]));
        }
        //creamos y agregamos el expediente medico
        ExpedienteMedico expediente = new ExpedienteMedico(tipo, enfermedades);
        //creamos el paciente
        Paciente paciente = new Paciente(edad, nombrecompleto, dni, expediente);
         //lo añadimos a la lista de pacientes el paciente
        lis_pacientes.add(paciente);
        String datos = "Paciente añadido";
        Controlador.MandarDatos(datos);
    }
        /**
     * Añade un paciente a la lista de pacientes sin proporcionar información detallada sobre su expediente médico.
     * El usuario ingresa manualmente el tipo de sangre y las enfermedades del paciente.
     * 
     * @param edad La edad del paciente.
     * @param nombrecompleto El nombre completo del paciente.
     * @param dni El DNI del paciente.
     */
    public void alta_paciente(int edad,String nombrecompleto,String dni){
          String datos;
          // Solicitar al usuario que ingrese el tipo de sangre
            datos=("Ingrese el tipo de sangre A_POSITIVO,A_NEGATIVO,B_POSITIVO,B_NEGATIVO,AB_POSITIVO,AB_NEGATIVO, O_POSITIVO,O_NEGATIVO,: ");
            Controlador.MandarDatos(datos);
           String tipoSangreStr = lectura.nextLine().toUpperCase();//leer el string del usuario
           // Convertir la cadena ingresada por el usuario en un valor del Enum TipoSangre
           ExpedienteMedico.TipoSangre tipoSangre = ExpedienteMedico.TipoSangre.valueOf(tipoSangreStr);
                                        
           datos=("Ingrese las enfermedades del paciente (Ingrese 'fin' para terminar): ");
           Controlador.MandarDatos(datos);
           //creamos el arraylist de enfermedades
           ArrayList<Enfermedad> enfermedades = new ArrayList<>();
             while (true) {//mientras no escriba fin le preguntará acerca de la enfermedad que tiene
                   System.out.print("Enfermedad: ");
                   String nombreEnfermedad = lectura.nextLine();
                   if (nombreEnfermedad.equalsIgnoreCase("fin")) {
                                break;
                   }
                                            // Aquí podrías solicitar la fecha de concepción y tratamiento si es necesario
                    Enfermedad enfermedad = new Enfermedad(nombreEnfermedad, LocalDate.now(), LocalDate.now());
                   enfermedades.add(enfermedad);
               }
            //Creamos el expediente del paciente                  
           ExpedienteMedico expediente = new ExpedienteMedico(tipoSangre, enfermedades);
           
           Paciente p = new Paciente(edad, nombrecompleto, dni,expediente);
           lis_pacientes.add(p);
           //lo añadimos a la lista
          datos=("Paciente añadido");
           Controlador.MandarDatos(datos);
    }
        
      /**
     * Añade un paciente a la lista de pacientes.
     * 
     * @param p El paciente a añadir.
     */
    public void baja_paciente(Paciente p){
        String datos;
        // Agregar el paciente a la lista de pacientes
        lis_pacientes.add(p);
        datos=("Paciente añadido");
        // Enviar mensaje al controlador
        Controlador.MandarDatos(datos);
    }
    
    /**
     * Elimina un paciente de la lista de pacientes según su índice.
     * 
     * @param index El índice del paciente a eliminar.
     */
    public void baja_paciente(int index){
        // Eliminar el paciente de la lista de pacientes
        lis_pacientes.remove(index);
        // No hay mensaje de confirmación en este método
    }
    
    /**
     * Muestra los detalles de todos los pacientes en la lista de pacientes.
     */
    public void detallesPacientes(){
        String datos;
        int i = 1;
        // Encabezado de la sección de pacientes
        datos=("Pacientes:");
        Controlador.MandarDatos(datos);
        Controlador.MandarDatos("");
        
        // Encabezado de la tabla de detalles de pacientes
        datos = String.format("%-3s   %-4s   %-15s %-9s%n", "ID", "Edad", "Nombre completo", "DNI");
        Controlador.MandarDatos(datos);
        
        // Iterar sobre la lista de pacientes y mostrar sus detalles
        for(Paciente e:lis_pacientes){
            datos = String.format("%-3d   %-4d   %-15s   %-9s ", i, e.edad, e.nomComp, e.DNI);
            Controlador.MandarDatos(datos);
            i++;
        }
    }   
        /**
     * Comprueba si hay una cita programada para un médico específico dentro de un rango de tiempo.
     * 
     * @param nombreMedico El nombre del médico para el que se desea comprobar las citas.
     * @return true si hay una cita para el médico dentro del rango de tiempo especificado, false en caso contrario.
     */
    public boolean comprobarCitas(String nombreMedico){
        String datos;
        // Obtener la fecha y hora actual
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        // Definir el rango de tiempo como 2 horas antes y 2 horas después de la hora actual
        LocalTime horaInicioRango = horaActual.minusHours(2);
        LocalTime horaFinRango = horaActual.plusHours(2);
        
        // Iterar sobre la lista de pacientes
        for (Paciente paciente : lis_pacientes) {
            // Obtener la cita del paciente, si existe
            Cita cita = paciente.getCita();
            if (cita != null && cita.getPersonal().getNom().equals(nombreMedico)) {
                // Si la cita existe y es para el médico específico
                
                // Obtener la fecha y hora de la cita
                LocalDate FechaCita = cita.getFechacita().getFecha(); 
                int horaC = cita.getHoracita();
                
                // Convertir la hora de la cita a un objeto LocalTime
                LocalTime horaCita = LocalTime.of(horaC, 0); // Suponiendo que solo tienes la hora y no los minutos
                
                // Comprobar si la hora de la cita está dentro del rango especificado y si es para hoy
                if (horaCita.isAfter(horaInicioRango) && horaCita.isBefore(horaFinRango) && FechaCita.isEqual(fechaActual)) {
                    // Si la cita es para hoy y está dentro del rango de horas
                    return true;
                } else {
                    // Si la cita no está dentro del rango, enviar mensajes de aviso al controlador
                    datos = "Usted no tiene la cita en esta fecha u hora";
                    Controlador.MandarDatos(datos);
                    datos = "Comprobando si hay alguien disponible para esta fecha y hora";
                    Controlador.MandarDatos(datos);
                }
            }
        }
        // Si no se encuentra ninguna cita dentro del rango, retornar false
        return false;
    }

        /**
     * Modifica el expediente médico de un paciente añadiendo una nueva enfermedad.
     * 
     * @param p El paciente cuyo expediente médico se va a modificar.
     * @param enf El nombre de la nueva enfermedad a añadir.
     * @param fechaConcepcion La fecha de concepción de la enfermedad en formato String.
     */
    public void mod_expediente(Paciente p, String enf, String fechaConcepcion) {
        // Obtener el expediente médico del paciente
        ExpedienteMedico expe = p.obtenerExpediente();
        if (expe != null) {
            // Convertir la fecha de concepción a un objeto LocalDate
            Fecha f = new Fecha(fechaConcepcion);
            LocalDate fechaconcepcion = f.getFecha();
            LocalDate fechaActual = LocalDate.now();
            
            // Crear una nueva instancia de Enfermedad utilizando el constructor
            Enfermedad enfermedad = new  Enfermedad(enf, fechaconcepcion, fechaActual);
            
            // Agregar la nueva enfermedad al expediente médico del paciente
            expe.agregarEnfermedad(enfermedad);
            // Mensaje de confirmación
            //System.out.println("Enfermedad añadida");
        } else {
            // Si el expediente médico del paciente es nulo, no se puede agregar la enfermedad
            //System.out.println("El expediente del paciente es nulo");
        }
    }
    /**
 * Muestra el expediente médico de un paciente seleccionado, incluyendo detalles como tipo de sangre e historial de enfermedades.
 * 
 * @param pacienteSeleccionado El paciente del que se mostrará el expediente médico.
 */
    public void mostrarExpedienteMedico(Paciente pacienteSeleccionado) {
        String datos;
             // Obtener el expediente médico del paciente seleccionado
            ExpedienteMedico expediente = pacienteSeleccionado.obtenerExpediente();
            if (expediente != null) {
                // Mostrar el nombre del paciente y el tipo de sangre
                datos=("Expediente Médico del Paciente: "+ pacienteSeleccionado.getNom());
                Controlador.MandarDatos(datos);
                datos=("Tipo de Sangre: " + expediente.getSangre());
                Controlador.MandarDatos(datos);
                datos=("Ingresado:" + expediente.getIngresado());
                Controlador.MandarDatos(datos);
               // Obtener el historial de enfermedades del expediente médico
                ArrayList<Enfermedad> enfermedades = expediente.getEnfermedades();
                for (Enfermedad enfermedad : enfermedades) {
                    System.out.println("- Nombre: Problema" + enfermedad.getNombreEnf());
                    System.out.println("  Gravedad: " + enfermedad.obtenerGravedad());
                    System.out.println("  Fecha de Concepción: " + enfermedad.getFechaConcepcion());
                    System.out.println("  Fecha de Tratamiento: " + enfermedad.getFechaTratamiento());
                }
            } else {
                System.out.println("El paciente no tiene un expediente médico registrado.");
            }
        } 
    
           /**
     * Imprime una factura para un tratamiento de una enfermedad específica, incluyendo su precio.
     * 
     * @param enfermedad La enfermedad para la que se va a generar la factura.
     */
    public void imprimirFactura(String enfermedad) {
        // Definir el precio del tratamiento para cada enfermedad
        double precioTratamiento = 0.0;
        String datos;
    
        // Utilizar un switch para asignar el precio correspondiente a cada enfermedad
        switch (enfermedad.toLowerCase()) {
            case "aparato_digestivo":
                precioTratamiento = 50.0;
                break;
            case "cardiología":
                precioTratamiento = 100.0;
                break;
            case "cirugía_general":
                precioTratamiento = 200.0;
                break;
            case "dermatología":
                precioTratamiento = 80.0;
                break;
            case "medicina_interna":
                precioTratamiento = 70.0;
                break;
            case "oncología":
                precioTratamiento = 300.0;
                break;
            case "oftalmología":
                precioTratamiento = 90.0;
                break;
            case "psiquiatría":
                precioTratamiento = 120.0;
                break;
            case "traumatología":
                precioTratamiento = 150.0;
                break;
            default:
                precioTratamiento = 20.0; // Precio por defecto
                break;
        }
        
        // Imprimir la factura con los detalles del tratamiento y su precio
        datos=("Factura para la enfermedad: " + enfermedad);
        Controlador.MandarDatos(datos);
        datos=("Tratamiento: " + Enfermedad.obtenerTratamiento(enfermedad));
        Controlador.MandarDatos(datos);
        datos=("Precio del tratamiento: " + precioTratamiento + " euros");
        Controlador.MandarDatos(datos);
        Controlador.MandarDatos(""); // Agregar una línea en blanco después de la factura
    }
}
