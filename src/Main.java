public class Main {
    public static void main(String[] args) {
        Producto.agregarProducto();
        Productor.getListaProductores().add(Productor.agregarProductor());
        Productor.mostrarProductores();

    }

}