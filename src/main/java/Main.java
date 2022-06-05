package main.java;

import main.java.calculator.Calculator;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filename = (args.length != 0) ? args[0] : "";
        Scanner scan = (Objects.equals(filename, "")) ? new Scanner(System.in) : new Scanner(filename);
        Calculator Calc;
        Calc = new Calculator();
        Calc.calculate(scan);
    }
}
