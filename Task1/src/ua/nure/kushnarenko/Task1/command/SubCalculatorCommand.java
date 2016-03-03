package ua.nure.kushnarenko.Task1.command;

public class SubCalculatorCommand implements CalculatorCommand {

    @Override
    public Double execute(Double x, Double y) {
        return x - y;
    }

}
