package Patterns.Homework.View;

public class LogConsole implements Logging{

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }

}
