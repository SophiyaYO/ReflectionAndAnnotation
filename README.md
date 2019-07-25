# **REFLECTION AND ANNOTATION**
----------
----------
Lab exercises and some notes for
--------------


## Part I: Reflection
-----------

<details>
<summary>1. Reflection**</summary>

Import "**Reflection.java"** to your **"src"** folder in your project. Try to use reflection and print some information about this class. Print everything on new line:
-	This class type
-	Super class type 
-	All interfaces that are implemented by this class
-	Instantiate object using reflection and print it too

**Don’t change anything in "Reflection class"!** 

#### Solution

```java
public class Main {
    public static void main(String[] args)
            throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {

        Class<Reflection> reflection = Reflection.class;

        System.out.println(reflection);

        Class superClass = reflection.getSuperclass();

        System.out.println(superClass);

        Class[] interfaces = reflection.getInterfaces();

        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Reflection oReflection = reflection.getConstructor().newInstance();
        System.out.println(oReflection);
    }
}
```

</details>

<details>
<summary>**2. Getters and Setters**</summary>
Using reflection to get all Reflection methods. Then prepare an algorithm that will recognize, which methods are getters and setters. Sort each collection alphabetically by methods names. Print to console each getter on new line in format:
-	"{name} will return class {Return Type}"
Then print all setters in format:
-	"{name} and will set field of class {Parameter Type}"
Do this without changing anything in "Reflection.java"
</details>
