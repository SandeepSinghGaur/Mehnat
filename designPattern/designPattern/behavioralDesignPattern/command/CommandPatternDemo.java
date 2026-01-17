package designPattern.designPattern.behavioralDesignPattern.command;

public class CommandPatternDemo {
    public static void main(String[] args) {
        // Receiver
        Light livingRoomLight = new Light();

        // Concrete Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Turn the light on
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn the light off
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
