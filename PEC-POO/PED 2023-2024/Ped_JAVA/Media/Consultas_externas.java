package Media;
import java.util.*;
import Controlador.Controlador;
import java.time.LocalDateTime;
import java.time.LocalDate;

/**
 * Write a description of class Consultas_externas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Consultas_externas 
{


        /**
         * Constructor for objects of class Consultas_externas
         */
        public Consultas_externas()
        {
       
        }
 
     /**
     * Método para recetar un tratamiento a un paciente en consulta externa.
     * @param p El paciente al que se le recetará el tratamiento.
     * @param admin La instancia de la clase Administracion para acceder a la información y servicios administrativos.
     */
            public void recetarPaciente(Paciente p,Administracion admin){
             Cita c=p.getCita();//Cojo la cita del paciente en cuestion
             LocalDateTime  horadia = LocalDateTime.now();
             int horaActual = horadia.getHour();//Paso la hora actual a int para compararla más tarde
             ArrayList<Medicos_Especialistas> Especialistasdisponibles= admin.SacarLisMedNoOcupados(horaActual);//sacamos los medicos que estan disponibles en esa hora
             ArrayList<Enfermedad> enfermedadesPaciente=p.exp.getEnfermedades();//Preparamos las enfermedades que tiene el paciente
             boolean EncontradoEsp=false;//Nos servirá para saber cuando dejar de buscar
             String datos;
           
                //Recorro a todos los medicos especialistas que tengo y veo si el que necesita está disponible para la enfermedad que tengo
            
             //si tiene cita se le coge inmediatamente
        if(c!=null){
                 int horacita= c.getHoracita();
                 Fecha fechaActual=c.getFechacita();
                 LocalDate FechaActual=fechaActual.getFecha();
                  String nombre_medico=c.getPersonal().getNom();
            if(admin.comprobarCitas(nombre_medico)==true){//Comprobamos que el nombre del medico y el nombre que sale en la cita coincidan
                        Medicos_Especialistas medico = c.getPersonal();
                        String especializacion=medico.getEsp();
                        for(Enfermedad enf:enfermedadesPaciente){//Recorremos las enfermedades del paciente
                              String enfermedadactual=enf.getNombreEnf().toLowerCase();
                            if(especializacion.equals(enfermedadactual)){ // Verificar si la especialización del médico coincide con alguna enfermedad del paciente
                                datos=("El paciente " + p.getNom() + " será tratado por el médico especialista " +nombre_medico + " tratará un problema de "+ enf.getNombreEnf() + " con un "+ enf.obtenerTratamiento(especializacion));
                                Controlador.MandarDatos(datos);
                                enf.setNombreEnf(enfermedadactual + "(tratado)");//tratamos la enfermedad
                                enf.setFechaTratamiento(FechaActual);
                                admin.imprimirFactura(enfermedadactual);//imprimimos la factura de la enfermedad
                                EncontradoEsp=true;//He encontrado al especialista
                                  if(enf.obtenerGravedad().equals("grave")){// obtenemos la gravedad del paciente y si es grave lo encamamos
                                     datos=("Se ha decidido hospitalizar a "+ p.getNom() + " debido a la alta gravedad de la enfermedad que se está tratando ");
                                    Controlador.MandarDatos(datos);
                                    p.setEstado("Encamado en UCI");
                                    UCI.EncamarPaciente(p);  
                                  
                                    enf.setNombreEnf(enfermedadactual + "(en tratamiento,dentro de UCI)");
                                }
                                 if(enf.obtenerGravedad().equals("moderado")){// obtenemos la gravedad del paciente y si es moderado lo encamamos
                                        if(p.getEstado().toLowerCase().equals("encamado en uci")) {
                                        datos=("Se ha decidido hospitalizar a "+ p.getNom() + " debido a la moderada gravedad de la enfermedad que se está tratando ");
                                        Controlador.MandarDatos(datos);
                                        Hospitalizacion.EncamarPaciente(p);  
                                        datos=("Se ha decidido hospitalizar a "+ p.getNom() + " debido a la moderada gravedad de la enfermedad que se está tratando ");
                                    }
                                    enf.setNombreEnf(enfermedadactual + "(en tratamiento,dentro de hospital)");
                                }
                               } 
                        }
                    
                        }
                }
                if(c==null){
                    //sino tiene cita se revisa a los medicos disponibles y hacemos lo mismo que antes
                
                 for(Medicos_Especialistas e:Especialistasdisponibles){//recorremos los medicos que están disponibles
                String especializacion=e.getEsp().toLowerCase();
                 
                  for(Enfermedad enf:enfermedadesPaciente){//recorremos las enfermedades del paciente
                    String enfermedadactual=enf.getNombreEnf().toLowerCase();
                      
                    if(especializacion.equals(enfermedadactual)){//Lo mismo pero con alguien que esté libre en ese momento
                        datos=("El paciente " + p.getNom() + " será tratado por el médico especialista " + e.getNom() + " tratará un problema de "+ enf.getNombreEnf() + " con un "+ enf.obtenerTratamiento(especializacion));
                        Controlador.MandarDatos(datos);
                        admin.imprimirFactura(enfermedadactual);
                        enf.setFechaTratamiento(LocalDate.now());
                        enf.setNombreEnf(enfermedadactual + "(tratado)");
                        EncontradoEsp=true;
                        if(enf.obtenerGravedad().equals("grave")){// obtenemos la gravedad del paciente y si es grave lo encamamos
                            datos=("Se ha decidido hospitalizar a "+ p.getNom() + " debido a la alta gravedad de la enfermedad que se está tratando ");
                            Controlador.MandarDatos(datos);
                            p.setEstado("Encamado en UCI");
                            UCI.EncamarPaciente(p);     
                            enf.setNombreEnf(enfermedadactual + "(en tratamiento,dentro de UCI)");
                                }
                        if(enf.obtenerGravedad().equals("moderado")){// obtenemos la gravedad del paciente y si es moderado lo encamamos
                            if(p.getEstado().toLowerCase().equals("encamado en uci")) {
                                     datos=("Se ha decidido hospitalizar a "+ p.getNom() + " debido a la moderada gravedad de la enfermedad que se está tratando ");
                                     Controlador.MandarDatos(datos);
                                     Hospitalizacion.EncamarPaciente(p);  
                                     datos=("Se ha decidido hospitalizar a "+ p.getNom() + " debido a la moderada gravedad de la enfermedad que se está tratando ");
                                    }
                            enf.setNombreEnf(enfermedadactual + "(en tratamiento,dentro de hospital)");
                                }
                               } 
                }
               
            }
            if(EncontradoEsp=false){
                datos=("No hay especialista disponible");
                Controlador.MandarDatos(datos);
            }
        }
    }
    /**
     * Método para realizar la revisión de un paciente en consulta externa.
     * @param p El paciente que se va a revisar.
     * @param admin La instancia de la clase Administracion para acceder a la información y servicios administrativos.
     */
    public void revisionPaciente(Paciente p,Administracion admin){
         Cita c=p.getCita();//Sacamos la cita
         int horacita= c.getHoracita();//Sacamos la hora de la cita
         ArrayList<Enfermeros> EnfermerosDisponibles= admin.SacarLisEnfNoOcupados(horacita);//Sacamos los enfermerosDisponibles
         ArrayList<Enfermedad> enfermedadesPaciente=p.exp.getEnfermedades();
         Enfermeros enfer=EnfermerosDisponibles.get(0);//cogemos la primera enfermera que veamos disponible
         String datos;
         
         if(enfer!=null){//si tenemos alguna enfermera disponible
             for(Enfermedad enf:enfermedadesPaciente){
                 String nombreEnf=enf.getNombreEnf().toLowerCase();
                if(nombreEnf.contains("(tratado)")){//si ya está tratadose deja
                    
                    datos=("La enfermedad problema de"+ enf.getNombreEnf()+ "que fue tratada el"+enf.getFechaTratamiento() + "está bien");
                    Controlador.MandarDatos(datos);
                    admin.imprimirFactura(enf.getNombreEnf());
                }
                
                }
            
            }
        }
    }
        

