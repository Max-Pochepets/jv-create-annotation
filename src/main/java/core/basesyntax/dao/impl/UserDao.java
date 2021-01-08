package core.basesyntax.dao.impl;

import core.basesyntax.dao.Dao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.User;

import java.util.List;

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
