package calculator.exception;

public enum InputDataExceptionType {
    NULL_OR_EMPTY_DATA_ERROR("빈 문자열 입력은 받지 않습니다."),
    NEGATIVE_DATA_ERROR("0과 음수는 받지 않습니다."),
    NOT_A_NUMBER_ERROR("구분자를 제외한 나머지 문자는 양의 정수여야 합니다."),
    NUMBER_RANGE_ERROR("계산 값은 Integer 범위를 넘을 수 없습니다.");

    private static final String PREFIX_ERROR_FORMAT = "[ERROR] ";
    private final String message;

    InputDataExceptionType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX_ERROR_FORMAT + message;
    }
}
