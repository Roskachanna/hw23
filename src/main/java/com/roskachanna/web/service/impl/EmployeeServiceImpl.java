package com.roskachanna.web.service.impl;

import com.roskachanna.web.exception.EmployeeAlreadyAddedException;
import com.roskachanna.web.exception.EmployeeNotFoundException;
import com.roskachanna.web.exception.InvalidInputException;
import com.roskachanna.web.model.Employee;
import com.roskachanna.web.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.springframework.util.StringUtils.isEmpty;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;
    private int department;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary) {
        validateInput(firstName,lastName);


        Employee employee = findEmployee(firstName, lastName, salary, department);
        if(employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remoweEmployee(String firstName, String lastName) {
        validateInput(firstName,lastName);

        Employee employee = findEmployee(firstName, lastName);
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int salary, int department) {
        validateInput(firstName,lastName);

        String key = firstName + lastName;

        if (employees.containsKey(key)) {
            return employees.get(key);
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

    private void validateInput(String firstName, String lastName) {
        if (!(isEmpty(firstName)&& isEmpty(lastName))) {
            throw new InvalidInputException();
        }
    }
}
