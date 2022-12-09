package app;

public class Smartphones extends ElectricProduct {
    public Smartphones(String type, String brand, String model, double price, int code, int inStock) {
        super(type,brand, model, price, code, inStock);
    }

    public Smartphones() {
    }

    public String toString() {
        return super.toString();
    }
}
