package calculator.view;

public class OutputView {
    private static final String PRINT_RESULT_MESSAGE = "결과 : %d\n";

    public void printError(final String message) {
        System.out.println(message);
    }

    public void printResult(final long result) {
        System.out.printf(PRINT_RESULT_MESSAGE, result);
    }
}
