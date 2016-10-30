package no.fint.filter.object;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class FieldFilter {

    @SuppressWarnings("unchecked")
    public <T> T filter(T o, List<String> fieldList) {
        try {
            Class oClass = o.getClass();
            Field[] fields = oClass.getDeclaredFields();
            Object filteredObj = oClass.newInstance();

            for (Field field : fields) {
                if (fieldList.contains(field.getName())) {
                    field.setAccessible(true);
                    field.set(filteredObj, field.get(o));
                }
            }

            return (T) filteredObj;
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("Unable to filter " + o.getClass(), e);
        }
    }

    public <T> List<T> filterList(List<T> objectList, List<String> fieldList) {
        return objectList.stream().map(obj -> filter(obj, fieldList)).collect(Collectors.toList());
    }
}
