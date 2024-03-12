package com.apex.designpattern.creationalpattern;

/**
 * The provided code is an implementation of the Singleton Pattern in Java with lazy initialization and thread safety using double-checked locking. 
 * Here's how it works:
The class LazyInitializedSingleton has a private constructor, which means that it cannot be instantiated from outside the class.
The class has a private static variable instance of type LazyInitializedSingleton, which holds the single instance of the class.
The class also has a public static method getInstance(), which provides the global access point to the single instance of the class.
Inside the getInstance() method, there is a double-checked locking mechanism to ensure thread safety while lazily initializing the singleton instance:

First, it checks if the instance variable is null (indicating that the class has not been instantiated yet).
 If it is null, it enters a synchronized block using the class's monitor (the LazyInitializedSingleton.class object).

Inside the synchronized block, it checks again if the instance variable is null. 
This double-check is necessary to prevent multiple threads from creating multiple instances of the class when they enter the synchronized block.
If the instance variable is still null inside the synchronized block, 
it creates a new instance of the LazyInitializedSingleton class and assigns it to the instance variable.

Subsequent calls to getInstance() return the existing instance without creating a new one.
This implementation provides lazy initialization, meaning that the singleton instance is created only when it is first requested. 

It also ensures thread safety by using double-checked locking to prevent multiple threads from creating multiple instances of the class. 

However, it's essential to note that double-checked locking is only applicable in Java 5 and later versions, 
where the memory model ensures the correct behavior of double-checked locking.
 * 
 * */

public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {
        // Private constructor
    }
    
    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyInitializedSingleton.class) {
                if (instance == null) {
                    instance = new LazyInitializedSingleton();
                }
            }
        }
        return instance;
    }
}

