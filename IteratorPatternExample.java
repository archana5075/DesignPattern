package com.apex.designpattern.behavioralpattern;
/**
 * 
 * 
 * 
 
 In this program:

We have an Aggregate interface defining the method createIterator() to create an iterator.
NameRepository is a concrete aggregate class that holds a collection of names and implements the createIterator() method to return an iterator
 for iterating over the names.
The inner class NameIterator implements the Iterator interface and provides the functionality to iterate over the names stored in the NameRepository.
In the Main class, we create an instance of NameRepository, add some names to it, and obtain an iterator from it using the createIterator() method.
 We then iterate over the names using the iterator and print them out. 
 This demonstrates how the iterator pattern provides a way to access the elements of an aggregate object sequentially 
without exposing its underlying representation.

 * 
 * 
 * */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Aggregate interface
interface Aggregate {
    Iterator<String> createIterator();
}

// Concrete Aggregate class
class NameRepository implements Aggregate {
    private List<String> names;

    public NameRepository() {
        names = new ArrayList<>();
    }

    public void addName(String name) {
        names.add(name);
    }

    @Override
    public Iterator<String> createIterator() {
        return new NameIterator();
    }

    // Inner iterator class
    private class NameIterator implements Iterator<String> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < names.size();
        }

        @Override
        public String next() {
            if (this.hasNext()) {
                return names.get(index++);
            }
            return null;
        }
    }
}

// Client code
public class IteratorPatternExample {
    public static void main(String[] args) {
        // Create an aggregate object (NameRepository)
        NameRepository nameRepository = new NameRepository();

        // Add names to the repository
        nameRepository.addName("John");
        nameRepository.addName("Doe");
        nameRepository.addName("Alice");
        nameRepository.addName("Bob");

        // Get an iterator from the repository
        Iterator<String> iterator = nameRepository.createIterator();

        // Iterate over the names using the iterator
        System.out.println("Names:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


