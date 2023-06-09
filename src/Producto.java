import java.util.ArrayList;

public class Producto {
    private String nombre;
    private double rendimientoHectarea;
    private double cosechaTotal;
    private boolean esPerecedero;
    private double precioKg;
    public Producto(String nombre,double rendimientoHectarea,double cosechaTotal,boolean esPerecedero,double precioKg) {

        this.nombre = nombre;
        this.rendimientoHectarea=rendimientoHectarea;
        this.cosechaTotal=cosechaTotal;
        this.esPerecedero=esPerecedero;
        this.precioKg=precioKg;
    }

    public boolean isEsPerecedero() {
        return esPerecedero;
    }

    public double getPrecioKg() {
        return precioKg;
    }

    public double getRendimientoHectarea() {
        return rendimientoHectarea;
    }

    public double getCosechaTotal() {
        return cosechaTotal;
    }


    public void setCosechaTotal(double cosechaTotal) {
        this.cosechaTotal = cosechaTotal;
    }

    public String getNombre() {
        return nombre;
    }



}
