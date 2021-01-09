package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.DaoAnnotation;
import core.basesyntax.model.Bet;
import java.util.List;

@DaoAnnotation
public class BetDao implements Dao<Bet> {
    @Override
    public void add(Bet value) {
        Storage.betsStorage.add(value);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.betsStorage;
    }
}
