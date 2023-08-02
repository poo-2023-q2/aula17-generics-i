/**
 * An exception to be used when a stack is empty.
 */
public class StackEmptyException extends RuntimeException {
    public StackEmptyException(String message) {
        super(message);
    }
}
