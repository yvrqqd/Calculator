package test.java;


import main.java.calculator.Calculator;
import main.java.calculator.CustomContainer;
import main.java.exceptions.InvalidNumberOfArgs;
import main.java.exceptions.StackDepthException;
import main.java.operations.IOperation;
import main.java.operations.OperationFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class OperationTests {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    public OperationTests() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    }

    @Before
    public void main() {
        Scanner scan = new Scanner(System.in);
        Calculator Calc;
        Calc = new Calculator();
        Calc.calculate(scan);
    }

    CustomContainer context = new CustomContainer(new Stack<>(), new HashMap<>());
    OperationFactory Fac = new OperationFactory();

    IOperation def = Fac.makeOperation("define");
    IOperation push = Fac.makeOperation("push");
    IOperation pop = Fac.makeOperation("pop");
    IOperation div = Fac.makeOperation("/");
    IOperation mult = Fac.makeOperation("*");
    IOperation minus = Fac.makeOperation("-");
    IOperation plus = Fac.makeOperation("+");


    @Test
    public void define_test() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvalidNumberOfArgs, StackDepthException {
        IOperation op = Fac.makeOperation("define");
        assert op != null;
        def.operate(context, new String[]{"define", "x", "5"});
        push.operate(context, new String[]{"push", "x"});
        pop.operate(context, new String[]{"pop"});
        Assert.assertEquals("5.0\n", output.toString());
        output.reset();

        def.operate(context, new String[]{"define", "x", "55.1"});
        push.operate(context, new String[]{"push", "x"});
        pop.operate(context, new String[]{"pop"});
        Assert.assertEquals("55.1\n", output.toString());
        output.reset();

        def.operate(context, new String[]{"define", "x1", "5"});
        def.operate(context, new String[]{"define", "x2", "55"});
        push.operate(context, new String[]{"push", "x1"});
        push.operate(context, new String[]{"push", "x2"});
        pop.operate(context, new String[]{"pop"});
        pop.operate(context, new String[]{"pop"});
        Assert.assertEquals("55.0\n5.0\n", output.toString());
        output.reset();
    }

    //        @Test
//        public void divide_test () {
//            tprint("push 5\n");
//            tprint("push 5\n");
//            tprint("/\n");
//            tprint("pop\n");
//            Assert.assertEquals("1.0\n", output.toString());
//            output.reset();
//
//            tprint("push 55\n");
//            tprint("push 11\n");
//            tprint("/\n");
//            tprint("pop\n");
//            Assert.assertEquals("5.0\n", output.toString());
//            output.reset();
//        }
//
//        @Test
//        public void minus_test () {
//            tprint("push 5\n");
//            tprint("push 5\n");
//            tprint("-\n");
//            tprint("pop\n");
//            Assert.assertEquals("0.0\n", output.toString());
//            output.reset();
//
//            tprint("push 5\n");
//            tprint("push 7\n");
//            tprint("-\n");
//            tprint("pop\n");
//            Assert.assertEquals("-2.0\n", output.toString());
//            output.reset();
//        }
//
//        @Test
//        public void multiply_test () {
//            tprint("push 5\n");
//            tprint("push 5\n");
//            tprint("*\n");
//            tprint("pop\n");
//            Assert.assertEquals("25.0\n", output.toString());
//            output.reset();
//
//            tprint("push 5\n");
//            tprint("push 11\n");
//            tprint("*\n");
//            tprint("pop\n");
//            Assert.assertEquals("55.0\n", output.toString());
//            output.reset();
//        }
//
//        @Test
//        public void plus_test () {
//            tprint("push 5\n");
//            tprint("push 5\n");
//            tprint("*\n");
//            tprint("pop\n");
//            Assert.assertEquals("25.0\n", output.toString());
//            output.reset();
//
//            tprint("push 5\n");
//            tprint("push 11\n");
//            tprint("*\n");
//            tprint("pop\n");
//            Assert.assertEquals("55.0\n", output.toString());
//            output.reset();
//        }
//
//        @Test
//        public void pop_test () {
//            tprint("push 5\n");
//            tprint("push 7\n");
//            tprint("pop\n");
//            Assert.assertEquals("7.0\n", output.toString());
//            output.reset();
//
//            tprint("push 5\n");
//            tprint("push 11\n");
//            tprint("define c 121\n");
//            tprint("pop\n");
//            Assert.assertEquals("11.0\n", output.toString());
//            output.reset();
//
//            tprint("push 5\n");
//            tprint("push 11\n");
//            tprint("define c 121\n");
//            tprint("push c");
//            tprint("pop\n");
//            Assert.assertEquals("121.0\n", output.toString());
//            output.reset();
//        }
//
//        @Test
//        public void push_test () {
//            // done above
//        }
//
//        @Test
//        public void sqrt_test () {
//            tprint("push 25\n");
//            tprint("sqrt\n");
//            tprint("pop\n");
//            Assert.assertEquals("5.0\n", output.toString());
//            output.reset();
//        }
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}

