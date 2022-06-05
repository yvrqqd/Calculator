package main.java.exceptions;

public class StackDepthException extends Exception{
    public StackDepthException(String errorMessage) {
        System.out.println(errorMessage);
    }
}