package com.apex.designpattern.structuralpattern;

//Component interface
interface Pizza {
 String getDescription();
 double getCost();
}

//Concrete component
class PlainPizza implements Pizza {
 @Override
 public String getDescription() {
     return "Plain Pizza";
 }

 @Override
 public double getCost() {
     return 5.0;
 }
}

//Decorator abstract class
abstract class PizzaDecorator implements Pizza {
 protected Pizza pizza;

 public PizzaDecorator(Pizza pizza) {
     this.pizza = pizza;
 }

 @Override
 public String getDescription() {
     return pizza.getDescription();
 }

 @Override
 public double getCost() {
     return pizza.getCost();
 }
}

//Concrete decorator
class CheeseDecorator extends PizzaDecorator {
 public CheeseDecorator(Pizza pizza) {
     super(pizza);
 }

 @Override
 public String getDescription() {
     return pizza.getDescription() + ", Cheese";
 }

 @Override
 public double getCost() {
     return pizza.getCost() + 1.5;
 }
}

//Client code
public class DecoratorPatternExample {
 public static void main(String[] args) {
     // Create a plain pizza
     Pizza pizza = new PlainPizza();

     // Decorate the pizza with cheese
     pizza = new CheeseDecorator(pizza);

     // Output description and cost of the decorated pizza
     System.out.println("Description: " + pizza.getDescription());
     System.out.println("Cost: $" + pizza.getCost());
 }
}


