package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.List;

public class Dao<T> {
    private Storage<T> storage;

    public Dao(Storage<T> storage) {
        this.storage = storage;
    }

    public void add(T element) {
        storage.getStorage().add(element);
    }

    public List<T> getAll(Storage<T> dataBase) {
        return dataBase.getStorage();
    }
}
