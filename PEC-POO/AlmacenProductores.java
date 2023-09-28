import java.util.*;

/**
 * Gestor de productores y almacén de arrays/arraylist
 * Aquí se determina el tipo de productor
 */
public class AlmacenProductores
{
    /********* Registro de productores *********/
    private ArrayList<Productor> prodTotales; //Arraylist que contiene todos los productores grandes y pequeños
    private HashMap<Producto,ProductorFede> prodFedeTotales; //Hashmap que contiene todos los productores federados ligados al producto en cuestión

    /**
     * Constructor para objetos de la clase AlmacenProductores
     */
    public AlmacenProductores()
    {
        prodTotales = new ArrayList<>();
        prodFedeTotales = new HashMap<>();

        /************ Inicialización de productores por defecto ************/        
        //PRODUCTOR: JUAN
        GranProductor juan = new GranProductor("Juan");
        addProductor(juan);
        juan.addProducto(Administracion.almProductos.getProductos()[0],0.5); //aceitunas, 0.5
        juan.addProducto(Administracion.almProductos.getProductos()[1],1); //pistachos, 1
        juan.addProducto(Administracion.almProductos.getProductos()[2],1); //naranjas, 1
        juan.addProducto(Administracion.almProductos.getProductos()[3],0.5); //melocotones, 0.5
        juan.addProducto(Administracion.almProductos.getProductos()[4],1); //melones, 1
        juan.addProducto(Administracion.almProductos.getProductos()[5],1.5); //uvas, 1.5
        juan.addProducto(Administracion.almProductos.getProductos()[6],1); //aceite, 1

        //PRODUCTOR: ANA
        PeqProductor ana = new PeqProductor("Ana");
        addProductor(ana);
        ana.addProducto(Administracion.almProductos.getProductos()[6],1); //aceite, 1
        ana.addProducto(Administracion.almProductos.getProductos()[7],0.5); //ciruelas, 0.5
        ana.addProducto(Administracion.almProductos.getProductos()[8],2); //trigo, 2
        ana.addProducto(Administracion.almProductos.getProductos()[9],1.5); //algodon, 1.5

        //PRODUCTOR: FELIPE
        PeqProductor felipe = new PeqProductor("Felipe");
        addProductor(felipe);
        felipe.addProducto(Administracion.almProductos.getProductos()[4],1); //melones, 1
        felipe.addProducto(Administracion.almProductos.getProductos()[5],2); //uvas, 2
        felipe.addProducto(Administracion.almProductos.getProductos()[6],0.5); //aceite, 0.5

        //PRODUCTOR: ANA Y FELIPE
        ProductorFede anayfelipe = new ProductorFede("Ana y Felipe", Administracion.almProductos.getProductos()[6]);
        addProductorFede(anayfelipe);
        anayfelipe.addProducto(Administracion.almProductos.getProductos()[6],1.5); //aceite, 1.5 -> 1 de parte de Ana y 0.5 de parte de Felipe
        anayfelipe.addProductor(ana);
        anayfelipe.addProductor(felipe);
    }

    /**
     * Añade un productor a la lista de productores totales
     */
    public void addProductor(Productor p){
        prodTotales.add(p);
    }

    /**
     * Añade un productor federado
     */
    public void addProductorFede(ProductorFede p){
        if(!prodFedeTotales.containsKey(p.getProducto())) {
            //si en el hashmap de productores federados no hay ninguno ya creado con ese producto
            //(el cual está asignado dentro de la clase ProductorFeder), entonces se puede crear uno
            prodFedeTotales.put(p.getProducto(), p);
        }
    }

    public void cambiarLimite() {
        int newLimExt = (int)(Math.random()*5+3);
        //El nuevo limite estara entre 3 y 8
        if(Productor.getLimiteExtension() < newLimExt) {
            //Si el limite anterior es mayor que el nuevo limite,
            Productor.setLimiteExtension(newLimExt);
            comprobarGrandesProductores(); //se comprueban los grandes productores (un productor puede ser pequeño ahora)
        } else if(Productor.getLimiteExtension() > newLimExt) { //si no,
            Productor.setLimiteExtension(newLimExt);
            comprobarPequeñosProductores(); //se comprueban los pequeños productores (un pequeño productor puede ser grande ahora)
        }
    }

    private void comprobarGrandesProductores() {
        for(Productor p: prodTotales) {
            //Recorremos todos los productores
            if(p instanceof GranProductor && p.getExtensionTotal() <= Productor.getLimiteExtension()) {
                //Si encontramos un productor de gran productor y resulta que la extension total de ese prodiuctor es <= limite,
                //entonces lo convertimos a pequeño productor
                PeqProductor nprod = new PeqProductor(p.getNombre(), p.getListaProd());
                prodTotales.remove(p);
                prodTotales.add(nprod);
            }
        }
    }

    private void comprobarPequeñosProductores() {
        for(Productor p: prodTotales) {
            //Recorremos todos los productores
            if(p instanceof PeqProductor && p.getExtensionTotal() > Productor.getLimiteExtension()) {
                //Si encontramos un productor de pequeño productor y resulta que la extension total de ese prodiuctor es > limite,
                //entonces lo convertimos a gran productor
                GranProductor nprod = new GranProductor(p.getNombre(), p.getListaProd());
                prodTotales.remove(p);
                prodTotales.add(nprod);
            }
        }
        for (HashMap.Entry<Producto, ProductorFede> prod : prodFedeTotales.entrySet()) {
            //Recorremos todos los pares Key-Value
            prod.getValue().comprobarProductores();
            //comprobamos todos los productores involucrados de cada productor federado y eliminamos los que no sean pequeños productores
        }
    }

    //GETTER

    public ArrayList<Productor> getProdTotales(){
        return prodTotales;
    }

    public HashMap<Producto,ProductorFede> getProdFedeTotales(){
        return prodFedeTotales;
    }
    
    /**
     * Obtener un productor del arraylist
     *
     * @param   nombre   nombre del productor buscado
     */
    public Productor getProductor(String nombre)
    {
        for (Productor productor : prodTotales){ //recorremos el arraylist de grandes y pequeños productores
            if (productor.getNombre().equals(nombre)) { 
                //si coincide con el productor buscado, se devuelve el objeto
                return productor;
            }
        }
        for (HashMap.Entry<Producto,ProductorFede> entrada : prodFedeTotales.entrySet()){ //recorremos el arraylist de productores feder.
            if (entrada.getValue().getNombre().equals(nombre)) { 
                //si coincide con el productor buscado, se devuelve el objeto
                return entrada.getValue();
            }
        }
        return null; //si no se encuentra, se devuelve null
    }
}
