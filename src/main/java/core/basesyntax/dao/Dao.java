package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class Dao<K, V> {
    private Storage<K, V> storage;

    public Dao(Storage<K, V> storage) {
        this.storage = storage;
    }

    public void add(K key, V value) {
        storage.getStorage().put(key, value);
    }

    public Map<K, V> getAll(Storage<K, V> dataBase) {
        return dataBase.getStorage();
    }
}
