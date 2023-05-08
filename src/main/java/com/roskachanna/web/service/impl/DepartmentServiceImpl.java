package com.roskachanna.web.service.impl;

import com.roskachanna.web.model.Employee;
import com.roskachanna.web.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeMaxSalary(Integer departmentId) {
        Collection<Employee> employees = employeeService.getAllEmployees();

        return employees.stream()
                .filter(it -> it.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public Employee getEmployeeMinSalary(Integer departmentId) {
        Collection<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(it -> it.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public List<Employee> getEmployeeByDepartment(Integer departmentId) {
        Collection<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(it -> it.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeeCollectedByDepartment() {
        Collection<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return null;
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return null;
    }
}
