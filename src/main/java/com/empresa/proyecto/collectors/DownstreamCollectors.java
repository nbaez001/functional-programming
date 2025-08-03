package com.empresa.proyecto.collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DownstreamCollectors {
    public static void main(String[] args) {
        Path path = Paths.get("C:/nerio/trabajo/disney/proyectos/functional-programming/src/main/java/com/empresa/proyecto/collectors/EmployeeData.txt");
        try (Stream<String> lines = Files.lines(path)) {
            Spliterator<String> wordSpliterator = lines.flatMap(line -> Arrays.stream(line.split(",")))
                    .spliterator();
            Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordSpliterator);
            List<Employee> employeeList = StreamSupport.stream(employeeSpliterator, false)
                    .collect(Collectors.toList());

            // Counting by designation
            Map<String, Long> countByDesignation = employeeList.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDesignation,
                            Collectors.counting()));
            System.out.println(countByDesignation);

            // Sum of salaries by designation
            Map<String, Double> fundByDesignation = employeeList.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDesignation,
                            Collectors.summingDouble(Employee::getSalary)));
            System.out.println(fundByDesignation);

            // Max salary by designation
            Map<String, Optional<Employee>> maxSalaryByDesignation = employeeList.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDesignation,
                            Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
            System.out.println(maxSalaryByDesignation);

            // Max salary by designation
            Map<String, Optional<Double>> maxSalaryByDesignation2 = employeeList.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDesignation,
                            Collectors.mapping(
                                    Employee::getSalary,
                                    Collectors.maxBy(Comparator.comparing(Function.identity())))));
            System.out.println(maxSalaryByDesignation2);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
