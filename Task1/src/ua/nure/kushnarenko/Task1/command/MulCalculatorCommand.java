package ua.nure.kushnarenko.Task1.command;

public class MulCalculatorCommand implements CalculatorCommand {

    @Override
    public Double execute(Double x, Double y) {
        return x*y;
    }

}
