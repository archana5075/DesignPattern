package com.apex.designpattern.creationalpattern;

/**
 * The provided code is an implementation of the Singleton Pattern in Java with thread safety ensured using synchronization. 
 * Here's an explanation of how it works:

The class ThreadSafeSingleton has a private constructor, which means that it cannot be instantiated from outside the class.
The class has a private static variable instance of type ThreadSafeSingleton, which holds the single instance of the class.
The class also has a public static method getInstance(), which provides the global access point to the single instance of the class. 

This method is declared as synchronized, which means that only one thread can execute it at a time.
Inside the getInstance() method, there is a check if the instance variable is null 
(indicating that the class has not been instantiated yet). 
If it is null, it creates a new instance of the ThreadSafeSingleton class
 and assigns it to the instance variable. 
 
Since the method is synchronized, only one thread can execute this block of code at a time, 
preventing multiple threads from creating multiple instances of the class.

Subsequent calls to getInstance() return the existing instance without creating a new one.
While this implementation ensures thread safety, it comes with a performance overhead because of the synchronization. 
Every time getInstance() is called, the method has to acquire and release a lock, which can affect the performance, 
especially in multithreaded environments with high contention. 

There are alternative approaches like double-checked locking 
or using static inner class initialization that provide thread safety without
 the performance overhead of synchronized methods.
 * 
 * 
 * */

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
        // Private constructor
    }
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

