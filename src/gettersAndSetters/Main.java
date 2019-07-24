package gettersAndSetters;

import reflection.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Reflection reflection = new Reflection();

        Class<Reflection> reflectionClass = (Class<Reflection>) reflection.getClass();
        Method[] declaredMethodsGet =
    }

    public Method[] getMethodsStartsWith(String with, Method[] methods) {
      return Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get"))
                .toArray(Method[]::new);
    }
}
