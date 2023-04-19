package com.roskachanna.web.service.impl;

import com.roskachanna.web.exception.EmployeeAlreadyAddedException;
import com.roskachanna.web.exception.EmployeeNotFoundException;
import com.roskachanna.web.exception.EmployeeStorageIsFullException;
import com.roskachanna.web.model.Employee;
import com.roskachanna.web.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Employee[] employees;

    public EmployeeServiceImpl() {
        employees = new Employee[5];
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        if(employee != null) {
            throw new EmployeeAlreadyAddedException();
        }
        employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] == null) {
                employees[i] =employee;
                return employee;
            }
        }
        throw new EmployeeStorageIsFullException();
    }

    @Override
    public Employee remoweEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        if(employee == null) {
            throw new EmployeeNotFoundException();
        }
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null && employees[i].equals(employee)){
                employees[i] = null;
            }
        }
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(employee)) {
                return employees[i];
            }
        };
        return null;
    }

    @Override
    public Employee[] getAllEmployees() {
        return employees;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        return null;
    }
}
