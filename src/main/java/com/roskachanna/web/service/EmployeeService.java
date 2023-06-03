package com.roskachanna.web.service;

import com.roskachanna.web.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstname, String lastName, int salary);
    Employee remoweEmployee(String firstname, String lastName);
    Employee findEmployee(String firstname, String lastName);

    abstract Employee findEmployee(String firstName, String lastName, int salary, int department);

    Collection<Employee> getAllEmployees();

    Employee removeEmployee(String firstName, String lastName);
}
