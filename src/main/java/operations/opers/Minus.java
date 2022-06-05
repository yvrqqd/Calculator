package main.java.operations.opers;

import main.java.calculator.CustomContainer;
import main.java.exceptions.InvalidNumberOfArgs;
import main.java.exceptions.StackDepthException;
import main.java.operations.IOperation;

public class Minus implements IOperation {
    @Override
    public void operate(CustomContainer context, String[] args) throws InvalidNumberOfArgs, StackDepthException {
        if (args.length != 1) {
            throw new InvalidNumberOfArgs("Passed " + (args.length-1) + " args in MINUS");
        } else if (CustomContainer.stack_depth() < 2) {
            throw new StackDepthException("Less the 2 vars in stack during minus" + CustomContainer.stack_depth());
        } else {
            double var1 = CustomContainer.pop();
            double var2 = CustomContainer.pop();
            CustomContainer.push(var2 - var1);
        }
    }
}
