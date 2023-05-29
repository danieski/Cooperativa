import java.util.ArrayList;

public class Producto {
    private static ArrayList<Producto> listaProductos = new ArrayList<>();
    private String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public static void agregarProducto(){
        listaProductos.add(new Producto("Tomates"));
        listaProductos.add(new Producto("Patatas"));
    }
    public static void mostrarProductos(){
        int idProducto =0;
        for (Producto nombresProductos: listaProductos
             ) {
            System.out.println(idProducto + " " +nombresProductos.getNombre());
            idProducto++;
        }
    }

}
