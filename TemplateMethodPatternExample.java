package com.apex.designpattern.behavioralpattern;

/*
 * 
 * In this program:

We have an abstract class Game defining a template method play(). 
This method encapsulates the sequence of steps required to play a game, 
but leaves the specific implementation of individual steps to concrete subclasses.
Concrete subclasses Cricket and Football extend the Game class and implement 
the abstract methods initialize(), startPlay(), and endPlay(). 
These methods represent specific steps in the game lifecycle.
The client code creates instances of concrete game classes and invokes the play() method. The template method orchestrates the execution of the game lifecycle steps, ensuring consistency across different types of games while allowing variations in specific steps.

 * 
 * 
 * **/

//Abstract class defining the template method
abstract class Game {
 abstract void initialize();
 abstract void startPlay();
 abstract void endPlay();

 // Template method
 public final void play() {
     initialize();
     startPlay();
     endPlay();
 }
}

//Concrete class implementing the template method
class Cricket extends Game {
 @Override
 void initialize() {
     System.out.println("Cricket Game Initialized! Start playing.");
 }

 @Override
 void startPlay() {
     System.out.println("Cricket Game Started. Enjoy the game!");
 }

 @Override
 void endPlay() {
     System.out.println("Cricket Game Finished!");
 }
}

//Concrete class implementing the template method
class Football extends Game {
 @Override
 void initialize() {
     System.out.println("Football Game Initialized! Start playing.");
 }

 @Override
 void startPlay() {
     System.out.println("Football Game Started. Enjoy the game!");
 }

 @Override
 void endPlay() {
     System.out.println("Football Game Finished!");
 }
}

//Client code
public class TemplateMethodPatternExample {
 public static void main(String[] args) {
     Game cricket = new Cricket();
     Game football = new Football();

     System.out.println("Playing Cricket:");
     cricket.play();

     System.out.println("\nPlaying Football:");
     football.play();
 }
}


