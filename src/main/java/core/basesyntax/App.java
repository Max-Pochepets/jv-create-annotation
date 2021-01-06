package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;

public class App {
    public static void main(String[] args) {
        Storage<User, Bet> storage = new Storage<>();
        ConsoleHandler handler = new ConsoleHandler();

        handler.handle(storage);

        System.out.println(storage.getStorage());
    }
}
