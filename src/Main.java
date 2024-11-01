import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Producto> listaProductos = new ArrayList<>();
    private static ArrayList<Productor> listaProductores = new ArrayList<Productor>();
    private static ArrayList<Federacion> listaFederados = new ArrayList<Federacion>();
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public static void main(String[] args) {

        listaProductos.add(new Producto("Aceite",1,6.2,true,0.5));
        listaProductos.add(new Producto("Manzana",1.2,3.6,true,1));
        listaProductos.add(new Producto("Coco",0.4,4.4,false,1.5));
        ArrayList<Hectareas> hectareasDani = new ArrayList<>();
        hectareasDani.add(new Hectareas(listaProductos.get(0),2));
        listaProductores.add(new ProductorPeque("Dani",hectareasDani));
        ArrayList<Hectareas> hectareasJose = new ArrayList<>();
        hectareasJose.add(new Hectareas(listaProductos.get(0),1.2));
        listaProductores.add(new ProductorPeque("Jose",hectareasJose));
        ArrayList<Hectareas> hectareasPepe = new ArrayList<>();
        hectareasPepe.add(new Hectareas(listaProductos.get(1),3));
        hectareasPepe.add(new Hectareas(listaProductos.get(0),3));
        listaProductores.add(new ProductorPeque("Pepe",hectareasPepe));
        ArrayList<Hectareas> hectareasJuan = new ArrayList<>();
        hectareasJuan.add(new Hectareas(listaProductos.get(2),11));
        listaProductores.add(new ProductorGrande("Juan",hectareasJuan));

        ArrayList<Pedidos> pedidosGus = new ArrayList<>();
        pedidosGus.add(new Pedidos(listaProductos.get(0),180,2000,false));
        listaClientes.add(new Distribuidor("Gustavo Fring",pedidosGus));

        ArrayList<Pedidos> pedidoPinkman = new ArrayList<>();
        pedidoPinkman.add(new Pedidos(listaProductos.get(1),40,50,false));
        listaClientes.add(new Consumidor("Jessie Pinkman",pedidoPinkman));

        System.out.println(calcularLogisticaPedido(pedidosGus.get(0)));
        System.out.println(calcularProductoPedido(pedidosGus.get(0),listaClientes.get(0)));

        System.out.println(calcularLogisticaPedido(pedidoPinkman.get(0)));
        System.out.println(calcularProductoPedido(pedidoPinkman.get(0),listaClientes.get(1)));

    }

    public static void mostrarProductos(){
        int idProducto =0;
        for (Producto nombresProductos: listaProductos
        ) {
            System.out.println(idProducto + " " +nombresProductos.getNombre() + " " + nombresProductos.getCosechaTotal() + " he");
            idProducto++;
        }
    }
    public static Hectareas crearHectarea(Producto producto,double hectareas){
        //Creamos el objeto con los parametros pasados a la funcion
        return new Hectareas(producto,hectareas);
    }
    public static void calcularCosechaTotal(int idProducto, double hectareasAumentadas){
        Producto productoSelecciondao = listaProductos.get(idProducto);
        double cosechaTotalActual=productoSelecciondao.getCosechaTotal();
        double cosechaNueva=cosechaTotalActual+hectareasAumentadas*productoSelecciondao.getRendimientoHectarea();
        productoSelecciondao.setCosechaTotal(cosechaNueva);
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
            calcularCosechaTotal(idProducto,cantidadHectareas);
            hectareas.add(crearHectarea(listaProductos.get(idProducto), cantidadHectareas));
            System.out.println("Agregar otro producto? 1=Si 2=No");
            decision = scanner.nextInt();

        } while (decision == 1);
        return hectareas;
    }

    public static void agregarProductor(){
        double totalHectareas=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre del productor:");
        String nombre = scanner.nextLine();
        ArrayList<Hectareas> hectareasProductor = agregarHectareas();
        for (Hectareas areasProductor:hectareasProductor
             ) {
            totalHectareas+=areasProductor.getArea();
        }
        if(totalHectareas>5){
            listaProductores.add(new ProductorGrande(nombre,hectareasProductor));
        }else {
            listaProductores.add(new ProductorPeque(nombre,hectareasProductor));
        }

    }
    public static void mostrarProductores(ArrayList<Productor> listaProductores) {
        int id = 0;
        // Recorremos la lista de productores
        for (Productor productor : listaProductores) {
            System.out.println(productor.getNombre() + " " +productor.getClass());
            for (Hectareas productoHectareas: productor.getHectareas()
            ) {
                System.out.println(productoHectareas.getProducto().getNombre() + " " + productoHectareas.getArea());
            }
        }
    }
    public static double calcularHectareasTotales(ArrayList<Productor> miembrosFederacion,int idProducto){
        double hectareasTotales = 0;
        for (Productor productorMiembro: miembrosFederacion
        ) {
            for (Hectareas hectareasProductor:productorMiembro.getHectareas()
            ) {
                if(hectareasProductor.getProducto().equals(listaProductos.get(idProducto))) {
                    hectareasTotales += hectareasProductor.getArea();
                }
            }
        }
        return hectareasTotales;
    }
    public static Federacion crearFederacion(){
        double hectareasTotales=0;
        boolean fin=true;
        ArrayList<Productor> miembrosFederacion = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el id del producto: ");
        int idProducto = scanner.nextInt();
        for (Productor productor:listaProductores
             ) {
            if(productor instanceof ProductorPeque){
                for (Hectareas hectareasProductor: productor.getHectareas()){
                    if (hectareasProductor.getProducto().equals(listaProductos.get(idProducto))) {
                        System.out.println("ID: " + listaProductores.indexOf(productor)+ " " + productor.getNombre());
                    }
                }
            }
        }
        do {
            System.out.print("Ingrese el id del productor: ");
            int idProductor = scanner.nextInt();
            miembrosFederacion.add(listaProductores.get(idProductor));
            System.out.print("Desea agregar otro mas? 1=si 2=no");
            int decision = scanner.nextInt();
            if (decision == 2){
                fin=false;
            }
        }while (fin);
        hectareasTotales = calcularHectareasTotales(miembrosFederacion,idProducto);
        if (hectareasTotales>5){
            System.out.println("Superado el limite de hectareas para federacion");
            return null;
        }else {
            return new Federacion("Federacion " + listaProductos.get(idProducto).getNombre(), miembrosFederacion, hectareasTotales);
        }
    }
    public static void mostrarFederados(){
        for ( Federacion nombreFederacion:listaFederados
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
    public static int calcularKmPequeLogisticas(Producto productoPedido,int distanciaPedido){
        int nuemroGrandesLogisticas;
        if(productoPedido.isEsPerecedero()){
            nuemroGrandesLogisticas=distanciaPedido%100;
            return nuemroGrandesLogisticas;
        }else {
            nuemroGrandesLogisticas=distanciaPedido%50;
            return nuemroGrandesLogisticas;
        }
    }
    public static int calcularViajesGranLogisticas(Producto productoPedido,int kmPequeLogistica,int distanciaPedido){

        int numeroGrandesLogisticas;
        if(productoPedido.isEsPerecedero()){
            numeroGrandesLogisticas=(distanciaPedido-kmPequeLogistica)/100;
        }else{
            numeroGrandesLogisticas=(distanciaPedido-kmPequeLogistica)/50;
        }

        return numeroGrandesLogisticas;
    }
    public static double calcularPrecioKmGranLogistica(Pedidos pedido){
        if(pedido.isEsExpress()){
            double preciokm = 0.1;
            return preciokm;
        }else{
            double precioKm = 0.05;
            return precioKm;
        }
    }
    public static double calcularPrecioKmPequeLogistica(Pedidos pedido){
        if(pedido.isEsExpress()){
            double preciokm = 0.05;
            return preciokm;
        }else{
            double precioKm = 0.01;
            return precioKm;
        }
    }
    public static double calcularLogisticaPedido(Pedidos pedido){
        double KgContratados = pedido.getKgContratados();
        double KgAToneladas = KgContratados/1000;
        double precioKg=pedido.getProducto().getPrecioKg();
        int distanciaPedido=pedido.getDistancia();
        Producto productoPedido = pedido.getProducto();
        double precioViajeTonelada=0.5*precioKg*1000;
        int kmPequeLogistica = calcularKmPequeLogisticas(productoPedido,distanciaPedido);
        int kmGranLogistica = distanciaPedido - kmPequeLogistica;
        int numeroGrandesLogisiticas = calcularViajesGranLogisticas(productoPedido,kmPequeLogistica,distanciaPedido);
        double precioToneladaGranLogistica=numeroGrandesLogisiticas*precioViajeTonelada;
        double precioKmGranLogistica=kmGranLogistica*calcularPrecioKmGranLogistica(pedido);
        double precioTotalGranLogistica=(precioToneladaGranLogistica+precioKmGranLogistica)*KgAToneladas;
        double precioTotalPequeLogistica=kmPequeLogistica*KgContratados*calcularPrecioKmPequeLogistica(pedido);
        double precioTotal= precioTotalGranLogistica+precioTotalPequeLogistica;
        return precioTotal;

    }

    public static double calcularProductoPedido(Pedidos pedido,Cliente cliente){
        int kgProducto=pedido.getKgContratados();
        Producto productoPedido = pedido.getProducto();

        if (cliente instanceof Distribuidor){
            double precioProdcuto= kgProducto*productoPedido.getPrecioKg() * 1.05;
            return precioProdcuto;
        }else{
            double precioProdcuto= kgProducto*productoPedido.getPrecioKg() * 1.15;
            return precioProdcuto;
        }

    }


}