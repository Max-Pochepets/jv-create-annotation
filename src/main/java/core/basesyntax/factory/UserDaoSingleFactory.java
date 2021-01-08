package core.basesyntax.factory;

import core.basesyntax.dao.UserDao;

public class UserDaoSingleFactory {
    private static UserDao userDao;

    public static UserDao get() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }
}
