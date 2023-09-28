import java.util.*;

/**
 * Cliente: Distribuidor o Consumidor final, compran los productos y pagan la logistica
 * Se guardan los registros de pedidos para cada cliente
 */
public class Cliente
{
    public static enum tipo {Distribuidor, Consumidor}
    String nombre;
    tipo cliente;
    public ArrayList<Pedido> regPedidos;
    
    public Cliente(String n, tipo t){
        regPedidos = new ArrayList<>();
        nombre = n;
        cliente = t;
    }
    
    public void addPedido(Pedido p) {
        regPedidos.add(p);
    }
    
    /**
     * Realizar un pedido de parte de un cliente
     * 
     * @param   t   tipo de cliente (Distribuidor / Consumidor)
     * @param   p   producto pedido
     * @param   pr  productor al que se hizo el pedido
     * @param   kg  kilos de producto pedidos
     * @param   km  distancia de la cooperativa al destino
     * @param   eg  empresa que hará la gran logística
     * @param   ep  empresa que hará la pequeña logística
     */
    public Pedido realizarPedido(Producto p, Productor pr, int kg, int km, EmpresaLogistica eg, EmpresaLogistica ep) {
        Pedido ped = new Pedido(cliente, p, pr, kg, km, eg, ep);
        switch(cliente) {
            case Distribuidor:
                if(kg >= 1000 && Administracion.comprobarReservas(pr, p, kg)) {
                    addPedido(ped);
                } else {
                    System.out.println("Error. Un distribuidor debe pedir mínimo 1T de producto o no quedan reservas suficientes en la cooperativa.");
                    return null;
                }
                break;
            case Consumidor:
                if(kg <= 100 && Administracion.comprobarReservas(pr, p, kg)) {
                    addPedido(ped);
                } else {
                    System.out.println("Error. Un consumidor no puede pedir más de 100kg de producto o no quedan reservas suficientes en la cooperativa.");
                    return null;
                }
                break;
        }
        return ped; //se devuelve el pedido 
    }
}
