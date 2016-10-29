package no.fint.filter.object;

import java.lang.reflect.Field;
import java.util.List;

public class MemberFilter {

    public Object filter(Object o, List<String> members) throws IllegalAccessException, InstantiationException {

        Class theClass = o.getClass();
        Field[] fields = theClass.getDeclaredFields();
        Object objInstance = theClass.newInstance();

        for (int i = 0; i < fields.length; i++) {
            if (members.contains(fields[i].getName())) {
                fields[i].setAccessible(true);
                fields[i].set(objInstance, fields[i].get(o));
            }
        }

        return objInstance;
    }
}
