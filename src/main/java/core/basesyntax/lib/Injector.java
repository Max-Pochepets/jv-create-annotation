package core.basesyntax.lib;

import core.basesyntax.dao.DaoInterface;
import core.basesyntax.exception.IllegalAnnotationException;
import core.basesyntax.factory.Factory;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public class Injector {
    public static Object getInstance(Class<?> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, IllegalAnnotationException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(instance, getDao(field.getGenericType()));
            }
        }
        return instance;
    }

    private static DaoInterface<?> getDao(Type type) throws IllegalAnnotationException {
        DaoInterface<?> daoInterface = null;
        if (type.getTypeName().contains(Bet.class.getTypeName())) {
            daoInterface = Factory.getBetDao();
        } else if (type.getTypeName().contains(User.class.getTypeName())) {
            daoInterface = Factory.getUserDao();
        }
        if (daoInterface != null && daoInterface.getClass().getAnnotation(Dao.class) != null) {
            return daoInterface;
        }
        throw new IllegalAnnotationException("DaoAnnotation missing.");
    }
}
