package com.apex.designpattern.structuralpattern;

//Target interface
interface Target {
 void request();
}

//Adaptee (Legacy component) interface
interface Adaptee {
 void specificRequest();
}

//Concrete Adaptee
class LegacyComponent implements Adaptee {
 @Override
 public void specificRequest() {
     System.out.println("Legacy component specific request");
 }
}

//Adapter class
class Adapter implements Target {
 private Adaptee adaptee;

 public Adapter(Adaptee adaptee) {
     this.adaptee = adaptee;
 }

 @Override
 public void request() {
     adaptee.specificRequest();
 }
}

//Client code
public class AdapterPatternExample {
 public static void main(String[] args) {
     // Create legacy component
     Adaptee adaptee = new LegacyComponent();

     // Create adapter
     Target adapter = new Adapter(adaptee);

     // Call request method through adapter
     adapter.request();
 }
}


