import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private ArrayList<Pedidos> pedidosCliente;
    public Cliente(String nombre, ArrayList<Pedidos> pedidosCliente) {
        this.nombre = nombre;
        this.pedidosCliente = pedidosCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pedidos> getPedidosCliente() {
        return pedidosCliente;
    }
}
