package main.java.operations.opers;

import main.java.calculator.CustomContainer;
import main.java.exceptions.InvalidNumberOfArgs;
import main.java.operations.IOperation;


public class Define implements IOperation {
    @Override
    public void operate(CustomContainer context, String[] args) throws InvalidNumberOfArgs {
        if (args.length == 3) {
            CustomContainer.define(args[1], Double.parseDouble(args[2]));
        } else {
            throw new InvalidNumberOfArgs("Passed "+(args.length-1)+" args in DEFINE");
        }
    }
}
