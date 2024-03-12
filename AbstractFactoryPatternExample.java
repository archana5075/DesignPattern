package com.apex.designpattern.creationalpattern;

//Abstract product interface
interface CarNew {
 void drive();
}

//Concrete product: SedanCar
class SedanCar implements CarNew {
 @Override
 public void drive() {
     System.out.println("Driving Sedan car");
 }
}

//Concrete product: SUVCar
class SUVCar implements CarNew {
 @Override
 public void drive() {
     System.out.println("Driving SUV car");
 }
}

//Abstract product interface
interface Bike {
 void ride();
}

//Concrete product: SportsBike
class SportsBike implements Bike {
 @Override
 public void ride() {
     System.out.println("Riding Sports bike");
 }
}

//Concrete product: CruiserBike
class CruiserBike implements Bike {
 @Override
 public void ride() {
     System.out.println("Riding Cruiser bike");
 }
}

//Abstract factory interface
interface VehicleFactory {
	CarNew createCar();
 Bike createBike();
}

//Concrete factory: CarFactory
class CarFactoryNew implements VehicleFactory {
 @Override
 public CarNew createCar() {
     return new SedanCar();
 }

 @Override
 public Bike createBike() {
     // Car factory doesn't create bikes, so returning null
     return null;
 }
}

//Concrete factory: BikeFactory
class BikeFactory implements VehicleFactory {
 @Override
 public CarNew createCar() {
     // Bike factory doesn't create cars, so returning null
     return null;
 }

 @Override
 public Bike createBike() {
     return new SportsBike();
 }
}

//Client code


public class AbstractFactoryPatternExample {
	public static void main(String[] args) {
	     // Create a car factory
	     VehicleFactory carFactory = new CarFactoryNew();
	     // Create a sedan car using car factory
	     CarNew sedanCar = carFactory.createCar();
	     sedanCar.drive();

	     // Create a bike factory
	     VehicleFactory bikeFactory = new BikeFactory();
	     // Create a sports bike using bike factory
	     Bike sportsBike = bikeFactory.createBike();
	     sportsBike.ride();
	 }
}
