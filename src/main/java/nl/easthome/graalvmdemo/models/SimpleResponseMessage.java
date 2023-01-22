package nl.easthome.graalvmdemo.models;

public class SimpleResponseMessage {

    String message;
    public SimpleResponseMessage() {
    }

    public SimpleResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
