import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Producto> listaProductos = new ArrayList<>();
    private static ArrayList<Productor> listaProductores = new ArrayList<Productor>();
    public static void main(String[] args) {

        listaProductos.add(new Producto("Platano"));
        listaProductos.add(new Producto("Manzana"));
        listaProductores.add(agregarProductor());
        mostrarProductores(listaProductores);

    }
    public static void mostrarProductos(){
        int idProducto =0;
        for (Producto nombresProductos: listaProductos
        ) {
            System.out.println(idProducto + " " +nombresProductos.getNombre());
            idProducto++;
        }
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
        mostrarProductos();
        int decision;
        do {
            System.out.println("Que ID producto:");
            int idProducto = scanner.nextInt();
            System.out.println("Cantidad en hectareas:");
            double cantidadHectareas = scanner.nextDouble();

            hectareas.add(crearHectarea(listaProductos.get(idProducto), cantidadHectareas));
            System.out.println("Agregar otro producto? 1=Si 2=No");
            decision = scanner.nextInt();

        } while (decision == 1);
        return hectareas;
    }
    public static Productor agregarProductor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre del productor:");
        String nombre = scanner.nextLine();
        return new Productor(nombre,agregarHectareas());
    }
    public static void mostrarProductores(ArrayList<Productor> listaProductores) {
        int id = 0;
        // Recorremos la lista de productores
        for (Productor productor : listaProductores) {
            System.out.println(productor.getNombre());
            for (Hectareas productoHectareas: productor.getHectareas()
            ) {
                System.out.println(productoHectareas.getProducto().getNombre() + " " + productoHectareas.getHectareas());
            }
        }
    }
}