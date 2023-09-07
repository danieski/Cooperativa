public class clientSpent implements Comparable<clientSpent>{
    private Cliente client;
    private Double spent;
    public clientSpent(Cliente client,double spent){
        this.client=client;
        this.spent=spent;
    }
    public Cliente getClient(){
        return client;
    }
    public Double getSpent(){
        return spent;
    }
    public int compareTo(clientSpent c){
        if(c.spent>spent){
            return 1;
        }else if (c.spent>spent){
            return 0;
        }else{
            return -1;
        }
    }

}
