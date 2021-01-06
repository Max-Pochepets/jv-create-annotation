package core.basesyntax.controller;

import core.basesyntax.dao.Dao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleUserHandler implements ConsoleHandler<User> {
    public static final int FIRST_SEQUENCE_INDEX = 0;
    public static final int SECOND_SEQUENCE_INDEX = 1;

    public void handle(Storage<User> storage) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        try {
            String[] values = command.split(" ");
            String firstName = values[FIRST_SEQUENCE_INDEX];
            String lastName = values[SECOND_SEQUENCE_INDEX];
            User bet = new User(firstName, lastName);
            Dao<User> userDao = new Dao<>(storage);
            userDao.add(bet);
        } catch (NumberFormatException e) {
            System.out.println("Enter valid data.");
        }
    }
}
