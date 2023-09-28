
import java.util.Scanner;
import java.util.HashMap;

/**
 * Clase principal que abrira el menu de la aplicacion de la Cooperativa.
 *
 * @author Leire Arranz Esteban
 */
public class Cooperativa
{

    /**
     * Procedimiento main, muestra un menu.
     * Se muestra desde la perspectiva de que quien maneja el programa es un
     * trabajador de la cooperativa, no un cliente.
     */
    public static void main (String[] args){
        //Inicializamos todos nuestros datos
        char tecla;

        System.out.println("-------------------------------------------\n");
        System.out.println("Bienvenido, por favor, elija una operación: \n");

        do {
            System.out.println("Fecha actual: " + Administracion.fecha.getDay() + "-" + Administracion.fecha.getMonth() + "-" + Administracion.fecha.getYear());
            System.out.println("A - Ayuda");
            // Muestra una pequeña guia para el usuario
            System.out.println("B - Cambiar fecha actual"); 
            // Si se cambia la fecha a otra de otra semana, los precios de los productos
            // cambian
            System.out.println("C - Consultar productos y precios");
            // Se muestra una lista de productos por defecto y sus respectivos precios
            System.out.println("D - Consultar productores");
            // Se muestra una lista de productores por defecto y sus respectivos detalles
            System.out.println("E - Consultar precios/km");
            // Se muestra el precio/km que ofertan las distintas empresas
            System.out.println("F - Añadir pedido");
            // Se añade un pedido nuevo con cierta id (depende del tipo de cliente)
            System.out.println("G - Analizar pedido");
            // Se muestran los beneficios obtenidos por cada uno de los implicados
            // (por id de producto)
            System.out.println("H - Resumen anual");
            // Se muestra un resumen anual con finalidad estadística:
            // • Ventas totales en un periodo determinado de cada uno de los productos de
            // la cooperativa.
            // • Importes totales obtenidos por cada uno de los productores (desglosados
            // por productos) 
            // • Importes obtenidos por cada una de las empresas de logística.
            // • Beneficios de la cooperativa por cada uno de los productos.
            // • Evolución de los precios base de cada producto.

            System.out.println("S - Salir de la aplicación\n");
            System.out.println("-------------------------------------------");
            Scanner scan = new Scanner(System.in);
            tecla = scan.next().trim().charAt(0); /*eliminamos espacios en
            blanco y cogemos el primer caracter del string*/
            switch(tecla){
                case 'A':
                    opcionAyuda();
                    break;
                case 'B':
                    opcionCambiarFecha();
                    break;
                case 'C':
                    opcionMostrarProductos();
                    break;
                case 'D':
                    System.out.println("-------------------------------------------\n");
                    opcionMostrarProductores();
                    System.out.println("\n-------------------------------------------\n");
                    break;
                case 'E':
                    opcionMostrarEmpresas();
                    System.out.println("\n-------------------------------------------\n");
                    break;
                case 'F':
                    opcionAñadirPedido();
                    break;
                case 'G':
                    System.out.println("Inserte programa de la tecla "+ tecla);
                    break;
                case 'H':
                    System.out.println("Inserte programa de la tecla "+ tecla);
                    break;
                case 'S':
                    break;
                default:
                    System.out.println("Seleccione una tecla valida");
                    tecla = scan.next().trim().charAt(0);
            }
        } while (tecla !='S');
    }

    public static void opcionAyuda(){
        //Muestra una pequeña guía de usuario
        System.out.println("-------------------------------------------\n");
        System.out.println("Esta es una aplicación diseñada para la gestión de la coorporativa.\n");
        System.out.println("* Puede revisar la información de productos y sus precios tecleando C.");
        System.out.println("* Si lo que quiere es revisar la información de los productores, teclee D.");
        System.out.println("* Si busca los precios/km que ofrecen nuestras empresas de logística relacionadas, teclee E.");
        System.out.print("* Puede añadir un pedido realizado previamente pulsando la tecla F; sin embargo, se aconseja ");
        System.out.println("cambiar la fecha con anterioridad para su buen funcionamiento. ");
        System.out.println("* Puede realizar esto último pulsando la tecla A.");
        System.out.print("* Al reunir varios pedidos, también tiene la posibilidad de obtener una serie de informes y ");
        System.out.println("estadísticas:");
        System.out.print("* Si pulsa G, podrá ver las ganancias de los productores involucrados en la venta de uno de ");
        System.out.println("sus productos que elija.");
        System.out.print("* Si pulsa H, podrá ver las estadísticas anuales tales como: ventas totales, importes obtenidos, ");
        System.out.println("beneficios o evolución de precios de productos.\n");
        System.out.println("-------------------------------------------\n");
    }

    public static void opcionCambiarFecha(){
        //Cambia la fecha actual y actualiza los precios de los productos
        //Si pasa un año, actualiza el limite
        int dia;
        int mes;
        int anno;
        Scanner scan = new Scanner(System.in);
        System.out.println("-------------------------------------------\n");
        System.out.print("Introduzca el día: ");
        dia = scan.nextInt();
        System.out.print("Introduzca el mes: ");
        mes = scan.nextInt();
        System.out.print("Introduzca el año: ");
        anno = scan.nextInt();
        System.out.println("\n-------------------------------------------\n");
        Fecha nuevaFecha = new Fecha(dia, mes, anno);

        if (Administracion.fecha.getWeekOfTheYear() != nuevaFecha.getWeekOfTheYear()) Administracion.almProductos.cambiarPrecios();

        if (Administracion.fecha.getYear() != nuevaFecha.getYear()) Administracion.almProductores.cambiarLimite();
        Administracion.fecha.setDate(dia,mes,anno);
    }

    public static void opcionMostrarProductos(){
        //Muestra la info de productos
        System.out.println("-------------------------------------------\n");
        int cont=1;
        System.out.println("Nº  PRODUCTO     TIPO             RENDIMIENTO   PRECIO");
        for (Producto producto : Administracion.almProductos.getProductos()) {
            System.out.printf("%-2s  %-11s  %-15s  %-11s   %-5s\n",cont,producto.getNombre(),producto.getTipo(),producto.getRendimiento()+" T/hect.",producto.getPrecio() + " €");
            cont++;
        }
        System.out.println("\n-------------------------------------------\n");
    }

    public static void opcionMostrarProductores(){
        //Muestra info de productos
        int cont=1;
        String tipoProd;
        Producto producto;
        double extensionProd;
        System.out.printf("Limite de extension: %d\n\n", Productor.getLimiteExtension());
        //Primero imprimimos los productores individuales
        System.out.println("Nº  PRODUCTOR    TIPO                EXTENSION TOTAL");
        for (Productor productor : Administracion.almProductores.getProdTotales()) {
            if(productor instanceof GranProductor){
                tipoProd = "Gran Productor";
            } else {
                tipoProd = "Pequeño Productor";
            }

            System.out.printf("%-2s  %-11s  %-18s  %-11s\n", cont, productor.getNombre(), tipoProd, productor.getExtensionTotal()+" hect.");
            System.out.println("....Productos que tiene....");
            if(!productor.getListaProd().isEmpty()) {
                for (HashMap.Entry<Producto, Double> entrada : productor.getListaProd().entrySet()) {
                    //Tomamos todas los pares de entrada K-V y los almacenamos en variables para imprimir después
                    producto = entrada.getKey();
                    extensionProd = entrada.getValue();
                    System.out.printf("%-15s (%s hect., %s t)\n",producto.getNombre(),extensionProd,extensionProd*producto.getRendimiento());
                }
                System.out.println(" ");
            } else {
                System.out.println("Sin productos\n");
            }
            cont++;
        }
        //Luego imprimimos los productores federados

        String prodFeder;
        double extensionConj;
        System.out.println("Nº  PRODUCTOR Y PRODUCTO    TIPO                 EXTENSION TOTAL");
        for (HashMap.Entry<Producto,ProductorFede> entrada : Administracion.almProductores.getProdFedeTotales().entrySet()){
            //Tomamos los pares de entrada Producto y Productor federado y los almacenamos en variables para imprimir después
            producto = entrada.getKey();
            prodFeder = entrada.getValue().getNombre();
            extensionConj = entrada.getValue().getExtensionTotal();
            System.out.printf("%-2s  %-11s (%s)   Productor federado   %s hect. (%s t)\n",cont,prodFeder,producto.getNombre(),extensionConj,extensionConj*producto.getRendimiento());
            System.out.println("....Productores Involucrados....");
            for (PeqProductor productor : entrada.getValue().getProductores()){
                extensionProd = productor.getListaProd().get(entrada.getKey());
                System.out.printf("%-14s  (%s hect., %s t)\n",productor.getNombre(),extensionProd,extensionProd*producto.getRendimiento());
            }
            cont++;
        }
    }

    public static void opcionMostrarEmpresas(){
        //Mostrar empresas y coste/km (diferentes costes de logística
        int cont = 1;
        System.out.println("-------------------------------------------\n");
        System.out.println("Nº  EMPRESA            PRECIO/KM");
        for(EmpresaLogistica empresa : Administracion.almLogistica.getEmpresas()) {
            System.out.printf("%-2s  %-17s  %-9s\n", cont, empresa.getNombre(), empresa.getCosteKm() + " €/Km");
            cont++;
        }
        System.out.println("\nSe puede elegir una empresa diferente para gran y pequeña logística");
    }

    public static void opcionAñadirPedido(){
        Scanner scan = new Scanner(System.in);

        System.out.println("-------------------------------------------\n");
        System.out.println("Nuevo pedido - ID" + Pedido.getUltimaID() + "\n");
        System.out.println("===========================================\n");
        opcionMostrarProductores();
        System.out.println("");
        opcionMostrarEmpresas();
        System.out.println("\n===========================================\n");
        System.out.println("Consumidores (C) pueden comprar hasta 100 Kg");
        System.out.println("Distribuidores (D) tienen que comprar 1000 Kg o más\n");
        System.out.print("Cliente (C/D): ");

        Cliente.tipo t;
        char cliente = scan.next().trim().charAt(0);
        switch(cliente){
            case 'C':
                t = Cliente.tipo.Consumidor;
                break;
            case 'c': //por si se ponen minusculas sin querer, validarlo igual
                t = Cliente.tipo.Consumidor;
                break;
            case 'D':
                t = Cliente.tipo.Distribuidor;
                break;
            case 'd':
                t = Cliente.tipo.Distribuidor;
                break;
            default:
                System.out.println("Error en la seleccion del cliente, tendrá que volver a realizar el pedido");
                return; //nos salimos del metodo
        }
        System.out.print("Producto: ");
        String producto = scan.next().trim();
        Producto productoBuscado = Administracion.almProductos.getProducto(producto);
        if(productoBuscado == null){
            System.out.println("Error buscando producto, revise el nombre e intentelo de nuevo");
            return; //nos salimos del metodo
        }
        System.out.print("Cantidad (kg): ");
        int kg = scan.nextInt(); //luego se comprueba si hay error
        scan.nextLine();
        System.out.print("Productor: ");
        String productor = scan.nextLine();
        Productor productorBuscado = Administracion.almProductores.getProductor(productor);
        if(productorBuscado == null){
            System.out.println("Error buscando productor, revise el nombre e intentelo de nuevo");
            return; //nos salimos del metodo
        }
        System.out.print("Distancia (km): ");
        int km = scan.nextInt();
        scan.nextLine();
        System.out.print("Empresa Gran Log: ");
        String empresaGL = scan.nextLine();
        EmpresaLogistica empresaGLBuscada = Administracion.almLogistica.getEmpresa(empresaGL);
        if(empresaGLBuscada == null){
            System.out.println("Error buscando empresa, revise el nombre e intentelo de nuevo");
            return; //nos salimos del metodo
        }
        System.out.print("Empresa Peq Log: ");
        String empresaPL = scan.nextLine();
        EmpresaLogistica empresaPLBuscada = Administracion.almLogistica.getEmpresa(empresaPL);
        if(empresaPLBuscada == null){
            System.out.println("Error buscando empresa, revise el nombre e intentelo de nuevo");
            return; //nos salimos del metodo
        }
        Pedido ped = null;
        System.out.println(t.name());
        switch(t){ //creamos un pedido y analizamos condiciones segun tipo cliente
            case Consumidor:
                ped = Administracion.cons.realizarPedido(productoBuscado,productorBuscado,kg,km,empresaGLBuscada,empresaPLBuscada);
                break;
            case Distribuidor:
                ped = Administracion.dist.realizarPedido(productoBuscado,productorBuscado,kg,km,empresaGLBuscada,empresaPLBuscada);
                break;
        }
        if(ped == null) return;
        System.out.println("===========================================\n");
        System.out.println("Producto: " + ped.calcularCosteProducto() + " €");
        System.out.println("Logística: " + ped.calcularCosteLogistica() + " €");
        if(ped.calcularIVA() != 0){ //se detecta que es consumidor
            System.out.println("IVA: 10%");
        } else {
            System.out.println("Distribuidores no pagan IVA");
        }
        System.out.println("Total: " + ped.calcularCosteTotal() + " €");
        System.out.println("\n-------------------------------------------\n");
    }
}
