package com.apex.designpattern.creationalpattern;

/** 
 * 
 *
 * The class Singleton has a private constructor,
  which means that it cannot be instantiated from outside the class.
   
   The class has a private static variable instance of type Singleton, 
   which holds the single instance of the class.
   
   The class also has a public static method getInstance(),
   which provides the global access point to the single instance of the class. 
   This method checks if the instance variable is null 
   (indicating that the class has not been instantiated yet).
  
  If it is null, it creates a new instance of the Singleton class
   and assigns it to the instance variable. 
   Subsequent calls to getInstance() return the existing instance.
  
  The lazy initialization technique is used here, 
  meaning that the instance is created only when it is first requested.
   This helps in saving memory until the instance is actually needed.
 
  Overall, this code ensures that there 
  is only one instance of the Singleton class created 
  throughout the runtime of the application, 
   providing global access to that instance
 * 
 * */

public class Singleton {
    // Static variable to hold the single instance of the class
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside the class
    private Singleton() {
        // Constructor implementation
    }

    // Static method to get the single instance of the class
    public static Singleton getInstance() {
        // Lazy initialization: create the instance only when it is requested for the first time
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods and properties can be added as needed
    public void showMessage() {
        System.out.println("Hello, I am a singleton object!");
    }
}

// Client code
class Main {
    public static void main(String[] args) {
        // Get the singleton instance
        Singleton singleton = Singleton.getInstance();

        // Call a method on the singleton object
        singleton.showMessage();
    }
}


