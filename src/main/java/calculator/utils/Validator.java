package calculator.utils;

import calculator.exception.InputDataException;

import java.util.List;

import static calculator.exception.InputDataExceptionType.*;

public class Validator {
    private static final int ZERO = 0;
    private static final int MAX_INT = 2_147_483_647;

    public static void validateStringFormat(final String inputData) throws InputDataException {
        if (inputData == null || inputData.trim().isEmpty()) {
            throw new InputDataException(NULL_OR_EMPTY_DATA_ERROR);
        }
    }

    public static void validateSplitedDataFormat(final List<String> splitedData) throws InputDataException {
        splitedData.forEach(Validator::validateStringFormat);
        splitedData.forEach(Validator::validateNumberFormat);
    }

    private static void validateNumberFormat(final String splitData) throws InputDataException {
        String testData = splitData.trim();
        checkNumber(testData);
        long number = (long) Double.parseDouble(testData);
        checkRange(number);
        checkPositive(number);
    }

    private static void checkNumber(final String testData) {
        try {
            Double.parseDouble(testData);
        } catch (NumberFormatException e) {
            throw new InputDataException(NOT_A_NUMBER_ERROR);
        }
    }

    private static void checkRange(final long number) {
        if (number >= MAX_INT) {
            throw new InputDataException(NUMBER_RANGE_ERROR);
        }
    }

    private static void checkPositive(final long number) {
        if (number <= ZERO) {
            throw new InputDataException(NEGATIVE_DATA_ERROR);
        }
    }
}
