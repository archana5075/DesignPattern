package com.apex.designpattern.creationalpattern;

//Product class
class Pizza {
 private String dough;
 private String sauce;
 private String topping;

 public void setDough(String dough) {
     this.dough = dough;
 }

 public void setSauce(String sauce) {
     this.sauce = sauce;
 }

 public void setTopping(String topping) {
     this.topping = topping;
 }

 public void describe() {
     System.out.println("Pizza with " + dough + " dough, " + sauce + " sauce, and " + topping + " topping.");
 }
}

//Builder interface
interface PizzaBuilder {
 PizzaBuilder addDough(String dough);
 PizzaBuilder addSauce(String sauce);
 PizzaBuilder addTopping(String topping);
 Pizza build();
}

//Concrete builder
class MargheritaPizzaBuilder implements PizzaBuilder {
 private Pizza pizza;

 public MargheritaPizzaBuilder() {
     pizza = new Pizza();
 }

 @Override
 public PizzaBuilder addDough(String dough) {
     pizza.setDough(dough);
     return this;
 }

 @Override
 public PizzaBuilder addSauce(String sauce) {
     pizza.setSauce(sauce);
     return this;
 }

 @Override
 public PizzaBuilder addTopping(String topping) {
     pizza.setTopping(topping);
     return this;
 }

 @Override
 public Pizza build() {
     return pizza;
 }
}

//Director class
class PizzaDirector {
 private PizzaBuilder pizzaBuilder;

 public PizzaDirector(PizzaBuilder pizzaBuilder) {
     this.pizzaBuilder = pizzaBuilder;
 }

 public Pizza makePizza() {
     return pizzaBuilder.addDough("thin")
                        .addSauce("tomato")
                        .addTopping("cheese")
                        .build();
 }
}

//Client code
public class BuilderPatternExample {
 public static void main(String[] args) {
     // Create a MargheritaPizzaBuilder
     PizzaBuilder builder = new MargheritaPizzaBuilder();

     // Create a PizzaDirector with the MargheritaPizzaBuilder
     PizzaDirector director = new PizzaDirector(builder);

     // Make a pizza using the director
     Pizza pizza = director.makePizza();

     // Describe the pizza
     pizza.describe();
 }
}


