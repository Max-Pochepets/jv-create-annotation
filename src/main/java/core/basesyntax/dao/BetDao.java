package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;
import java.util.List;

@Dao
public class BetDao implements DaoInterface<Bet> {
    @Override
    public void add(Bet value) {
        Storage.betsStorage.add(value);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.betsStorage;
    }
}
