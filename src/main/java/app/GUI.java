package app;
import app.User.Role;
import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;

public class GUI {
    private final Scanner scanner;
    final app.Authenticator authenticator;
    final ElectricProductDB electricProductDB;
    final app.UserDB userDB;
    private static final GUI instance = new GUI();

    private GUI() {
        this.scanner = new Scanner(System.in);
        this.authenticator = app.Authenticator.getInstance();
        this.electricProductDB = ElectricProductDB.getInstance();
        this.userDB = app.UserDB.getInstance();
    }

    public String showMenu() {
        System.out.println("1. Show list electronics products");
        System.out.println("2. Buy electronic product");
        System.out.println("3. Exit");
        if (this.authenticator.getLoggedUser() != null && this.authenticator.getLoggedUser().getRole() == Role.ADMIN) {
            System.out.println("4. Add product");
            System.out.println(("5. Change products inStock"));
            System.out.println("6. Change user's role");

        }

        return this.scanner.nextLine();
    }

    public String showLoginMenu() {
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        return this.scanner.nextLine();
    }

    public void listUsers() {
        for (User user : this.userDB.getUsers()) {
            System.out.println(user);
        }
        }

    public void listElectricProducts() {
        for (ElectricProduct electricProduct : this.electricProductDB.getElectricProducts()) {
            System.out.println(electricProduct);
        }
    }

    public int readCode() {
        System.out.println("Code:");
        return Integer.parseInt(this.scanner.nextLine());
    }

    public String readUser() {
        System.out.println("User:");
        return this.scanner.nextLine();
    }

    public String readRole() {
        System.out.println("Role:");
        return this.scanner.nextLine();
    }

    public int readAmount() {
        System.out.println("Amount:");
        return Integer.parseInt(this.scanner.nextLine());
    }

    public void showBuyResult(boolean result) {
        if (result) {
            System.out.println("Product bought successful");
        } else {
            System.out.println("Product is not available");
        }

    }

    public void showAddStockResult(boolean result) {
        if(result) {
            System.out.println("You filled products in stock");
        } else {
            System.out.println("Incorrect code or amount!");
        }
    }

    public void showChangeRoleResult(boolean result) {
        if (result) {
            System.out.println("Role changed successful");
        } else {
            System.out.println("Bad role or login!");
        }

    }

    public User register() {
        System.out.println("Login:");
        String login = this.scanner.nextLine();
        System.out.println("Password:");
        String password = this.scanner.nextLine();
        return new User(login, DigestUtils.md5Hex(password + Authenticator.getSeed()), Role.USER);
    }

    public User readLoginAndPassword() {
        User user = new User();
        System.out.println("Login:");
        user.setLogin(this.scanner.nextLine());
        System.out.println("Password:");
        user.setPassword(this.scanner.nextLine());
        return user;
    }

    public ElectricProduct readNewElectricProductsData() {
        System.out.println("1. Laptops");
        System.out.println("2. Desktops");
        System.out.println("3. Smartphones");
        System.out.println("4. Tablets");
        System.out.println("5. Smartwatches");

        String choose = this.scanner.nextLine();
        System.out.println("Type:");
        String type= this.scanner.nextLine();
        System.out.println("Brand:");
        String brand = this.scanner.nextLine();
        System.out.println("Model:");
        String model = this.scanner.nextLine();
        System.out.println("Price:");
        double price = Double.parseDouble(this.scanner.nextLine());
        System.out.println("Code:");
        int code = Integer.parseInt(this.scanner.nextLine());
        System.out.println("In stock:");
        int inStock = Integer.parseInt(this.scanner.nextLine());
        byte var27 = -1;
        switch(choose.hashCode()) {
            case 49:
                if (choose.equals("1")) {
                    var27 = 0;
                }
                break;
            case 50:
                if (choose.equals("2")) {
                    var27 = 1;
                }
                break;
            case 51:
                if (choose.equals("3")) {
                    var27 = 2;
                }
                break;
            case 52:
                if (choose.equals("4")) {
                    var27 = 3;
                }
                break;
            case 53:
                if (choose.equals("5")) {
                    var27 = 4;
                }
        }

        switch(var27) {
            case 0:
                return new Laptops(type, brand, model, price, code, inStock);
            case 1:
                return new Desktops(type, brand, model, price, code, inStock);
            case 2:
                return new Tablets(type,brand, model, price, code, inStock);
            case 3:
                return new Smartwatches(type,brand, model, price, code, inStock);
            case 4:
                return new Smartphones(type,brand, model, price, code, inStock);
            default:
                return null;
        }
    }

    public static GUI getInstance() {
        return instance;
    }
}

