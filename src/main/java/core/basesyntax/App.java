package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.factory.BetDaoSingleFactory;
import core.basesyntax.factory.UserDaoSingleFactory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);

        handler.handle();

        System.out.println("Bets:\n" + BetDaoSingleFactory.get().getAll());
        System.out.println("Users:\n" + UserDaoSingleFactory.get().getAll());
    }
}
