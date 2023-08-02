/**
 * An exception to be used when a stack is full.
 */
public class StackFullException extends RuntimeException {
    public StackFullException(String message) {
        super(message);
    }
}
