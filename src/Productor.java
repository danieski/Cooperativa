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
}