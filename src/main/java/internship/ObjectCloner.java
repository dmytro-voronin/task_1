package internship;

import java.lang.reflect.Field;

public class ObjectCloner {
    public static <T> T cloneObject(T obj) {
        try {
            // Создаем новый экземпляр объекта
            @SuppressWarnings("unchecked")
            T clone = (T) obj.getClass().getDeclaredConstructor().newInstance();

            // Копируем поля текущего класса и суперклассов
            Class<?> clazz = obj.getClass();
            while (clazz != null) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true); // Установка доступа к приватным полям
                    Object fieldValue = field.get(obj);

                    // Если поле является ссылкой на другой объект, клонируем его
                    if (fieldValue != null
                            && !field.getType().isPrimitive()
                            && field.getType() != String.class) {
                        Object clonedFieldValue = cloneObject(fieldValue);
                        field.set(clone, clonedFieldValue);
                    } else {
                        field.set(clone, fieldValue);
                    }
                }
                clazz = clazz.getSuperclass();
            }

            return clone;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
