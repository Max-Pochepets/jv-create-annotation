package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage<K, V> {
    private Map<K, V> storage = new HashMap<>();

    public Map<K, V> getStorage() {
        return storage;
    }
}
