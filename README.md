# **REFLECTION AND ANNOTATION**
----------
----------
Lab exercises and some notes for
--------------


## Part I: reflection.Reflection
-----------

<details>
<summary>:package: 1. reflection.Reflection</summary>

Import "**reflection.Reflection.java"** to your **"src"** folder in your project. Try to use reflection and print some information about this class. Print everything on new line:
-	This class type
-	Super class type 
-	All interfaces that are implemented by this class
-	Instantiate object using reflection and print it too

**Don’t change anything in "reflection.Reflection class"!** 

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
<summary>:package: 2. Getters and Setters</summary>

Using reflection to get all reflection.Reflection methods. Then prepare an algorithm that will recognize, which methods are getters and setters. Sort each collection alphabetically by methods names. Print to console each getter on new line in format:
-	**"{name} will return class {Return Type}"**
Then print all setters in format:
-	**"{name} and will set field of class {Parameter Type}"**

**Do this without changing anything in "reflection.Reflection.java"**

#### **:exclamation:NOTES:exclamation:**
-----
In class Main you will find 2 implementations of a code. The first \(That one that is active)
is copied from the presentation. The 2 have identical Output. At the moment there is a problem with the judge system
so it is getting 0/100. No mistakes are found. Will try later to see if there is problem with the solution.

</details>


<details>
<summary>:package: 3.	High Quality Mistakes</summary>

You are already expert of **High Quality Code**, so you know what kind of **access modifiers** must be set to members of class. Time for revenge has come. Now you have to check code produced by your "Beautiful and Smart" trainers in class Reflection. **Check all fields and methods access modifiers**. **Sort each category of members alphabetically**. Print on console all mistakes in format:
-	Fields
**{fieldName} must be private!**
-	Getters
**{methodName} have to be public!**
-	Setters
**{methodName} have to be private!**


#### **:exclamation: NOTES <sup>:exclamation:**
-----

**_Same shit as pr 02_**
</details>