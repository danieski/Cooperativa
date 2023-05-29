import java.util.ArrayList;

public class ProductorPeque extends Productor  {
    private String nombre;
    private ArrayList<Hectareas> hectareas;
    public ProductorPeque(String nombre,ArrayList<Hectareas> hectareas) {
        super(nombre,hectareas);
    }
    public String getNombre() {
        return nombre;
    }
    public ArrayList<Hectareas> getHectareas() {
        return hectareas;
    }
}