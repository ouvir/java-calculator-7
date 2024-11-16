package calculator.exception;

public class InputDataException extends IllegalArgumentException {

    public InputDataException(final InputDataExceptionType e) {
        super(e.getMessage());
    }
}
