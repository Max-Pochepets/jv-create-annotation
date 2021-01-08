package core.basesyntax.dao.impl;

import core.basesyntax.dao.Dao;
import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;

import java.util.List;

@Dao
public class UserDao {
    public void add(User value) {
        Storage.usersStorage.add(value);
    }

    public List<User> getAll() {
        return Storage.usersStorage;
    }
}
