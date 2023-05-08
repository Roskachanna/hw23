package com.roskachanna.web.service;

import com.roskachanna.web.model.Employee;


import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeMaxSalary(Integer departmentId);
    Employee getEmployeeMinSalary(Integer departmentId);
    List<Employee> getEmployeeByDepartment(Integer departmentId);
    Map<Integer, List<Employee>> getEmployeeCollectedByDepartment();

    Employee getEmployeeWithMaxSalary(Integer departmentId);

    Employee getEmployeeWithMinSalary(Integer departmentId);
}

