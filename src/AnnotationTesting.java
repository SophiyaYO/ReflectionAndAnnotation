import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class AnnotationTesting {
    public static void main(String[] args) {
        @SuppressWarnings("duplicate code")
        reflection.Reflection reflection = new reflection.Reflection();
        @SuppressWarnings("duplicate code")

        Class<reflection.Reflection> reflectionClass = (Class<reflection.Reflection>) reflection.getClass();
        @SuppressWarnings("")

        Method[] allDeclaredMethods = reflectionClass.getDeclaredMethods();
        Method[] getters = getMethodsStartsWith("get", allDeclaredMethods);
        Method[] setters = getMethodsStartsWith("set", allDeclaredMethods);
        Field[] fields = reflectionClass.getDeclaredFields();

        Arrays.stream(fields)
                .filter(f -> {
                    Subject declaredAnnotation = f.getDeclaredAnnotation(Subject.class);
                    String[] categories = declaredAnnotation.categories();
                     if (f.isAnnotationPresent(Subject.class)) {
                        Subject annotation = f.getAnnotation(Subject.class);
                    }
                    return !Modifier.isPrivate(f.getModifiers());
                })
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


