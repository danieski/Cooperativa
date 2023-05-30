import java.util.ArrayList;

public class Producto {
    private String nombre;
    private double rendimientoHectarea;
    private double cosechaTotal;

    public Producto(String nombre,double rendimientoHectarea,double cosechaTotal) {

        this.nombre = nombre;
        this.rendimientoHectarea=rendimientoHectarea;
        this.cosechaTotal=cosechaTotal;
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
