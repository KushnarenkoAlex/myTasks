package ua.nure.kushnarenko.Task1.command;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private static Map<String, CalculatorCommand> calculatorCommandContainer = new HashMap<>();

    static {
        calculatorCommandContainer.put("+", new AddCalculatorCommand());
        calculatorCommandContainer.put("-", new SubCalculatorCommand());
        calculatorCommandContainer.put("*", new MulCalculatorCommand());
        calculatorCommandContainer.put("/", new DivCalculatorCommand());
    }

    public static CalculatorCommand get(String key) {
        if (calculatorCommandContainer.containsKey(key)) {
            return calculatorCommandContainer.get(key);
        }
        return new NoCalculatorCommand();
    }

}
