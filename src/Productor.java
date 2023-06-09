import java.util.ArrayList;
import java.util.Scanner;

public class Productor {
    private String nombre;
    private ArrayList<Hectareas> hectareas;

    public Productor(String nombre,ArrayList<Hectareas> hectareas) {
        this.nombre = nombre;
        this.hectareas=hectareas;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Hectareas> getHectareas() {
        return hectareas;
    }


    public static void agregarProductor(){
        double totalHectareas=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre del productor:");
        String nombre = scanner.nextLine();
        ArrayList<Hectareas> hectareasProductor = Hectareas.agregarHectareas();
        for (Hectareas areasProductor:hectareasProductor
        ) {
            totalHectareas+=areasProductor.getArea();
        }
        if(totalHectareas>5){
            Main.getListaProductores().add(new ProductorGrande(nombre,hectareasProductor));
        }else {
            Main.getListaProductores().add(new ProductorPeque(nombre,hectareasProductor));
        }

    }
    public static void mostrarProductores() {
        int id = 0;
        // Recorremos la lista de productores
        for (Productor productor : Main.getListaProductores()) {
            System.out.println(productor.getNombre() + " " +productor.getClass());
            for (Hectareas productoHectareas: productor.getHectareas()
            ) {
                System.out.println(productoHectareas.getProducto().getNombre() + " " + productoHectareas.getArea());
            }
        }
    }
}