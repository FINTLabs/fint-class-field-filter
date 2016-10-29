package no.fint.Filter.Object;

import java.lang.reflect.Field;
import java.util.List;

public class MemberFilter {

    public Object filter(Object o, List<String> members) throws IllegalAccessException, InstantiationException {

        Class theClass = o.getClass();
        Field[] fields = theClass.getFields();
        Object objInstance = theClass.newInstance();

        for (int i = 0; i < fields.length; i++) {
            if (members.contains(fields[i].getName())) {
                fields[i].set(objInstance, fields[i].get(o));
            }
        }

        return objInstance;
    }
}
