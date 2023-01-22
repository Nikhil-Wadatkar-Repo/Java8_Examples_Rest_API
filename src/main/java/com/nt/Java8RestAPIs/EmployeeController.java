package com.nt.Java8RestAPIs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    @GetMapping("/departmentWiseEmployees")
    public Map<String, List<Employee>> departmentWiseEmployees() {
        return Employee.getEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @GetMapping("/ageWiseEmployees")
    public Map<Integer, List<Employee>> ageWiseEmployees() {
        return Employee.getEmployees().stream().collect(Collectors.groupingBy(Employee::getAge));
    }

    @GetMapping("/ageWiseEmployeesCount")
    public Map<Integer, Long> ageWiseEmployeesCount() {
        return Employee.getEmployees().stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
    }

    @GetMapping("/firstElement")
    public Employee firstElement() {

        Optional<Employee> firstElement = Employee.getEmployees().stream().findFirst();
        if (firstElement.isPresent())
            return firstElement.get();
        else
            return null;
    }
}
