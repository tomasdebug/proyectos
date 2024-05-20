package Media;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
    protected LocalDate fecha;
    private String fecha_String;
     /**
     * Constructor de la clase Fecha.
     * 
     * @param fechaString Cadena de texto que representa la fecha en formato "dd/MM/yyyy".
     */
     public Fecha(String fechaString) {
        // Define el formato de la cadena de texto.
        fecha_String=fechaString;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Parsea la cadena de texto en un objeto LocalDate utilizando el formateador definido.
        this.fecha = LocalDate.parse(fechaString, formatter);
    }
       /**
     * getter de la clase fecha
     * 
     * @param fechaString Cadena de texto que representa la fecha en formato "dd/MM/yyyy".
     */
      public LocalDate getFecha() {
        return fecha;
    }
     public String getFecha_String() {
        return fecha_String;
    }

}