public class Pedidos {
    private Producto producto;
    private int distancia;
    private int KgContratados;
    private boolean esExpress;

    public Pedidos(Producto producto, int distancia, int kgContratados, boolean esExpress) {
        this.producto = producto;
        this.distancia = distancia;
        this.KgContratados = kgContratados;
        this.esExpress = esExpress;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getKgContratados() {
        return KgContratados;
    }

    public boolean isEsExpress() {
        return esExpress;
    }
}
