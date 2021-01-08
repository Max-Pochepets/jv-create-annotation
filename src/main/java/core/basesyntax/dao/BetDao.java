package core.basesyntax.dao.impl;

import core.basesyntax.dao.Dao;
import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;

import java.util.List;

@Dao
public class BetDao {
    public void add(Bet value) {
        Storage.betsStorage.add(value);
    }

    public List<Bet> getAll() {
        return Storage.betsStorage;
    }
}
