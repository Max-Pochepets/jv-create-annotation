package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.Dao;
import core.basesyntax.dao.impl.BetDao;
import core.basesyntax.dao.impl.UserDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;

public class App {
    public static void main(String[] args) {
        Dao<Bet> betDao = new BetDao();
        Dao<User> userDao = new UserDao();
        ConsoleHandler handler = new ConsoleHandler();

        handler.handle();

        System.out.println("Bets:\n" + betDao.getAll());
        System.out.println("Users:\n" + userDao.getAll());
    }
}
