package app;
public final class Laptops extends ElectricProduct {
    public Laptops(String type, String brand, String model, double price, int code, int inStock) {
        super(type,brand, model, price, code, inStock);
    }

    public Laptops() {
    }


    public String toString() {
        return super.toString();
    }
}
