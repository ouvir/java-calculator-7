package calculator;

import calculator.controller.Calculator;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Calculator calculator = new Calculator(
                appConfig.inputView(), appConfig.outputView(),
                appConfig.delimiterService(), appConfig.customDelimiterExtractor(), appConfig.operatorService()
        );
        calculator.run();
    }
}
