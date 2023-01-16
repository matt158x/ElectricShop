package app;

import java.util.LinkedList;
import java.util.List;

public class ElectricProductDB {
    private List <ElectricProduct> electricProducts = new LinkedList<>();
    private static final ElectricProductDB instance = new ElectricProductDB();

    public ElectricProductDB() {
        this.electricProducts.add(new Laptops("Laptop","Hp", "Omen", 1200, 1118372, 4));
        this.electricProducts.add(new Laptops("Laptop","Lenovo", "Legion", 1000, 1503222, 8));
        this.electricProducts.add(new Laptops("Laptop","Asus", "RogStrix", 1600, 1530412, 3));
        this.electricProducts.add(new Desktops("Desktop", "Dell","W20", 2050, 2153291, 2));
        this.electricProducts.add(new Smartphones("Smartphone", "Apple","14", 1500, 5201204, 11));
        this.electricProducts.add(new Tablets("Tablet", "Lenovo","M10", 400, 5932912, 5));
        this.electricProducts.add(new Smartwatches("Smartwatch", "Apple","5", 700, 1594391, 9));
        this.electricProducts.add(new Smartwatches("Smartwatch", "Xiaomi","mi band 5", 200, 3494153, 5));

    }

    public List <ElectricProduct> getElectricProducts() {
        return this.electricProducts;
    }

    public boolean buyVehicle(int code, int amount) {

        /*
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

         */

        return this.electricProducts.stream().filter(s -> s.getCode() == code)
                .filter(s -> s.getInStock() >= amount)
                .map(s -> {
                s.setInStock(s.getInStock() - amount);
                return true;
                })
                .findFirst()
                .orElse(false);
    }

    public void addElectricProduct(ElectricProduct electricProduct) {
       /* ElectricProduct[] newElectricProducts = new ElectricProduct[this.electricProducts.length + 1];

        for(int i = 0; i < this.electricProducts.length; ++i) {
            newElectricProducts[i] = this.electricProducts[i];
        }

        newElectricProducts[newElectricProducts.length - 1] = electricProduct;  */
        this.electricProducts.add(electricProduct);
    }

    public boolean addStock(int code, int amount) {
       /* for(ElectricProduct electricProduct : this.electricProducts) {
            if(electricProduct.getCode() == code ){
                electricProduct.setInStock(electricProduct.getInStock() + amount);
                return true;
            }

        }
        return false;
    }*/

        return this.electricProducts.stream().filter(s -> s.getCode() == code)
                .map(s -> {
                s.setInStock(s.getInStock() + amount);
                return true;
                })
                .findFirst()
                .orElse(false);
    }

    public static ElectricProductDB getInstance() {
        return instance;
    }
}
