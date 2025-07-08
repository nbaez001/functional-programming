package com.empresa.proyecto.functionalprogramming;

public class JavaClosure {
    public static void main(String[] args) {
        int val = 111;
        Task lambda = () -> {
            System.out.println(val);
            System.out.println("Task Completed");
        };

        printValue(lambda);
    }

    private static void printValue(Task lambda) {
        // Even if val variable is not present in this scope, it tracks
        // and uses it from its lexical scope
        lambda.doTask();
    }
}

@FunctionalInterface
interface Task {
    void doTask();
}
