package motech.nms.Csv;

import motech.nms.Csv.CsvModel.CsvModelFlw;
import motech.nms.util.Util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * For Csv Model, make sure every field is a String field.
 * @param <T>
 */

public abstract class CsvReaderGeneric<T> {

    public T setColumnToField(Object[] column, T t, Class<T> clazz)
            throws NoSuchFieldException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException,
            ClassNotFoundException {
        for (int counter = 0; counter <= column.length - 1; counter++) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                CsvElement csvElement = (CsvElement) field
                        .getAnnotation(CsvElement.class);
                if (csvElement.index() == counter) {

                    Method method = clazz.getMethod("set" + Util
                                    .capitalizeFirstLetterOfFieldName(
                                            field.getName()),
                            Class.forName(field.getType().getName()));
                    method.invoke(t, column[counter]);
                }
            }
        }
        return t;
    }

    public abstract List<T> read(String csvFile);
}
