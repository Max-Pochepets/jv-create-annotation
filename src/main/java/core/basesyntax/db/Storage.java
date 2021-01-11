package core.basesyntax.db;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static List<Bet> betsStorage = new ArrayList<>();
    public static List<User> usersStorage = new ArrayList<>();
}
