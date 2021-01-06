package core.basesyntax.db;

import java.util.ArrayList;
import java.util.List;

public class Storage<T> {
    private List<T> storage = new ArrayList<>();

    public List<T> getStorage() {
        return storage;
    }
}
