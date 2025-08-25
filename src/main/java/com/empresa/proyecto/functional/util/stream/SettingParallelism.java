package com.empresa.proyecto.functional.util.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class SettingParallelism {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Find the available processors
        System.out.println(Runtime.getRuntime().availableProcessors());

        // Setting a property to control the ForkJoinPool
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        // We can create our own ForkJoinPool to execute a task
        ForkJoinPool pool = new ForkJoinPool(2);
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Employee("John", 20000));
            list.add(new Employee("Rohn", 3000));
            list.add(new Employee("Tom", 15000));
            list.add(new Employee("Bheem", 8000));
            list.add(new Employee("Shiva", 200));
            list.add(new Employee("Krishna", 50000));
        }
        long count = pool.submit(() -> list.parallelStream()
                .filter(e -> e.getSalary() > 1000)
                .count()).get();
        System.out.println(count);
    }
}
