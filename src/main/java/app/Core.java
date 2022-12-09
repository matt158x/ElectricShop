package app;
import app.User.Role;

public class Core {
    final ElectricProductDB electricProductDB = ElectricProductDB.getInstance();
    final UserDB userDB = UserDB.getInstance();
    final Authenticator authenticator = Authenticator.getInstance();
    final GUI gui = GUI.getInstance();
    private static final Core instance = new Core();
    boolean isRunning = false;
    int counter = 0;

    private Core() {
    }

    public void start() {
        boolean isLogged = false;

        String var2;
        byte var3;
        label93:
        while(!isLogged) {
            var2 = this.gui.showLoginMenu();
            var3 = -1;
            switch(var2.hashCode()) {
                case 49:
                    if (var2.equals("1")) {
                        var3 = 0;
                    }
                    break;
                case 50:
                    if (var2.equals("2")) {
                        var3 = 1;
                    }
                    break;
                case 51:
                    if (var2.equals("3")) {
                        var3 = 2;
                    }
            }

            switch(var3) {
                case 0:
                    while(true) {
                        if (this.isRunning || this.counter >= 3) {
                            continue label93;
                        }

                        this.authenticator.authenticate(this.gui.readLoginAndPassword());
                        this.isRunning = this.authenticator.getLoggedUser() != null;
                        if (!this.isRunning) {
                            System.out.println("Not authorized !!");
                        } else {
                            isLogged = true;
                        }

                        ++this.counter;
                    }
                case 1:
                    this.userDB.addUser(this.gui.register());
                    break;
                case 2:
                    isLogged = true;
            }
        }

        while(true) {
            while(this.isRunning) {
                var2 = this.gui.showMenu();
                var3 = -1;
                switch(var2.hashCode()) {
                    case 49:
                        if (var2.equals("1")) {
                            var3 = 0;
                        }
                        break;
                    case 50:
                        if (var2.equals("2")) {
                            var3 = 1;
                        }
                        break;
                    case 51:
                        if (var2.equals("3")) {
                            var3 = 2;
                        }
                        break;
                    case 52:
                        if (var2.equals("4")) {
                            var3 = 3;
                        }
                        break;
                    case 53:
                        if (var2.equals("5")) {
                            var3 = 4;
                        }
                    case 54:
                        if(var2.equals("6")) {
                            var3=5;
                        }
                }

                switch(var3) {
                    case 0:
                        this.gui.listElectricProducts();
                        break;
                    case 1:
                        this.gui.showBuyResult(this.electricProductDB.buyVehicle(this.gui.readCode(), this.gui.readAmount()));
                        break;
                    case 2:
                        this.isRunning = false;
                        break;
                    case 3:
                        if (this.authenticator.getLoggedUser() != null && this.authenticator.getLoggedUser().getRole() == Role.ADMIN) {
                            this.electricProductDB.addElectricProduct(this.gui.readNewElectricProductsData());
                            break;
                        }
                    case 4:
                        if (this.authenticator.getLoggedUser() !=null && this.authenticator.getLoggedUser().getRole() == Role.ADMIN) {
                            this.gui.listElectricProducts();
                            this.gui.showAddStockResult(this.electricProductDB.addStock(this.gui.readCode(),this.gui.readAmount()));
                            break;
                        }
                    case 5:
                        if (this.authenticator.getLoggedUser() != null && this.authenticator.getLoggedUser().getRole() == Role.ADMIN) {
                            this.gui.listUsers();
                            this.gui.showChangeRoleResult(this.userDB.changeUserRole(this.gui.readUser(), this.gui.readRole()));
                            break;
                        }
                    default:
                        System.out.println("Wrong choose !!");
                        break;
                }
            }
        }
    }

    public static Core getInstance() {
        return instance;
    }
}
