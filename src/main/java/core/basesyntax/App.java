package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.exception.IllegalAnnotationException;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, IllegalAnnotationException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);

        handler.handle();

        System.out.println("Bets:\n" + Factory.getBetDao().getAll());
        System.out.println("Users:\n" + Factory.getUserDao().getAll());
    }
}
