public class ProductSold implements Comparable<ProductSold>{
    private Producto product;
    private double kgSold;

    public ProductSold(Producto product, double kgSold) {
        this.product = product;
        this.kgSold = kgSold;
    }
    public Producto getProduct(){
        return product;
    }

    public double getKgSold() {
        return kgSold;
    }

    @Override
    public int compareTo(ProductSold ps){
        if(ps.kgSold>kgSold){
            return 1;
        } else if (ps.kgSold>kgSold) {
            return  0;
        }else {
            return -1;
        }
    }


}
