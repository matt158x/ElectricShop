package app;

public class ElectricProduct {
    private String type;
    private String brand;
    private String model;
    private double price;
    private int code;
    private int inStock;

    public ElectricProduct() {
    }

    public ElectricProduct(String type, String brand, String model, double price, int code, int inStock) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.code = code;
        this.inStock = inStock;
    }

    public String getType() {return this.type;}

    public void setType(String type) {this.type=type;}

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getInStock() {
        return this.inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String toString() {
        
        return this.getType() + " " + this.getBrand() + " " + this.getModel()  + " Price:" + this.getPrice() + " Code:" + this.getCode() + " In Stock:" + this.getInStock();
    }
}
