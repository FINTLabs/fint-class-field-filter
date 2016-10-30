package test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldFilter {

    public Object filter(Object o, List<String> fieldList) throws IllegalAccessException, InstantiationException {

        Class oClass = o.getClass();
        Field[] fields = oClass.getDeclaredFields();
        Object filteredObj = oClass.newInstance();

        for (int i = 0; i < fields.length; i++) {
            if (fieldList.contains(fields[i].getName())) {
                fields[i].setAccessible(true);
                fields[i].set(filteredObj, fields[i].get(o));
            }
        }

        return filteredObj;
    }

    public List<Object> filterList(List<Object> objectList, List<String> fieldList)  {

        List<Object> filteredObjectList = new ArrayList();
        objectList.stream().forEach(o -> {
            try {
                filteredObjectList.add(filter(o, fieldList));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        });

        return filteredObjectList;
    }
}
