package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.db.Storage;

public class App {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();

        handler.handle();

        System.out.println("Bets:\n" + Storage.betsStorage);
        System.out.println("Users:\n" + Storage.usersStorage);
    }
}
