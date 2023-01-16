package app;

public final class Smartwatches extends ElectricProduct {
    public Smartwatches(String type,String brand, String model, double price, int code, int inStock) {
        super(type, brand, model, price, code, inStock);
    }

    public Smartwatches() {
    }

    public String toString() {
        return super.toString();
    }
}
