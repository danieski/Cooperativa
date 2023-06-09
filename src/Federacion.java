import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Federacion {
    private String nombre;
    ArrayList<Productor> miembrosFederacion;
    private double hectareasTotales;
    public Federacion(String nombre, ArrayList<Productor> miembrosFederacion,double hectareasTotales) {
        this.nombre = nombre;
        this.miembrosFederacion = miembrosFederacion;
        this.hectareasTotales = hectareasTotales;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Productor> getMiembrosFederacion() {
        return miembrosFederacion;
    }

    public double getHectareasTotales() {
        return hectareasTotales;
    }
    public static void mostrarFederados(){
        for ( Federacion nombreFederacion:Main.getListaFederados()
        ) {
            System.out.println("Nombre: " + nombreFederacion.getNombre());
            ArrayList<Productor> miembrosFederacion1 = nombreFederacion.miembrosFederacion;
            for (Productor miembrosFederacion:miembrosFederacion1
            ) {
                System.out.println(miembrosFederacion.getNombre());
            }
            System.out.println("Hectareas totales: " + nombreFederacion.getHectareasTotales());
        }
    }

    public static Federacion crearFederacion(){
        double hectareasTotales=0;
        boolean fin=true;
        ArrayList<Productor> miembrosFederacion = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el id del producto: ");
        int idProducto = scanner.nextInt();
        for (Productor productor:Main.getListaProductores()
        ) {
            if(productor instanceof ProductorPeque){
                for (Hectareas hectareasProductor: productor.getHectareas()){
                    if (hectareasProductor.getProducto().equals(Main.getListaProductos().get(idProducto))) {
                        System.out.println("ID: " + Main.getListaProductores().indexOf(productor)+ " " + productor.getNombre());
                    }
                }
            }
        }
        do {
            System.out.print("Ingrese el id del productor: ");
            int idProductor = scanner.nextInt();
            miembrosFederacion.add(Main.getListaProductores().get(idProductor));
            System.out.print("Desea agregar otro mas? 1=si 2=no");
            int decision = scanner.nextInt();
            if (decision == 2){
                fin=false;
            }
        }while (fin);
        hectareasTotales = Hectareas.calcularHectareasTotales(miembrosFederacion,idProducto);
        if (hectareasTotales>5){
            System.out.println("Superado el limite de hectareas para federacion");
            return null;
        }else {
            return new Federacion("Federacion " + Main.getListaProductos().get(idProducto).getNombre(), miembrosFederacion, hectareasTotales);
        }
    }

}

