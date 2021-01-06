package core.basesyntax.controller;

import core.basesyntax.dao.Dao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    public static final int FIRST_SEQUENCE_INDEX = 0;
    public static final int SECOND_SEQUENCE_INDEX = 1;

    public void handle(Storage<User, Bet> storage) {
        Dao<User, Bet> dao = new Dao<>(storage);
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter your bet and it's risk");
            Bet bet;
            while (true) {
                try {
                    command = scanner.nextLine();
                    bet = handleBet(command);
                } catch (IllegalArgumentException e) {
                    System.out.println("Enter valid data.");
                    continue;
                }
                break;
            }

            System.out.println("Please, enter your first and last name to verify the bet");
            User user;
            while (true) {
                try {
                    command = scanner.nextLine();
                    user = handleUser(command);
                } catch (IllegalArgumentException e) {
                    System.out.println("Enter valid data.");
                    continue;
                }
                break;
            }

            dao.add(user, bet);

            System.out.println("Next? Y/N");
            command = scanner.nextLine();
            while (!command.equalsIgnoreCase("y") && !command.equalsIgnoreCase("n")) {
                System.out.println("It's Y or N, you silly ^^");
                command = scanner.nextLine();
            }
            if (command.equalsIgnoreCase("n")) {
                return;
            }
        }
    }

    private Bet handleBet(String command) {
        int amount;
        double risk;
        try {
            String[] values = command.split(" ");
            amount = Integer.parseInt(values[FIRST_SEQUENCE_INDEX]);
            risk = Double.parseDouble(values[SECOND_SEQUENCE_INDEX]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return new Bet(amount, risk);
    }

    private User handleUser(String command) {
        String firstName;
        String lastName;
            String[] values = command.split(" ");
            firstName = values[FIRST_SEQUENCE_INDEX];
            lastName = values[SECOND_SEQUENCE_INDEX];
            if (firstName.contains("^[a-zA-Z]") || lastName.contains("^[a-zA-Z]")) {
                throw new IllegalArgumentException();
            }
        return new User(firstName, lastName);
    }
}
