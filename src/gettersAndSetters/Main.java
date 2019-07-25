package gettersAndSetters;


import reflection.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Method[] methods = Reflection.class.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get") &&
                        m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(getters).forEach(m ->
                System.out.printf("%s will return class %s%n",
                        m.getName(), m.getReturnType().getName()));

        Method[] setters = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set") )
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(setters).forEach(m ->
                System.out.printf("%s and will set field of class %s%n",
                        m.getName(), m.getParameterTypes()[0].getSimpleName()));

//        reflection.Reflection reflection = new reflection.Reflection();
//
//        Class<reflection.Reflection> reflectionClass = (Class<reflection.Reflection>) reflection.getClass();
//        Method[] allDeclaredMethods = reflectionClass.getDeclaredMethods();
//        Method[] getters = getMethodsStartsWith("get", allDeclaredMethods);
//        Method[] setters = getMethodsStartsWith("set", allDeclaredMethods);
//
//
//        Arrays.stream(getters)
//                .sorted(Comparator.comparing(Method::getName))
//                .forEach(m-> System.out.println(
//                        String.format("%s will return class %s",
//                        m.getName(),
//                        m.getReturnType().getSimpleName()))
//                );
//
//        Arrays.stream(setters)
//                .sorted(Comparator.comparing(Method::getName))
//                .forEach(m-> System.out.println(
//                        String.format("%s and will set field of class %s",
//                                m.getName(),
//                                m.getParameterTypes()[0]
//                                        .getSimpleName())
//                        )
//
//                );

    }

//    public static Method[] getMethodsStartsWith(String with, Method[] methods) {
//      return Arrays.stream(methods)
//                .filter(method -> method.getName().startsWith(with))
//                .toArray(Method[]::new);
//    }
}
