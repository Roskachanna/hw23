package com.roskachanna.web.service;

import com.roskachanna.web.model.Employee;

public interface EmployeeService {

    Employee addEmployee(String firstname, String lastName);
    Employee remoweEmployee(String firstname, String lastName);
    Employee findEmployee(String firstname, String lastName);

    Employee[] getAllEmployees();

    Employee removeEmployee(String firstName, String lastName);
}
