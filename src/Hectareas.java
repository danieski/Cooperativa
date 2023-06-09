import java.util.ArrayList;

public class Hectareas {

    private static ArrayList<Hectareas> listaHectareas=new ArrayList<>();
    private ProductorPeque productorPeque;

    private Producto producto;
    private double area;

    public Hectareas(Producto producto, double area) {

        this.producto = producto;
        this.area = area;
    }



    public ProductorPeque getProductorPeque() {
        return productorPeque;
    }

    public void setProductorPeque(ProductorPeque productorPeque) {
        this.productorPeque = productorPeque;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getArea() {
        return area;
    }

}
