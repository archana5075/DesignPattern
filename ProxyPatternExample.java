package com.apex.designpattern.structuralpattern;
/**
 * 
 * Image Interface: This interface defines the contract for all image objects. It declares a display() method that must be implemented by concrete image classes.

RealImage Class: This class represents the real image object. It implements the Image interface and provides the actual implementation for loading and displaying an image from disk.

ProxyImage Class: This class acts as a proxy for the RealImage class. It implements the Image interface and delegates the display() method to a RealImage object. However, it only creates the RealImage object when necessary (i.e., when the display() method is called for the first time).

ProxyPatternExample Class: 

This class contains the client code 
that demonstrates the usage of the proxy pattern. 

It creates a ProxyImage object with the filename "test.jpg" 
and calls the display() method twice. 

The first time, the image is loaded from disk, 
and subsequent calls to display() use the cached image 
without reloading it.

Overall, the Proxy Pattern allows for lazy initialization 
and control over the creation and access of expensive 
or resource-intensive objects, 
such as loading images from disk only when needed. 

It helps improve performance and resource management in applications 
by deferring the creation of objects until they are actually required.
 * 
 * 
 * 
 * */

//Subject interface
interface Image {
 void display();
}

//RealSubject class
class RealImage implements Image {
 private String filename;

 public RealImage(String filename) {
     this.filename = filename;
     loadImageFromDisk();
 }

 private void loadImageFromDisk() {
     System.out.println("Loading image: " + filename);
 }

 @Override
 public void display() {
     System.out.println("Displaying image: " + filename);
 }
}

//Proxy class
class ProxyImage implements Image {
 private RealImage realImage;
 private String filename;

 public ProxyImage(String filename) {
     this.filename = filename;
 }

 @Override
 public void display() {
     if (realImage == null) {
         realImage = new RealImage(filename);
     }
     realImage.display();
 }
}

//Client code
public class ProxyPatternExample {
 public static void main(String[] args) {
     // Create a proxy image
     Image image = new ProxyImage("test.jpg");

     // Image will be loaded from disk only when required
     image.display();

     // Image will be loaded from disk again only when required
     image.display();
 }
}


