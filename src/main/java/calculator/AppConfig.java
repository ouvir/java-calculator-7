package calculator;

import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.Delimiter;
import calculator.domain.operator.Operator;
import calculator.domain.operator.PlusOperator;
import calculator.service.CustomDelimiterExtractor;
import calculator.service.DelimiterService;
import calculator.service.OperatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {
    private final InputView inputView;
    private final OutputView outputView;
    private final Delimiter delimiter;
    private final Operator operator;
    private final OperatorService operatorService;
    private final CustomDelimiterExtractor customDelimiterExtractor;
    private final DelimiterService delimiterService;

    public AppConfig() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.delimiter = new CustomDelimiter();
        this.operator = new PlusOperator();
        this.operatorService = new OperatorService(operator);
        this.customDelimiterExtractor = new CustomDelimiterExtractor();
        this.delimiterService = new DelimiterService(delimiter);
    }

    public InputView inputView() {
        return inputView;
    }

    public OutputView outputView() {
        return outputView;
    }

    public DelimiterService delimiterService() {
        return delimiterService;
    }

    public CustomDelimiterExtractor customDelimiterExtractor() {
        return customDelimiterExtractor;
    }

    public OperatorService operatorService() {
        return operatorService;
    }
}