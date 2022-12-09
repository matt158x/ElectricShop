package app;
import app.User.Role;

public class UserDB {
    private User[] users = new User[2];
    private static final UserDB instance = new UserDB();

    private UserDB() {
        this.users[0] = new User("admin", "eb0468abcd9f88e9844fd140fbb6acff", Role.ADMIN);
        this.users[1] = new User("mateusz", "6fff9bb96e12805ea3ccb8ec27e8206f", Role.USER);
    }

    public User[] getUsers() {
        return this.users;
    }

    public User findByLogin(String login) {
        User[] var2 = this.users;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            User user = var2[var4];
            if (user.getLogin().equals(login)) {
                return user;
            }
        }

        return null;
    }

    public void addUser(User user) {
        User[] newUsers = new User[this.users.length + 1];

        for(int i = 0; i < this.users.length; ++i) {
            newUsers[i] = this.users[i];
        }

        newUsers[newUsers.length - 1] = user;
        this.users = newUsers;
    }

    public boolean changeUserRole(String login, String role) {
        User[] var3 = this.users;
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            User user = var3[var5];
            if (user.getLogin().equals(login)) {
                user.setRole(Role.valueOf(role));
                return true;
            }
        }

        return false;
    }

    public static UserDB getInstance() {
        return instance;
    }
}
