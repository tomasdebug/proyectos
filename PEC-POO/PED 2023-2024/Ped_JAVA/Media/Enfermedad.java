package Media;

import java.time.*;
import java.util.*;

/**
 * Write a description of class Enfermedad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enfermedad
{
 
        private String nombre;
        private String tratamiento;
        private String gravedad;
        private LocalDate fechaConcepcion;
        private LocalDate fechaTratamiento;
        /**
         * Constructor de la clase enfermedad.
        */
        public Enfermedad(String nombre, LocalDate fechaConcepcion, LocalDate fechaTratamiento) {
            this.nombre = nombre;
            this.tratamiento = obtenerTratamiento(nombre);
            this.fechaConcepcion = fechaConcepcion;
            this.fechaTratamiento = fechaTratamiento;
            switch (nombre.toLowerCase()) {
                    case "aparato_digestivo":
                         gravedad="moderada";
                         break;
                    case "cardiología":
                        gravedad="grave";
                        break;
                    case "cirugía_general":
                         gravedad="grave";
                         break;
                    case "dermatología":
                        gravedad="leve";
                        break;
                    case "medicina_interna":
                         gravedad="moderada";
                         break;
                    case "oncología":
                         gravedad="grave";
                         break;
                    case "oftalmología":
                        gravedad="leve";
                        break;
                    case "psiquiatría":
                         gravedad="moderada";
                         break;
                    case "traumatología":
                        gravedad="grave";
                        break;
                }
        }
         /**
         * Constructor para "infectar a un paciente" utilizo este constructor para meter enfermedades que no han sido tratadas a un paciente
         * @param Especialidad:String que da la especialidad
         */
         public Enfermedad(String nombre, LocalDate fechaConcepcion) {
            this.nombre = nombre;
            this.tratamiento = obtenerTratamiento(nombre);
            this.fechaConcepcion = fechaConcepcion;
            LocalDate fecha = null; // La fecha aún no se ha establecido
              switch (nombre.toLowerCase()) {
                    case "aparato_digestivo":
                         gravedad="moderada";
                         break;
                    case "cardiología":
                        gravedad="grave";
                        break;
                    case "cirugía_general":
                         gravedad="grave";
                         break;
                    case "dermatología":
                        gravedad="leve";
                        break;
                    case "medicina_interna":
                         gravedad="moderada";
                         break;
                    case "oncología":
                         gravedad="grave";
                         break;
                    case "oftalmología":
                        gravedad="leve";
                        break;
                    case "psiquiatría":
                         gravedad="moderada";
                         break;
                    case "traumatología":
                        gravedad="grave";
                        break;
                }
        }
        /**
         * Metodo para obtener el tratamiento asignado segun la especialidad que requierá la enfermedad
         * @param Especialidad:String que da la especialidad
         */
        public static String obtenerTratamiento(String Especialidad) {
            // Lógica para obtener el tratamiento según la especialidad a la que pertenece
            switch (Especialidad.toLowerCase()) {
                       case "aparato_digestivo":
                    return "Tratamiento con medicamentos y cambios en la dieta.";
                case "cardiología":
                    return "Tratamiento con medicamentos y cambios en el estilo de vida, y en casos graves, cirugía.";
                case "cirugía_general":
                    return "Tratamiento quirúrgico para abordar la afección específica.";
                case "dermatología":
                    return "Tratamiento con cremas y medicamentos tópicos, y en casos graves, procedimientos dermatológicos.";
                case "medicina_interna":
                    return "Tratamiento con medicamentos específicos para la afección y cambios en el estilo de vida.";
                case "oncología":
                    return "Tratamiento con quimioterapia, radioterapia y/o cirugía, dependiendo del tipo y estadio del cáncer.";
                case "oftalmología":
                    return "Tratamiento con medicamentos o cirugía, dependiendo de la afección ocular.";
                case "psiquiatría":
                    return "Tratamiento con terapia cognitivo-conductual, medicamentos psiquiátricos y apoyo psicológico.";
                case "traumatología":
                    return "Tratamiento con reposo, fisioterapia y en casos graves, cirugía para reparar lesiones.";
                default:
                    return "Descanso y paracetamol";
            }
        }
         /**
         * Metodo para obtener la gravedad 
         * @param Especialidad:String que da la especialidad
         */
        public String obtenerGravedad() {
                // Lógica para obtener la gravedad   según la especialidad a la que pertenece
                return gravedad;
        }

         /**
         * Getter del nombre de la enfermedad
         */
         public String getNombreEnf() {
           return nombre;
        }
        /**
         * Getter de la fecha de concepción de la enfermedad
         */
         public LocalDate getFechaConcepcion() {
           return fechaConcepcion;
        }
        /**
         * Getter de la fecha de tratamiento de la enfermedad
         */
         public LocalDate getFechaTratamiento() {
           return fechaTratamiento;
        }
         /**
         * setter del nombre de la enfermedad
         */
         public void setNombreEnf(String nombreenf) {
           nombre=nombreenf;
        }
         /**
         * Setter de la fecha de tratamiento de la enfermedad
         */
         public void setFechaTratamiento(LocalDate fechatrat) {
           fechaTratamiento=fechatrat;
        }
    }

