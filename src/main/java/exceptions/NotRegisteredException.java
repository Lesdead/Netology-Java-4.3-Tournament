package exceptions;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Player " + name + " is not registered, sorry.");
    }
}