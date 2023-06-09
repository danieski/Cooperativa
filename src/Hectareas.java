import java.util.ArrayList;
import java.util.Scanner;

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

    public static double calcularHectareasTotales(ArrayList<Productor> miembrosFederacion,int idProducto){
        double hectareasTotales = 0;
        for (Productor productorMiembro: miembrosFederacion
        ) {
            for (Hectareas hectareasProductor:productorMiembro.getHectareas()
            ) {
                if(hectareasProductor.getProducto().equals(Main.getListaProductos().get(idProducto))) {
                    hectareasTotales += hectareasProductor.getArea();
                }
            }
        }
        return hectareasTotales;
    }
    public static Hectareas crearHectarea(Producto producto,double hectareas){
        //Creamos el objeto con los parametros pasados a la funcion
        return new Hectareas(producto,hectareas);
    }
    public static ArrayList<Hectareas> agregarHectareas() {
        Scanner scanner = new Scanner(System.in);
        //Creamos el arraylist, lo nombramos para poder usarlo
        ArrayList<Hectareas> hectareas = new ArrayList<>();
        //agregamos el objeto en el array
        Producto.mostrarProductos();
        int decision;
        do {
            System.out.println("Que ID producto:");
            int idProducto = scanner.nextInt();
            System.out.println("Cantidad en hectareas:");
            double cantidadHectareas = scanner.nextDouble();
            Main.calcularCosechaTotal(idProducto,cantidadHectareas);
            hectareas.add(crearHectarea(Main.getListaProductos().get(idProducto), cantidadHectareas));
            System.out.println("Agregar otro producto? 1=Si 2=No");
            decision = scanner.nextInt();

        } while (decision == 1);
        return hectareas;
    }
}
