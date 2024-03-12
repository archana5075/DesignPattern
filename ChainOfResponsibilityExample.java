package com.apex.designpattern.behavioralpattern;

/*
 * In this example:

Handler is the interface that all concrete handlers implement.
ConcreteHandler1 and ConcreteHandler2 are two concrete handlers. 
Each handler decides whether it can handle a request or not.
 If it can't handle the request, it passes the request to the next handler in the chain.
Request represents a request object.
ChainOfResponsibilityExample is the client code that 
sets up the chain and sends requests to the chain.
 * 
 * */

//Handler interface
interface Handler {
 void setNextHandler(Handler nextHandler);
 void handleRequest(Request request);
}

//Concrete Handler 1
class ConcreteHandler1 implements Handler {
 private Handler nextHandler;

 @Override
 public void setNextHandler(Handler nextHandler) {
     this.nextHandler = nextHandler;
 }

 @Override
 public void handleRequest(Request request) {
     if (request.getType().equals("Type1")) {
         System.out.println("Handling request of Type1 by ConcreteHandler1");
     } else if (nextHandler != null) {
         nextHandler.handleRequest(request);
     } else {
         System.out.println("No handler available for request of Type: " + request.getType());
     }
 }
}

//Concrete Handler 2
class ConcreteHandler2 implements Handler {
 private Handler nextHandler;

 @Override
 public void setNextHandler(Handler nextHandler) {
     this.nextHandler = nextHandler;
 }

 @Override
 public void handleRequest(Request request) {
     if (request.getType().equals("Type2")) {
         System.out.println("Handling request of Type2 by ConcreteHandler2");
     } else if (nextHandler != null) {
         nextHandler.handleRequest(request);
     } else {
         System.out.println("No handler available for request of Type: " + request.getType());
     }
 }
}

//Request class
class Request {
 private String type;

 public Request(String type) {
     this.type = type;
 }

 public String getType() {
     return type;
 }
}

//Client class
public class ChainOfResponsibilityExample {
 public static void main(String[] args) {
     // Creating handlers
     Handler handler1 = new ConcreteHandler1();
     Handler handler2 = new ConcreteHandler2();

     // Setting up the chain
     handler1.setNextHandler(handler2);

     // Creating requests
     Request request1 = new Request("Type1");
     Request request2 = new Request("Type2");
     Request request3 = new Request("Type3");

     // Handling requests
     handler1.handleRequest(request1);
     handler1.handleRequest(request2);
     handler1.handleRequest(request3);
 }
}

