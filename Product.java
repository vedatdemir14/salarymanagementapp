package Objects;

import java.util.Objects;
import java.util.Random;
import FileInputOutput.FileIO;

public class Product {
    private int id;
    private String productName;
    private double price;

    public Product(int id, String productName, double price){
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public Product(Product product) {
        this.id = product.id;
        this.productName = product.productName;
        this.price = product.price;
    }
    public int getProductId() {
        return id;
    }

    public void setProductId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return price;
    }

    public void setProductPrice(double price) {
        this.price = price;
    }

    public Product getRandomProduct(int id,String productName,double price){
        Random rand = new Random();
        int index = rand.nextInt(90);
        return FileInputOutput.FileIO.getProductById(index);

    }






}
