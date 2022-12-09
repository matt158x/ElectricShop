package app;

public class ElectricProductDB {
    private ElectricProduct[] electricProducts = new ElectricProduct[8];
    private static final ElectricProductDB instance = new ElectricProductDB();

    public ElectricProductDB() {
        this.electricProducts[0] = new Laptops("Laptop","Hp", "Omen", 1200, 1118372, 4);
        this.electricProducts[1] = new Laptops("Laptop","Lenovo", "Legion", 1000, 1503222, 8);
        this.electricProducts[2] = new Laptops("Laptop","Asus", "RogStrix", 1600, 1530412, 3);
        this.electricProducts[3] = new Desktops("Desktop", "Dell","W20", 2050, 2153291, 2);
        this.electricProducts[4] = new Smartphones("Smartphone", "Apple","14", 1500, 5201204, 11);
        this.electricProducts[5] = new Tablets("Tablet", "Lenovo","M10", 400, 5932912, 5);
        this.electricProducts[6] = new Smartwatches("Smartwatch", "Apple","5", 700, 1594391, 9);
        this.electricProducts[7] = new Smartwatches("Smartwatch", "Xiaomi","mi band 5", 200, 3494153, 5);

    }

    public ElectricProduct[] getElectricProducts() {
        return this.electricProducts;
    }

    public boolean buyVehicle(int code, int amount) {
        ElectricProduct[] var3 = this.electricProducts;
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            ElectricProduct electricProduct = var3[var5];
            if (electricProduct.getCode() == code) {
                if (electricProduct.getInStock() >= amount) {
                    electricProduct.setInStock(electricProduct.getInStock() - amount);
                    return true;
                }

                if (electricProduct.getInStock() < amount) {
                    System.out.println("You can buy " + electricProduct.getInStock() + " pieces of this product at the moment");
                }

            }
        }

        return false;
    }

    public void addElectricProduct(ElectricProduct electricProduct) {
        ElectricProduct[] newElectricProducts = new ElectricProduct[this.electricProducts.length + 1];

        for(int i = 0; i < this.electricProducts.length; ++i) {
            newElectricProducts[i] = this.electricProducts[i];
        }

        newElectricProducts[newElectricProducts.length - 1] = electricProduct;
        this.electricProducts = newElectricProducts;
    }

    public boolean addStock(int code, int amount) {
        for(ElectricProduct electricProduct : this.electricProducts) {
            if(electricProduct.getCode() == code ){
                electricProduct.setInStock(electricProduct.getInStock() + amount);
                return true;
            }

        }
        return false;
    }


    public static ElectricProductDB getInstance() {
        return instance;
    }
}
