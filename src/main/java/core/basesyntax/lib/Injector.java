package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.BetDaoSingleFactory;
import core.basesyntax.factory.UserDaoSingleFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().getAnnotation(Dao.class) != null) {
                    if (field.getType() == BetDao.class) {
                        field.set(instance, BetDaoSingleFactory.get());
                    }
                    if (field.getType() == UserDao.class) {
                        field.set(instance, UserDaoSingleFactory.get());
                    }
                }
            }
        }
        return instance;
    }
}
