package app;


public final class Tablets extends ElectricProduct {
    public Tablets(String type,String brand, String model, double price, int code, int inStock) {
        super(type, brand, model, price, code, inStock);
    }

    public Tablets() {
    }

    public String toString() {
        return super.toString();
    }
}
