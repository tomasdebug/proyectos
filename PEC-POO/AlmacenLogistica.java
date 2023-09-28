import java.util.*;

/**
 * Guardar y gestionar empresas de logistica
 */
public class AlmacenLogistica
{
    private ArrayList<EmpresaLogistica> empresas;

    public AlmacenLogistica() {
        empresas = new ArrayList<>();
        empresas.add(new EmpresaLogistica("DHL", 0.05));
        empresas.add(new EmpresaLogistica("Maersk Line", 0.01));
        empresas.add(new EmpresaLogistica("MSC", 0.02));
        empresas.add(new EmpresaLogistica("Agility Logistics", 0.1));
        empresas.add(new EmpresaLogistica("UPS", 0.03));
    }

    public void addEmpresa(EmpresaLogistica emp) {
        empresas.add(emp);
    }

    public static double realizarLogística(EmpresaLogistica granLog, EmpresaLogistica peqLog, Producto p, int km, int kg) {
        double coste = 0;
        if(p.esPerecedero()) {
            while(kg >= 1000) {
                if(km >= 100) {
                    coste += granLog.realizarGranLogistica(p, (int)(km/100)*100, 1000);
                    coste += peqLog.realizarPeqLogistica(km%100, 1000);
                } else {
                    coste += peqLog.realizarPeqLogistica(km, 1000);
                }
                kg -= 1000;
            }
            if(km >= 100) {
                coste += granLog.realizarGranLogistica(p, (int)(km/100)*100, kg);
                coste += peqLog.realizarPeqLogistica(km%100, kg);
            } else {
                coste += peqLog.realizarPeqLogistica(km, kg);
            }
        } else {
            while(kg >= 1000) {
                while(km >= 50) {
                    coste += granLog.realizarGranLogistica(p, 50, 1000);
                    km -= 50;
                }
                coste += peqLog.realizarPeqLogistica(km, 1000);
                kg -= 1000;
            }
            while(km >= 50) {
                coste += granLog.realizarGranLogistica(p, 50, kg);
                km -= 50;
            }
            coste += peqLog.realizarPeqLogistica(km, kg);
        }
        return coste;
    }
    
    public ArrayList<EmpresaLogistica> getEmpresas(){
        return empresas;
    }
    
    /**
     * Obtener una empresa del arraylist
     *
     * @param   nombre   nombre de la empresa buscada
     */
    public EmpresaLogistica getEmpresa(String nombre)
    {
        for (EmpresaLogistica empresa : empresas){ //recorremos el arraylist
            if (empresa.getNombre().equals(nombre)) { 
                //si coincide con la empresa buscada, se devuelve el objeto
                return empresa;
            }
        }
        return null; //si no se encuentra, se devuelve null
    }
}
