package com.apex.designpattern.creationalpattern;

//Product interface
interface Toy {
 void play();
}

//Concrete Product: Car
class Car implements Toy {
 @Override
 public void play() {
     System.out.println("Playing with toy car");
 }
}

//Concrete Product: Plane
class Plane implements Toy {
 @Override
 public void play() {
     System.out.println("Flying toy plane");
 }
}

//Concrete Product: Boat
class Boat implements Toy {
 @Override
 public void play() {
     System.out.println("Sailing toy boat");
 }
}

//Factory interface
interface ToyFactory {
 Toy createToy();
}

//Concrete Factory: CarFactory
class CarFactory implements ToyFactory {
 @Override
 public Toy createToy() {
     return new Car();
 }
}

//Concrete Factory: PlaneFactory
class PlaneFactory implements ToyFactory {
 @Override
 public Toy createToy() {
     return new Plane();
 }
}

//Concrete Factory: BoatFactory
class BoatFactory implements ToyFactory {
 @Override
 public Toy createToy() {
     return new Boat();
 }
}

//Client code
public class FactoryPatternExample {
 public static void main(String[] args) {
     // Create a car using CarFactory
     ToyFactory carFactory = new CarFactory();
     Toy car = carFactory.createToy();
     car.play();

     // Create a plane using PlaneFactory
     ToyFactory planeFactory = new PlaneFactory();
     Toy plane = planeFactory.createToy();
     plane.play();

     // Create a boat using BoatFactory
     ToyFactory boatFactory = new BoatFactory();
     Toy boat = boatFactory.createToy();
     boat.play();
 }
}
