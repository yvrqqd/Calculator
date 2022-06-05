package main.java.calculator;

import java.util.Map;
import java.util.Stack;

public final class CustomContainer {
    private static Stack<Double> stack;
    private static Map<String, Double> defines = null;
    private static int depth;
    public CustomContainer(Stack<Double> stack, Map<String, Double> defines) {
        CustomContainer.stack = stack;
        CustomContainer.defines = defines;
        CustomContainer.depth = 0;
    }

    public static int stack_depth() {
        return CustomContainer.depth;
    }

    public static double pop() {
        CustomContainer.depth -= 1;
        return stack.pop();
    }

    public static double peek() {
        return stack.peek();
    }

    public static void push(double value) {
        CustomContainer.depth += 1;
        stack.push(value);
    }

    public static void define(String str, Double value) {
        defines.put(str, value);
    }

    public static double defined(String str) {
        if (defines.containsKey(str)) {
            return Double.parseDouble(String.valueOf(defines.get(str)));
        } else {
            return Double.parseDouble(str);
        }
    }
}