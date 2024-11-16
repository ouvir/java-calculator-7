package calculator.domain.operator;

import calculator.exception.InputDataException;

import java.util.List;

import static calculator.exception.InputDataExceptionType.NUMBER_RANGE_ERROR;

public class PlusOperator implements Operator{
    @Override
    public int operate(final List<Integer> numbers) throws InputDataException {
        int result = numbers.stream().reduce(0, Integer::sum);
        if (result <= 0) {
            throw new InputDataException(NUMBER_RANGE_ERROR);
        }
        return result;
    }
}
