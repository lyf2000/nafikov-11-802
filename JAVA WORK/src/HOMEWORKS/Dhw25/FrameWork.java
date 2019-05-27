package HOMEWORKS.Dhw25;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FrameWork {

    static String[] wrappers, primitives;

    static {
        wrappers = new String[8];
        wrappers[0] = Integer.class.getTypeName();
        wrappers[1] = Long.class.getTypeName();
        wrappers[2] = Boolean.class.getTypeName();
        wrappers[3] = Character.class.getTypeName();
        wrappers[4] = Float.class.getTypeName();
        wrappers[5] = Double.class.getTypeName();
        wrappers[6] = Byte.class.getTypeName();
        wrappers[7] = Short.class.getTypeName();

        primitives = new String[8];
        primitives[0] = int.class.getTypeName();
        primitives[1] = long.class.getTypeName();
        primitives[2] = boolean.class.getTypeName();
        primitives[3] = char.class.getTypeName();
        primitives[4] = float.class.getTypeName();
        primitives[5] = double.class.getTypeName();
        primitives[6] = byte.class.getTypeName();
        primitives[7] = short.class.getTypeName();
    }


    public static <T> List<T> getObjects(int count, Class<T> aClass, Object... args) {
        List<T> list = new LinkedList<>();
        int length = args.length;
        Class[] classes;
        boolean isFound = false;
        String args_type_names[] = new String[length];

        Constructor[] constructors = aClass.getDeclaredConstructors();

        for (int j = 0; j < length; j++) {

            args_type_names[j] = args[j].getClass().getTypeName();

        }


        int constructorsNum = constructors.length;

        Constructor constructor = null;
        String name;
        int constructorIndex;
        for (constructorIndex = 0; !isFound && constructorIndex < constructorsNum; constructorIndex++) {
            constructor = constructors[constructorIndex];

            if (constructor.getParameterCount() == length) {
                classes = constructor.getParameterTypes();

                isFound = true;

                for (int j = 0; j < length; j++) {
                    name = classes[j].getTypeName();
                    int index = Arrays.asList(primitives).indexOf(name);
                    if (index > -1) {
                        name = wrappers[index];
                    }
                    if (!name.equals(args_type_names[j])) {
                        isFound = false;
                        break;
                    }
                }
            }
            if (isFound) {
                break;
            }
        }

        T o = null;
        for (int i = 0; i < count; i++) {
            try {
                o = (T) constructor.newInstance(args);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            list.add(o);
        }
        return list;
    }
}