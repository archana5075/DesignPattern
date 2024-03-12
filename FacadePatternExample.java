package com.apex.designpattern.structuralpattern;


//Subsystem classes
class CPU {
 public void start() {
     System.out.println("CPU is starting...");
 }

 public void shutdown() {
     System.out.println("CPU is shutting down...");
 }
}

class Memory {
 public void load() {
     System.out.println("Memory is loading...");
 }

 public void unload() {
     System.out.println("Memory is unloading...");
 }
}

class HardDrive {
 public void read() {
     System.out.println("Hard Drive is reading...");
 }

 public void write() {
     System.out.println("Hard Drive is writing...");
 }
}

//Facade class
class ComputerFacade {
 private CPU cpu;
 private Memory memory;
 private HardDrive hardDrive;

 public ComputerFacade() {
     cpu = new CPU();
     memory = new Memory();
     hardDrive = new HardDrive();
 }

 public void start() {
     cpu.start();
     memory.load();
     hardDrive.read();
     System.out.println("Computer is starting...");
 }

 public void shutdown() {
     cpu.shutdown();
     memory.unload();
     hardDrive.write();
     System.out.println("Computer is shutting down...");
 }
}

//Client code
public class  FacadePatternExample{
 public static void main(String[] args) {
     // Create a computer facade
     ComputerFacade computer = new ComputerFacade();

     // Start the computer using the facade
     computer.start();

     // Shutdown the computer using the facade
     computer.shutdown();
 }
}


