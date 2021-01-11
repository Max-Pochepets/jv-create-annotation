package core.basesyntax.dao;

import java.util.List;

public interface DaoInterface<T> {
    void add(T value);

    List<T> getAll();
}
