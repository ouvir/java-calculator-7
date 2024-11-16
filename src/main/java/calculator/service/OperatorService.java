package calculator.service;

import calculator.domain.operator.Operator;

import java.util.List;

public class OperatorService {
    private final Operator operator;

    public OperatorService(final Operator operator) {
        this.operator = operator;
    }

    public int operate(final List<Integer> splitNumbers) {
        return operator.operate(splitNumbers);
    }
}
