package main.java.operations;

import main.java.calculator.CustomContainer;
import main.java.exceptions.InvalidNumberOfArgs;
import main.java.exceptions.StackDepthException;

public interface IOperation {
    void operate(CustomContainer context, String[] args) throws InvalidNumberOfArgs, StackDepthException;
}
