package main.java.operations;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

public class OperationFactory {
    private HashMap<String, Class<?>> loadAvailableOperations() {
        HashMap<String, Class<?>> map = new HashMap<>();
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("main/java/operations/props"));
            props.forEach((k,v) -> {
                try {
                    map.put(((String) k).trim(), Class.forName((String) v));
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
    private final HashMap<String, Class<?>> _operations = loadAvailableOperations();
    public IOperation makeOperation(String command) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (_operations.containsKey(command)) {
            return (IOperation) _operations.get(command).getConstructor().newInstance();
        } else {
            System.out.println("UNKNOWN OPERATION");
        }
        return null;
    }
}
