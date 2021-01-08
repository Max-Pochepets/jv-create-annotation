package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.db.Storage;
import core.basesyntax.lib.BetDaoInjector;

import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) BetDaoInjector.getInstance(ConsoleHandler.class);

        handler.handle();

        System.out.println("Bets:\n" + betDao.getAll());
        System.out.println("Users:\n" + userDao.getAll());
    }
}
