package com.yogesh.streamapi;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestClass {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();


        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));




        //1. Find out the count of male and female employees present in the organization?

        Map<String, Long> genderCountList = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        //System.out.println(genderCountList);

        //2. Write a program to print the names of all departments in the organization.
        List<String> deplartmentNames = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        //System.out.println(deplartmentNames);

        //3. Find the average age of Male and Female Employees.
        Map<String, Double> averageAgeMaleFemaile = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        //System.out.println(averageAgeMaleFemaile);

        //4. Get the Names of employees who joined after 2015.

        List<String> employeeJoinafte2015 = employeeList.stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .map(e -> e.getName())
                .collect(Collectors.toList());
        //System.out.println(employeeJoinafte2015);
        
        //5. Count the number of employees in each department.
        Map<String, Long> employeesCount = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        //System.out.println(employeesCount);

        //6. Find out the average salary of each department.
        Map<String, Double> deptAverageSalary = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        //System.out.println(deptAverageSalary);

        //7. Find out the oldest employee, his/her age and department?
        Optional<String> maxEmployeeAge = employeeList
                .stream()
                .max(Comparator.comparing(Employee::getAge))
                .map(e -> e.getName());
       // System.out.println(maxEmployeeAge.get());

        //8. Find out the average and total salary of the organization.
        DoubleSummaryStatistics collect = employeeList
                .stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        //System.out.println("Total Salary "+collect.getSum());
        //System.out.println("Average Salary "+collect.getAverage());

        //9. List down the employees of each department.
        Map<String, List<Employee>> collect1 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        //System.out.println(collect1);
        
        //10. Find out the highest experienced employees in the organization
        Optional<Employee> min = employeeList.stream()
                .min(Comparator.comparing(Employee::getYearOfJoining));
        //System.out.println(min.get());

        //11Program to Find the Frequency of Each Character in a Given String
        List<String> items = List.of("apple", "banana", "cherry");
        LinkedHashMap<String, Integer> collect2 = items.stream()
                .collect(Collectors.toMap(Function.identity(), String::length, (oldvalue, newvalude) -> newvalude, LinkedHashMap::new));
        //System.out.println(collect2);

        //12. Program To Reverse a String
        String originalString = "Hello, World!";
        IntStream charStream = originalString.chars();
        Stream<String> charStringStream = charStream.mapToObj(ch -> String.valueOf((char) ch));
        String reversedString = charStringStream.reduce((acc, ch) -> ch + acc).orElse("");
        //System.out.println(reversedString); // Output: !dlroW ,olleH

        //13. write a program find the highest paid employee from each dept.

        Map<String, Employee> collect3 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                Optional::get)));
        //System.out.println(collect3);

        //---Important------18: Write a Java 8 program to find the distinct characters in a list of strings ?
        List<String> strings9 = List.of("apple", "banana", "cherry");
        Map<Character,Integer> intMap=new HashMap<>();

        //Write a Java 8 program to find the distinct characters in a list of strings ?
        List<String> strings10 = List.of("apple", "banana", "cherry");
        List<Character> collect4 = strings10.stream()
                .flatMapToInt(s -> s.chars())
                .mapToObj(t -> (char) t)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(n -> n.getValue() == 1)
                .collect(Collectors.mapping(Map.Entry::getKey, Collectors.toList()));
       // System.out.println(collect4);


        //---Important------8: Write a Java 8 program to find the second distinct(non repeating) characters in a list of strings ?
        List<String> strings12 = List.of("apple", "banana", "cherry");
        Character character = strings12.stream()
                .flatMapToInt(CharSequence::chars)
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .skip(1)
                .findFirst()
                .map(e -> e.getKey())
                .get();
        System.out.println(character);

        //1. Find out the count of male and female employees present in the organization?
        Map<String, Long> collect5 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));


        //2. Write a program to print the names of all departments in the organization.
        List<String> collect6 = employeeList
                .stream()
                .map(e -> e.getDepartment())
                .distinct()
                .collect(Collectors.toList());


        //3. Find the average age of Male and Female Employees.
        Map<String, Double> collect7 = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));

        //4. Get the Names of employees who joined after 2015.

        List<Employee> collect8 = employeeList.stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .collect(Collectors.toList());

        //5. Count the number of employees in each department.
        Map<String, Long> collect9 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        //6. Find out the average salary of each department.

        Map<String, Double> collect10 = employeeList
                .stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        //7. Find out the oldest employee, his/her age and department?
        Optional<Employee> min1 = employeeList.stream()
                .min(Comparator.comparing(Employee::getAge));



        //8. Find out the average and total salary of the organization.
        DoubleSummaryStatistics collect11 = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        //9. List down the employees of each department.
        List<String> collect12 = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());


        //10. Find out the highest experienced employees in the organization
        Employee employee = employeeList.stream()
                .min(Comparator.comparing(Employee::getYearOfJoining))
                .get();


        //13. write a program find the highest paid employee from each dept.
        List<Map.Entry<String, Optional<Employee>>> collect13 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))
                .entrySet().stream().collect(Collectors.toList());


        //---Important------18: Write a Java 8 program to find the distinct characters in a list of strings ?
        List<String> strings11 = List.of("apple", "banana", "cherry");
        List<Character> collect14 = strings11.stream()
                .flatMapToInt(CharSequence::chars)
                .mapToObj((ch -> (char) ch))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter((e -> e.getValue() == 1))
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        //System.out.println(collect14);

    }
}
