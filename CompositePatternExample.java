package com.apex.designpattern.structuralpattern;


import java.util.ArrayList;
import java.util.List;

// Component interface
interface Component {
    void operation();
}

// Leaf class
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf: " + name);
    }
}

// Composite class
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite:");
        for (Component component : children) {
            component.operation();
        }
    }
}

// Client code
public class CompositePatternExample {
    public static void main(String[] args) {
        // Create leaf components
        Leaf leaf1 = new Leaf("Leaf 1");
        Leaf leaf2 = new Leaf("Leaf 2");
        Leaf leaf3 = new Leaf("Leaf 3");

        // Create composite component
        Composite composite = new Composite();

        // Add leaf components to the composite
        composite.add(leaf1);
        composite.add(leaf2);

        // Operation on composite
        composite.operation();

        // Add another leaf component to the composite
        composite.add(leaf3);

        // Operation on composite after adding another leaf
        composite.operation();
    }
}


