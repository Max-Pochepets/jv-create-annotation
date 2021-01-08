package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;

public class BetDaoSingleFactory {
    private static BetDao betDao;

    public static BetDao get() {
        if (betDao == null) {
            betDao = new BetDao();
        }
        return betDao;
    }
}
