package main.java.operations.opers;

import main.java.calculator.CustomContainer;
import main.java.exceptions.InvalidNumberOfArgs;
import main.java.exceptions.StackDepthException;
import main.java.operations.IOperation;


public class Print implements IOperation {
    @Override
    public void operate(CustomContainer context, String[] args) throws InvalidNumberOfArgs, StackDepthException {
        if (CustomContainer.stack_depth() < 1) {
            throw new StackDepthException("Passed " + (args.length-1) + " args in PRINT");
        } else {
           System.out.println(CustomContainer.peek());
        }
    }
}
