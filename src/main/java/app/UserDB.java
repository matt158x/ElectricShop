package app;
import app.User.Role;

import java.util.ArrayList;
import java.util.List;


public class UserDB {
    private List<User> users = new ArrayList<>();
    private static final UserDB instance = new UserDB();

    private UserDB() {
        this.users.add(new User("admin", "eb0468abcd9f88e9844fd140fbb6acff", Role.ADMIN));
        this.users.add(new User("mateusz", "6fff9bb96e12805ea3ccb8ec27e8206f", Role.USER));
    }

    public List<User> getUsers() {
        return users;
    }

    public User findByLogin(String login) {
        /*
        User[] var2 = this.users;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            User user = var2[var4];
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
*/
        return this.users.stream().filter(s -> s.getLogin().equals(login)).
        findFirst().orElse(null);
    }

    public void addUser(User user) {
        /*
        User[] newUsers = new User[this.users.length + 1];

        for(int i = 0; i < this.users.length; ++i) {
            newUsers[i] = this.users[i];
        }

        newUsers[newUsers.length - 1] = user; */
        this.users.add(user);
    }

    public boolean changeUserRole(String login, String role) {
        /*
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

         */
        return this.users.stream()
                .filter(user -> user.getLogin().equals(login))
                .map(user -> {
                user.setRole(User.Role.valueOf(role));
                return true;
                })
                .findFirst()
                .orElse(false);
    }

    public static UserDB getInstance() {
        return instance;
    }
}
