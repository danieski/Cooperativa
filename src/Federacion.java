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
}
