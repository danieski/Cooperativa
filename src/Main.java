import com.sun.source.tree.SwitchTree;

import java.awt.image.ImagingOpException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;


public class Main {



    private static ArrayList<Producto> listaProductos = new ArrayList<>();
    private static ArrayList<Productor> listaProductores = new ArrayList<Productor>();
    private static ArrayList<Federacion> listaFederados = new ArrayList<Federacion>();
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static ArrayList<Pedidos> listaPedidos = new ArrayList<>();

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        System.out.println(c.getTime());

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



        ArrayList<Pedidos> pedidoPinkman = new ArrayList<>();
        pedidoPinkman.add(new Pedidos(listaProductos.get(1),40,50,false,1));
        //Filling list of clients for testing
        ArrayList<Pedidos> pedidoWW = new ArrayList<>();
        pedidoWW.add(new Pedidos(listaProductos.get(0),340,3000,false,4));
        ArrayList<Pedidos> pedidoMIA = new ArrayList<>();
        pedidoMIA.add(new Pedidos(listaProductos.get(2),10,100,false,6));
        pedidoMIA.add(new Pedidos(listaProductos.get(0),10,100,false,6));
        listaClientes.add(new Consumidor("Jessie Pinkman",pedidoPinkman));
        listaClientes.add(new Distribuidor("Walter White", pedidoWW));
        listaClientes.add(new Consumidor("Mia Kalifa", pedidoMIA));
        listaClientes.add(new Consumidor("Franco", pedidoWW));
        listaClientes.add(new Consumidor("Ezeka", pedidoMIA));
        //getMonthPurchase(1);
        //getProductList1();

        menuPrincipal();

    }

    public static ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public static ArrayList<Productor> getListaProductores() {
        return listaProductores;
    }

    public static ArrayList<Federacion> getListaFederados() {
        return listaFederados;
    }

    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public static void menuPrincipal(){
        boolean fin=true;
        do {
            System.out.println("Menu:");
            System.out.println("1. Agregar un producto");
            System.out.println("2. Agregar un productor");
            System.out.println("3. Crear una federacion");
            System.out.println("4. Mostrar productos");
            System.out.println("5. Mostrar productores");
            System.out.println("6. Mostrar federaciones");
            System.out.println("7. Crear Pedido");
            System.out.println("8. Mostrar Pedidos");
            System.out.println("9. Salir");
            System.out.println("10. TestButton");
            System.out.println("Selecciona Opcion: ");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    break;
                case 2:
                    Productor.agregarProductor();
                    break;
                case 3:
                    listaFederados.add(Federacion.crearFederacion());
                    break;
                case 4:
                    Producto.mostrarProductos();
                    break;
                case 5:
                    Productor.mostrarProductores();
                    break;
                case 6:
                    Federacion.mostrarFederados();
                    break;
                case 7:
                    crearPedido();
                    break;
                case 8:
                    mostrarPedidos();
                    break;
                case 9:
                    fin=false;
                    break;
                case 10:
                    //intervaloDeTiempo(0,3);
                    //topCustumer();
                    pedidosListFix();
                    topProducts();
                    fin=false;
                    break;
            }
        }while(fin);
    }
    public static void mostrarPedidos(){
        int idPedido=0;
        System.out.println("Lista Pedidos:");
        for (Cliente mostrarCliente:listaClientes
             ) {
            System.out.println("-------Client Details-------");
            System.out.println("Client name:" + mostrarCliente.getNombre());

        for (Pedidos mostrarPedidos:mostrarCliente.getPedidosCliente()
             ) {
            System.out.println("Date: " + mostrarPedidos.getMonth());
            System.out.println("-------Delivery Details-------");
            System.out.println("ID: " +idPedido);
            idPedido++;
            System.out.println("Product: " + mostrarPedidos.getProducto().getNombre());
            System.out.println("Kg: " + mostrarPedidos.getKgContratados());
            System.out.println("Distance: " + mostrarPedidos.getDistancia());
            System.out.println("Espress: " + mostrarPedidos.isEsExpress());

            System.out.println("-------Costs-------");
            System.out.println("Transport costs: " + Pedidos.calcularLogisticaPedido(mostrarPedidos) + "€");
            System.out.println("Product sell price: " + Pedidos.calcularPrecioProducto(mostrarPedidos) + "€");
            System.out.println("");
            }
        }
    }
    public static void crearPedido(){


        boolean express=false;
        ArrayList<Pedidos> nuevoPedido = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Costumer Name: ");
        String nameCostumer = scanner.nextLine();

        Producto.mostrarProductos();
        System.out.print("Choose product id: ");
        int productId = scanner.nextInt();
        System.out.print("Distance: ");
        int distance = scanner.nextInt();
        System.out.print("KG: ");
        int kg = scanner.nextInt();
        System.out.print("Option express? 1=yes 2=no): ");
        int userOption = scanner.nextInt();

        if (userOption==1) {
            express = true;
        } else if (userOption==2) {
            express = false;
        } else {
            System.out.println("Invalid option: ");
        }

        nuevoPedido.add(new Pedidos(listaProductos.get(productId),distance,kg,express,Calendar.MONTH));
        listaPedidos.addAll(nuevoPedido);
        listaClientes.add(new Distribuidor(nameCostumer,nuevoPedido));
    }

    public static void calcularCosechaTotal(int idProducto, double hectareasAumentadas){
        Producto productoSelecciondao = listaProductos.get(idProducto);
        double cosechaTotalActual=productoSelecciondao.getCosechaTotal();
        double cosechaNueva=cosechaTotalActual+hectareasAumentadas*productoSelecciondao.getRendimientoHectarea();
        productoSelecciondao.setCosechaTotal(cosechaNueva);
    }
    public static void getMonthPurchase(int month){
        for (Cliente custumerName:listaClientes
             ) {
            for (Pedidos purchaseCustumer: custumerName.getPedidosCliente()
                 ) {
                if (purchaseCustumer.getMonth() == month){
                    System.out.println("Custumer name from that month: " + custumerName.getNombre());
                    System.out.println("Es pedecedero: " + purchaseCustumer.getProducto().isEsPerecedero());

                }
            }
        }
        System.out.println();
    }
    public static void getProductList1 (){
        for (Producto producto:listaProductos
             ) {
            //Read product list
            System.out.println(producto.getNombre());

            for (Productor productor:listaProductores
                 ) {
               //Read Productores list
                //if productor has the producto we are looking
                for (Hectareas productor1:productor.getHectareas()
                     ) {
                    if (productor1.getProducto().equals(producto)){
                        System.out.println(productor.getNombre() + productor.getClass());
                    }
                }

            }
        }
    }
    public static void intervaloDeTiempo(int initial,int finish) {
        double calculo = 0;
        for (Cliente cliente : listaClientes
        ) {


        for (Pedidos pedido : cliente.getPedidosCliente()
          ) {
              if (pedido.getMonth() >= initial && pedido.getMonth() <= finish) {
                    calculo += Pedidos.calcularLogisticaPedido(pedido);

                }
            }
        }
        System.out.println(calculo);
    }
    public static void topCustumer() throws IndexOutOfBoundsException {
        double spent = 0;
        ArrayList<clientSpent> listClientSpent = new ArrayList<>();


        for (Cliente c:listaClientes
             ) {
            //Entramos dentro de la lista clientes
            //Revisamos la lista

            for (Pedidos p : c.getPedidosCliente()
                 ) {

                spent += Pedidos.calcularLogisticaPedido(p);

            }
            listClientSpent.add(new clientSpent(c,spent));

        }
            Collections.sort(listClientSpent);
        for (int i = 0; i<=4;i++){
            System.out.println(listClientSpent.get(i).getClient().getNombre());
            System.out.println(listClientSpent.get(i).getSpent());
        }

    }
    public static void pedidosListFix(){
        for (Cliente c:listaClientes
             ) {
            listaPedidos.addAll(c.getPedidosCliente());
        }
    }
    public static void topProducts() throws IndexOutOfBoundsException {
        ArrayList<ProductSold> psList=new ArrayList<>();
        double counter =0;
        for (Producto producto:listaProductos
             ) {


                for (Pedidos p:listaPedidos
                     ) {
                    if(p.getProducto().equals(producto)){
                        counter+=p.getKgContratados();
                    }
                }
                psList.add(new ProductSold(producto,counter));
                counter=0;

        }
    //Show the list
        Collections.sort(psList);
        try {
            for (int i = 0; i <= 4; i++) {
                System.out.println(psList.get(i).getProduct().getNombre());
                System.out.println(psList.get(i).getKgSold());
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Thats it");
        }
    }


}
