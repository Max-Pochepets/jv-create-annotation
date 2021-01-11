package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.DaoInterface;
import core.basesyntax.dao.UserDao;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;

public class Factory {
    public static DaoInterface<Bet> betDao;
    public static DaoInterface<User> userDao;

    public static DaoInterface<Bet> getBetDao() {
        if (betDao == null) {
            betDao = new BetDao();
        }
        return betDao;
    }

    public static DaoInterface<User> getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }
}
