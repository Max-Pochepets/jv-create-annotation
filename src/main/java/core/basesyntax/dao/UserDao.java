package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.DaoAnnotation;
import core.basesyntax.model.User;
import java.util.List;

@DaoAnnotation
public class UserDao implements Dao<User> {
    @Override
    public void add(User value) {
        Storage.usersStorage.add(value);
    }

    @Override
    public List<User> getAll() {
        return Storage.usersStorage;
    }
}
