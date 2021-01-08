package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.factory.BetDaoSingleFactory;
import core.basesyntax.factory.UserDaoSingleFactory;
import core.basesyntax.model.Bet;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BetDaoInjector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(instance, BetDaoSingleFactory.get());
            }
        }
        return instance;
    }
}
