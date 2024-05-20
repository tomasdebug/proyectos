package Media;

import java.util.ArrayList;
import java.time.*;
/**
 * Clase ExpedienteMedico donde se guardan las enfermedades del paciente y otras caracterisiticas de este
 */

public class ExpedienteMedico {
    // Enumeración de los tipos de sangre posibles
    public enum TipoSangre {
        A_POSITIVO,
        A_NEGATIVO,
        B_POSITIVO,
        B_NEGATIVO,
        AB_POSITIVO,
        AB_NEGATIVO,
        O_POSITIVO,
        O_NEGATIVO,
    }
    private boolean ingresado;
    private TipoSangre sangre;
    protected ArrayList<Enfermedad> enfermedades;
    /**
     * Constructor 
     * @param sangre = tipo de sangre que tiene el paciente
     * @param enfermedad=la enfermedad que tiene el paciente
     */

    public ExpedienteMedico(TipoSangre sangre, Enfermedad enfermedad) {
        this.sangre = sangre;
        this.enfermedades = new ArrayList<>();
        this.enfermedades.add(enfermedad);
    }
     /**
         * Constructor 
         * @param sangre = tipo de sangre que tiene el paciente
         * @param lisenfermedades=la lista de enfermedad que tiene el paciente
         */
    public ExpedienteMedico(TipoSangre sangre, ArrayList<Enfermedad> lisEnfermedades) {
        this.sangre = sangre;
        this.enfermedades = lisEnfermedades;
    }
     /**
     * Getter para sacar el tipo de sangre que tiene el paciente 
     */
    public TipoSangre getSangre() {
        return sangre;
    }
    /**
     * Getter para sacar las enfermedades del paciente
     */
    public ArrayList<Enfermedad> getEnfermedades() {
        return enfermedades;
    }
    /**
     * Getter para comprobar si el paciente se encuentra ingresado actualmente
     */
    public void setIngresado(boolean ing){
    
        ingresado=ing;
    }
    /**
     * Getter para comprobar si el paciente se encuentra ingresado actualmente
     */
    public boolean getIngresado(){
    
        return ingresado;
    }
    /**
     * Setter para agregar una enfermedad al expediente medico del paciente 
     */
    public void agregarEnfermedad(Enfermedad enfermedad) {
        enfermedades.add(enfermedad);
    }
    /**
     * Setter para eliminar una enfermedad del expediente medico del paciente 
     */
    public void eliminarEnfermedad(Enfermedad enfermedad) {
        enfermedades.remove(enfermedad);
    }
}

 