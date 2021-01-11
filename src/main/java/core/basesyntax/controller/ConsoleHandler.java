package core.basesyntax.controller;

import core.basesyntax.dao.DaoInterface;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    public static final int FIRST_SEQUENCE_INDEX = 0;
    public static final int SECOND_SEQUENCE_INDEX = 1;
    @Inject
    DaoInterface<Bet> betDao;
    @Inject
    DaoInterface<User> userDao;

    public void handle() {
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
            betDao.add(bet);

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
            userDao.add(user);

            System.out.println("Next? Y/N");
            command = scanner.nextLine();
            while (!command.equalsIgnoreCase("y") && !command.equalsIgnoreCase("n")) {
                System.out.println("Enter Y or N, please");
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
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
        return new Bet(amount, risk);
    }

    private User handleUser(String command) {
        String firstName;
        String lastName;
        if (command == null) {
            throw new IllegalArgumentException();
        }
        try {
            String[] values = command.split(" ");
            firstName = values[FIRST_SEQUENCE_INDEX];
            lastName = values[SECOND_SEQUENCE_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
        if (firstName.replaceAll("[^a-zA-Z]", "").length() != firstName.length()
                || lastName.replaceAll("[^a-zA-Z]", "").length() != lastName.length()
                || command.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return new User(firstName, lastName);
    }
}
