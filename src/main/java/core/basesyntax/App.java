package core.basesyntax;

import core.basesyntax.controller.ConsoleBetHandler;
import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.controller.ConsoleUserHandler;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Storage<Bet> betsStorage = new Storage<>();
        Storage<User> usersStorage = new Storage<>();

        while (true) {
            System.out.println("Enter your bet and it's risk");
            ConsoleHandler<Bet> betHandler = new ConsoleBetHandler();
            betHandler.handle(betsStorage);

            System.out.println("Please, enter your first and last name to verify the bet");
            ConsoleHandler<User> userHandler = new ConsoleUserHandler();
            userHandler.handle(usersStorage);

            System.out.println("Next? Y/N");
            String command = scanner.nextLine();
            while (!command.equalsIgnoreCase("y") && !command.equalsIgnoreCase("n")) {
                System.out.println("It's Y or N, you silly ^^");
                command = scanner.nextLine();
            }
            if (command.equalsIgnoreCase("n")) {
                break;
            }
        }

        System.out.println(betsStorage.getStorage());
        System.out.println(usersStorage.getStorage());
    }
}
