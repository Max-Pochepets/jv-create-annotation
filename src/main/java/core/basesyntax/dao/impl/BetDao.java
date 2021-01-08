package core.basesyntax.dao.impl;

import core.basesyntax.dao.Dao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;

public class BetDao implements Dao<Bet> {
    @Override
    public void add(Bet value) {
        Storage.betsStorage.add(value);
    }
}
