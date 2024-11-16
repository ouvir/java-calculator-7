package calculator.controller;

import calculator.service.CustomDelimiterExtractor;
import calculator.service.DelimiterService;
import calculator.service.OperatorService;
import calculator.utils.TypeCast;
import calculator.utils.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;
import java.util.Optional;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;
    private final CustomDelimiterExtractor customDelimiterExtractor;
    private final DelimiterService delimiterService;
    private final OperatorService operatorService;

    public Calculator(
            InputView inputView,
            OutputView outputView,
            DelimiterService delimiterService,
            CustomDelimiterExtractor customDelimiterExtractor,
            OperatorService operatorService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.delimiterService = delimiterService;
        this.customDelimiterExtractor = customDelimiterExtractor;
        this.operatorService = operatorService;
    }

    public void run() {
        while (true) {
            try {
                process();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void process() throws IllegalArgumentException {
        String inputData = requestData();
        inputData = extractCustomDelimiter(inputData);
        List<String> splitedData = delimiterService.split(inputData);
        Validator.validateSplitedDataFormat(splitedData); // nan, negative, range
        List<Integer> splitNumbers = TypeCast.cast(splitedData);
        long result = operatorService.operate(splitNumbers);
        outputView.printResult(result);
    }

    private String requestData() {
        String inputData = inputView.readString();
        Validator.validateStringFormat(inputData); // null, empty
        return inputData;
    }

    private String extractCustomDelimiter(final String inputData) {
        Optional<String> customDelimiter = customDelimiterExtractor.extract(inputData);
        if (customDelimiter.isPresent()) {
            delimiterService.addDelimiter(customDelimiter.get());
            return customDelimiterExtractor.deleteDelimiterExtractFormat(inputData);
        }
        return inputData;
    }
}
