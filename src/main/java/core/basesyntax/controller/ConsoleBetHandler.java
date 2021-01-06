package core.basesyntax.controller;

import core.basesyntax.dao.Dao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleBetHandler implements ConsoleHandler<Bet> {
    public static final int FIRST_SEQUENCE_INDEX = 0;
    public static final int SECOND_SEQUENCE_INDEX = 1;

    public void handle(Storage<Bet> storage) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        try {
            String[] values = command.split(" ");
            int amount = Integer.parseInt(values[FIRST_SEQUENCE_INDEX]);
            double risk = Double.parseDouble(values[SECOND_SEQUENCE_INDEX]);
            Bet bet = new Bet(amount, risk);
            Dao<Bet> betDao = new Dao<>(storage);
        } catch (NumberFormatException e) {
            System.out.println("Enter valid data.");
        }
    }
}
