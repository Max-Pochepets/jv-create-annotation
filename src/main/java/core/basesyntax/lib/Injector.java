package core.basesyntax.lib;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.impl.BetDao;
import core.basesyntax.model.Bet;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getClass().getTypeName().equalsIgnoreCase("bet")) {
                    field.set(instance, new BetDao());
                }
                if (field.getClass().getTypeName().equalsIgnoreCase("user")) {
                    field.set(instance, new BetDao());
                }
            }
        }
        return instance;
    }
}
