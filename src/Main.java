import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
                reflection.Reflection reflection = new reflection.Reflection();

        Class<reflection.Reflection> reflectionClass = (Class<reflection.Reflection>) reflection.getClass();
        Method[] allDeclaredMethods = reflectionClass.getDeclaredMethods();
        Method[] getters = getMethodsStartsWith("get", allDeclaredMethods);
        Method[] setters = getMethodsStartsWith("set", allDeclaredMethods);
        Field[] fields = reflectionClass.getDeclaredFields();

        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
        .forEach(field -> {
            System.out.println(String.format("%s must be private!",
                    field.getName()));
        });


        Arrays.stream(getters)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> System.out.println(
                        String.format("%s have to be public!",
                        m.getName()))
                );

        Arrays.stream(setters)
                .filter(f -> !Modifier.isPublic(f.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> System.out.println(
                        String.format("%s have to be private!",
                                m.getName())
                        )

                );

    }

    public static Method[] getMethodsStartsWith(String with, Method[] methods) {
      return Arrays.stream(methods)
                .filter(method -> method.getName().startsWith(with))
                .toArray(Method[]::new);
    }
    }

