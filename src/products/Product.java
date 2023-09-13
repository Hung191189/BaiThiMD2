package products;

public class Product {
   private int code;
   private String name;
   private double price;
   private int quantity;
   private String status;

    public Product(){

    }
    public Product(int code, String name, double price, int quantity, String status){
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  code + ","+
                 name  + ","+
                price + ","+
                quantity + ","+
               status
               ;
    }
}
