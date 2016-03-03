package ua.nure.kushnarenko.Task1.command;

public class NoCalculatorCommand implements CalculatorCommand {

    @Override
    public Double execute(Double x, Double y) {
        throw new IllegalArgumentException();
    }

}
