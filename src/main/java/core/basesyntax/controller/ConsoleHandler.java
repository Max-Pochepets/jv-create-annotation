package core.basesyntax.controller;

import core.basesyntax.db.Storage;

public interface ConsoleHandler<T> {
    public void handle(Storage<T> storage);
}
