package ua.nure.kushnarenko.Task1.command;

public class AddCalculatorCommand implements CalculatorCommand {

    @Override
    public Double execute(Double x, Double y) {
        return x + y;
    }

}
