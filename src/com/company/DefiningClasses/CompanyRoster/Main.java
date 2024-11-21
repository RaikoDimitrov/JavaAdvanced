package com.company.DefiningClasses.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> departmentAndSalary = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] employeeInfo = scanner.nextLine().split("\\s+");
            Employee employee = new Employee(employeeInfo[0],
                    Double.parseDouble(employeeInfo[1]),
                    employeeInfo[2],
                    employeeInfo[3]);
            if (employeeInfo.length > 4) {
                if (employeeInfo[4].contains("@")) employee.setEmail(employeeInfo[4]);
                else employee.setAge(Integer.parseInt(employeeInfo[4]));
            }
            if (employeeInfo.length > 5) employee.setAge(Integer.parseInt(employeeInfo[5]));
            departmentAndSalary.putIfAbsent(employeeInfo[3], new ArrayList<>());
            departmentAndSalary.get(employeeInfo[3]).add(employee);
        }
        String bestDepartment = "";
        double bestSalary = 0;

        //get average salary for best department
        for (Map.Entry<String, List<Employee>> entry : departmentAndSalary.entrySet()) {
            OptionalDouble averageSalary = entry.getValue().stream().mapToDouble(Employee::getSalary).average();
            if (averageSalary.isPresent()) {
                double average = averageSalary.getAsDouble();
                if (average > bestSalary) {
                    bestSalary = average;
                    bestDepartment = entry.getKey();
                }
            }
        }
        //print
        System.out.printf("Highest average salary: %s%n", bestDepartment);
        departmentAndSalary.get(bestDepartment).stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);

    }
}
