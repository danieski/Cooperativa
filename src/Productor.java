import java.util.ArrayList;
import java.util.Scanner;

public class Productor {
    private String nombre;
    private static ArrayList<Productor> listaProductores = new ArrayList<Productor>();
    private ArrayList<Hectareas> hectareas;

    public Productor(String nombre,ArrayList<Hectareas> hectareas) {
        this.nombre = nombre;
        this.hectareas=hectareas;
    }

    public String getNombre() {
        return nombre;
    }

    public static ArrayList<Productor> getListaProductores() {
        return listaProductores;
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

            hectareas.add(crearHectarea(Producto.getListaProductos().get(idProducto), cantidadHectareas));
            System.out.println("Agregar otro producto? 1=Si 2=No");
            decision = scanner.nextInt();

        } while (decision == 1);
        return hectareas;
    }
    public static void agregarProductores(Productor productor) {

        listaProductores.add(productor);

    }
    public static Productor agregarProductor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre del productor:");
        String nombre = scanner.nextLine();
        return new Productor(nombre,agregarHectareas());
    }
    public static void mostrarProductores() {
        int id = 0;
        // Recorremos la lista de productores
        for (Productor productor : getListaProductores()) {
            System.out.println(productor.getNombre());
            for (Hectareas productoHectareas: productor.hectareas
                 ) {
                System.out.println(productoHectareas.getProducto().getNombre() + " " + productoHectareas.getHectareas());
            }
        }
    }
}