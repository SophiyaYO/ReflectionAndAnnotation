package gettersAndSetters;

import reflection.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Reflection reflection = new Reflection();

        Class<Reflection> reflectionClass = (Class<Reflection>) reflection.getClass();
        Method[] allDeclaredMethods = reflectionClass.getDeclaredMethods();
        Method[] getters = getMethodsStartsWith("get", allDeclaredMethods);
        Method[] setters = getMethodsStartsWith("set", allDeclaredMethods);

        Arrays.stream(getters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> {
                    System.out.println((
                            String.format("%s will return class %s",
                            m.getName(),
                            m.getClass().getSimpleName())));
                }
                );

        Arrays.stream(setters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> {
                            System.out.println((
                                    String.format("%s will set field of class %s",
                                            m.getName(),
                                            m.getParameterTypes()[0].getSimpleName())));
                        }
                );

    }

    public static Method[] getMethodsStartsWith(String with, Method[] methods) {
      return Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get"))
                .toArray(Method[]::new);
    }
}
