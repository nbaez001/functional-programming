package com.empresa.proyecto.functional.util.designpatterns;

public class CommandPattern {
    public static void main(String[] args) {
        AC ac1 = new AC();
        AC ac2 = new AC();

        ACAutomationRemote remote = new ACAutomationRemote();
        remote.setCommand(() -> ac2.turnOn());
        remote.buttonPressed();
    }
}

interface Command {
    public void execute();
}

class ACAutomationRemote {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonPressed() {
        command.execute();
    }
}

class AC {
    public void turnOn() {
        System.out.println("Turning on AC");
    }

    public void turnOff() {
        System.out.println("Turning off AC");
    }

    public void incTemp() {
        System.out.println("Increasing temperature");
    }

    public void decTemp() {
        System.out.println("Decreasing temperature");
    }
}
