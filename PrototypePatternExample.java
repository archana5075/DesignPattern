package com.apex.designpattern.creationalpattern;

import java.util.HashMap;
import java.util.Map;

// Prototype interface
interface Prototype {
    Prototype clone();
}

// Concrete prototype
class Robot implements Prototype {
    private String model;
    private String color;

    public Robot(String model, String color) {
        this.model = model;
        this.color = color;
    }

    // Copy constructor
    public Robot(Robot robot) {
        this.model = robot.model;
        this.color = robot.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void describe() {
        System.out.println("Model: " + model + ", Color: " + color);
    }

    @Override
    public Prototype clone() {
        return new Robot(this);
    }
}

// Client code
public class PrototypePatternExample {
    public static void main(String[] args) {
        // Create prototype instances
        Robot prototypeRobot = new Robot("GreyRobot", "Grey");

        // Create a map to store cloned instances
        Map<String, Prototype> robotCache = new HashMap<>();

        // Store prototype instance in the map
        robotCache.put("GreyRobot", prototypeRobot);

        // Clone the prototype instance from the map
        Robot clonedRobot = (Robot) robotCache.get("GreyRobot").clone();

        // Modify the cloned instance
        clonedRobot.setColor("BLUE");

        // Describe both original and cloned Robots
        System.out.println("Original Robot:");
        prototypeRobot.describe();
        System.out.println("Cloned Robot:");
        clonedRobot.describe();
    }
}


