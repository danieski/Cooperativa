import java.util.ArrayList;

public class ProductorPeque extends Productor  {
    private String nombre;

    //Creamos una lista de productores peques esta tiene que estar inicializada puesto que va a ir obteniendo objetos productores ya "construidos"
    //private ArrayList<ProductorPeque> listaProductores=new ArrayList<>();

    //La lista de hectareas no esta inicializada porque se construye cuando creamos un Productor Peque
    //Mientras que el Array de Proiductores podemos dejarlo inicializado

    private ArrayList<Hectareas> hectareas;

    //Productor Peque recibe un nombre y un array de hectareas
    public ProductorPeque(String nombre,ArrayList<Hectareas> hectareas) {
        super(nombre,hectareas);

        //this.hectareas=new Arraylist<Hectaria> Lo usuariamos si queremos que el array list puesta esta en Null ya qye se crea en el constructor

    }


    public String getNombre() {
        return nombre;
    }


    public ArrayList<Hectareas> getHectareas() {
        return hectareas;
    }



}
