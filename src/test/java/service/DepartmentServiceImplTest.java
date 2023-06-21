package service;

import com.roskachanna.web.model.Employee;
import com.roskachanna.web.service.DepartmentService;
import com.roskachanna.web.service.EmployeeService;
import com.roskachanna.web.service.impl.DepartmentServiceImpl;
import com.roskachanna.web.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldReturnEmployeeWithMaxSalary() {
        //given
        final int departmentId = 1;
        Employee employee1 = new Employee("Ivan","Petrov", 100_000, departmentId);
        Employee employee2 = new Employee("Stepan","Sidorov", 200_000,departmentId);
        Employee employee3 = new Employee("Ivan","Ivanov", 300_000,departmentId);

        Map<String, Employee> employees = new HashMap<>();
        employees.put(employee1.getFirstName() + employee1.getLastName(), employee1);
        employees.put(employee2.getFirstName() + employee2.getLastName(), employee2);
        employees.put(employee3.getFirstName() + employee3.getLastName(), employee3);

        when(employeeService.getAllEmployees()).thenReturn(employees.values());

        //when
        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);
        //then
        Assertions.assertEquals(employee3, employeeWithMaxSalary);

    }
    @Test
    public void shouldReturnNullWhenDepartmentIsImply() {
        //given
        when(employeeService.getAllEmployees()).thenReturn((Collection<Employee>) Collections.emptyMap());
        //when
        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(1);
        //then
        Assertions.assertNull(employeeWithMaxSalary);
    }
    @Test
    public void shouldReturnEmployeeWithMinSalary() {
        //given
        final int departmentId = 1;
        Employee employee1 = new Employee("Ivan","Petrov", 100_000, departmentId);
        Employee employee2 = new Employee("Stepan","Sidorov", 200_000,departmentId);
        Employee employee3 = new Employee("Ivan","Ivanov", 300_000,departmentId);

        Map<String, Employee> employees = new HashMap<>();
        employees.put(employee1.getFirstName() + employee1.getLastName(), employee1);
        employees.put(employee2.getFirstName() + employee2.getLastName(), employee2);
        employees.put(employee3.getFirstName() + employee3.getLastName(), employee3);

        when(employeeService.getAllEmployees()).thenReturn(employees.values());

        //when
        Employee employeeWithMinSalary = departmentService.getEmployeeWithMinSalary(departmentId);
        //then
        Assertions.assertEquals(employee1, employeeWithMinSalary);

    }
}
