package org.example.exo1Calculatrice;

import java.util.HashMap;
import java.util.Map;

public class Calculatrice {
    Map<String, Calculator> operations;

    public Calculatrice() {
        operations = new HashMap<>();

        // Ajouter les lambdas pour chaque opération
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> b != 0 ? a / b : Double.NaN);
    }

    public Calculator getOperation(String operation) {
        return operations.get(operation);
    }

    public boolean isOperationSupported(String operation) {
        return operations.containsKey(operation);
    }
}
