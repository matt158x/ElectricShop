package app;

import org.apache.commons.codec.digest.DigestUtils;

public class Authenticator {
    final UserDB userDB = UserDB.getInstance();
    private User loggedUser = null;
    private static final String seed = "OK4wkjJ15XD@T*41pO9M21t^rLhlt#&9srznHWyo";
    private static final Authenticator instance = new Authenticator();

    private Authenticator() {
    }

    public void authenticate(User user) {
        User userFromDB = this.userDB.findByLogin(user.getLogin());
        if (userFromDB != null) {
            String var10000 = userFromDB.getPassword();
            String var10001 = user.getPassword();
            if (var10000.equals(DigestUtils.md5Hex(var10001 + "OK4wkjJ15XD@T*41pO9M21t^rLhlt#&9srznHWyo"))) {
                this.loggedUser = userFromDB;
            }
        }

    }

    public static Authenticator getInstance() {
        return instance;
    }

    public User getLoggedUser() {
        return this.loggedUser;
    }

    public static String getSeed() {
        return "OK4wkjJ15XD@T*41pO9M21t^rLhlt#&9srznHWyo";
    }
}
