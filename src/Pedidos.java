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

    public static int calcularKmPequeLogisticas(Producto productoPedido,int distanciaPedido){
        int nuemroGrandesLogisticas;
        if(productoPedido.isEsPerecedero()){
            nuemroGrandesLogisticas=distanciaPedido%100;
            return nuemroGrandesLogisticas;
        }else {
            nuemroGrandesLogisticas=distanciaPedido%50;
            return nuemroGrandesLogisticas;
        }
    }
    public static int calcularViajesGranLogisticas(Producto productoPedido,int kmPequeLogistica,int distanciaPedido){

        int numeroGrandesLogisticas;
        if(productoPedido.isEsPerecedero()){
            numeroGrandesLogisticas=(distanciaPedido-kmPequeLogistica)/100;
        }else{
            numeroGrandesLogisticas=(distanciaPedido-kmPequeLogistica)/50;
        }

        return numeroGrandesLogisticas;
    }
    public static double calcularPrecioKmGranLogistica(Pedidos pedido){
        if(pedido.isEsExpress()){
            double preciokm = 0.1;
            return preciokm;
        }else{
            double precioKm = 0.05;
            return precioKm;
        }
    }
    public static double calcularPrecioKmPequeLogistica(Pedidos pedido){
        if(pedido.isEsExpress()){
            double preciokm = 0.05;
            return preciokm;
        }else{
            double precioKm = 0.01;
            return precioKm;
        }
    }
    public static double calcularLogisticaPedido(Pedidos pedido){
        double KgContratados = pedido.getKgContratados();
        double KgAToneladas = KgContratados/1000;
        double precioKg=pedido.getProducto().getPrecioKg();
        int distanciaPedido=pedido.getDistancia();
        Producto productoPedido = pedido.getProducto();
        double precioViajeTonelada=0.5*precioKg*1000;
        int kmPequeLogistica = calcularKmPequeLogisticas(productoPedido,distanciaPedido);
        int kmGranLogistica = distanciaPedido - kmPequeLogistica;
        int numeroGrandesLogisiticas = calcularViajesGranLogisticas(productoPedido,kmPequeLogistica,distanciaPedido);
        double precioToneladaGranLogistica=numeroGrandesLogisiticas*precioViajeTonelada;
        double precioKmGranLogistica=kmGranLogistica*calcularPrecioKmGranLogistica(pedido);
        double precioTotalGranLogistica=(precioToneladaGranLogistica+precioKmGranLogistica)*KgAToneladas;
        double precioTotalPequeLogistica=kmPequeLogistica*KgContratados*calcularPrecioKmPequeLogistica(pedido);
        double precioTotal= precioTotalGranLogistica+precioTotalPequeLogistica;
        return precioTotal;

    }

    public static double calcularProductoPedido(Pedidos pedido,Cliente cliente){
        int kgProducto=pedido.getKgContratados();
        Producto productoPedido = pedido.getProducto();

        if (cliente instanceof Distribuidor){
            double precioProdcuto= kgProducto*productoPedido.getPrecioKg() * 1.05;
            return precioProdcuto;
        }else{
            double precioProdcuto= kgProducto*productoPedido.getPrecioKg() * 1.15;
            return precioProdcuto;
        }

    }
}
