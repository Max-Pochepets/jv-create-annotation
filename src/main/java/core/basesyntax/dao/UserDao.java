package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;
import java.util.List;

@Dao
public class UserDao implements DaoInterface<User> {
    @Override
    public void add(User value) {
        Storage.usersStorage.add(value);
    }

    @Override
    public List<User> getAll() {
        return Storage.usersStorage;
    }
}
