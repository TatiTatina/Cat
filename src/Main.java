import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Cat cat = new Cat("Vasya", 10, new ArrayList<>(Arrays.asList("Anton", "Oleg", "Igor")));
        Cat cat2 = new Cat("Ivan", 8, new ArrayList<>(Arrays.asList("Katya", "Masha", "Gosha")));

        String s = cat.toString();
        System.out.println(s);

        String s2 = cat.toString();
        System.out.println(s2);

        resetObject(cat);
        System.out.println(cat);
    }

    public static void resetObject(Object obj) {
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(obj) instanceof List) {
                    ((List) field.get(obj)).clear();
                } else {
                    field.set(obj, null);
                }
            }
        } catch (IllegalAccessException e){
            e.printStackTrace();

            }
        }
    }
