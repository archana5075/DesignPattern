package com.apex.designpattern.behavioralpattern;

/**
 * 
 * In this program:

We have a Light class acting as a receiver, which performs the actual actions (turning on and off the light).
There's a Command interface defining the execute method that all concrete command classes must implement.
TurnOnCommand and TurnOffCommand are concrete command classes that encapsulate the actions to turn on and off the light, respectively.
RemoteControl acts as an invoker and holds a list of commands. It has a method to add commands and another method to press buttons, 
which executes the corresponding command.
In the Main class, we create instances of the receiver (light) and concrete command classes (turn on and turn off commands).
 We then add these commands to the remote control and press buttons to execute the commands. 
 This demonstrates how the command pattern decouples the sender (invoker) from the receiver,
  allowing us to encapsulate requests as objects and parameterize clients with queues, requests, and operations.
 * 
 * 
 * 
 * */
import java.util.ArrayList;
import java.util.List;

// Receiver
class Light {
    public void turnOn() {
        System.out.println("Light is turned on");
    }

    public void turnOff() {
        System.out.println("Light is turned off");
    }
}

// Command interface
interface Command {
    void execute();
}

// Concrete Command classes
class TurnOnCommand implements Command {
    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class TurnOffCommand implements Command {
    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Invoker
class RemoteControl {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void pressButton(int index) {
        if (index >= 0 && index < commands.size()) {
            commands.get(index).execute();
        } else {
            System.out.println("Invalid button");
        }
    }
}

// Client code
public class CommandPatternExample  {
    public static void main(String[] args) {
        // Receiver
        Light light = new Light();

        // Concrete commands
        Command turnOnCommand = new TurnOnCommand(light);
        Command turnOffCommand = new TurnOffCommand(light);

        // Invoker
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.addCommand(turnOnCommand);
        remoteControl.addCommand(turnOffCommand);

        // Pressing buttons
        remoteControl.pressButton(0); // Turn on the light
        remoteControl.pressButton(1); // Turn off the light
    }
}



