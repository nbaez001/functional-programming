package com.empresa.proyecto.functional.util.collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectorsInAction {
    public static void main(String[] args) {
        Path path = Paths.get("C:/nerio/trabajo/disney/proyectos/functional-programming/src/main/java/com/empresa/proyecto/collectors/EmployeeData.txt");
        try (Stream<String> lines = Files.lines(path)) {
            Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
            Spliterator<String> wordSpliterator = words.spliterator();
            Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordSpliterator);
            Stream<Employee> employees = StreamSupport.stream(employeeSpliterator, false);
            List<Employee> employeeList = employees.collect(Collectors.toList());

            // get a list of names
            List<String> employeenames = employeeList.stream()
                    .map(Employee::getName)
                    .collect(Collectors.toList());
            employeenames.forEach(System.out::println);
            System.out.println("----X-------LIST-------X----");

            // get all designations present in this data
            Set<String> designations = employeeList.stream()
                    .map(Employee::getDesignation)
                    .collect(Collectors.toSet());
            designations.forEach(System.out::println);
            System.out.println("----X-------SET-------X----");

            // get a sorted set using collectors
            TreeSet<Employee> employeeSorted = employeeList.stream()
                    .collect(Collectors.toCollection(TreeSet::new));
            employeeSorted.forEach(System.out::println);
            System.out.println("----X-------TREESET-------X----");

            // get a map collection
            Map<Integer, String> namesById = employeeList.stream()
                    .collect(Collectors.toMap(Employee::getId, Employee::getName));
            System.out.println(namesById);
            System.out.println("----X-------MAP-------X----");

            // Collectors to partition data
            Map<Boolean, List<Employee>> partitionedData = employeeList.stream()
                    .collect(Collectors.partitioningBy(e -> e.getGender() == 'M'));
            System.out.println(partitionedData);
            List<Employee> maleEmployees = partitionedData.get(true);
            List<Employee> femaleEmployees = partitionedData.get(false);

            // Collectors to group data
            Map<String, List<Employee>> groupedData = employeeList.stream()
                    .collect(Collectors.groupingBy(e -> e.getDesignation()));
            System.out.println(groupedData);

            // Single String containning the data
            String names = employeeList.stream()
                    .map(e -> e.getName())
                    .collect(Collectors.joining(", "));
            System.out.println(names);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
