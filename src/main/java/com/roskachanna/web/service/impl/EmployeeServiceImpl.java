package com.roskachanna.web.service.impl;

import com.roskachanna.web.exception.EmployeeAlreadyAddedException;
import com.roskachanna.web.exception.EmployeeNotFoundException;
import com.roskachanna.web.exception.EmployeeStorageIsFullException;
import com.roskachanna.web.model.Employee;
import com.roskachanna.web.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        if(employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remoweEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.containsKey(employee.getFullName())) {
            return employee;
        }else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        return null;
    }
}
